package pl.edu.wat.flatmates.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.wat.flatmates.beans.Flat;
import pl.edu.wat.flatmates.beans.Shoppingitem;
import pl.edu.wat.flatmates.beans.Shoppinglist;
import pl.edu.wat.flatmates.dto.IdDto;
import pl.edu.wat.flatmates.dto.ItemDTO;
import pl.edu.wat.flatmates.repository.ShoppingItemRepository;
import pl.edu.wat.flatmates.repository.ShoppingListRepository;

import java.util.List;

@Service
public class ShoppingItemService {

    @Autowired
    private ShoppingItemRepository shoppingItemRepository;

    @Autowired
    private ShoppingListRepository shoppingListRepository;

    public IdDto createItem(ItemDTO item){

        Shoppinglist shoppingList = shoppingListRepository.getOne(item.getListId());

        Shoppingitem shoppingitem  = new Shoppingitem();

        shoppingitem.setDescription(item.getDescription());
        shoppingitem.setPrice(item.getPrice());
        shoppingitem.setShoppinglistid(shoppingList);

        shoppingitem = shoppingItemRepository.save(shoppingitem);

        return new IdDto(shoppingitem.getShoppingitemid());
    }

    public List<Shoppingitem> getShoppingListItems(Integer shoppingListId){

        Shoppinglist shoppingList = shoppingListRepository.getOne(shoppingListId);

        List<Shoppingitem> items = shoppingItemRepository.findByShoppinglistid(shoppingList);

        return items;
    }


}
