package com.example.service;

import com.example.model.Sport;

import java.util.List;

public interface SportService {

    Sport addSport(String name);

    List<Sport> findAll();
}
