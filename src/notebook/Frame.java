package notebook;

import java.awt.BorderLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;

public class Frame extends JFrame {
  private static final long serialVersionUID = 4319336198324776603L;
  private Controller controller;
  private Model model;
  
  public Frame(Controller controller, Model model) throws Exception {
    super("Notebook - " + System.getProperty("notebook.version"));
    this.controller = controller;
    this.model = model;
    
    UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
    getContentPane().setLayout(new BorderLayout());
    add(new FilterPanel(controller), BorderLayout.NORTH);
    JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
    JTable table = new JTable(model);
    table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    JScrollPane scrollPane = new JScrollPane(table);
    splitPane.setTopComponent(scrollPane);
    JTextArea textArea = new JTextArea();
    textArea.setEnabled(false);
    splitPane.setBottomComponent(textArea);
    add(splitPane, BorderLayout.CENTER);
    setSize(Toolkit.getDefaultToolkit().getScreenSize());
    splitPane.setDividerLocation((int) (getHeight() * 0.7));
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}
