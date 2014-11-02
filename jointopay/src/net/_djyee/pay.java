package net._djyee;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;

//All Rights Reserved
//Bu pluginin Kodlarinin Deðiþtirilmesi,Kullanilmasi,veya çoðaltilmasi halinde Gerekli Makamlara bildirilecektir!
//Bu pluginin Her Hakki Saklýdýr!

public final class pay extends JavaPlugin
  implements Listener
{
  HashMap<Player, Boolean> sohbet = new HashMap<Player, Boolean>();


  public void onEnable()
  {
	
		
	    getServer().getPluginManager().registerEvents(this, this);
		  getConfig().options().copyDefaults(true);
		    saveConfig();
getLogger().info("Join To Pay V1.0 Enable!");

  }

  public void onDisable()
  {
		 saveConfig();
		 getLogger().info("Join To Pay V1.0 Disable!");
  }
 
		  

		 
	
  @SuppressWarnings("deprecation")
@EventHandler(priority=EventPriority.HIGHEST)
  public void onPlayerChat(AsyncPlayerChatEvent event)
  {
    Player p3 = event.getPlayer();

    for (Player player1 : Bukkit.getServer().getOnlinePlayers())
    {
      if (this.sohbet.get(player1) == Boolean.TRUE) {
        event.getRecipients().remove(player1);
        if (this.sohbet.get(p3) == Boolean.TRUE)
          event.setCancelled(true);
      }
    }
  }

 

  
  String hostname = getConfig().getString("MySQL.hostname");
  int port = getConfig().getInt("MySQL.port");
  String database = getConfig().getString("MySQL.database");
  String username =  getConfig().getString("MySQL.username");
  String password = getConfig().getString("MySQL.password");
  String utf8 = "?useUnicode=true&characterEncoding=UTF-8";
  
int s = 20;
int sxc = getConfig().getInt("jointime");

int xx = s*sxc;

int atilma1 = s * getConfig().getInt("kicktime");
int atilma = atilma1 + xx;


@EventHandler
  public void durbun2(final PlayerJoinEvent event) throws SQLException{
  {
	  final Player p3 = event.getPlayer();
    final Connection connection = DriverManager.getConnection("jdbc:mysql://" + hostname + "/"
            + database, username, password);
    DatabaseMetaData metadata = connection.getMetaData();
    final ResultSet resultSet;
    resultSet = metadata.getColumns(null, null, "jointopay", p3.getAddress().getAddress().getHostAddress().replace(".", ""));
    
   
    getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
	public void run() {
        Player p3 = event.getPlayer();

       

        try {
			if(resultSet.next()){
				  connection.close();
			}else{
				
				 p3.sendMessage("    ");
   				 p3.sendMessage("    ");
   				 p3.sendMessage("    ");
   				 p3.sendMessage("    ");
   				 p3.sendMessage("    ");
   				 p3.sendMessage("    ");
   				 p3.sendMessage("    ");
   				 p3.sendMessage("    ");		 
   				 p3.sendMessage("    ");
   				 p3.sendMessage("    ");
   				 p3.sendMessage("    ");
   				 p3.sendMessage("    ");
				 p3.sendMessage("    ");
   				 p3.sendMessage("    ");
   				 p3.sendMessage("    ");
   				 p3.sendMessage("    ");
   				 p3.sendMessage("    ");
   				 p3.sendMessage("    ");
   				 p3.sendMessage("    ");		 
   				 p3.sendMessage("    ");
   				 p3.sendMessage("    ");
   				 p3.sendMessage("    ");
   				 p3.sendMessage("    ");
				 p3.sendMessage("    ");
		        p3.sendMessage(ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=");
		        p3.sendMessage(ChatColor.WHITE + "=" + ChatColor.BLUE + " Hoþgeldin " + ChatColor.YELLOW + p3.getName());
		        p3.sendMessage(ChatColor.DARK_RED + "=" + ChatColor.LIGHT_PURPLE + " Sunucuda Oynaya Bilmek için Aþaðidaki linke tikla Reklami Geç");
		        p3.sendMessage(ChatColor.WHITE + "=" + ChatColor.YELLOW + " Link: " + ChatColor.AQUA + getConfig().getString("Reklam_Link") );
		        p3.sendMessage(ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=");
		   	 p3.sendMessage("    ");
			 p3.sendMessage("    ");
		        pay.this.sohbet.put(p3, Boolean.TRUE);
		        p3.isFlying();
		        p3.setAllowFlight(true);
		        p3.setFlying(true);
		        
		        connection.close();
			}
		} catch (SQLException e) {
	
			e.printStackTrace();
		}

	}
    }
    , xx+ 'L');
    
   
    getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {	
    	public void run() { 	
  
		try {
			if(resultSet.next()){
			}else{
p3.kickPlayer(ChatColor.RED + "Belirlenen Reklam Tiklama Suresini Aþtiniz!");
					connection.close();
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
    	}
    }
   
    , atilma+ 'L');
       }
    	
  
    
    
   
  }
@EventHandler(priority = EventPriority.NORMAL)
public void hasar(final EntityDamageEvent event) {
Entity e = event.getEntity();

if (e instanceof Player && this.sohbet.get(e) == Boolean.TRUE){
	event.setCancelled(true);
}


}

@EventHandler(priority = EventPriority.NORMAL)
public void kir(final BlockBreakEvent event) {
	Player p2 = event.getPlayer();


if (this.sohbet.get(p2) == Boolean.TRUE){
	event.setCancelled(true);
}
}

@EventHandler
public void jointopay(AsyncPlayerChatEvent event){

  Player p122 = event.getPlayer();


  if (event.getMessage().toLowerCase().contains("jointopaylicense")) {
	  event.setCancelled(true);
  	p122.sendMessage("§cJointopay: Author §9djyee §bVersiyon 1.0 §eAll Rights Reserved");

  }


}
@EventHandler(priority=EventPriority.MONITOR, ignoreCancelled = true)
  public void Haraket(PlayerMoveEvent event) throws SQLException{
Player p3 = event.getPlayer();     


        if (this.sohbet.get(p3) == Boolean.TRUE){
        	final Connection connection = DriverManager.getConnection("jdbc:mysql://" + hostname + "/"
        	        + database, username, password);
        	DatabaseMetaData metadata = connection.getMetaData();
        	final ResultSet resultSet;
        	resultSet = metadata.getColumns(null, null, "jointopay", p3.getAddress().getAddress().getHostAddress().replace(".", ""));
	         event.setCancelled(true);
        	p3.teleport(p3);
   	
        	 try {
     			if(resultSet.next()){
     		        p3.sendMessage(ChatColor.GRAY + ">>>>>" + ChatColor.GOLD + "Reklama Baþariyla Tikladiniz Artik OynayaBilirsiniz!" + ChatColor.GRAY + "<<<<<");
     		    
     		        pay.this.sohbet.put(p3, Boolean.FALSE);
    		 		
     		 	  connection.close();
     		       p3.setAllowFlight(false);
     			}else{
   				 p3.sendMessage("    ");
   				 p3.sendMessage("    ");
   				 p3.sendMessage("    ");
   				 p3.sendMessage("    ");
   				 p3.sendMessage("    ");
   				 p3.sendMessage("    ");
   				 p3.sendMessage("    ");		 
   				 p3.sendMessage("    ");
   				 p3.sendMessage("    ");
   				 p3.sendMessage("    ");
   				 p3.sendMessage("    ");
				 p3.sendMessage("    ");
   				 p3.sendMessage("    ");
   				 p3.sendMessage("    ");
   				 p3.sendMessage("    ");
   				 p3.sendMessage("    ");
   				 p3.sendMessage("    ");
   				 p3.sendMessage("    ");
   				 p3.sendMessage("    ");		 
   				 p3.sendMessage("    ");
   				 p3.sendMessage("    ");
   				 p3.sendMessage("    ");
   				 p3.sendMessage("    ");
				 p3.sendMessage("    ");
   		        p3.sendMessage(ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=");
   		        p3.sendMessage(ChatColor.WHITE + "=" + ChatColor.BLUE + " Hoþgeldin " + ChatColor.YELLOW + p3.getName());
   		        p3.sendMessage(ChatColor.DARK_RED + "=" + ChatColor.LIGHT_PURPLE + " Sunucuda Oynaya Bilmek için Aþaðidaki linke tikla Reklami Geç");
   		        p3.sendMessage(ChatColor.WHITE + "=" + ChatColor.YELLOW + " Link: " + ChatColor.AQUA + getConfig().getString("Reklam_Link") );
   		        p3.sendMessage(ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=");
   		   	 p3.sendMessage("    ");
   			 p3.sendMessage("    ");
   		  connection.close();
  
     			}
     		} catch (SQLException e) {
     	
     			e.printStackTrace();
     		}

        }
         
  }
  
}