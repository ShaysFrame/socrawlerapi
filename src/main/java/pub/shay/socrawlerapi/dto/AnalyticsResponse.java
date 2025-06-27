package pub.shay.socrawlerapi.dto;

import java.util.List;
import java.util.Map;

public class AnalyticsResponse {
	private Statistics statistics;
	private List<TimelineData> timeline;

	// Default constructor
	public AnalyticsResponse() {
	}

	// Constructor
	public AnalyticsResponse(Statistics statistics, List<TimelineData> timeline) {
		this.statistics = statistics;
		this.timeline = timeline;
	}

	// Getters and Setters
	public Statistics getStatistics() {
		return statistics;
	}

	public void setStatistics(Statistics statistics) {
		this.statistics = statistics;
	}

	public List<TimelineData> getTimeline() {
		return timeline;
	}

	public void setTimeline(List<TimelineData> timeline) {
		this.timeline = timeline;
	}

	// Inner class for Statistics
	public static class Statistics {
		private long totalPosts;
		private long totalAnswers;
		private Map<String, Long> postTypes;

		public Statistics() {
		}

		public Statistics(long totalPosts, long totalAnswers, Map<String, Long> postTypes) {
			this.totalPosts = totalPosts;
			this.totalAnswers = totalAnswers;
			this.postTypes = postTypes;
		}

		public long getTotalPosts() {
			return totalPosts;
		}

		public void setTotalPosts(long totalPosts) {
			this.totalPosts = totalPosts;
		}

		public long getTotalAnswers() {
			return totalAnswers;
		}

		public void setTotalAnswers(long totalAnswers) {
			this.totalAnswers = totalAnswers;
		}

		public Map<String, Long> getPostTypes() {
			return postTypes;
		}

		public void setPostTypes(Map<String, Long> postTypes) {
			this.postTypes = postTypes;
		}
	}

	// Inner class for Timeline Data
	public static class TimelineData {
		private int year;
		private int month;
		private long postCount;

		public TimelineData() {
		}

		public TimelineData(int year, int month, long postCount) {
			this.year = year;
			this.month = month;
			this.postCount = postCount;
		}

		public int getYear() {
			return year;
		}

		public void setYear(int year) {
			this.year = year;
		}

		public int getMonth() {
			return month;
		}

		public void setMonth(int month) {
			this.month = month;
		}

		public long getPostCount() {
			return postCount;
		}

		public void setPostCount(long postCount) {
			this.postCount = postCount;
		}
	}
}
