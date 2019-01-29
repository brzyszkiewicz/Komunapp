package pl.edu.wat.flatmates.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.wat.flatmates.beans.Shoppinglist;
import pl.edu.wat.flatmates.dto.ShoppingListDto;
import pl.edu.wat.flatmates.repository.ShoppingListRepository;
import pl.edu.wat.flatmates.utils.UserUtils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service
public class ShoppingListService {

    @Autowired
    ShoppingListRepository listRepository;

    @Autowired
    UserUtils userUtils;

    public List<Shoppinglist> getFlatShoppingLists(){
        List<Shoppinglist> lists = new ArrayList<>();
        Integer flatId;

        flatId = userUtils.getCurrentUser().getFlatid().getFlatid();

        lists = listRepository.findByFlatid(flatId);

        return lists;
    }

    public void createShoppingList(ShoppingListDto shoppingListDto) throws Exception {
        Shoppinglist shoppinglist = new Shoppinglist();

        if(shoppingListDto != null || !shoppingListDto.getDescription().isEmpty()) {

            shoppinglist.setFlatid(userUtils.getCurrentUser().getFlatid());
            shoppinglist.setCreatedate(Calendar.getInstance().getTime());
            shoppinglist.setDescription(shoppingListDto.getDescription());
            shoppinglist.setUserid(userUtils.getCurrentUser());
            listRepository.save(shoppinglist);
        } else
            throw new Exception("Shopping list description is empty!");

    }
}
