package org.spigotmc.arrowrideplugin;

import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class ArrowRidePlugin extends JavaPlugin implements Listener {


    @Override
    public void onEnable() {
     getServer().getLogger().info("Plugin is now running");
        getServer().getPluginManager().registerEvents(new EventHandlerArrow(),this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

}
