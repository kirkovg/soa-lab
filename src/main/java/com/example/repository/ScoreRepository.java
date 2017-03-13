package com.example.repository;

import com.example.model.Score;

import java.util.List;

/**
 * Created by Win 8 on 13.03.2017.
 */
public interface ScoreRepository {

    List<Score> getScoresByLeague(String leagueName);

    List<Score> getScoresBySport(String sportName);
}
