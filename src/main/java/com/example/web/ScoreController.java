package com.example.web;

import com.example.model.Score;
import com.example.repository.ScoreRepository;
import com.example.repository.impl.ScoreRepositoryImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Win 8 on 13.03.2017.
 */
@RestController
@RequestMapping(value = "/api",produces = "application/json")
public class ScoreController {

    private ScoreRepository scoreRepository;

    @Autowired
    public ScoreController(ScoreRepository scoreRepository) {
        this.scoreRepository = scoreRepository;
    }

    @RequestMapping(value = "/getScoresByLeague", method = RequestMethod.GET)
    public List<Score> getScoresByLeague(@RequestParam(value = "leagueName", defaultValue = "Premier League") String leagueName) {
        return scoreRepository.getScoresByLeague(leagueName);
    }

    @RequestMapping(value = "/getScoresBySport",method = RequestMethod.GET)
    public List<Score> getScoresBySport(@RequestParam(value="sportName", defaultValue = "football") String sportName) {
        return scoreRepository.getScoresBySport(sportName);
    }
}
