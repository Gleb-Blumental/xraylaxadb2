package com.example.xraylaxadb2;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;

@Service
@RequiredArgsConstructor
public class OnlineCatService {

    @Autowired
    private final OnlineCatRepository repository;

    @Autowired
    private DataSource dataSource;

    @XRayTimed(segmentName = "Online cat surveillance")
    public boolean createOnlineCat(OnlineCat onlineCat) {
        try {
            repository.save(onlineCat);
            System.out.println("Executing online cat surveillance");
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    @XRayTimed(segmentName = "Get online cats")
    public Iterable<OnlineCat> getOnlineCats() {
        return repository.findAll();
    }
}
