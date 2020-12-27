package eu.pyralia.pyrapi.bungeecord.commands.admin;

import eu.pyralia.pyrapi.PyraliaAPI;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class RebootCommand extends Command {

    private boolean reboot;
    public RebootCommand(String name) {
        super(name);
    }

    @SuppressWarnings("deprecation")
    public void execute(CommandSender commandSender, String[] strings) {
        if(commandSender instanceof ProxiedPlayer) {
            if(commandSender.hasPermission("admin.use")){
                if(!getReboot()){
                    setReboot(true);
                    commandSender.sendMessage((BaseComponent)new TextComponent(PyraliaAPI.PREFIX + "§cRefaites §cla §ccommande §cpour §cconfirmer."));
                } else {
                    ProxyServer.getInstance().stop(PyraliaAPI.PREFIX + "§7Reboot - BungeeCord (§e" + commandSender.getName() + "§7)");
                    setReboot(false);
                }
            }
        }
    }
    public static RebootCommand INSTANCE;
    public static RebootCommand getInstance() {
        return INSTANCE;
    }
    private boolean getReboot(){
        return this.reboot;
    }
    private void setReboot(boolean bool){
        this.reboot = bool;
    }

}

