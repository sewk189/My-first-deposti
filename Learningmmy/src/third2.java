
import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class third2 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("File Explorerrr");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new BorderLayout());

        JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        fileChooser.setControlButtonsAreShown(false);

        JButton openButton = new JButton("Oppen");
        openButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    JOptionPane.showMessageDialog(frame, "Selected File: " + selectedFile.getAbsolutePath());
                }
            }
        });

        JButton exitButton = new JButton("Exxit");
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        JPanel panel = new JPanel();
        panel.add(openButton);
        panel.add(exitButton);

        contentPane.add(fileChooser, BorderLayout.CENTER);
        contentPane.add(panel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}
