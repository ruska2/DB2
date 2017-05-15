import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

class DBContext {
  
  static Connection c = null;
  static String url;
  static Properties properties;
  
  public static void init(String name, String password) throws SQLException {
	  String url = "jdbc:postgresql://db.ii.fmph.uniba.sk/db1";
	  Properties properties = new Properties();
	  properties.put("user", name);
	  properties.put("password", password);
	  c = DriverManager.getConnection(url, properties);
  }
  
  public static Connection getConnection() throws SQLException {
	  if(c == null){
		  init("ruska2","db1ruska2");
	  }
      if (c.isValid(10)) {
	  return c;
	  } else {
	      c.close();
		  System.out.print(c.toString());
	      c = DriverManager.getConnection(url, properties);
	    return c;
	}
  	
  }
  
  public static void close() throws SQLException {
  	c.close();
  }

}