package notebook;

import javax.swing.JFrame;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Controller {
  private static final Log log = LogFactory.getFactory().getInstance(Controller.class);
  private JFrame frame;
  private DAO dao;
  private Model model;
  
  public Controller(DAO dao) {
    this.dao = dao;
  }
  
  public void applyFilter(String filter) {
    log.info("applying filter with text " + filter);
  }
  
  public JFrame getFrame() {
    return frame;
  }

  public void setFrame(JFrame frame) {
    this.frame = frame;
  }

  public Model getModel() {
    return model;
  }

  public void setModel(Model model) {
    this.model = model;
  }

  public void addNote() {
    new NoteDialog(frame, this);
  }
  
  public void addNote(String title, String note) {
    log.info("adding note: " + title + "," + note);
    try {
      dao.addNote(title, note);
      Note n = dao.getLast();
      
    } catch(Exception e) {
      log.error("could not add note", e);
    }
  }
}
