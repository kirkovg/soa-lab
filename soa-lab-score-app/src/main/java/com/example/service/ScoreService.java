package com.example.service;

import com.example.model.Score;

import java.util.List;

public interface ScoreService {

    Score addScore(String hostTeam, String guestTeam, String league, Integer hostScore, Integer guestScore);

    List<Score> findAll();
}
