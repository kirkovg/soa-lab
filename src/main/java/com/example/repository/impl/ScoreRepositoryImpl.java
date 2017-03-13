package com.example.repository.impl;

import com.example.model.Score;
import com.example.repository.ScoreRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Win 8 on 13.03.2017.
 */
@Repository
public class ScoreRepositoryImpl implements ScoreRepository{

    @PersistenceContext(name = "soa-2017")
    EntityManager entityManager;

    public List<Score> getScoresByLeague(String leagueName) {
        return null;
    }

    public List<Score> getScoresBySport(String sportName) {
        return null;
    }
}
