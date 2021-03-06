package pl.edu.wat.flatmates.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.wat.flatmates.beans.Shoppinglist;
import pl.edu.wat.flatmates.dto.IdDto;
import pl.edu.wat.flatmates.dto.ShoppingListDto;
import pl.edu.wat.flatmates.service.ShoppingListService;

import java.util.List;

@RestController
public class ShoppingListController {

    @Autowired
    ShoppingListService shoppingListService;

    @RequestMapping(path = "/shoppingList",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<List<Shoppinglist>> getShoppingLists() {
        List<Shoppinglist> lists = shoppingListService.getFlatShoppingLists();

        if (lists.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(lists);
    }

    @RequestMapping(path = "/shoppingList",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<IdDto> createShoppingList(@RequestBody ShoppingListDto shoppingListDto) {
        IdDto result;
        try {
            result = shoppingListService.createShoppingList(shoppingListDto);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(result);
    }

    @RequestMapping(path = "/shoppingList/{shoppingListId}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity deleteShoppingList(@PathVariable Integer shoppingListId) {

        shoppingListService.deleteShoppingList(shoppingListId);

        return ResponseEntity.ok().build();
    }
}