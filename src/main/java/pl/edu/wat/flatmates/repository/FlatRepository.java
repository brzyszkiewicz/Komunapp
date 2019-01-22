package pl.edu.wat.flatmates.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.wat.flatmates.beans.Flat;

@Repository
public interface FlatRepository extends JpaRepository<Flat,Integer> {
    Flat findByFlatname(String flatname);
}
