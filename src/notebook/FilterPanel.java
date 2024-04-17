package notebook;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FilterPanel extends JPanel {
  private static final long serialVersionUID = 306809055566658714L;

  public FilterPanel(Controller controller) {
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

    JButton reset = new JButton("Reset");
    reset.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        filter.setText("");
      }
    });
    add(reset);
    
    JButton addNote = new JButton("Add note...");
    addNote.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        controller.addNote();
      }
    });
    add(addNote);
  }
}
