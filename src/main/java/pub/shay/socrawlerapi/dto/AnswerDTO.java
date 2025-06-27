package pub.shay.socrawlerapi.dto;

import pub.shay.socrawlerapi.model.Answer;
import java.time.LocalDateTime;

public class AnswerDto {
	private Long id;
	private Long answerId;
	private Long questionId;
	private String body;
	private Integer score;
	private Boolean isAccepted;
	private Long creationDate;
	private Boolean hasText;
	private Boolean hasImage;
	private Boolean hasVideo;
	private Boolean hasCode;
	private LocalDateTime createdAt;

	// Default constructor
	public AnswerDto() {
	}

	// Constructor from Answer entity
	public AnswerDto(Answer answer) {
		this.id = answer.getId();
		this.answerId = answer.getAnswerId();
		this.questionId = answer.getQuestionId();
		this.body = answer.getBody();
		this.score = answer.getScore();
		this.isAccepted = answer.getIsAccepted();
		this.creationDate = answer.getCreationDate();
		this.hasText = answer.getHasText();
		this.hasImage = answer.getHasImage();
		this.hasVideo = answer.getHasVideo();
		this.hasCode = answer.getHasCode();
		this.createdAt = answer.getCreatedAt();
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
