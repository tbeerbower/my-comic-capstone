package com.techelevator.service;

import java.util.List;
import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class Marvel {

    public static class ComicResponse {

        private Integer code;
        private String status;
        private String copyright;
        private String attributionText;
        private String attributionHTML;
        private String etag;
        private Data data;

        public Integer getCode() {
            return code;
        }

        public void setCode(Integer code) {
            this.code = code;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getCopyright() {
            return copyright;
        }

        public void setCopyright(String copyright) {
            this.copyright = copyright;
        }

        public String getAttributionText() {
            return attributionText;
        }

        public void setAttributionText(String attributionText) {
            this.attributionText = attributionText;
        }

        public String getAttributionHTML() {
            return attributionHTML;
        }

        public void setAttributionHTML(String attributionHTML) {
            this.attributionHTML = attributionHTML;
        }

        public String getEtag() {
            return etag;
        }

        public void setEtag(String etag) {
            this.etag = etag;
        }

        public Data getData() {
            return data;
        }

        public void setData(Data data) {
            this.data = data;
        }
    }

    public static class Characters {

        private Integer available;
        private String collectionURI;
        private List<Character> items = null;
        private Integer returned;

        public Integer getAvailable() {
            return available;
        }

        public void setAvailable(Integer available) {
            this.available = available;
        }

        public String getCollectionURI() {
            return collectionURI;
        }

        public void setCollectionURI(String collectionURI) {
            this.collectionURI = collectionURI;
        }

        public List<Character> getItems() {
            return items;
        }

        public void setItems(List<Character> items) {
            this.items = items;
        }

        public Integer getReturned() {
            return returned;
        }

        public void setReturned(Integer returned) {
            this.returned = returned;
        }
    }

    public static class Creators {

        private Integer available;
        private String collectionURI;
        private List<CreatorItem> items = null;
        private Integer returned;

        public Integer getAvailable() {
            return available;
        }

        public void setAvailable(Integer available) {
            this.available = available;
        }

        public String getCollectionURI() {
            return collectionURI;
        }

        public void setCollectionURI(String collectionURI) {
            this.collectionURI = collectionURI;
        }

        public List<CreatorItem> getItems() {
            return items;
        }

        public void setItems(List<CreatorItem> items) {
            this.items = items;
        }

        public Integer getReturned() {
            return returned;
        }

        public void setReturned(Integer returned) {
            this.returned = returned;
        }
    }

    public static class Data {

        private Integer offset;
        private Integer limit;
        private Integer total;
        private Integer count;
        private List<Result> results = null;

        public Integer getOffset() {
            return offset;
        }

        public void setOffset(Integer offset) {
            this.offset = offset;
        }

        public Integer getLimit() {
            return limit;
        }

        public void setLimit(Integer limit) {
            this.limit = limit;
        }

        public Integer getTotal() {
            return total;
        }

        public void setTotal(Integer total) {
            this.total = total;
        }

        public Integer getCount() {
            return count;
        }

        public void setCount(Integer count) {
            this.count = count;
        }

        public List<Result> getResults() {
            return results;
        }

        public void setResults(List<Result> results) {
            this.results = results;
        }
    }

    public static class Date {

        private String type;
        private String date;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }
    }

    public static class CreatorItem {

        private String resourceURI;
        private String name;
        private String role;

        public String getResourceURI() {
            return resourceURI;
        }

        public void setResourceURI(String resourceURI) {
            this.resourceURI = resourceURI;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }
    }

    public static class StoryItem {

        private String resourceURI;
        private String name;
        private String type;

        public String getResourceURI() {
            return resourceURI;
        }

        public void setResourceURI(String resourceURI) {
            this.resourceURI = resourceURI;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }

    public static class Price {

        private String type;
        private Integer price;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public Integer getPrice() {
            return price;
        }

        public void setPrice(Integer price) {
            this.price = price;
        }
    }

    public static class Result {

        private Integer id;
        private Integer digitalId;
        private String title;
        private Integer issueNumber;
        private String variantDescription;
        private String description;
        private String modified;
        private String isbn;
        private String upc;
        private String diamondCode;
        private String ean;
        private String issn;
        private String format;
        private Integer pageCount;
        private String resourceURI;
        private List<Url> urls = null;
        private Series series;
        private List<Variant> variants = null;
        private List<Date> dates = null;
        private List<Price> prices = null;
        private Image thumbnail;
        private List<Image> images = null;
        private Creators creators;
        private Characters characters;
        private Stories stories;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getDigitalId() {
            return digitalId;
        }

        public void setDigitalId(Integer digitalId) {
            this.digitalId = digitalId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public Integer getIssueNumber() {
            return issueNumber;
        }

        public void setIssueNumber(Integer issueNumber) {
            this.issueNumber = issueNumber;
        }

        public String getVariantDescription() {
            return variantDescription;
        }

        public void setVariantDescription(String variantDescription) {
            this.variantDescription = variantDescription;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getModified() {
            return modified;
        }

        public void setModified(String modified) {
            this.modified = modified;
        }

        public String getIsbn() {
            return isbn;
        }

        public void setIsbn(String isbn) {
            this.isbn = isbn;
        }

        public String getUpc() {
            return upc;
        }

        public void setUpc(String upc) {
            this.upc = upc;
        }

        public String getDiamondCode() {
            return diamondCode;
        }

        public void setDiamondCode(String diamondCode) {
            this.diamondCode = diamondCode;
        }

        public String getEan() {
            return ean;
        }

        public void setEan(String ean) {
            this.ean = ean;
        }

        public String getIssn() {
            return issn;
        }

        public void setIssn(String issn) {
            this.issn = issn;
        }

        public String getFormat() {
            return format;
        }

        public void setFormat(String format) {
            this.format = format;
        }

        public Integer getPageCount() {
            return pageCount;
        }

        public void setPageCount(Integer pageCount) {
            this.pageCount = pageCount;
        }

        public String getResourceURI() {
            return resourceURI;
        }

        public void setResourceURI(String resourceURI) {
            this.resourceURI = resourceURI;
        }

        public List<Url> getUrls() {
            return urls;
        }

        public void setUrls(List<Url> urls) {
            this.urls = urls;
        }

        public Series getSeries() {
            return series;
        }

        public void setSeries(Series series) {
            this.series = series;
        }

        public List<Variant> getVariants() {
            return variants;
        }

        public void setVariants(List<Variant> variants) {
            this.variants = variants;
        }

        public List<Date> getDates() {
            return dates;
        }

        public void setDates(List<Date> dates) {
            this.dates = dates;
        }

        public List<Price> getPrices() {
            return prices;
        }

        public void setPrices(List<Price> prices) {
            this.prices = prices;
        }

        public Image getThumbnail() {
            return thumbnail;
        }

        public void setThumbnail(Image thumbnail) {
            this.thumbnail = thumbnail;
        }

        public List<Image> getImages() {
            return images;
        }

        public void setImages(List<Image> images) {
            this.images = images;
        }

        public Creators getCreators() {
            return creators;
        }

        public void setCreators(Creators creators) {
            this.creators = creators;
        }

        public Characters getCharacters() {
            return characters;
        }

        public void setCharacters(Characters characters) {
            this.characters = characters;
        }

        public Stories getStories() {
            return stories;
        }

        public void setStories(Stories stories) {
            this.stories = stories;
        }
    }

    public static class Series {

        private String resourceURI;
        private String name;

        public String getResourceURI() {
            return resourceURI;
        }

        public void setResourceURI(String resourceURI) {
            this.resourceURI = resourceURI;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class Stories {

        private Integer available;
        private String collectionURI;
        private List<StoryItem> items = null;
        private Integer returned;

        public Integer getAvailable() {
            return available;
        }

        public void setAvailable(Integer available) {
            this.available = available;
        }

        public String getCollectionURI() {
            return collectionURI;
        }

        public void setCollectionURI(String collectionURI) {
            this.collectionURI = collectionURI;
        }

        public List<StoryItem> getItems() {
            return items;
        }

        public void setItems(List<StoryItem> items) {
            this.items = items;
        }

        public Integer getReturned() {
            return returned;
        }

        public void setReturned(Integer returned) {
            this.returned = returned;
        }
    }

    public static class Image {

        private String path;
        private String extension;

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }

        public String getExtension() {
            return extension;
        }

        public void setExtension(String extension) {
            this.extension = extension;
        }
    }

    public static class Url {

        private String type;
        private String url;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    public static class Variant {

        private String resourceURI;
        private String name;

        public String getResourceURI() {
            return resourceURI;
        }

        public void setResourceURI(String resourceURI) {
            this.resourceURI = resourceURI;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class Character {

        private String resourceURI;
        private String name;

        public String getResourceURI() {
            return resourceURI;
        }

        public void setResourceURI(String resourceURI) {
            this.resourceURI = resourceURI;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
