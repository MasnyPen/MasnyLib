package dev.masnypen.masnyLib.command.error;

public class CommandException extends RuntimeException {
    public CommandException(String message) {
        super(message);
    }
}
