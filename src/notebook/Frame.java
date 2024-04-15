package notebook;

import java.awt.BorderLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class Frame extends JFrame {
  private static final long serialVersionUID = 4319336198324776603L;

  public Frame() throws Exception {
    super("Notebook - " + System.getProperty("notebook.version"));
    UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
    getContentPane().setLayout(new BorderLayout());
    add(new FilterPanel(), BorderLayout.NORTH);
    add(new JPanel(), BorderLayout.CENTER);
    add(new JButton("Push me"), BorderLayout.SOUTH);
    setSize(Toolkit.getDefaultToolkit().getScreenSize());
    setVisible(true);
  }
}
