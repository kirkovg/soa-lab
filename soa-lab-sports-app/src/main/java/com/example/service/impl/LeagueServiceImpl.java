package com.example.service.impl;

import com.example.model.League;
import com.example.model.Sport;
import com.example.persistence.LeagueRepository;
import com.example.persistence.SportRepository;
import com.example.service.LeagueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeagueServiceImpl implements LeagueService {

    private final LeagueRepository leagueRepository;
    private final SportRepository sportRepository;

    @Autowired
    public LeagueServiceImpl(LeagueRepository leagueRepository, SportRepository sportRepository) {
        this.leagueRepository = leagueRepository;
        this.sportRepository = sportRepository;
    }

    @Override
    public League addLeague(String name, Long sportId) {
        Sport sport = sportRepository.findOne(sportId);
        League league = new League(name, sport);
        return leagueRepository.save(league);
    }

    @Override
    public League findLeagueByName(String name) {
        return leagueRepository.findLeagueByName(name);
    }

    @Override
    public List<League> findAllLeagues(){
        return (List<League>) leagueRepository.findAll();
    }
}

