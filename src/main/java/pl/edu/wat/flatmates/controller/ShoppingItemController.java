package pl.edu.wat.flatmates.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.wat.flatmates.beans.Shoppingitem;
import pl.edu.wat.flatmates.dto.ItemDTO;
import pl.edu.wat.flatmates.service.ShoppingItemService;

import java.util.List;

@RestController
public class ShoppingItemController {

    @Autowired
    private ShoppingItemService shoppingItemService;

    @RequestMapping(
            path = "/items",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    public ResponseEntity createShoppingItem(@RequestBody ItemDTO item){
        shoppingItemService.createItem(item);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(
            path = "/items/{shoppingListId}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    public ResponseEntity<List<Shoppingitem>> getShoppingListItems(@PathVariable Integer shoppingListId){
        List<Shoppingitem> list = shoppingItemService.getShoppingListItems(shoppingListId);

        return ResponseEntity.ok(list);
    }
}
