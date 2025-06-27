package pub.shay.socrawlerapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pub.shay.socrawlerapi.model.Answer;

import java.util.List;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {

	List<Answer> findByQuestionIdOrderByScoreDesc(Long questionId);

	@Query("SELECT COUNT(a) FROM Answer a")
	long getTotalAnswerCount();

	@Query("SELECT a FROM Answer a WHERE a.questionId = :questionId ORDER BY " +
			"CASE WHEN a.isAccepted = true THEN 0 ELSE 1 END, a.score DESC")
	List<Answer> findByQuestionIdOrderByAcceptedAndScore(@Param("questionId") Long questionId);
}
