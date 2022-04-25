package me.moontimer.vanish;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.lang.management.BufferPoolMXBean;
import java.util.ArrayList;
import java.util.List;

public final class Vanish extends JavaPlugin {

    @Getter
    public static Vanish instance;

    @Getter
    private String prefix = "§4§lGrieferWeit §8» §7";

    public static List<Player> vanished = new ArrayList<>();

    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;

        getCommand("vanish").setExecutor(new VanishCommand());

        getLogger().info("Das vanish Plugin von MoonTimer wurde erfolgreich gestartet");

        PluginManager pl = Bukkit.getPluginManager();

        pl.registerEvents(new PlayerJoinListener(), this);
        pl.registerEvents(new PlayerQuitListener(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
