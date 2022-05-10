package com.techelevator.service;

import com.techelevator.model.Character;
import com.techelevator.model.Comic;
import com.techelevator.model.Creator;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ComicService {
    private static final String MARVEL_COMIC_URL_FORMAT = "https://gateway.marvel.com:443/v1/public/comics/%d?apikey=54fc1b38a0d9986d48fabdb6ab3170c3&hash=a9d690da39f192a95a3b3d32acbc3b3c&ts=1";
    private static final String MARVEL_COMICS_URL_FORMAT = "https://gateway.marvel.com:443/v1/public/comics?apikey=54fc1b38a0d9986d48fabdb6ab3170c3&hash=a9d690da39f192a95a3b3d32acbc3b3c&ts=1%s";

    private static final String COMIC_VINE_COMIC_URL_FORMAT = "https://www.comicvine.gamespot.com/api/issue/4000-%d?format=json&api_key=52edd43bd7875b4228905801a53263202c76d653";
    private static final String COMIC_VINE_COMICS_URL_FORMAT = "https://www.comicvine.com/api/issues?format=json&api_key=52edd43bd7875b4228905801a53263202c76d653%s";
//    https://comicvine.gamespot.com/api/search/?api_key= api_key&format=json&limit=1&offset=0&field_list=id,name,deck,volume&sort=name:asc&resources=issue&query=Feynman

    private static final String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/100.0.4896.88 Safari/537.36";

    private final RestTemplate restTemplate;

    public ComicService() {
        this.restTemplate = new RestTemplate();
    }

    // Marvel
    public Comic getComicFromMarvel(Long id) {
        Marvel.ComicResponse response = restTemplate.getForObject(String.format(MARVEL_COMIC_URL_FORMAT, id), Marvel.ComicResponse.class);
        if (response != null) {
            List<Marvel.Result> results = response.getData().getResults();
            if (response.getCode() == HttpStatus.OK.value() && results.size() > 0) {
                return mapMarvelResponseToComic(results.get(0));
            }
        }
        // TODO : response if null?
        return null;
    }

    public Page<Comic> getComicsFromMarvel(Pageable pageRequest) {
        List<Comic> comics = new ArrayList<>();
        String pageParams = "";

        if (pageRequest != null && pageRequest.isPaged()){
            pageParams = String.format("&limit=%d&offset=%d", pageRequest.getPageSize(), pageRequest.getOffset());
//            Sort sort = pageRequest.getSort();
//            if (sort.isSorted()) {
//            }
        }

        Marvel.ComicResponse response =
            restTemplate.getForObject(String.format(MARVEL_COMICS_URL_FORMAT, pageParams), Marvel.ComicResponse.class);
        if (response != null && response.getCode() == HttpStatus.OK.value()) {
            List<Marvel.Result> results = response.getData().getResults();
            for (Marvel.Result result : results) {
                comics.add(mapMarvelResponseToComic(result));
            }
            return pageRequest == null ? new PageImpl<>(comics) : new PageImpl<>(comics, pageRequest, response.getData().getTotal());
        }
        return new PageImpl<>(comics);
    }



    // ComicVine

    public Comic getComicFromComicVine(Long id) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set(HttpHeaders.USER_AGENT, USER_AGENT);
        HttpEntity<ComicVine.ComicResponse> entity = new HttpEntity<>(headers);

        ResponseEntity<ComicVine.ComicResponse> response =
            restTemplate.exchange(String.format(COMIC_VINE_COMIC_URL_FORMAT, id), HttpMethod.GET, entity, ComicVine.ComicResponse.class);

        if (response != null) {
            ComicVine.ResultResource result = response.getBody().getResults();
            return mapComicVineResponseToComic(result);
        }
        // TODO : response if null?
        return null;
    }
    public Page<Comic> getComicsFromComicVine(Pageable pageRequest) {
        List<Comic> comics = new ArrayList<>();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set(HttpHeaders.USER_AGENT, USER_AGENT);
        HttpEntity<ComicVine.ComicsResponse> entity = new HttpEntity<>(headers);

        String pageParams = "";
        if (pageRequest != null && pageRequest.isPaged()){
            pageParams = String.format("&limit=%d&offset=%d", pageRequest.getPageSize(), pageRequest.getOffset());
//            Sort sort = pageRequest.getSort();
//            if (sort.isSorted()) {
//            }
        }
        ResponseEntity<ComicVine.ComicsResponse> response =
            restTemplate.exchange(String.format(COMIC_VINE_COMICS_URL_FORMAT, pageParams), HttpMethod.GET, entity, ComicVine.ComicsResponse.class);
        if (response != null && response.getBody().getStatusCode() == 1) {
            List<ComicVine.ResultResource> results = response.getBody().getResults();
            for (ComicVine.ResultResource result : results) {
                comics.add(mapComicVineResponseToComic(result));
            }
            return pageRequest == null ? new PageImpl<>(comics) : new PageImpl<>(comics, pageRequest, response.getBody().getNumberOfTotalResults());
        }
        return new PageImpl<>(comics);
    }





    private Comic mapMarvelResponseToComic(Marvel.Result result) {

        List<Marvel.Image> images = result.getImages();
        String image = "";
        if (images.size() > 0) {
            image = String.format("%s.%s", images.get(0).getPath(), images.get(0).getExtension());
        } else {
            image = String.format("%s.%s", result.getThumbnail().getPath(), result.getThumbnail().getExtension());
        }
        Set<Creator> creators;
        List<Marvel.CreatorItem> creatorItems = result.getCreators().getItems();
        creators = creatorItems.stream().map(
            creatorItem -> new Creator(0L, creatorItem.getName())).collect(Collectors.toSet());

        Set<Character> characters;
        List<Marvel.Character> characterItems = result.getCharacters().getItems();
        characters = characterItems.stream().map(
            characterItem -> new Character(0L, characterItem.getName())).collect(Collectors.toSet());

        String name = result.getTitle();
        Marvel.Series series = result.getSeries();
        String seriesName = series == null ? name : series.getName();
        Integer issueNumber = result.getIssueNumber();
        String title = name == null || name.isBlank() ?
            issueNumber == null ? seriesName : String.format("%s #%s", seriesName, issueNumber) : name;

        return new Comic(0L, title, seriesName,
            image, creators, characters,
            Comic.Source.MARVEL, Long.valueOf(result.getId()));
    }


    private Comic mapComicVineResponseToComic(ComicVine.ResultResource result) {
        Set<Creator> creators = new HashSet<>();
        if (result.getPersonCredits() != null) {
            creators = result.getPersonCredits().stream().map(
                personCredit -> new Creator(0L, personCredit.getName())).collect(Collectors.toSet());
        }

        Set<Character> characters = new HashSet<>();
        if (result.getCharacterCredits()!= null) {
            characters = result.getCharacterCredits().stream().map(
                characterCredit -> new Character(0L, characterCredit.getName())).collect(Collectors.toSet());
        }

        String name = result.getName();
        ComicVine.Resource volume = result.getVolume();
        String series = volume == null ? name : volume.getName();
        String issueNumber = result.getIssueNumber();
        String title = name == null || name.isBlank() ?
            issueNumber == null ? series : String.format("%s #%s", series, issueNumber) : name;

        return new Comic(0L, title, series,
            result.getImage().getOriginalUrl(), creators, characters,
            Comic.Source.COMIC_VINE, (long) result.getId());
    }
}
