package com.techelevator.repository;

import com.techelevator.model.Comic;
import com.techelevator.model.User;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;

@RepositoryEventHandler
public class EventHandler {

    @HandleBeforeCreate
    public void handleComicBeforeCreate(Comic comic) {
        comic.registerCreationEvent();
    }

    @HandleBeforeCreate
    public void handleUserBeforeCreate(User user) {
        user.registerCreationEvent();
    }
}
