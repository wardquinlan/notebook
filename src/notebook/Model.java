package notebook;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Model extends DefaultTableModel {
  private static final long serialVersionUID = -3950929583108303584L;
  private static final Log log = LogFactory.getFactory().getInstance(Model.class);
  private List<Note> list = new ArrayList<>();
  
  @Override
  public String getColumnName(int column) {
    switch(column) {
    case 0:
      return "ID";
    case 1:
      return "Timestamp";
    case 2:
      return "Title";
    default:
      log.error("unexpected column: " + column);
      return null;
    }
  }
  
  @Override
  public int getRowCount() {
    return list == null ? 0 : list.size();
  }
  
  public void add(Note note) {
    list.add(note);
    fireTableDataChanged();
  }
  
  @Override
  public Object getValueAt(int row, int column) {
    Note note = list.get(row);
    switch (column) {
    case 0:
      return "0";
    case 1:
      return "1";
    case 2:
      return "2";
    default:
      log.error("unexpected column: " + column);
      return null;
    }
  }
  
  @Override
  public int getColumnCount() {
    return 3;
  }
}

