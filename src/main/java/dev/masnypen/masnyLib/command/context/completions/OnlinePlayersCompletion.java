package dev.masnypen.masnyLib.command.context.completions;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import dev.masnypen.masnyLib.command.context.CommandContext;

import java.util.List;

public class OnlinePlayersCompletion implements CompletionProvider {
    @Override
    public List<String> complete(CommandContext ctx) {
        return Bukkit.getOnlinePlayers().stream().map(Player::getName).toList();
    }
}
