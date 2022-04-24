package me.moontimer.vanish;

import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

public final class Vanish extends JavaPlugin {

    @Getter
    public static Vanish instance;

    @Getter
    private String prefix = "§4§lGrieferWeit §8»";

    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;

        getCommand("vanish").setExecutor(new VanishCommand());

        getLogger().info("Das vanish Plugin von MoonTimer wurde erfolgreich gestartet");

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
