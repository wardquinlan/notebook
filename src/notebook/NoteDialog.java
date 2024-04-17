package notebook;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class NoteDialog extends JDialog {
  private static final long serialVersionUID = 6299811276766639359L;
  private static final int WIDTH = 600;
  private static final int HEIGHT = 400;

  public NoteDialog(JFrame frame, Controller controller) {
    super(frame, "Add Note", true);
    setLayout(new BorderLayout());
    JPanel mainPanel = new JPanel();
    mainPanel.setLayout(new BorderLayout());
    JTextField title = new JTextField(20);
    mainPanel.add(new LabeledComponent("Title", title), BorderLayout.NORTH);
    JTextArea textArea = new JTextArea();
    mainPanel.add(new LabeledComponent("Note", textArea), BorderLayout.CENTER);
    mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
    getContentPane().add(mainPanel, BorderLayout.CENTER);
    
    JButton ok = new JButton("OK");
    ok.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if (title.getText().length() == 0) {
          JOptionPane.showMessageDialog(frame, "A title is required", "Error", JOptionPane.ERROR_MESSAGE);
          return;
        }
        controller.addNote(title.getText(), textArea.getText());
        dispose();
      }
    });
    
    JButton cancel = new JButton("Cancel");
    cancel.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        dispose();
      }
    });

    JPanel buttonPanel = new JPanel();
    buttonPanel.add(ok);
    buttonPanel.add(cancel);
    getContentPane().add(buttonPanel, BorderLayout.SOUTH);
    
    setSize(WIDTH, HEIGHT);
    setLocation((int) Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 2 - WIDTH / 2, (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 2 - HEIGHT / 2);
    setVisible(true);
  }
}
