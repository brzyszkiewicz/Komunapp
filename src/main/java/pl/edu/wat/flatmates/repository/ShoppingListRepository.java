package pl.edu.wat.flatmates.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.wat.flatmates.beans.Shoppinglist;

@Repository
public interface ShoppingListRepository extends JpaRepository<Shoppinglist, Integer> {

}
