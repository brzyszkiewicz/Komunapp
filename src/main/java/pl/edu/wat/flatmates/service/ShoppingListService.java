package pl.edu.wat.flatmates.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.wat.flatmates.beans.Shoppingitem;
import pl.edu.wat.flatmates.beans.Shoppinglist;
import pl.edu.wat.flatmates.dto.IdDto;
import pl.edu.wat.flatmates.dto.ShoppingListDto;
import pl.edu.wat.flatmates.repository.ShoppingItemRepository;
import pl.edu.wat.flatmates.repository.ShoppingListRepository;
import pl.edu.wat.flatmates.utils.UserUtils;

import java.util.Calendar;
import java.util.List;

@Service
public class ShoppingListService {

    @Autowired
    ShoppingListRepository listRepository;

    @Autowired
    ShoppingItemRepository shoppingItemRepository;

    @Autowired
    UserUtils userUtils;

    public List<Shoppinglist> getFlatShoppingLists(){
        List<Shoppinglist> lists;
        Integer flatId;

        flatId = userUtils.getCurrentUser().getFlatid().getFlatid();

        lists = listRepository.findByFlatidFlatid(flatId);

        return lists;
    }

    public IdDto createShoppingList(ShoppingListDto shoppingListDto) throws Exception {
        Shoppinglist shoppinglist = new Shoppinglist();

        if(shoppingListDto != null || !shoppingListDto.getDescription().isEmpty()) {

            shoppinglist.setFlatid(userUtils.getCurrentUser().getFlatid());
            shoppinglist.setCreatedate(Calendar.getInstance().getTime());
            shoppinglist.setDescription(shoppingListDto.getDescription());
            shoppinglist.setUserid(userUtils.getCurrentUser());
            shoppinglist = listRepository.save(shoppinglist);
            return new IdDto(shoppinglist.getShoppinglistid());
        } else
            throw new Exception("Shopping list description is empty!");

    }

    public void deleteShoppingList(Integer shoppingListId) {

        Shoppinglist shoppingList = listRepository.getOne(shoppingListId);
        List<Shoppingitem> shoppingItems= shoppingItemRepository.findByShoppinglistid(shoppingList);
        shoppingItemRepository.deleteAll(shoppingItems);
        listRepository.delete(shoppingList);

    }
}
