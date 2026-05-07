package dev.masnypen.masnyLib.command.engine;

import org.bukkit.plugin.java.JavaPlugin;
import dev.masnypen.masnyLib.command.command.BaseCommand;
import dev.masnypen.masnyLib.command.command.CommandMapper.MappedCommand;
import dev.masnypen.masnyLib.command.context.CommandContext;

import org.bukkit.command.CommandSender;
import dev.masnypen.masnyLib.command.context.completions.CompletionProvider;

import java.util.*;

public class TabCompleteDispatcher {

    private final Map<Class<?>, CompletionProvider> providerCache = new HashMap<>();
    private final Map<String, MappedCommand> metadata;

    private final JavaPlugin plugin;

    public TabCompleteDispatcher(Map<String, MappedCommand> metadata, JavaPlugin plugin) {
        this.metadata = metadata;
        this.plugin = plugin;
    }

    public List<String> complete(
            BaseCommand command,
            CommandSender sender,
            String label,
            String[] args
    ) {

        MappedCommand meta = metadata.get(command.getName());
        if (meta == null) return List.of();

        int index = args.length - 1;
        Class<?> providerClass = meta.getAutoCompletes().get(index);
        if (providerClass == null) return List.of();

        CompletionProvider provider = providerCache.computeIfAbsent(
                providerClass,
                this::instantiate
        );

        CommandContext ctx = new CommandContext(sender, args, label, plugin);

        return provider.complete(ctx);
    }

    private CompletionProvider instantiate(Class<?> cls) {
        try {
            return (CompletionProvider) cls.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new IllegalStateException("Cannot instantiate CompletionProvider " + cls, e);
        }
    }
}
