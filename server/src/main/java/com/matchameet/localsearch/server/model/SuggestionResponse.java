package com.matchameet.localsearch.server.model;

import java.util.List;

/**
 * Search Engine Response using "Wikipedia"-styled response.
 */
public class SuggestionResponse {

    /**
     * Query string.
     *
     * First element in response list, allows browsers to verify suggestions match current search term.
     */
    private String query;

    /**
     * Completion List
     */
    private List<String> completionList;

    /**
     * Descriptions for each suggestion in the completion list.
     *
     * Ignored in Firefox.
     */
    private List<Object> descriptions;

    /**
     * Descriptions for each suggestion in the completion list.
     *
     * Ignored in Firefox.
     */
    private List<String> queryURLs;

    public SuggestionResponse(String query, List<String> completionList, List<Object> descriptions, List<String> queryURLs) {
        this.query = query;
        this.completionList = completionList;
        this.descriptions = descriptions;
        this.queryURLs = queryURLs;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public List<String> getCompletionList() {
        return completionList;
    }

    public void setCompletionList(List<String> completionList) {
        this.completionList = completionList;
    }

    public List<Object> getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(List<Object> descriptions) {
        this.descriptions = descriptions;
    }

    public List<String> getQueryURLs() {
        return queryURLs;
    }

    public void setQueryURLs(List<String> queryURLs) {
        this.queryURLs = queryURLs;
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
        return List.of(query, completionList, descriptions, queryURLs);
    }
}
