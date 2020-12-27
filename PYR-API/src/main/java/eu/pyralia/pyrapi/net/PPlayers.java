package eu.pyralia.pyrapi.net;

import java.util.HashMap;
import java.util.UUID;

public class PPlayers {
	
	public static PPlayers INSTANCE;
	private HashMap<PlayerPermission, PermissionAbout> playerPermissions = new HashMap<>();
	private String name;
	private UUID uuid;
	  
	public static PPlayers getInstance() {
		return INSTANCE;
	}
	
	public HashMap<PlayerPermission, PermissionAbout> getPlayerPermissions() {
		return this.playerPermissions;
	}
		  
	public boolean hasPermission(PlayerPermission playerPermission) {
		return getPlayerPermissions().containsKey(playerPermission);
	}



}
