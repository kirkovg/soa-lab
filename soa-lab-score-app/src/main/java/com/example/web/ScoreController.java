package com.example.web;

import com.example.model.Score;
import com.example.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api", produces = "application/json")
public class ScoreController {

    private ScoreService scoreService;

    @Autowired
    public ScoreController(ScoreService scoreService) {
        this.scoreService = scoreService;
    }

    @RequestMapping(value = "/addScore", method = RequestMethod.POST)
    public Score addScore(@RequestParam(value = "hostTeam") String hostTeam,
                         @RequestParam(value = "guestTeam") String guestTeam,
                         @RequestParam(value = "leagueName") String league,
                         @RequestParam(value = "hostScore") Integer hostScore,
                         @RequestParam(value = "guestScore") Integer guestScore) {
        return scoreService.addScore(hostTeam, guestTeam, league, hostScore, guestScore);
    }

    @RequestMapping(value = "/findAllScores", method = RequestMethod.GET)
    public List<Score> findAllScores(){
        return scoreService.findAll();
    }
}
