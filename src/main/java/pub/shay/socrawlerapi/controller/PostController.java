package pub.shay.socrawlerapi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pub.shay.socrawlerapi.dto.PostDetailResponse;
import pub.shay.socrawlerapi.dto.PostListResponse;
import pub.shay.socrawlerapi.service.PostService;

import java.util.Optional;

@RestController
@RequestMapping("/api/posts")
@Tag(name = "Posts", description = "Stack Overflow Posts API")
public class PostController {

	@Autowired
	private PostService postService;

	@GetMapping
	@Operation(summary = "Get paginated posts list", description = "Retrieve a paginated list of posts with optional search and filters")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Successfully retrieved posts"),
			@ApiResponse(responseCode = "400", description = "Invalid parameters")
	})
	public ResponseEntity<PostListResponse> getPosts(
			@Parameter(description = "Page number (default: 1)") @RequestParam(defaultValue = "1") int page,

			@Parameter(description = "Items per page (default: 50, max: 100)") @RequestParam(defaultValue = "50") int limit,

			@Parameter(description = "Search in title and body") @RequestParam(required = false) String search,

			@Parameter(description = "Minimum score filter") @RequestParam(required = false) Integer minScore,

			@Parameter(description = "Maximum score filter") @RequestParam(required = false) Integer maxScore,

			@Parameter(description = "Filter posts with code") @RequestParam(required = false) Boolean hasCode,

			@Parameter(description = "Filter posts with images") @RequestParam(required = false) Boolean hasImage,

			@Parameter(description = "Filter by tags (comma-separated)") @RequestParam(required = false) String tags,

			@Parameter(description = "Start date filter (timestamp)") @RequestParam(required = false) Long startDate,

			@Parameter(description = "End date filter (timestamp)") @RequestParam(required = false) Long endDate,

			@Parameter(description = "Sort by field (score, viewCount, answerCount, date, createdAt, title)") @RequestParam(defaultValue = "score") String sortBy,

			@Parameter(description = "Sort direction (asc, desc)") @RequestParam(defaultValue = "desc") String sortDir) {

		try {
			PostListResponse response = postService.getAllPosts(
					page, limit, search, minScore, maxScore,
					hasCode, hasImage, tags, startDate, endDate, sortBy, sortDir);
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}

	@GetMapping("/{id}")
	@Operation(summary = "Get post details", description = "Retrieve a single post with all its answers")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Successfully retrieved post"),
			@ApiResponse(responseCode = "404", description = "Post not found")
	})
	public ResponseEntity<PostDetailResponse> getPostById(
			@Parameter(description = "Post ID") @PathVariable Long id) {

		Optional<PostDetailResponse> response = postService.getPostById(id);
		return response.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/search")
	@Operation(summary = "Advanced search", description = "Advanced search with multiple filters")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Successfully retrieved search results"),
			@ApiResponse(responseCode = "400", description = "Invalid search parameters")
	})
	public ResponseEntity<PostListResponse> searchPosts(
			@Parameter(description = "Search query", required = true) @RequestParam String query,

			@Parameter(description = "Page number (default: 1)") @RequestParam(defaultValue = "1") int page,

			@Parameter(description = "Items per page (default: 50, max: 100)") @RequestParam(defaultValue = "50") int limit,

			@Parameter(description = "Minimum score filter") @RequestParam(required = false) Integer minScore,

			@Parameter(description = "Maximum score filter") @RequestParam(required = false) Integer maxScore,

			@Parameter(description = "Filter posts with code") @RequestParam(required = false) Boolean hasCode,

			@Parameter(description = "Filter posts with images") @RequestParam(required = false) Boolean hasImage,

			@Parameter(description = "Filter by tags (comma-separated)") @RequestParam(required = false) String tags,

			@Parameter(description = "Start date filter (timestamp)") @RequestParam(required = false) Long startDate,

			@Parameter(description = "End date filter (timestamp)") @RequestParam(required = false) Long endDate,

			@Parameter(description = "Sort by field (score, viewCount, answerCount, date, createdAt, title)") @RequestParam(defaultValue = "score") String sortBy,

			@Parameter(description = "Sort direction (asc, desc)") @RequestParam(defaultValue = "desc") String sortDir) {

		if (query == null || query.trim().isEmpty()) {
			return ResponseEntity.badRequest().build();
		}

		try {
			PostListResponse response = postService.searchPosts(
					query, page, limit, minScore, maxScore,
					hasCode, hasImage, tags, startDate, endDate, sortBy, sortDir);
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
}
