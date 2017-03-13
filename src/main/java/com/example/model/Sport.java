package com.example.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "sports")
public class Sport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "sport")
    private List<League> leagues;

    public Sport(List<League> leagues) {
        this.leagues = leagues;
    }

    public Long getId() {
        return id;
    }

    public List<League> getLeagues() {
        return leagues;
    }
}
