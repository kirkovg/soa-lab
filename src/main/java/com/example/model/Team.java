package com.example.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "teams")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    private League league;

    @OneToMany(mappedBy = "team")
    private List<Player> players;

    public Team(String name, League league, List<Player> players) {
        this.name = name;
        this.league = league;
        this.players = players;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public League getLeague() {
        return league;
    }

    public List<Player> getPlayers() {
        return players;
    }
}
