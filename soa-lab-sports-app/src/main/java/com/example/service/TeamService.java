package com.example.service;

import com.example.model.Team;


public interface TeamService {

    Team addTeam(String name, Long leagueId);

    Team findTeamByName(String name);
}
