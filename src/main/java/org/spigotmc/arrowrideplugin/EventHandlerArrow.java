package org.spigotmc.arrowrideplugin;

import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.spigotmc.event.entity.EntityDismountEvent;

public class EventHandlerArrow implements Listener {

    private Player shoter;
    private Projectile projectile = null;
    private boolean arrowRideEnabled = false;


    @EventHandler
    public void eventHandler(ProjectileLaunchEvent event) {
        if (event.getEntityType() == EntityType.ARROW && event.getEntity().getShooter() instanceof Player) {
            projectile = event.getEntity();
//&& event.getEntity().getShooter().equals(shoter)
            if (arrowRideEnabled) {
                projectile.setPassenger(shoter);
                shoter.setInvisible(true);
            }
        }
    }


    @EventHandler
    public void eventHandlerArrowHit(ProjectileHitEvent event) {
        if (event.getEntityType() == EntityType.ARROW && event.getEntity().getShooter() instanceof Player) {
//            Player shoter = (Player) event.getEntity().getShooter();
            if (shoter != null) {
                shoter.setInvisible(false);
            }
            projectile = null;

        }

    }

    @EventHandler
    public void playerSneakEventHandler(PlayerToggleSneakEvent event) {

        if (!event.isSneaking()) {
            arrowRideEnabled = !arrowRideEnabled;
            if (arrowRideEnabled) {
                if (shoter == null) {
                    shoter = event.getPlayer();
                }
                shoter.sendMessage("Arrow riding enabled");

            } else {

                shoter.sendMessage("Arrow riding disabled");

            }
        }

    }
}

