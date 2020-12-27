package eu.pyralia.pyrapi;

import java.util.concurrent.TimeUnit;

import eu.pyralia.pyrapi.bungeecord.commands.CommandManager;
import eu.pyralia.pyrapi.bungeecord.commands.admin.MaintenanceCommand;
import eu.pyralia.pyrapi.bungeecord.event.EventManager;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Plugin;

public class BungeeCordAPI extends Plugin {

    private static BungeeCordAPI INSTANCE;
    
    private boolean started;
    private boolean maintenance;
    private String maintenancemess;

    public void onEnable() {
        INSTANCE = this;

        System.out.println("--- PYRALIA API ENABLED ---");
        System.out.println("BungeeCordAPI is activated ‣ Dev by Ariloxe");

        CommandManager.register(this);
        EventManager.register(this);
        setStarted(false);
        String string = getMaintenancemess();
        if(string == null){
            setMaintenancemess("       §c§oServeur actuellement en maintenance !");
        }
        
        
        ProxyServer.getInstance().getScheduler().schedule(getInstance(), () -> setStarted(true), 30L, TimeUnit.SECONDS);
        
    }

    
    
    public void onDisable() {

    }


    public boolean getStarted() {
        return this.started;
    }
    public void setStarted(boolean started) {
        this.started = started;
    }

    public boolean getMaintenanceStatut() {
        return this.maintenance;
    }
    public void setMaintenanceStatut(boolean maintenance) {
        this.maintenance = maintenance;
    }

    public String getMaintenancemess(){ return this.maintenancemess; }
    public void setMaintenancemess(String maintenancemess){ this.maintenancemess = maintenancemess; }
    
    public static BungeeCordAPI getInstance() { return INSTANCE; }

}

