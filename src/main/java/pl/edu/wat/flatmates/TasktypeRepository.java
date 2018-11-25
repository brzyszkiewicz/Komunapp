package pl.edu.wat.flatmates;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.wat.flatmates.beans.Tasktype;

@Repository
public interface TasktypeRepository extends JpaRepository<Tasktype, Integer> {
}
