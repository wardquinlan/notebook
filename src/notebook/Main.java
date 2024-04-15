package notebook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Main {
  private static final Log log = LogFactory.getFactory().getInstance(Main.class);
  
  public static void main(String[] args) {
    log.info("starting up");
    try {
      log.info("reading notebook properties");
      InputStream input = new FileInputStream(System.getenv("NB_HOME") + File.separator + "notebook.d" + File.separator + "notebook.properties");
      System.getProperties().load(input);
    } catch (IOException e) {
      log.error("cannot load notepad properties", e);
      System.exit(1);
    }
    
    log.info("extracting database connection properties");
    String host;
    if (System.getProperty("notebook.host") == null) {
      host = "localhost";
    } else {
      host = System.getProperty("notebook.host");
    }
    if (System.getProperty("notebook.database") == null) {
      log.fatal("notebook.database not set");
      System.exit(1);
    }
    String database = System.getProperty("notebook.database");
    
    if (System.getProperty("notebook.username") == null) {
      log.fatal("notebook.username not set");
      System.exit(1);
    }
    String username = System.getProperty("notebook.username");
    
    if (System.getProperty("notebook.password") == null) {
      log.fatal("notebook.password not set");
      System.exit(1);
    }
    String password = System.getProperty("notebook.password");
    
    log.info("connecting to database");
    DAO dao = new DAO();
    try {
      dao.connect(host, database, username, password);
    } catch(Exception e) {
      log.fatal("can't connect to database", e);
      System.exit(1);
    }
    
    log.info("adding shutdown hook");
    Runtime.getRuntime().addShutdownHook(new Thread() {
      public void run() {
        log.info("shutting down...");
        try {
          dao.close();
          log.info("database connection closed");
        } catch(Exception e) {
          log.error("could not close database connection", e);
        }
      }
    });
    
    Model model = new Model();
    Controller controller = new Controller();
    try {
      new Frame(controller, model);
    } catch(Exception e) {
      log.fatal("could not launch frame", e);
      System.exit(1);
    }
  }
}
