package pub.shay.socrawlerapi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
@Tag(name = "Health", description = "Health Check API")
public class HealthController {

	@GetMapping("/health")
	@Operation(summary = "Health check", description = "Check if the API is running")
	public ResponseEntity<Map<String, Object>> healthCheck() {
		Map<String, Object> response = new HashMap<>();
		response.put("status", "UP");
		response.put("timestamp", LocalDateTime.now());
		response.put("service", "socrawlerapi");
		response.put("version", "1.0.0");

		return ResponseEntity.ok(response);
	}
}
