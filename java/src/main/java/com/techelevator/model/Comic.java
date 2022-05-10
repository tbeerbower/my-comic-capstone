package com.techelevator.model;


import org.springframework.data.domain.AbstractAggregateRoot;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames = {"source", "sourceId"})})
public class Comic extends AbstractAggregateRoot {

    public enum Source {
        MARVEL,
        COMIC_VINE,
        INTERNAL
    }

    @Id
    @Column(
        updatable = false
    )
    @GeneratedValue(
        strategy = GenerationType.IDENTITY
    )
    private Long id;

    private String title;

    private String series;

    private String image;

    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinTable(name="comic_creator",
        joinColumns={@JoinColumn(name="comic_id")},
        inverseJoinColumns={@JoinColumn(name="creator_id")})
    private Set<Creator> creators;

    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinTable(name="comic_character",
        joinColumns={@JoinColumn(name="comic_id")},
        inverseJoinColumns={@JoinColumn(name="character_id")})
    private Set<Character> characters;

    @Enumerated(EnumType.ORDINAL)
    private Source source;

    private Long sourceId;

    public Comic() {
    }

    public Comic(Long id, String title, String series, String image,
                 Set<Creator> creators, Set<Character> characters,
                 Source source, Long sourceId) {
        this.id = id;
        this.title = title;
        this.series = series;
        this.image = image;
        this.creators = creators;
        this.characters = characters;
        this.source = source;
        this.sourceId = sourceId;
    }

    public Comic registerCreationEvent() {
        registerEvent(new Comic.CreationEvent());
        return this;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Set<Creator> getCreators() {
        return creators;
    }

    public void setCreators(Set<Creator> creators) {
        this.creators = creators;
    }

    public Set<Character> getCharacters() {
        return characters;
    }

    public void setCharacters(Set<Character> characters) {
        this.characters = characters;
    }

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    public Long getSourceId() {
        return source == Source.INTERNAL ? id : sourceId;
    }

    public void setSourceId(Long sourceId) {
        this.sourceId = sourceId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comic comic = (Comic) o;
        return id.equals(comic.id) && title.equals(comic.title) && Objects.equals(series, comic.series) && Objects.equals(image, comic.image) && Objects.equals(creators, comic.creators) && Objects.equals(characters, comic.characters) && source == comic.source && sourceId.equals(comic.sourceId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, series, image, creators, characters, source, sourceId);
    }

    public class CreationEvent {
        public Comic getComic() {
            return Comic.this;
        }
    }
}
