package dev.masnypen.masnyLib.command.context.completions;

import dev.masnypen.masnyLib.command.context.CommandContext;

import java.util.List;

public interface CompletionProvider {
    List<String> complete(CommandContext ctx);
}
