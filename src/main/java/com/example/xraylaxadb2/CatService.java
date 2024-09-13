package com.example.xraylaxadb2;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;

@Service
@RequiredArgsConstructor
public class CatService {

    @Autowired
    private final CatRepository repository;

    @Autowired
    private DataSource dataSource;


    @XRayTimed(segmentName = "Local cat surveillance")
    public boolean createCat(Cat cat) {
        try {
            repository.save(cat);
            System.out.println("Executing cat surveillance");
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    @XRayTimed(segmentName = "Get cats")
    public Iterable<Cat> getCats() {
        return repository.findAll();
    }

}
