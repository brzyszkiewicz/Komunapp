package pl.edu.wat.flatmates.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.wat.flatmates.beans.Shoppingitem;
import pl.edu.wat.flatmates.dto.IdDto;
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
    public ResponseEntity<IdDto> createShoppingItem(@RequestBody ItemDTO item){
        IdDto result = shoppingItemService.createItem(item);
        return ResponseEntity.ok(result);
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

    @RequestMapping(
            path = "/items/{shoppingItemId}",
            method = RequestMethod.DELETE
    )
    @ResponseBody
    public ResponseEntity deleteShoppingList(@PathVariable Integer shoppingItemId){
        try{
            shoppingItemService.deleteItem(shoppingItemId);
        } catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }


}
