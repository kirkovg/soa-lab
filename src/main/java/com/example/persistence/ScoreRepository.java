package com.example.persistence;

import com.example.model.Score;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScoreRepository extends CrudRepository<Score, Long> {

    // spring data methods
    List<Score> findScoresByLeagueName(String leagueName);
}
