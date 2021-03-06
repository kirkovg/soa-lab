package com.example.web;

import com.example.model.League;
import com.example.service.LeagueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api", produces = "application/json")
public class LeagueController {

    private LeagueService leagueService;

    @Autowired
    public LeagueController(LeagueService leagueService) {
        this.leagueService = leagueService;
    }

    @RequestMapping(value = "/addLeague", method = RequestMethod.POST)
    public League addLeague(@RequestParam(value = "leagueName") String name, @RequestParam(value = "sportId") Long sportId) {
        return leagueService.addLeague(name, sportId);
    }

    @RequestMapping(value = "/findLeagueByName", method = RequestMethod.GET)
    public League findLeagueByName(@RequestParam(value = "leagueName") String name) {
        return leagueService.findLeagueByName(name);
    }

    @RequestMapping(value = "/findAllLeagues", method = RequestMethod.GET)
    public List<League> findAllLeagues() {
        return leagueService.findAllLeagues();
    }
}
