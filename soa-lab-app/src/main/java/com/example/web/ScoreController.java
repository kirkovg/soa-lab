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
    public Score addScore(@RequestParam(value = "hostTeamId") Long hostTeamId,
                         @RequestParam(value = "guestTeamId") Long guestTeamId,
                         @RequestParam(value = "LeagueId") Long leagueId,
                         @RequestParam(value = "hostScore") Integer hostScore,
                         @RequestParam(value = "guestScore") Integer guestScore) {
        return scoreService.addScore(hostTeamId, guestTeamId, leagueId, hostScore, guestScore);
    }

    @RequestMapping(value = "/findScoresByLeagueName", method = RequestMethod.GET)
    public List<Score> findScoresByLeagueName(@RequestParam(value = "leagueName") String leagueName){
        return scoreService.findScoresByLeagueName(leagueName);
    }

    @RequestMapping(value = "/findAllScores", method = RequestMethod.GET)
    public List<Score> findAllScores(){
        return scoreService.findAll();
    }
}
