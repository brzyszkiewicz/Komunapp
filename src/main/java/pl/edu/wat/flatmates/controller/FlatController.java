package pl.edu.wat.flatmates.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;
import pl.edu.wat.flatmates.dto.FlatDTO;
import pl.edu.wat.flatmates.dto.IdDto;
import pl.edu.wat.flatmates.service.FlatService;


@Slf4j
@RestController
public class FlatController {

    @Autowired
    FlatService flatService;

    @RequestMapping(path = "/flat",
                    method = RequestMethod.POST,
                    consumes = MediaType.APPLICATION_JSON_VALUE,
                    produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<IdDto> createFlat(@RequestBody FlatDTO flat){
        try{
            Integer flatId = flatService.createFlat(flat);
            return ResponseEntity.ok(new IdDto(flatId));

        } catch (Exception e){
            log.error("Something went wrong",e);
            return ResponseEntity.unprocessableEntity().build();
        }
    }
    @RequestMapping(path = "/flat",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<IdDto> getFlat(){
        return ResponseEntity.ok(new IdDto(flatService.getFlatId()));
    }
}
