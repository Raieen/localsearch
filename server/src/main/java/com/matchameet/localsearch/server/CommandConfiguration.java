package com.matchameet.localsearch.server;

import com.matchameet.localsearch.server.command.ICommand;
import com.matchameet.localsearch.server.command.TestCommand;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

import java.util.HashMap;
import java.util.Map;

/**
 * Configuration.
 */
@Configuration
public class CommandConfiguration {

    @Bean
    public Map<String, ICommand> commandMap() {
        Map<String, ICommand> commandHashMap = new HashMap<>();
        commandHashMap.put("test", new TestCommand());
        commandHashMap.put("testalias", new TestCommand());
        return commandHashMap;
    }

    // From https://www.baeldung.com/spring-http-logging
    @Bean
    public CommonsRequestLoggingFilter logFilter() {
        CommonsRequestLoggingFilter filter
                = new CommonsRequestLoggingFilter();
        filter.setIncludeQueryString(true);
        filter.setIncludePayload(true);
        filter.setMaxPayloadLength(10000);
        filter.setIncludeHeaders(false);
        filter.setAfterMessagePrefix("REQUEST DATA : ");
        return filter;
    }
}
