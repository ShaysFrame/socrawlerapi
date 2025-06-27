package pub.shay.socrawlerapi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pub.shay.socrawlerapi.dto.AnalyticsResponse;
import pub.shay.socrawlerapi.service.AnalyticsService;

import java.util.List;

@RestController
@RequestMapping("/api/analytics")
@Tag(name = "Analytics", description = "Database Analytics API")
public class AnalyticsController {

	@Autowired
	private AnalyticsService analyticsService;

	@GetMapping
	@Operation(summary = "Get complete analytics", description = "Retrieve complete analytics data including statistics and timeline")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Successfully retrieved analytics data")
	})
	public ResponseEntity<AnalyticsResponse> getCompleteAnalytics() {
		try {
			AnalyticsResponse response = analyticsService.getCompleteAnalytics();
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			return ResponseEntity.internalServerError().build();
		}
	}

	@GetMapping("/stats")
	@Operation(summary = "Get database statistics", description = "Retrieve database statistics only")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Successfully retrieved statistics")
	})
	public ResponseEntity<AnalyticsResponse.Statistics> getStatistics() {
		try {
			AnalyticsResponse.Statistics statistics = analyticsService.getStatistics();
			return ResponseEntity.ok(statistics);
		} catch (Exception e) {
			return ResponseEntity.internalServerError().build();
		}
	}

	@GetMapping("/timeline")
	@Operation(summary = "Get timeline data", description = "Retrieve timeline data for charts")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Successfully retrieved timeline data")
	})
	public ResponseEntity<List<AnalyticsResponse.TimelineData>> getTimelineData() {
		try {
			List<AnalyticsResponse.TimelineData> timeline = analyticsService.getTimelineData();
			return ResponseEntity.ok(timeline);
		} catch (Exception e) {
			return ResponseEntity.internalServerError().build();
		}
	}
}
