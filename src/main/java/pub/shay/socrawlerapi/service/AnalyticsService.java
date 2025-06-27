package pub.shay.socrawlerapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import pub.shay.socrawlerapi.dto.AnalyticsResponse;
import pub.shay.socrawlerapi.repository.AnswerRepository;
import pub.shay.socrawlerapi.repository.PostRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AnalyticsService {

	@Autowired
	private PostRepository postRepository;

	@Autowired
	private AnswerRepository answerRepository;

	@Cacheable("analytics")
	public AnalyticsResponse getCompleteAnalytics() {
		AnalyticsResponse.Statistics statistics = getStatistics();
		List<AnalyticsResponse.TimelineData> timeline = getTimelineData();

		return new AnalyticsResponse(statistics, timeline);
	}

	@Cacheable("analytics-stats")
	public AnalyticsResponse.Statistics getStatistics() {
		long totalPosts = postRepository.getTotalPostCount();
		long totalAnswers = answerRepository.getTotalAnswerCount();

		// Get post type distribution
		List<Object[]> postTypeData = postRepository.getPostTypeDistribution();
		Map<String, Long> postTypes = new HashMap<>();

		for (Object[] row : postTypeData) {
			String type = (String) row[0];
			Long count = (Long) row[1];
			if (type != null) {
				postTypes.put(type, count);
			}
		}

		return new AnalyticsResponse.Statistics(totalPosts, totalAnswers, postTypes);
	}

	@Cacheable("analytics-timeline")
	public List<AnalyticsResponse.TimelineData> getTimelineData() {
		List<Object[]> timelineRawData = postRepository.getTimelineData();

		return timelineRawData.stream()
				.map(row -> {
					Integer year = (Integer) row[0];
					Integer month = (Integer) row[1];
					Long postCount = (Long) row[2];
					return new AnalyticsResponse.TimelineData(year, month, postCount);
				})
				.collect(Collectors.toList());
	}
}
