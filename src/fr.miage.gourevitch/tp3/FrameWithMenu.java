package fr.miage.gourevitch.tp3;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class FrameWithMenu {
    void showFrame() {
        if (frame == null) {
            frame = new JFrame("Test menu");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setBounds(100, 100, 450, 300);
            contentPane = new JPanel();
            contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
            contentPane.setLayout(new BorderLayout(0, 0));
            frame.setContentPane(contentPane);
        }
        buildMenu();
        frame.setVisible(true);
    }

    JFrame frame;
    private JPanel contentPane;

    @SuppressWarnings("serial")
    void buildMenu() {
        JMenuBar bar = new JMenuBar();
        frame.setJMenuBar(bar);
        JMenu fileM = new JMenu("Fichier");
        bar.add(fileM);
        fileM.add(new AbstractAction("Save", new ImageIcon("res/save-icon16.png")) {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                System.out.println("DoSaveAction:"+arg0);
            }
            @Override
            public Object getValue(String arg0) {
                if(arg0==Action.ACCELERATOR_KEY) // cannot be changed later (use putValue when possible - not anonymous)
                    return KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK);
                return super.getValue(arg0);
            }
        });
    }

    public static void main(String[] args) {
        new FrameWithMenu().showFrame();
    }
}