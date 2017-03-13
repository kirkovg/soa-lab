package com.example.service.impl;

import com.example.model.Score;
import com.example.service.ScoreService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Win 8 on 13.03.2017.
 */
@Service
public class ScoreServiceImpl implements ScoreService {


    @Override
    public List<Score> getResultsByLeague(String leagueName) {
        return null;
    }

    @Override
    public List<Score> getResultsBySport(String sportName) {
        return null;
    }
}
