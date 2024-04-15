package notebook;

import java.sql.Connection;
import java.sql.DriverManager;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DAO {
  private static Log log = LogFactory.getFactory().getInstance(DAO.class);
  private Connection conn;
  
  public void connect(String host, String database, String username, String password) throws Exception {
    if (conn != null) {
      throw new Exception("already connected to datastore");
    }
    Class.forName("org.postgresql.Driver");
    String url = "jdbc:postgresql://" + host + "/" + database + "?user=" + username;
    log.info("connecting to database using " + url);
    if (password != null) {
      url = url + "&password=" + password;
    }
    conn = DriverManager.getConnection(url);  
  }
  
  public void load(String filter) {
    // select * from notebook where UPPER(note) like UPPER('%myx%') or UPPER(title) like UPPER('%my%');
  }
  
}
