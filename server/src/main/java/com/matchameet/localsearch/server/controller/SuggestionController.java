package com.matchameet.localsearch.server.controller;

import com.matchameet.localsearch.server.model.SuggestionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
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

        List<String> completionList = new ArrayList<>(List.of("search results!!!", "👁👄👁", "hi", "hello", "world", "123"));
        Collections.shuffle(completionList);
        List<Object> descriptions = completionList.stream()
                .map(s -> {
                    if (s.length() % 2 == 0) {
                        return s.length();
                    } else {
                        return s + " description!";
                    }
                })
                .collect(Collectors.toList());
        List<String> links = completionList.stream()
                .map(s -> "http://example.com")
                .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK)
                .header("Content-type", "application/x-suggestions+json")
                .body(new SuggestionResponse(query, completionList, descriptions, links).getResponse());
    }
}
