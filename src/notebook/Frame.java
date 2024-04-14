package notebook;

import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.UIManager;

public class Frame extends JFrame {
  private static final long serialVersionUID = 4319336198324776603L;

  public Frame() throws Exception {
    super("Notebook - " + System.getProperty("notebook.version"));
    UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
    setSize(Toolkit.getDefaultToolkit().getScreenSize());
    setVisible(true);
  }
}
