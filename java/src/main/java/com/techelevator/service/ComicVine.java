package com.techelevator.service;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.annotation.Generated;
import java.util.List;

@Generated("jsonschema2pojo")
public class ComicVine {

    public static class Response {

        private String error;
        private int limit;
        private int offset;
        @JsonProperty("number_of_page_results")
        private int numberOfPageResults;
        @JsonProperty("number_of_total_results")
        private int numberOfTotalResults;
        @JsonProperty("status_code")
        private int statusCode;
        private String version;

        public String getError() {
            return error;
        }

        public void setError(String error) {
            this.error = error;
        }

        public int getLimit() {
            return limit;
        }

        public void setLimit(int limit) {
            this.limit = limit;
        }

        public int getOffset() {
            return offset;
        }

        public void setOffset(int offset) {
            this.offset = offset;
        }

        public int getNumberOfPageResults() {
            return numberOfPageResults;
        }

        public void setNumberOfPageResults(int numberOfPageResults) {
            this.numberOfPageResults = numberOfPageResults;
        }

        public int getNumberOfTotalResults() {
            return numberOfTotalResults;
        }

        public void setNumberOfTotalResults(int numberOfTotalResults) {
            this.numberOfTotalResults = numberOfTotalResults;
        }

        public int getStatusCode() {
            return statusCode;
        }

        public void setStatusCode(int statusCode) {
            this.statusCode = statusCode;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }
    }

    public static class ComicResponse extends Response {

        private ResultResource results;

        public ResultResource getResults() {
            return results;
        }

        public void setResults(ResultResource results) {
            this.results = results;
        }
    }

    public static class ComicsResponse extends Response {

        private List<ResultResource> results = null;

        public List<ResultResource> getResults() {
            return results;
        }

        public void setResults(List<ResultResource> results) {
            this.results = results;
        }
    }

    public static class Image {

        @JsonProperty("icon_url")
        private String iconUrl;
        @JsonProperty("medium_url")
        private String mediumUrl;
        @JsonProperty("screen_url")
        private String screenUrl;
        @JsonProperty("screen_large_url")
        private String screenLargeUrl;
        @JsonProperty("small_url")
        private String smallUrl;
        @JsonProperty("super_url")
        private String superUrl;
        @JsonProperty("thumb_url")
        private String thumbUrl;
        @JsonProperty("tiny_url")
        private String tinyUrl;
        @JsonProperty("original_url")
        private String originalUrl;
        @JsonProperty("image_tags")
        private String imageTags;

        public String getIconUrl() {
            return iconUrl;
        }

        public void setIconUrl(String iconUrl) {
            this.iconUrl = iconUrl;
        }

        public String getMediumUrl() {
            return mediumUrl;
        }

        public void setMediumUrl(String mediumUrl) {
            this.mediumUrl = mediumUrl;
        }

        public String getScreenUrl() {
            return screenUrl;
        }

        public void setScreenUrl(String screenUrl) {
            this.screenUrl = screenUrl;
        }

        public String getScreenLargeUrl() {
            return screenLargeUrl;
        }

        public void setScreenLargeUrl(String screenLargeUrl) {
            this.screenLargeUrl = screenLargeUrl;
        }

        public String getSmallUrl() {
            return smallUrl;
        }

        public void setSmallUrl(String smallUrl) {
            this.smallUrl = smallUrl;
        }

        public String getSuperUrl() {
            return superUrl;
        }

        public void setSuperUrl(String superUrl) {
            this.superUrl = superUrl;
        }

        public String getThumbUrl() {
            return thumbUrl;
        }

        public void setThumbUrl(String thumbUrl) {
            this.thumbUrl = thumbUrl;
        }

        public String getTinyUrl() {
            return tinyUrl;
        }

        public void setTinyUrl(String tinyUrl) {
            this.tinyUrl = tinyUrl;
        }

        public String getOriginalUrl() {
            return originalUrl;
        }

        public void setOriginalUrl(String originalUrl) {
            this.originalUrl = originalUrl;
        }

        public String getImageTags() {
            return imageTags;
        }

        public void setImageTags(String imageTags) {
            this.imageTags = imageTags;
        }
    }

    public static class Resource {

        @JsonProperty("api_detail_url")
        private String apiDetailUrl;
        private int id;
        private String name;
        @JsonProperty("site_detail_url")
        private String siteDetailUrl;

        public String getApiDetailUrl() {
            return apiDetailUrl;
        }

        public void setApiDetailUrl(String apiDetailUrl) {
            this.apiDetailUrl = apiDetailUrl;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSiteDetailUrl() {
            return siteDetailUrl;
        }

        public void setSiteDetailUrl(String siteDetailUrl) {
            this.siteDetailUrl = siteDetailUrl;
        }

    }

    public static class PersonCreditResource extends Resource {

        private String role;

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class ResultResource extends Resource {
        @JsonProperty("character_credits")
        private List<Resource> characterCredits = null;
        @JsonProperty("cover_date")
        private String coverDate;
        private String description;
        private Image image;
        @JsonProperty("issue_number")
        private String issueNumber;
        @JsonProperty("person_credits")
        private List<PersonCreditResource> personCredits = null;
        private Resource volume;

        public List<Resource> getCharacterCredits() {
            return characterCredits;
        }

        public void setCharacterCredits(List<Resource> characterCredits) {
            this.characterCredits = characterCredits;
        }

        public String getCoverDate() {
            return coverDate;
        }

        public void setCoverDate(String coverDate) {
            this.coverDate = coverDate;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public Image getImage() {
            return image;
        }

        public void setImage(Image image) {
            this.image = image;
        }

        public String getIssueNumber() {
            return issueNumber;
        }

        public void setIssueNumber(String issueNumber) {
            this.issueNumber = issueNumber;
        }

        public List<PersonCreditResource> getPersonCredits() {
            return personCredits;
        }

        public void setPersonCredits(List<PersonCreditResource> personCredits) {
            this.personCredits = personCredits;
        }

        public Resource getVolume() {
            return volume;
        }

        public void setVolume(Resource volume) {
            this.volume = volume;
        }
    }
}
