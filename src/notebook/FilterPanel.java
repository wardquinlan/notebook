package notebook;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FilterPanel extends JPanel {
  private static final long serialVersionUID = 306809055566658714L;

  public FilterPanel(Frame frame, Controller controller, Model model) {
    super(new FlowLayout(FlowLayout.LEFT));
    
    //setBackground(new Color(0, 255, 0));
    JTextField filter = new JTextField(20);
    add(new LabeledComponent("Filter", filter));
    
    JButton search = new JButton("Search");
    search.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        controller.search(filter.getText());
      }
    });
    add(search);

    JButton clear = new JButton("Clear");
    clear.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        filter.setText("");
        controller.clear();
      }
    });
    add(clear);
    
    JButton add = new JButton("Add");
    add.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        controller.add();
      }
    });
    add(add);
    
    JButton edit = new JButton("Edit");
    edit.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        controller.edit();
      }
    });
    add(edit);
    
    JButton delete = new JButton("Delete");
    delete.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if (frame.getSelectedRow() != -1 &&
            JOptionPane.showConfirmDialog(frame, "Are you sure?", "Confirm", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
          Note note = model.get(frame.getSelectedRow());
          controller.delete(note.getId());
        }
      }
    });
    add(delete);

    JButton exit = new JButton("Exit");
    exit.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        System.exit(0);
      }
    });
    add(exit);
  }
}
