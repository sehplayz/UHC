package me.sehplayz.listeners;

import me.sehplayz.exception.TeamException;
import me.sehplayz.main.UHCore;
import me.sehplayz.managers.TeamManager;
import me.sehplayz.util.GameState;
import me.sehplayz.util.UHCT;
import me.sehplayz.util.Utils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;

/**
 * Created by sehplayz.
 */
public class Joinlistener implements Listener {



    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player p = event.getPlayer();
        Utils.getInstace().sendMessage(p, UHCore.getInstance().getTAG() + "&2You are now in a Game!");
        int players = Bukkit.getServer().getOnlinePlayers().size();
        if(players == UHCore.getInstance().MIN_PLAYERS) {
            Utils.getInstace().sendMessage(p, UHCore.getInstance().getTAG() + "&2The Game will start when there's &a" + UHCore.getInstance().MIN_PLAYERS + " &6Players!");
        }else {
            Utils.getInstace().sendMessage(p, UHCore.getInstance().getTAG() + "&eThe Game will being shortly...");
        }

        p.setHealth(p.getMaxHealth());
        p.setFoodLevel(20);
        p.setSaturation(8F);
        p.setLevel(0);
        p.setExp(0);
        p.getInventory().clear();
        p.getInventory().setArmorContents(null);

        try {
            TeamManager.JoinPlayer(p, UHCore.getInstance().getTeam("Spectators"));
        } catch (TeamException e) {
            //NOPE
        }

    }

    @EventHandler
    public void onLogin(PlayerLoginEvent event) {
        Player p = event.getPlayer();

        GameState state = UHCore.getInstance().getState();


        if(state != GameState.WAITING) {
            event.disallow(PlayerLoginEvent.Result.KICK_OTHER, "");
            Utils.getInstace().sendMessage(p, UHCore.getInstance().getTAG() + "&cThe Game has already started!");
        }
    }
}
