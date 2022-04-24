package me.moontimer.vanish;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Locale;

public class VanishCommand implements CommandExecutor {
    private static Vanish instance = Vanish.getInstance();
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        if (!player.hasPermission("vanish")) {
            player.sendMessage(instance.getPrefix() + "§cDu hast darauf keine Rechte");
            return true;
        }
        if (args.length == 0) {
            player.sendMessage(instance.getPrefix() + "§cFalscher Syntax /vanish on/off");
            return true;
        }

        switch (args[1].toLowerCase(Locale.ROOT)) {
            case "on":
                for (Player all : Bukkit.getOnlinePlayers()) {
                    all.hidePlayer(player);
                }
                player.sendMessage(instance.getPrefix() + "Du bist nun im Vanish §c(Unsichtbar)");
            case "off":
                for (Player all : Bukkit.getOnlinePlayers()) {
                    all.showPlayer(player);
                }
                player.sendMessage(instance.getPrefix() + "Du bist nun nicht mehr im Vanish §c(Sichtbar)");
        }
        return false;
    }
}
