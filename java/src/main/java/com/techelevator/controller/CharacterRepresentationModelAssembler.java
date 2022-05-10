package com.techelevator.controller;

import com.techelevator.model.Character;
import com.techelevator.model.Comic;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.SimpleRepresentationModelAssembler;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

public class CharacterRepresentationModelAssembler implements SimpleRepresentationModelAssembler<Character> {

    private final Long id;

    public CharacterRepresentationModelAssembler(Long id) {
        this.id = id;
    }


    @Override
    public void addLinks(EntityModel<Character> resource) {
    }

    @Override
    public void addLinks(CollectionModel<EntityModel<Character>> resources) {
        Link link = linkTo(methodOn(ComicController.class).getComicCharactersHal(id)).withSelfRel();
        resources.add(link);
    }
}
