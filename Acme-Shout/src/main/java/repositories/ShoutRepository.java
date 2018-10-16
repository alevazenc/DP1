
package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import domain.Shout;

public interface ShoutRepository extends JpaRepository<Shout, Integer> {

	@Query("select count(s) from Shout s")
	public long countAllShouts();

	@Query("select count(s) from Shout s where length(s.text) <= 25")
	public long countShortShouts();

	@Query("select count(s) from Shout s where length(s.text) > 25")
	public long countLongShouts();

}
