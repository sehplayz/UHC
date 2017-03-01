package me.sehplayz.main;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import me.sehplayz.util.Utils;
import org.bukkit.ChatColor;
import org.bukkit.craftbukkit.libs.jline.internal.Log;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import me.sehplayz.teams.Blue;
import me.sehplayz.teams.Green;
import me.sehplayz.teams.Red;
import me.sehplayz.teams.Spectators;
import me.sehplayz.teams.Yellow;
import me.sehplayz.util.GameState;
import me.sehplayz.util.UHCT;

public class UHCore extends JavaPlugin {

    //TODO: ADD SOLO UHC & Clean up.
	
	private static String TAG = ChatColor.GRAY + "[" + ChatColor.BOLD + ChatColor.RED + "UHC" + ChatColor.GRAY + "] " + ChatColor.WHITE;
	
	private static final UHCore instance = new UHCore();
	
	private static final List<UHCT> teams = new ArrayList<UHCT>();
	
	private int ticks = 0;

	private final UHCore plugin = new UHCore();

	public int MIN_PLAYERS = 12;
	
	private GameState state;
	
	public GameState getState() {
		return state;
	}

    public UHCore getPlugin() {
        return plugin;
    }

    public String getTAG() {
        return TAG;
    }

    public int getTicks() {
		return ticks;
	}
	
	public UHCT getTeam(Player p) {
		for(UHCT team : getTeams()) {
			if(team.getMember().contains(p.getName())) {
				return team;
			}
		}
		
		return null;
	}
	
	public UHCT getTeam(String name) {
		
		for(UHCT team : getTeams()) {
			if(team.getName().equalsIgnoreCase(name)) {
				return team;
			}
		}
		
		return null;
	}
	
	public List<UHCT> getTeams() {
		return teams;
	}
	
	
	
	public static UHCore getInstance() {
		return instance;
	}
	
	@Override
	public void onEnable() {
		Console();
		
		state = GameState.STARTING;
		
		if(((new File(getDataFolder(), "config.yml")).exists())) {
			saveDefaultConfig();
		}
		
		
		teams.add(new Blue());
		teams.add(new Red());
		teams.add(new Yellow());
		teams.add(new Green());
		teams.add(new Spectators());
	}
	
	@Override
	public void onDisable() {
		Utils.getInstace().log(Log.Level.INFO, " UHC Plugin has been Disable");
	}

	public void Console() {
		Utils.getInstace().log(Log.Level.INFO, " UHC Plugin has been Enabled");
	}

}
