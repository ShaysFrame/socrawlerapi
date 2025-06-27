package pub.shay.socrawlerapi.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "posts")
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "post_id", unique = true)
	private Long postId;

	@Column(columnDefinition = "TEXT")
	private String title;

	@Column(columnDefinition = "TEXT")
	private String body;

	private Integer score;

	@Column(name = "view_count")
	private Integer viewCount;

	@Column(name = "answer_count")
	private Integer answerCount;

	@Column(columnDefinition = "TEXT")
	private String tags;

	private Long date;

	@Column(columnDefinition = "TEXT")
	private String type;

	@Column(name = "has_text")
	private Boolean hasText;

	@Column(name = "has_image")
	private Boolean hasImage;

	@Column(name = "has_video")
	private Boolean hasVideo;

	@Column(name = "has_code")
	private Boolean hasCode;

	@Column(name = "created_at")
	private LocalDateTime createdAt;

	// Default constructor
	public Post() {
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
