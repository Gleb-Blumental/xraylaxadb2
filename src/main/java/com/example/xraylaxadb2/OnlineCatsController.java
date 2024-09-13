package com.example.xraylaxadb2;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("onlinekitten")
@RequiredArgsConstructor
public class OnlineCatsController {

    private final OnlineCatService service;

    @PostMapping
    public String createOnlineKitten(){
        return "Online kitten created!";
    }

    @GetMapping
    public Iterable<OnlineCat> getOnlineCats(){
        var cats = service.getOnlineCats();
        return cats;
    }
}
