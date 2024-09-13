package com.example.xraylaxadb2;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OnlineCat {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String OnlineCatId;

    private String onlineKittenName;

    private boolean realCat;
}
