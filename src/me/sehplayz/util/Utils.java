package me.sehplayz.util;


import org.bukkit.ChatColor;
import org.bukkit.craftbukkit.libs.jline.internal.Log;
import org.bukkit.entity.Player;

public class Utils {
	
	private static final Utils instance = new Utils();
	
	public static Utils getInstace() {
		return instance;
	}
	
	public void sendMessage(Player p, String msg) {
		p.sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
	}
	
	public void log(Log.Level level, String msg) {
		
	}
	
	public void logger(String msg, Log.Level level) {
		
	}

}
