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
    
    try {
      log.info("Starting up...");
      try {
        InputStream input = new FileInputStream(System.getenv("NB_HOME") + File.separator + "notebook.d" + File.separator + "notebook.properties");
        System.getProperties().load(input);
      } catch (IOException e) {
        log.error("cannot load notepad properties", e);
        System.exit(1);
      }
      
      new Frame();
    } catch(Exception e) {
      log.error(e);
      System.exit(1);
    }
  }
}
