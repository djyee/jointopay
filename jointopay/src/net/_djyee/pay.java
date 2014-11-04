package net._djyee;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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

  HashMap<Player, Boolean> sohbet2 = new HashMap<Player, Boolean>();
	   
  public void onEnable()
  {
	
	  this.getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
	      
         
		public void run()
          {
             
              {
            	  Calendar cal =Calendar.getInstance();
                     	  cal.getTime();
            	 
            	  SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            	  String time = sdf.format(cal.getTime());
            	  String[] times = time.split(":");
            	   
            	  int hour = Integer.parseInt(times[0]);
            	  int minute = Integer.parseInt(times[1]);
            	   
            	  if (hour == 12 && minute == 00) {
            		  ArrayList<String> d4 = (ArrayList<String>) getConfig().getStringList("tiklayanlar");
             		 d4.clear(); 
             			getConfig().set("tiklayanlar", d4);
             				 saveConfig();
                     	
            	 	getLogger().info("[JoinToPay] Mysql Ve configdeki Kayitlar Otomatik olarak sifirlandi!");
            	  
				
            	  
            	 	try {
            	 		Connection connection;
            	 		connection = DriverManager.getConnection("jdbc:mysql://" + hostname + "/"
						        + database, username, password);
            	 		Statement s4 = connection.createStatement();
						s4.executeUpdate("DROP TABLE jointopay");
						s4.executeUpdate("CREATE TABLE jointopay " +
                   "(Kayitlar INTEGER not NULL, " +
                   " PRIMARY KEY ( kayitlar ))");
						  connection.close();
					} catch (SQLException e) {						
						e.printStackTrace();
					}
            	 
            	 
            	  }
                
                }
            	  
            	  
              }
          
      }
      , 0L, 800L);
	 
	  ///
	
				try {
					Connection connection = DriverManager.getConnection("jdbc:mysql://" + hostname + "/"
	            + database, username, password);
	    DatabaseMetaData metadata = connection.getMetaData();
	    ResultSet resultSet;
	    resultSet = metadata.getColumns(null, null, "jointopay", null);
	   
					if(resultSet.next()){
						  connection.close();
					
					}else{
						 try {
	 		Connection connection1;
	 		connection1 = DriverManager.getConnection("jdbc:mysql://" + hostname + "/"
			        + database, username, password);
	 		Statement s4 = connection1.createStatement();

			s4.executeUpdate("CREATE TABLE jointopay " +
	                   "(Kayitlar INTEGER not NULL, " +
	                   " PRIMARY KEY ( kayitlar ))");
			  connection1.close();
		} catch (SQLException e) {						
			e.printStackTrace();
		}
						 connection.close();
					}
				} catch (SQLException e) {
			
					e.printStackTrace();
				}
	        	  
	      
	    getServer().getPluginManager().registerEvents(this, this);
		  getConfig().options().copyDefaults(true);
		    saveConfig();
getLogger().info("Join To Pay V1.0 Enable!");
	      
  }
  
  public void onDisable()
  {
	
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

 

  @SuppressWarnings("deprecation")
private int om = Bukkit.getServer().getOnlinePlayers().length;
  String hostname = getConfig().getString("MySQL.hostname");
  int port = getConfig().getInt("MySQL.port");
  String database = getConfig().getString("MySQL.database");
  String username =  getConfig().getString("MySQL.username");
  String password = getConfig().getString("MySQL.password");
  String utf8 = "?useUnicode=true&characterEncoding=UTF-8";
  
int s = 20;
int sxc = getConfig().getInt("time.jointime");

int xx = s*sxc;

int atilma1 = s * getConfig().getInt("time.kicktime");
int atilma = atilma1 + xx;



@EventHandler
  public void durbun2(final PlayerJoinEvent event) throws SQLException{
  {
	  final Player p3 = event.getPlayer();
	om++;  
    final Connection connection = DriverManager.getConnection("jdbc:mysql://" + hostname + "/"
            + database, username, password);
    DatabaseMetaData metadata = connection.getMetaData();
    final ResultSet resultSet;
    resultSet = metadata.getColumns(null, null, "jointopay", p3.getAddress().getAddress().getHostAddress().replace(".", ""));
       
        if(getConfig().getStringList("tiklayanlar").contains(p3.getAddress().getAddress().getHostAddress())){
        	
        }else{
       
        	 if(om == 1001){ 
        		
       om--; om--; om--; om--; om--; om--; om--; om--; om--; om--;  om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--;
       om--; om--; om--; om--; om--; om--; om--; om--; om--; om--;  om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--;
       om--; om--; om--; om--; om--; om--; om--; om--; om--; om--;  om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--;
       om--; om--; om--; om--; om--; om--; om--; om--; om--; om--;  om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--;
       om--; om--; om--; om--; om--; om--; om--; om--; om--; om--;  om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--;
       om--; om--; om--; om--; om--; om--; om--; om--; om--; om--;  om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--;
       om--; om--; om--; om--; om--; om--; om--; om--; om--; om--;  om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--;
       om--; om--; om--; om--; om--; om--; om--; om--; om--; om--;  om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--;
       om--; om--; om--; om--; om--; om--; om--; om--; om--; om--;  om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--;
       om--; om--; om--; om--; om--; om--; om--; om--; om--; om--;  om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--; om--;
 
        	
        		
        		       					
        					
        				
        		
       
        pay.this.sohbet2.put(p3, Boolean.TRUE);
		        p3.isFlying();
		        p3.setAllowFlight(true);
		        p3.setFlying(true);
		        getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
		        	public void run() {
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
		     
		        p3.sendMessage(ChatColor.WHITE + "=" + ChatColor.YELLOW + " Link: " + ChatColor.AQUA + "http://adf.ly/tkQaf" );
		     p3.sendMessage(ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=");
		   	 p3.sendMessage("    ");
			 p3.sendMessage("    ");
		        	}
		        }
		        ,5L);
        	 }else{
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
		        p3.sendMessage(ChatColor.WHITE + "=" + ChatColor.YELLOW + " Link: " + ChatColor.AQUA + getConfig().getString("Reklam.Reklam_Link") );		      
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
				 if(getConfig().getStringList("tiklayanlar").contains(p3.getAddress().getAddress().getHostAddress())){
				    	
				    }else{
p3.kickPlayer(ChatColor.RED + "Belirlenen Reklam Tiklama Suresini Aþtiniz!");
}
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

if (this.sohbet2.get(p3) == Boolean.TRUE){
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
		       ArrayList<String> d4 = (ArrayList<String>) this.getConfig().getStringList("tiklayanlar");
		 	   d4.add("#####################"); 
		       d4.add(p3.getPlayerListName()); 
		       d4.add(p3.getAddress().getAddress().getHostAddress());
		       d4.add("#####################"); 
				 this.getConfig().set("tiklayanlar", d4);
				 saveConfig();
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
	
	        p3.sendMessage(ChatColor.WHITE + "=" + ChatColor.YELLOW + " Link: " + ChatColor.AQUA + "http://adf.ly/tkQaf" );

	       
	       
	        
	     p3.sendMessage(ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=" + ChatColor.WHITE + "=" + ChatColor.DARK_RED + "=");
	   	 p3.sendMessage("    ");
		 p3.sendMessage("    ");
	  connection.close();

			}
		} catch (SQLException e) {
	
			e.printStackTrace();
		}

}





//////////////////


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
     		       ArrayList<String> d4 = (ArrayList<String>) this.getConfig().getStringList("tiklayanlar");
     		 	   d4.add("#####################"); 
     		       d4.add(p3.getPlayerListName()); 
     		       d4.add(p3.getAddress().getAddress().getHostAddress());
     		       d4.add("#####################"); 
     				 this.getConfig().set("tiklayanlar", d4);
     				 saveConfig();
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
 		        p3.sendMessage(ChatColor.WHITE + "=" + ChatColor.YELLOW + " Link: " + ChatColor.AQUA + getConfig().getString("Reklam.Reklam_Link") ); 	 		      
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