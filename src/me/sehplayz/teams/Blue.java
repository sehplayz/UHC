package me.sehplayz.teams;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;

import me.sehplayz.util.UHCT;

public class Blue implements UHCT {
	
	private List<String> members = new ArrayList<String>();

	@Override
	public String getName() {
		return "Blue";
	}

	@Override
	public List<String> getMember() {
		return members;
	}

	@Override
	public ChatColor getColor() {
		return ChatColor.BLUE;
	}

}
