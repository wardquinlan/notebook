package notebook;

import javax.swing.table.DefaultTableModel;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Model extends DefaultTableModel {
  private static final long serialVersionUID = -3950929583108303584L;
  private static final Log log = LogFactory.getFactory().getInstance(Model.class);
  
  @Override
  public String getColumnName(int col) {
    switch(col) {
    case 0:
      return "ID";
    case 1:
      return "Timestamp";
    case 2:
      return "Title";
    default:
      log.error("unexpected column: " + col);
      return null;
    }
  }
  
  @Override
  public int getRowCount() {
    return 0;
  }
  
  @Override
  public int getColumnCount() {
    return 3;
  }
}

