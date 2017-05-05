package com.example.service;

import com.example.model.League;

import java.util.List;

public interface LeagueService {

    League addLeague(String name, Long sportId);

    League findLeagueByName(String name);

    List<League> findAllLeagues();
}
