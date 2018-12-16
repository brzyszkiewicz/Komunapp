package pl.edu.wat.flatmates.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import pl.edu.wat.flatmates.beans.Shoppinglist;
import pl.edu.wat.flatmates.dto.ShoppingListDto;
import pl.edu.wat.flatmates.repository.ShoppingListRepository;

import java.util.Calendar;

@Service
public class ShoppingListService {

    @Autowired
    ShoppingListRepository listRepository;

    public Integer createShoppingList(ShoppingListDto list){
        Shoppinglist result = new Shoppinglist();

        result.setDescription(list.getDescription());

        System.out.println(list.getDescription());

        result.setCreatedate(Calendar.getInstance().getTime());

        result = listRepository.save(result);

        return result.getShoppinglistid();

    }
}
