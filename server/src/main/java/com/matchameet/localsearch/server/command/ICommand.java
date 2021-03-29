package com.matchameet.localsearch.server.command;

import java.util.List;
import java.util.Optional;

/**
 * Command Interface.
 */
public interface ICommand {

    /**
     * Returns the unique identifier for command.
     * This may not be a user friendly string
     *
     * @return Unique Identifier for command
     */
    String getCommandId();

    /**
     * Execute the command give the command and any possible arguments.
     *
     * @param command Command, might be an alias
     * @param args    Command arguments
     * @return Optional containing any error messages
     */
    Optional<String> execute(String command, List<String> args);

    /**
     * Validate the arguments and returns any error messages.
     *
     * @param command Command, might be an alias
     * @param args    Command arguments
     * @return Optional containing any error messages
     */
    Optional<String> validate(String command, List<String> args);
}
