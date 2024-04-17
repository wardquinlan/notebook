package notebook;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;

public class Table extends JTable {
  private static final long serialVersionUID = 3882178188030656062L;
  private Controller controller;
  private Model model;

  public Table(Controller controller, Model model) {
    super(model);
    this.controller = controller;
    this.model = model;
    setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
  }
  
  @Override
  public void valueChanged(ListSelectionEvent e) {
    super.valueChanged(e);
    //int index = e.getFirstIndex();
    int index = getSelectedRow();
    controller.setNoteText(model.get(index).getText());
  }
}
