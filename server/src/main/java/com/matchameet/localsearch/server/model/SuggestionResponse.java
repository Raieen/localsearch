package com.matchameet.localsearch.server.model;

import java.util.List;

/**
 * Search Engine Response using "Wikipedia"-styled response.
 */
public class SuggestionResponse {

    // First Element
    private String query;

    // Second Element
    private List<String> suggestions;

    // Third Element, not sure what this does yet, Google returns empty list
    // Wikipedia return suggestions.size number of empty strings in a list
    // Are these meant to be thumbnails?
    private List<String> mystery;

    // Third Element
    private List<String> links;

    public SuggestionResponse(String query, List<String> suggestions, List<String> mystery, List<String> links) {
        this.query = query;
        this.suggestions = suggestions;
        this.mystery = mystery;
        this.links = links;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public List<String> getSuggestions() {
        return suggestions;
    }

    public void setSuggestions(List<String> suggestions) {
        this.suggestions = suggestions;
    }

    public List<String> getMystery() {
        return mystery;
    }

    public void setMystery(List<String> mystery) {
        this.mystery = mystery;
    }

    public List<String> getLinks() {
        return links;
    }

    public void setLinks(List<String> links) {
        this.links = links;
    }

    /**
     * <p>Returns the "Wikipedia" style response formatted as:</p>
     * <code>
     * [query, [suggestions], [list of suggestions.size empty strings], [links]]
     * </code>
     *
     * @return List of objects
     */
    public List<Object> getResponse() {
        return List.of(query, suggestions, mystery, links);
    }
}
