package com.matchameet.localsearch.server.controller;

import com.matchameet.localsearch.server.command.ICommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class QueryController {

    private Logger logger = LoggerFactory.getLogger(QueryController.class);

    private Map<String, ICommand> commandMap;

    @Autowired
    public QueryController(Map<String, ICommand> commandMap) {
        this.commandMap = commandMap;
    }

    @GetMapping("/")
    public ResponseEntity query(@RequestParam(value = "q", required = false) String query) {
        if (query == null) {
            return redirect("search.html");
        }

        // Tokenize String
        String[] split = query.split(" ");

        List<String> commandArgs = new ArrayList<>();
        String commandString = split[0];

        if (split.length > 1) {
            commandArgs = Arrays.asList(split);
        }

        ICommand command = commandMap.get(commandString);

        // TODO: Quick hack to prove a point
        if (commandString.equals("d")) {
            return redirect("https://duckduckgo.com/?q=" + query);
        }

        if (command != null) {
            Optional<String> validationErrors = command.validate(commandString, commandArgs);
            if (validationErrors.isPresent()) {
                logger.debug("Validation errors {} {} {}", command, commandArgs, validationErrors.get());
                return ResponseEntity.badRequest().body(validationErrors.get());
            }

            Optional<String> runtimeErrors = command.execute(commandString, commandArgs);
            if (runtimeErrors.isPresent()) {
                logger.debug("Runtime errors {} {} {}", command, commandArgs, runtimeErrors.get());
                return ResponseEntity.badRequest().body(runtimeErrors);
            }

            // TODO: Don't actually want to return 204 No Content if this was a success.
            // Need to do some browser tricks here, might run into issues and need to do cases with UA.
            logger.debug("Successfully ran command {} {}", command, commandArgs);
            return ResponseEntity.ok("ok");
        } else {
            // TODO: Should fail and fallback to Google/DDG/... whatever is in config file
            logger.debug("Invalid command {} {}", command, commandArgs);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("not found");
        }
    }

    ResponseEntity redirect(String url) {
        return ResponseEntity.status(HttpStatus.PERMANENT_REDIRECT)
                .header("Location", url).build();
    }

}
