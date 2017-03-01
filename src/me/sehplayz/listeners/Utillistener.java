package me.sehplayz.listeners;

import me.sehplayz.main.UHCore;
import me.sehplayz.util.GameState;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.server.ServerListPingEvent;

/**
 * Created by sehplayz.
 */
public class Utillistener implements Listener {

    @EventHandler
    public void onPing(ServerListPingEvent event) {
        GameState state = UHCore.getInstance().getState();

        if(state == GameState.WAITING) {
            event.setMotd(UHCore.getInstance().getPlugin().getConfig().getString("signs.state.open".toString()));
        }else if(state == GameState.INGAME) {
            event.setMotd(UHCore.getInstance().getPlugin().getConfig().getString("signs.state.ingame".toString()));
        }else if(state == GameState.STARTING) {
            event.setMotd(UHCore.getInstance().getPlugin().getConfig().getString("signs.state.starting".toString()));
        }else if(state == GameState.ENDED) {
            event.setMotd(UHCore.getInstance().getPlugin().getConfig().getString("signs.state.ended".toString()));
        }

    }

    @EventHandler
    public void onDrop(PlayerDropItemEvent event) {
        if(UHCore.getInstance().getState() == GameState.INGAME) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onPickUp(PlayerPickupItemEvent event) {
        if(UHCore.getInstance().getState() == GameState.INGAME) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public  void onDamage(EntityDamageByEntityEvent event) {
        if(UHCore.getInstance().getState() == GameState.INGAME) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onFoodLevel(FoodLevelChangeEvent event) {
        if(UHCore.getInstance().getState() == GameState.INGAME) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onPlace(BlockPlaceEvent event) {
        if(UHCore.getInstance().getState() == GameState.INGAME) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onBreak(BlockBreakEvent event) {
        if(UHCore.getInstance().getState() == GameState.INGAME) {
            event.setCancelled(true);
        }
    }
}
