package pub.shay.socrawlerapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pub.shay.socrawlerapi.dto.*;
import pub.shay.socrawlerapi.model.Answer;
import pub.shay.socrawlerapi.model.Post;
import pub.shay.socrawlerapi.repository.AnswerRepository;
import pub.shay.socrawlerapi.repository.PostRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostService {

	@Autowired
	private PostRepository postRepository;

	@Autowired
	private AnswerRepository answerRepository;

	public PostListResponse getAllPosts(
			int page,
			int limit,
			String search,
			Integer minScore,
			Integer maxScore,
			Boolean hasCode,
			Boolean hasImage,
			String tags,
			Long startDate,
			Long endDate,
			String sortBy,
			String sortDir) {

		// Validate and set defaults
		page = Math.max(1, page);
		limit = Math.min(Math.max(1, limit), 100); // Max 100 items per page

		// Create sort object
		Sort sort = createSort(sortBy, sortDir);
		Pageable pageable = PageRequest.of(page - 1, limit, sort);

		// Process tags parameter
		String processedTags = null;
		if (tags != null && !tags.trim().isEmpty()) {
			// Convert comma-separated tags to a format suitable for LIKE query
			processedTags = Arrays.stream(tags.split(","))
					.map(String::trim)
					.filter(tag -> !tag.isEmpty())
					.collect(Collectors.joining(","));
		}

		Page<Post> postPage = postRepository.findPostsWithFilters(
				search, minScore, maxScore, hasCode, hasImage,
				processedTags, startDate, endDate, pageable);

		List<PostDto> postDtos = postPage.getContent().stream()
				.map(PostDto::new)
				.collect(Collectors.toList());

		return new PostListResponse(postDtos, postPage.getTotalElements(), page, limit);
	}

	@Cacheable("posts")
	public Optional<PostDetailResponse> getPostById(Long id) {
		Optional<Post> postOpt = postRepository.findById(id);
		if (postOpt.isEmpty()) {
			return Optional.empty();
		}

		Post post = postOpt.get();
		PostDto postDto = new PostDto(post);

		// Get answers for this post, ordered by accepted status and score
		List<Answer> answers = answerRepository.findByQuestionIdOrderByAcceptedAndScore(post.getPostId());
		List<AnswerDto> answerDtos = answers.stream()
				.map(AnswerDto::new)
				.collect(Collectors.toList());

		return Optional.of(new PostDetailResponse(postDto, answerDtos));
	}

	@Cacheable("posts")
	public Optional<PostDetailResponse> getPostByPostId(Long postId) {
		Optional<Post> postOpt = postRepository.findByPostId(postId);
		if (postOpt.isEmpty()) {
			return Optional.empty();
		}

		Post post = postOpt.get();
		PostDto postDto = new PostDto(post);

		// Get answers for this post, ordered by accepted status and score
		List<Answer> answers = answerRepository.findByQuestionIdOrderByAcceptedAndScore(postId);
		List<AnswerDto> answerDtos = answers.stream()
				.map(AnswerDto::new)
				.collect(Collectors.toList());

		return Optional.of(new PostDetailResponse(postDto, answerDtos));
	}

	public PostListResponse searchPosts(
			String query,
			int page,
			int limit,
			Integer minScore,
			Integer maxScore,
			Boolean hasCode,
			Boolean hasImage,
			String tags,
			Long startDate,
			Long endDate,
			String sortBy,
			String sortDir) {

		return getAllPosts(page, limit, query, minScore, maxScore,
				hasCode, hasImage, tags, startDate, endDate, sortBy, sortDir);
	}

	private Sort createSort(String sortBy, String sortDir) {
		// Default sorting
		if (sortBy == null || sortBy.trim().isEmpty()) {
			sortBy = "score";
		}

		if (sortDir == null || (!sortDir.equalsIgnoreCase("asc") && !sortDir.equalsIgnoreCase("desc"))) {
			sortDir = "desc";
		}

		// Validate sortBy field
		String[] allowedSortFields = { "score", "viewCount", "answerCount", "date", "createdAt", "title" };
		boolean isValidSortField = Arrays.asList(allowedSortFields).contains(sortBy);
		if (!isValidSortField) {
			sortBy = "score";
		}

		Sort.Direction direction = sortDir.equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
		return Sort.by(direction, sortBy);
	}
}
