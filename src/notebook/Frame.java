package notebook;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.UIManager;

public class Frame extends JFrame {
  private static final long serialVersionUID = 4319336198324776603L;
  private JTextArea textArea = new JTextArea();
  
  public Frame(Controller controller, Model model) throws Exception {
    super("Notebook - " + System.getProperty("notebook.version"));
    textArea.setEnabled(false);
    textArea.setDisabledTextColor(Color.BLACK);
    
    UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
    getContentPane().setLayout(new BorderLayout());
    
    add(new FilterPanel(controller), BorderLayout.NORTH);
    
    JTable table = new Table(controller, model);
    JScrollPane scrollPane = new JScrollPane(table);
    JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
    splitPane.setDividerLocation((int) (getHeight() * 0.7));
    splitPane.setTopComponent(scrollPane);
    splitPane.setBottomComponent(textArea);
    add(splitPane, BorderLayout.CENTER);
    
    setSize(Toolkit.getDefaultToolkit().getScreenSize());
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
  
  public void setNoteText(String text) {
    textArea.setText(text);
  }
}
