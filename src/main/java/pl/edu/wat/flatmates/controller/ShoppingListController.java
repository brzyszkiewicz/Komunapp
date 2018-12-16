package pl.edu.wat.flatmates.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.wat.flatmates.dto.ShoppingListDto;
import pl.edu.wat.flatmates.service.ShoppingListService;

@RestController
public class ShoppingListController {

    @Autowired
    ShoppingListService shoppingListService;

    @RequestMapping(path = "/shoppingList", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Integer> createShoppingList(@RequestBody ShoppingListDto listDto){
        return ResponseEntity.ok(shoppingListService.createShoppingList(listDto));
    }
}
