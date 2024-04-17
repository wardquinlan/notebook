package notebook;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableCellRenderer;

public class Table extends JTable {
  private static final long serialVersionUID = 3882178188030656062L;
  private Frame frame;
  private Model model;

  public Table(Frame frame, Model model) {
    super(model);
    this.frame = frame;
    this.model = model;
    setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    
    DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
    centerRenderer.setHorizontalAlignment(JLabel.CENTER);

    getColumnModel().getColumn(0).setCellRenderer(centerRenderer);    
    getColumnModel().getColumn(0).setPreferredWidth(60);
    getColumnModel().getColumn(0).setMaxWidth(60);
    getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
    getColumnModel().getColumn(1).setPreferredWidth(200);
    getColumnModel().getColumn(1).setMaxWidth(200);
  }
  
  @Override
  public boolean isCellEditable(int row, int column) {
    return false;
  }
  
  @Override
  public void valueChanged(ListSelectionEvent e) {
    super.valueChanged(e);
    int index = getSelectedRow();
    if (index == -1) {
      frame.setText("");
    } else {
      frame.setText(model.get(index).getText());
    }
  }
}
