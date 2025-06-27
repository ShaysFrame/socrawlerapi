package pub.shay.socrawlerapi.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "answers")
public class Answer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "answer_id", unique = true)
	private Long answerId;

	@Column(name = "question_id")
	private Long questionId;

	@Column(columnDefinition = "TEXT")
	private String body;

	private Integer score;

	@Column(name = "is_accepted")
	private Boolean isAccepted;

	@Column(name = "creation_date")
	private Long creationDate;

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
	public Answer() {
	}

	// Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAnswerId() {
		return answerId;
	}

	public void setAnswerId(Long answerId) {
		this.answerId = answerId;
	}

	public Long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
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

	public Boolean getIsAccepted() {
		return isAccepted;
	}

	public void setIsAccepted(Boolean isAccepted) {
		this.isAccepted = isAccepted;
	}

	public Long getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Long creationDate) {
		this.creationDate = creationDate;
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
