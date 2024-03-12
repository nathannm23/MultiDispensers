package me.natnm.multidispensers;

import org.bukkit.plugin.java.JavaPlugin;

public final class MultiDispensers extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.getCommand("multidispenser").setExecutor(new MultiDispenserCommand(this));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
