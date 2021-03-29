package com.matchameet.localsearch.server.controller;


import com.matchameet.localsearch.server.model.SuggestionResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class SuggestionController {

    @GetMapping("/s")
    public Object suggestion(@RequestParam(value = "q", required = false) String query) {
        if (query == null) {
            // TODO: This should return search.html
            return "search";
        }

        // TODO: This is using the Wikipedia format, but this differs from Google.
        // What should I be using? Why aren't these standardized?!
        List<String> suggestions = List.of("hello", "world", "123");
        List<String> mystery = suggestions.stream()
                .map(s -> s + " mystery!")
                .collect(Collectors.toList());
        List<String> links = suggestions.stream()
                .map(s -> "http://" + s + ".com")
                .collect(Collectors.toList());

        return new SuggestionResponse(query, suggestions, mystery, links).getResponse();
    }
}
