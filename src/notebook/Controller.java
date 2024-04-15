package notebook;

import javax.swing.JFrame;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Controller {
  private static final Log log = LogFactory.getFactory().getInstance(Controller.class);
  private JFrame frame;
  private Model model;
  
  public void applyFilter(String filter) {
    log.info("applying filter with text " + filter);
  }
  
  public void addNote() {
    
  }
}
