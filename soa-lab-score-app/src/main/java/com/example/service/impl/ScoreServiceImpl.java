package com.example.service.impl;

import com.example.model.Score;
import com.example.persistence.ScoreRepository;
import com.example.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreServiceImpl implements ScoreService {

    private final ScoreRepository scoreRepository;

    @Autowired
    public ScoreServiceImpl(ScoreRepository scoreRepository) {
        this.scoreRepository = scoreRepository;

    }

    @Override
    public Score addScore(String hostTeam, String guestTeam, String league, Integer hostScore, Integer guestScore) {
        Score score = new Score(hostTeam, guestTeam, league, hostScore, guestScore);
        return scoreRepository.save(score);
    }

    @Override
    public List<Score> findAll() {
        return (List<Score>) scoreRepository.findAll();
    }


}
