package com.example.model;

import javax.persistence.*;

@Entity
@Table(name = "scores")
public class Score {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String hostTeam;

    private String guestTeam;

    private String league;

    private Integer hostScore;

    private Integer guestScore;

    public Score() {}

    public Score(String hostTeam, String guestTeam, String league, Integer hostScore, Integer guestScore) {
        this.hostTeam = hostTeam;
        this.guestTeam = guestTeam;
        this.league = league;
        this.hostScore = hostScore;
        this.guestScore = guestScore;
    }

    public Long getId() {
        return id;
    }

    public String getHostTeam() {
        return hostTeam;
    }

    public String getGuestTeam() {
        return guestTeam;
    }

    public String getLeague() {
        return league;
    }

    public Integer getHostScore() {
        return hostScore;
    }

    public Integer getGuestScore() {
        return guestScore;
    }
}
