package com.techelevator.controller;

import com.techelevator.model.Comic;
import org.springframework.data.mapping.context.PersistentEntities;
import org.springframework.data.rest.core.support.SelfLinkProvider;
import org.springframework.data.rest.webmvc.PersistentEntityResourceAssembler;
import org.springframework.data.rest.webmvc.mapping.Associations;
import org.springframework.data.rest.webmvc.support.Projector;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.SimpleRepresentationModelAssembler;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;


@Component
public class ComicRepresentationModelAssembler implements SimpleRepresentationModelAssembler<Comic> {

    private final Optional<Comic.Source> source;

    public ComicRepresentationModelAssembler(Optional<Comic.Source> source) {
        this.source = source;
    }

    @Override
    public void addLinks(EntityModel<Comic> resource) {

        Long id = source.isPresent() ? resource.getContent().getSourceId() : resource.getContent().getId();

        WebMvcLinkBuilder webMvcLinkBuilder = linkTo(methodOn(ComicController.class).getComicHal(id, source ));
        resource.add(webMvcLinkBuilder.withSelfRel());
        resource.add(webMvcLinkBuilder.withRel("comic"));

        // TODO : figure out links
        //resource.add(linkTo(methodOn(ComicController.class).getComicCharactersHal(resource.getContent().getId(), this)).withRel("characters"));
    }

    @Override
    public void addLinks(CollectionModel<EntityModel<Comic>> resources) {
        for (EntityModel<Comic> resource : resources) {
            addLinks(resource);
        }
    }
}