package com.example.service;

import com.example.model.Score;

import java.util.List;

public interface ScoreService {

    Score addScore(Long hostTeamId, Long guestTeamId, Long leagueId, Integer hostScore, Integer guestScore);

    List<Score> findScoresByLeagueName(String leagueName);

    List<Score> findAll();
}
