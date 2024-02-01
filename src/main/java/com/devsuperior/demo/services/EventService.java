package com.devsuperior.demo.services;

import com.devsuperior.demo.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {

    @Autowired
    private EventRepository repository;



}
