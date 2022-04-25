package me.moontimer.vanish;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class VanishCommand implements CommandExecutor {

    private static final Vanish instance = Vanish.getInstance();
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        if (!player.hasPermission("vanish")) {
            player.sendMessage(instance.getPrefix() + "§cDu hast darauf keine Rechte");
            return true;
        }
        if (!(args.length == 1)) {
            player.sendMessage(instance.getPrefix() + "§cFalscher Syntax /vanish on/off");
            return true;
        }

        switch (args[0].toLowerCase(Locale.ROOT)) {
            case "on":
                for (Player all : Bukkit.getOnlinePlayers()) {
                    all.hidePlayer(player);
                }
                player.sendMessage(instance.getPrefix() + "Du bist nun im Vanish §c(Unsichtbar)");
                Vanish.vanished.add(player);
                break;
            case "off":
                for (Player all : Bukkit.getOnlinePlayers()) {
                    all.showPlayer(player);
                }
                Vanish.vanished.remove(player);
                player.sendMessage(instance.getPrefix() + "Du bist nun nicht mehr im Vanish §c(Sichtbar)");
                break;
        }
        return false;
    }
}
