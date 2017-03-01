package me.sehplayz.managers;

import org.bukkit.entity.Player;

import me.sehplayz.exception.TeamException;
import me.sehplayz.main.UHCore;
import me.sehplayz.util.GameState;
import me.sehplayz.util.UHCT;
import me.sehplayz.util.Utils;

public class TeamManager {
	
	public static void JoinPlayer(Player p, UHCT team) throws TeamException {
		if(UHCore.getInstance().getState() == GameState.WAITING) {
			for(UHCT t : UHCore.getInstance().getTeams()) {
				if(t.getMember().contains(p.getName())) {
				   t.getMember().remove(p.getName());
				}
			}
			
			team.getMember().add(p.getName());
			UHCore.getInstance();
			Utils.getInstace().sendMessage(p, UHCore.getInstance().getTAG() + "&7Your in Team &r" + team.getColor() + team.getName() + "&7!!");
		}
		
		else {
			throw new TeamException("Team's can't be change while in Lobby");
		}
	}

}
