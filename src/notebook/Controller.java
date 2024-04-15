package notebook;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Controller {
  private static final Log log = LogFactory.getFactory().getInstance(Controller.class);
  private DAO dao = new DAO();
  
  public Controller() throws Exception {
    String host;
    if (System.getenv("NB_HOST") == null) {
      host = "localhost";
    } else {
      host = System.getenv("NB_HOST");
    }
    if (System.getenv("NB_DATABASE") == null) {
      throw new Exception("NB_DATABASE not set");
    }
    String database = System.getenv("NB_DATABASE");
    
    if (System.getenv("NB_USERNAME") == null) {
      throw new Exception("NB_USERNAME not set");
    }
    String username = System.getenv("NB_USERNAME");
    
    if (System.getenv("NB_PASSWORD") == null) {
      throw new Exception("NB_PASSWORD not set");
    }
    String password = System.getenv("NB_PASSWORD");
    
    dao.connect(host, database, username, password);
  }
  
  public void applyFilter(String filter) {
    log.info("applying filter with text " + filter);
  }
}
