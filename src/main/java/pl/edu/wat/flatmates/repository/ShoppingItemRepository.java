package pl.edu.wat.flatmates.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.wat.flatmates.beans.Shoppingitem;
import pl.edu.wat.flatmates.beans.Shoppinglist;

import java.util.List;

@Repository
public interface ShoppingItemRepository extends JpaRepository<Shoppingitem,Integer> {
    List<Shoppingitem> findByShoppinglistid(Shoppinglist list);
}
