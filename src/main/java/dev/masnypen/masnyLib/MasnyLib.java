package dev.masnypen.masnyLib;

import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;
import dev.masnypen.masnyLib.command.engine.CommandHandler;
import dev.masnypen.masnyLib.command.LibCommand;

public final class MasnyLib extends JavaPlugin {

    @Getter
    private static MasnyLib instance;

    @Getter
    private CommandHandler commandHandler;

    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;


        commandHandler = new CommandHandler(this)
            .permissionMessage("&eYou do not have permission to execute this command.")
            .consoleOnlyMessage("&eYou cannot execute this command from the console.")
            .playerOnlyMessage("&eYou cannot execute this command by player.");
        commandHandler.register(new LibCommand(this));
        getLogger().info("SerweronLib is enabled");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

}
