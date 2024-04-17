package notebook;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Controller {
  private static final Log log = LogFactory.getFactory().getInstance(Controller.class);
  private Frame frame;
  private DAO dao;
  private Model model;
  
  public Controller(DAO dao) {
    this.dao = dao;
  }
  
  public void search(String filter) {
    log.info("searching with text " + filter);
    try {
      model.set(dao.search(filter));
    } catch(Exception e) {
      log.error("could not search against filter", e);
    }
  }
  
  public void clear() {
    model.clear();
  }
  
  public Frame getFrame() {
    return frame;
  }

  public void setFrame(Frame frame) {
    this.frame = frame;
  }

  public Model getModel() {
    return model;
  }

  public void setModel(Model model) {
    this.model = model;
  }

  public void add() {
    new NoteDialog(frame, this);
  }
  
  public void edit() {
    
  }
  
  public void delete(int id) {
    try {
      dao.delete(id);
      model.delete(frame.getSelectedRow());
    } catch(Exception e) {
      log.error("could not delete", e);
    }
  }
  
  public void add(String title, String note) {
    log.info("adding: " + title + "," + note);
    try {
      dao.add(title, note);
      model.clear();
      model.add(dao.getLast());
      frame.setSelectedRow(0);
    } catch(Exception e) {
      log.error("could not add", e);
    }
  }
  
  public void setNoteText(String text) {
    frame.setText(text);
  }
}
