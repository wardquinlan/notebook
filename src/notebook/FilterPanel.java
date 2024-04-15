package notebook;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FilterPanel extends JPanel {
  private static final long serialVersionUID = 306809055566658714L;

  public FilterPanel() {
    super();
    //setBackground(new Color(0, 255, 0));
    add(new LabeledComponent("Title", new JTextField(20)));
    add(new LabeledComponent("Text", new JTextField(20)));
    add(new JCheckBox("Case sensitive"));
    add(new JButton("Apply"));
    add(new JButton("Add note..."));
  }
}
