package pub.shay.socrawlerapi.dto;

import pub.shay.socrawlerapi.model.Post;
import java.time.LocalDateTime;

public class PostDto {
	private Long id;
	private Long postId;
	private String title;
	private String body;
	private Integer score;
	private Integer viewCount;
	private Integer answerCount;
	private String tags;
	private Long date;
	private String type;
	private Boolean hasText;
	private Boolean hasImage;
	private Boolean hasVideo;
	private Boolean hasCode;
	private LocalDateTime createdAt;

	// Default constructor
	public PostDto() {
	}

	// Constructor from Post entity
	public PostDto(Post post) {
		this.id = post.getId();
		this.postId = post.getPostId();
		this.title = post.getTitle();
		this.body = post.getBody();
		this.score = post.getScore();
		this.viewCount = post.getViewCount();
		this.answerCount = post.getAnswerCount();
		this.tags = post.getTags();
		this.date = post.getDate();
		this.type = post.getType();
		this.hasText = post.getHasText();
		this.hasImage = post.getHasImage();
		this.hasVideo = post.getHasVideo();
		this.hasCode = post.getHasCode();
		this.createdAt = post.getCreatedAt();
	}

	// Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPostId() {
		return postId;
	}

	public void setPostId(Long postId) {
		this.postId = postId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public Integer getViewCount() {
		return viewCount;
	}

	public void setViewCount(Integer viewCount) {
		this.viewCount = viewCount;
	}

	public Integer getAnswerCount() {
		return answerCount;
	}

	public void setAnswerCount(Integer answerCount) {
		this.answerCount = answerCount;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public Long getDate() {
		return date;
	}

	public void setDate(Long date) {
		this.date = date;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Boolean getHasText() {
		return hasText;
	}

	public void setHasText(Boolean hasText) {
		this.hasText = hasText;
	}

	public Boolean getHasImage() {
		return hasImage;
	}

	public void setHasImage(Boolean hasImage) {
		this.hasImage = hasImage;
	}

	public Boolean getHasVideo() {
		return hasVideo;
	}

	public void setHasVideo(Boolean hasVideo) {
		this.hasVideo = hasVideo;
	}

	public Boolean getHasCode() {
		return hasCode;
	}

	public void setHasCode(Boolean hasCode) {
		this.hasCode = hasCode;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
}
