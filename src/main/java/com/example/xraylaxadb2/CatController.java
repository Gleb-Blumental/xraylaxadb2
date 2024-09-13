package com.example.xraylaxadb2;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cats")
@RequiredArgsConstructor
public class CatController {

    private final CatService service;

    @PostMapping
    public ResponseEntity<String> createCat(@RequestBody Cat cat){
        var created = service.createCat(cat);

        if(created){
            return new ResponseEntity<>("cat created successfully", HttpStatus.CREATED);
        }
        else{
            return new ResponseEntity<>("Failed to create cat", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public Iterable<Cat> getCats(){
        var cats = service.getCats();
        return cats;
    }
}
