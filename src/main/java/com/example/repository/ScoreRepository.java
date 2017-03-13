package com.example.repository;

import com.example.model.Score;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Win 8 on 13.03.2017.
 */

@Repository
public interface ScoreRepository extends CrudRepository<Score, Long>{

}
