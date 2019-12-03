package cn.lightcolour.launcher;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Main extends JFrame {
    private JPanel contentPane;
    public static void main(final String[] args) throws IOException {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    BeautyEyeLNFHelper.launchBeautyEyeLNF();
                    UIManager.put("RootPane.setupButtonVisible", false);
                    Main frame = new Main();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }


    public Main() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Excel Minecraft Client Launcher By Lightcolour");
        setBounds(100, 100, 400, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        setResizable(false);
        contentPane.setLayout(null);
        JTextField idJTextField = new JTextField("Lightcolour");
        idJTextField.setBounds(30,30,100,20);
        contentPane.add(idJTextField);
        JLabel idJLabel = new JLabel("ID:");
        idJLabel.setBounds(10,30,20,20);
        contentPane.add(idJLabel);
        JComboBox versionJComboBox = new JComboBox();
        versionJComboBox.setBounds(200,30,100,20);
        versionJComboBox.addItem("1.8.8");
        contentPane.add(versionJComboBox);
        JLabel versionJLabel = new JLabel("Version:");
        versionJLabel.setBounds(150,30,100,20);
        contentPane.add(versionJLabel);
        JTextField minmemoryJTextField = new JTextField("128");//Min Memory
        minmemoryJTextField.setBounds(80,60,50,20);
        contentPane.add(minmemoryJTextField);
        JLabel minmemoryJLabel = new JLabel("Min Memory:");
        minmemoryJLabel.setBounds(10,60,100,20);
        contentPane.add(minmemoryJLabel);
        JTextField maxmemoryJTextField = new JTextField("1792");//Max Memory
        maxmemoryJTextField.setBounds(250,60,50,20);
        contentPane.add(maxmemoryJTextField);
        JLabel maxmemoryJLabel = new JLabel("Max Memory:");
        maxmemoryJLabel.setBounds(160,60,100,20);
        contentPane.add(maxmemoryJLabel);
        JTextField widthwindowJTextField = new JTextField("854");//Width Window
        widthwindowJTextField.setBounds(80,90,50,20);
        contentPane.add(widthwindowJTextField);
        JLabel widthwindowJLabel = new JLabel("Width Window:");
        widthwindowJLabel.setBounds(10,90,100,20);
        contentPane.add(widthwindowJLabel);
        JTextField heightwindowJTextField = new JTextField("480");//Height Window
        heightwindowJTextField.setBounds(250,90,50,20);
        contentPane.add(heightwindowJTextField);
        JLabel heightwindowJLabel = new JLabel("Height Window:");
        heightwindowJLabel.setBounds(160,90,100,20);
        contentPane.add(heightwindowJLabel);
        JTextField javapathJTextField = new JTextField(System.getProperty("java.home") + "\\bin\\java.exe");//java path
        javapathJTextField.setBounds(60,130,240,20);
        contentPane.add(javapathJTextField);
        JLabel javapathJLabel = new JLabel("JPath:");
        javapathJLabel.setBounds(10,120,50,50);
        contentPane.add(javapathJLabel);
        JTextField gamepathJTextField = new JTextField("C:\\Users\\lightcolour\\Desktop\\HMCL" + "\\.minecraft\\versions\\1.8.8\\1.8.8.jar");//game path
        gamepathJTextField.setBounds(60,160,240,20);
        contentPane.add(gamepathJTextField);
        JLabel gamepathJLabel = new JLabel("Gpath:");
        gamepathJLabel.setBounds(10,150,50,50);
        contentPane.add(gamepathJLabel);
        JTextField nativespathJTextField = new JTextField("C:\\Users\\lightcolour\\Desktop\\HMCL" + "\\.minecraft\\versions\\1.8.8\\1.8.8-natives");//natives path
        nativespathJTextField.setBounds(60,190,240,20);
        contentPane.add(nativespathJTextField);
        JLabel nativespathJLabel = new JLabel("Npath:");
        nativespathJLabel.setBounds(10,180,50,50);
        contentPane.add(nativespathJLabel);
        JButton button_launcher = new JButton("Launcher");
        button_launcher.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                try {
                    LauncherScript.writeScript("C:\\Users\\lightcolour\\Desktop","1.bat",javapathJTextField.getText(),gamepathJTextField.getText(),nativespathJTextField.getText(),Integer.valueOf(minmemoryJTextField.getText()),Integer.valueOf(maxmemoryJTextField.getText()),Integer.valueOf(widthwindowJTextField.getText()),Integer.valueOf(heightwindowJTextField.getText()),"Lightcolour");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                LauncherScript.runScript("C:\\Users\\lightcolour\\Desktop","1.bat");
            }
        });
        button_launcher.setBounds(100, 250, 100, 30);
        contentPane.add(button_launcher);

    }
}
