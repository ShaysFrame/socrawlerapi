package pub.shay.socrawlerapi.dto;

import java.util.List;

public class PostDetailResponse {
	private PostDto post;
	private List<AnswerDto> answers;

	// Default constructor
	public PostDetailResponse() {
	}

	// Constructor
	public PostDetailResponse(PostDto post, List<AnswerDto> answers) {
		this.post = post;
		this.answers = answers;
	}

	// Getters and Setters
	public PostDto getPost() {
		return post;
	}

	public void setPost(PostDto post) {
		this.post = post;
	}

	public List<AnswerDto> getAnswers() {
		return answers;
	}

	public void setAnswers(List<AnswerDto> answers) {
		this.answers = answers;
	}
}
