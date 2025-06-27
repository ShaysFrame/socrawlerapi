package pub.shay.socrawlerapi.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pub.shay.socrawlerapi.model.Post;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

	Optional<Post> findByPostId(Long postId);

	@Query("SELECT p FROM Post p WHERE " +
			"(:search IS NULL OR LOWER(p.title) LIKE LOWER(CONCAT('%', :search, '%')) OR LOWER(p.body) LIKE LOWER(CONCAT('%', :search, '%'))) AND "
			+
			"(:minScore IS NULL OR p.score >= :minScore) AND " +
			"(:maxScore IS NULL OR p.score <= :maxScore) AND " +
			"(:hasCode IS NULL OR p.hasCode = :hasCode) AND " +
			"(:hasImage IS NULL OR p.hasImage = :hasImage) AND " +
			"(:tags IS NULL OR p.tags LIKE CONCAT('%', :tags, '%')) AND " +
			"(:startDate IS NULL OR p.date >= :startDate) AND " +
			"(:endDate IS NULL OR p.date <= :endDate)")
	Page<Post> findPostsWithFilters(
			@Param("search") String search,
			@Param("minScore") Integer minScore,
			@Param("maxScore") Integer maxScore,
			@Param("hasCode") Boolean hasCode,
			@Param("hasImage") Boolean hasImage,
			@Param("tags") String tags,
			@Param("startDate") Long startDate,
			@Param("endDate") Long endDate,
			Pageable pageable);

	@Query("SELECT COUNT(p) FROM Post p")
	long getTotalPostCount();

	@Query("SELECT p.type, COUNT(p) FROM Post p GROUP BY p.type")
	List<Object[]> getPostTypeDistribution();

	@Query("SELECT " +
			"CAST(strftime('%Y', datetime(p.date, 'unixepoch')) AS INTEGER) as year, " +
			"CAST(strftime('%m', datetime(p.date, 'unixepoch')) AS INTEGER) as month, " +
			"COUNT(p) as postCount " +
			"FROM Post p " +
			"GROUP BY year, month " +
			"ORDER BY year, month")
	List<Object[]> getTimelineData();
}
