package com.matchameet.localsearch.server.command;

import java.util.List;
import java.util.Optional;

public class TestCommand implements ICommand {

    @Override
    public String getCommandId() {
        return "test-command";
    }

    @Override
    public Optional<String> execute(String command, List<String> args) {
        System.out.printf("Command %s\n", command);
        args.forEach(System.out::println);
        System.out.println("====");
        return Optional.empty();
    }

    @Override
    public Optional<String> validate(String command, List<String> args) {
        if (args != null && args.contains("invalid")) {
            return Optional.of("Invalid Argument");
        }
        return Optional.empty();
    }
}
