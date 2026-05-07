package dev.masnypen.masnyLib.command;

import dev.masnypen.masnyLib.api.economy.managers.IEconomyManager;
import dev.masnypen.masnyLib.api.ranks.managers.IRankManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import dev.masnypen.masnyLib.MasnyLib;
import dev.masnypen.masnyLib.command.annotations.Aliases;
import dev.masnypen.masnyLib.command.annotations.Description;
import dev.masnypen.masnyLib.command.annotations.Permission;
import dev.masnypen.masnyLib.command.command.BaseCommand;
import dev.masnypen.masnyLib.command.context.CommandContext;

@Aliases("lib")
@Description("MasnyLib lib command")
@Permission("masnylib.admin")
public class LibCommand extends BaseCommand {

    public LibCommand(MasnyLib masnyLib) {
        super("masnylib", masnyLib);
    }

    @Override
    protected void execute(@NotNull CommandContext ctx) {

        Plugin economyManager = Bukkit.getServicesManager().getRegistration(IEconomyManager.class).getPlugin();
        Plugin rankManager = Bukkit.getServicesManager().getRegistration(IRankManager.class).getPlugin();

        ctx.getSender().sendMessage(String.format("[%s] MasnyLib v%s Information", ctx.getPlugin().getPluginMeta().getName(), ctx.getPlugin().getPluginMeta().getVersion()));
        ctx.getSender().sendMessage(String.format("[%s] Economy: %s", ctx.getPlugin().getPluginMeta().getName(), economyManager.getPluginMeta().getName()));
        ctx.getSender().sendMessage(String.format("[%s] Ranks: %s", ctx.getPlugin().getPluginMeta().getName(), rankManager.getPluginMeta().getName()));
    }
}
