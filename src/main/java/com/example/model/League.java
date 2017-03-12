package com.example.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "leagues")
public class League {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "league")
    private List<Team> teams;

    @OneToMany(mappedBy = "league")
    private List<Score> scores;

    @ManyToOne
    private Sport sport;

    public League(List<Team> teams, List<Score> scores, Sport sport) {
        this.teams = teams;
        this.scores = scores;
        this.sport = sport;
    }

    public Long getId() {
        return id;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public List<Score> getScores() {
        return scores;
    }

    public Sport getSport() {
        return sport;
    }
}
