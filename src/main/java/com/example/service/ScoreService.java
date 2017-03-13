package com.example.service;

import com.example.model.League;
import com.example.model.Score;
import com.example.model.Sport;

import java.util.List;

/**
 * Created by Win 8 on 13.03.2017.
 */
public interface ScoreService {
    List<Score> getResultsByLeague(String leagueName);

    List<Score> getResultsBySport(String sportName);
}
