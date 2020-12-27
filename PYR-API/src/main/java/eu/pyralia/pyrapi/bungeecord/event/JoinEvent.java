package eu.pyralia.pyrapi.bungeecord.event;

import eu.pyralia.pyrapi.PyraliaAPI;

import eu.pyralia.pyrapi.BungeeCordAPI;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.LoginEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class JoinEvent implements Listener {

	@SuppressWarnings("deprecation")
	@EventHandler
    public void onJoin(LoginEvent loginEvent){
        if(!BungeeCordAPI.getInstance().getStarted()){
            loginEvent.setCancelled(true);
            loginEvent.setCancelReason("§7Connexion §crefusée §4✗ \n\n" + PyraliaAPI.PREFIX + "§7Nos serveurs §adémarrent §7!\n§7Merci d'attendre §equelques minutes §7le temps qu'ils se lancent !");
            return;
        }
        else if (loginEvent.getConnection().getVersion() < 47) {
        	loginEvent.setCancelled(true);
        	loginEvent.setCancelReason("§7Connexion §crefusée §4✗ \n\n" + PyraliaAPI.PREFIX + "§7Nos serveurs ne §csupportent pas §7les\n§7versions §bprés-1.8 §7!");
            return;
          }
        else if(BungeeCordAPI.getInstance().getMaintenanceStatut() == true){
        	ProxiedPlayer proxiedPlayer = ProxyServer.getInstance().getPlayer(loginEvent.getConnection().getUUID());
        	if(!loginEvent.getConnection().getName().equals("Ariloxe")) {
                loginEvent.setCancelled(true);
                loginEvent.setCancelReason(PyraliaAPI.PREFIX + "§7Nos serveurs sont en §amaintenance §7!\n§7Pour plus d'informations venez voir sur notre discord !\n§7(§9pyralia.com/discord§7)");        
                return;
        	}

        }
    }
}
