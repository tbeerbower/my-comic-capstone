package com.techelevator.controller;

import com.techelevator.model.Character;
import com.techelevator.model.Comic;
import com.techelevator.repository.ComicRepository;
import com.techelevator.service.ComicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RepositoryRestController
@PreAuthorize("hasRole('ROLE_USER')")
public class ComicController {

    private final PagedResourcesAssembler<Comic> pagedAssembler;
    private final ComicRepository repository;
    private final ComicService service;

    @Autowired
    public ComicController(PagedResourcesAssembler<Comic> pagedAssembler, ComicRepository repository, ComicService service) {
        this.pagedAssembler = pagedAssembler;
        this.repository = repository;
        this.service = service;
    }

    @RequestMapping(method= RequestMethod.GET, path="/comics", produces = "application/hal+json")
    public ResponseEntity<Page<Comic>> getComicsHal(Pageable pageRequest,
                                                    //PersistentEntityResourceAssembler assembler,
                                                    //ComicRepresentationModelAssembler assembler,
                                                    @RequestParam Optional<Comic.Source> source){

        Page<Comic> comics;
        switch (source.orElseGet(() -> Comic.Source.INTERNAL)) {
            case MARVEL:
                comics = service.getComicsFromMarvel(pageRequest);
                break;
            case COMIC_VINE:
                comics = service.getComicsFromComicVine(pageRequest);
                break;
            default:
                comics = repository.findAll(pageRequest);
                break;
        }
        ComicRepresentationModelAssembler assembler = new ComicRepresentationModelAssembler(source);
        Link link = linkTo(methodOn(ComicController.class).getComicsHal(pageRequest, source)).withSelfRel();

        // TODO : query param for source
        PagedModel pagedModel = pagedAssembler.toModel(comics, assembler, link);
        return new ResponseEntity(pagedModel, HttpStatus.OK);
    }



    @RequestMapping(method= RequestMethod.GET, path="/comics/{id}", produces = "application/hal+json")
    public ResponseEntity<Comic> getComicHal(@PathVariable Long id,
                                             //ComicRepresentationModelAssembler assembler,
                                             @RequestParam Optional<Comic.Source> source){
        Comic comic;
        switch (source.orElseGet(() -> Comic.Source.INTERNAL)) {
            case MARVEL:
                comic = service.getComicFromMarvel(id);
                break;
            case COMIC_VINE:
                comic = service.getComicFromComicVine(id);
                break;
            default:
                comic = repository.findById(id).orElse(null);
                break;
        }

        if (comic != null) {
            ComicRepresentationModelAssembler assembler = new ComicRepresentationModelAssembler(source);
            return new ResponseEntity(assembler.toModel(comic), HttpStatus.OK);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "entity not found");
    }


    // TODO
    @RequestMapping(method= RequestMethod.GET, path="/comics/{id}/characters", produces = "application/hal+json")
    public ResponseEntity<CollectionModel<EntityModel<Character>>> getComicCharactersHal(@PathVariable Long id){

        Comic comic = repository.findById(id).orElse(null);
        if (comic != null) {
            CharacterRepresentationModelAssembler assembler = new CharacterRepresentationModelAssembler(id);

            return new ResponseEntity(assembler.toCollectionModel(comic.getCharacters()), HttpStatus.OK);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "entity not found");
    }
}
