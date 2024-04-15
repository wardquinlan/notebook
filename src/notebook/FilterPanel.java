package notebook;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FilterPanel extends JPanel {
  private static final long serialVersionUID = 306809055566658714L;

  public FilterPanel() {
    super();
    setBackground(new Color(0, 255, 0));
    add(new JLabel("Title"));
    add(new JTextField());
    add(new JLabel("Text"));
    add(new JTextField());
  }
}
