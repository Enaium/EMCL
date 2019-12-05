package cn.lightcolour.launcher;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.*;

public class Main extends JFrame {
    private JPanel contentPane;
    private String APPDATA = System.getenv("APPDATA");
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


    public Main() throws IOException {
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
        File dir = new File(APPDATA + "\\.minecraft\\versions");
        File[] files = dir.listFiles();
        FileFilter fileFilter = new FileFilter() {
            public boolean accept(File file) {
                return file.isDirectory();
            }
        };
        files = dir.listFiles(fileFilter);
        if (!(files.length == 0)) {
            for (int i=0; i< files.length; i++) {
                File filename = files[i];
                versionJComboBox.addItem(filename.getName());
            }
        }
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
        JTextField jsonpathJTextField = new JTextField(APPDATA + "\\.minecraft\\versions\\" + versionJComboBox.getItemAt(versionJComboBox.getSelectedIndex()) + "\\" + versionJComboBox.getItemAt(versionJComboBox.getSelectedIndex()) + ".json");
        jsonpathJTextField.setBounds(60,130,240,20);
        contentPane.add(jsonpathJTextField);
        JLabel jsonJLabel = new JLabel("Json:");
        jsonJLabel.setBounds(10,130,240,20);
        contentPane.add(jsonJLabel);
        JTextField javapathJTextField = new JTextField(System.getProperty("java.home") + "\\bin\\java.exe");//java path
        javapathJTextField.setBounds(60,160,240,20);
        contentPane.add(javapathJTextField);
        JLabel javapathJLabel = new JLabel("Java:");
        javapathJLabel.setBounds(10,150,50,50);
        contentPane.add(javapathJLabel);
        JTextField gamepathJTextField = new JTextField(APPDATA + "\\.minecraft\\versions\\" + versionJComboBox.getItemAt(versionJComboBox.getSelectedIndex()) + "\\" + versionJComboBox.getItemAt(versionJComboBox.getSelectedIndex()) + ".jar");//game path
        gamepathJTextField.setBounds(60,190,240,20);
        contentPane.add(gamepathJTextField);
        JLabel gamepathJLabel = new JLabel("Game:");
        gamepathJLabel.setBounds(10,180,50,50);
        contentPane.add(gamepathJLabel);
        JTextField nativespathJTextField = new JTextField(APPDATA + "\\.minecraft\\versions\\" + versionJComboBox.getItemAt(versionJComboBox.getSelectedIndex()) + "\\" + versionJComboBox.getItemAt(versionJComboBox.getSelectedIndex()) + "-natives");//natives path
        nativespathJTextField.setBounds(60,220,240,20);
        contentPane.add(nativespathJTextField);
        JLabel nativespathJLabel = new JLabel("Natives:");
        nativespathJLabel.setBounds(10,210,50,50);
        contentPane.add(nativespathJLabel);
        versionJComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                jsonpathJTextField.setText(APPDATA + "\\.minecraft\\versions\\" + versionJComboBox.getItemAt(versionJComboBox.getSelectedIndex()) + "\\" + versionJComboBox.getItemAt(versionJComboBox.getSelectedIndex()) + ".json");
                gamepathJTextField.setText(APPDATA + "\\.minecraft\\versions\\" + versionJComboBox.getItemAt(versionJComboBox.getSelectedIndex()) + "\\" + versionJComboBox.getItemAt(versionJComboBox.getSelectedIndex()) + ".jar");//game path
                nativespathJTextField.setText(APPDATA + "\\.minecraft\\versions\\" + versionJComboBox.getItemAt(versionJComboBox.getSelectedIndex()) + "\\" + versionJComboBox.getItemAt(versionJComboBox.getSelectedIndex()) + "-natives");//natives path

            }
        });
        JButton button_launcher = new JButton("Launcher");
        button_launcher.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                try {
                    LauncherScript.writeScript(APPDATA + "\\.minecraft",
                            "EMCL.bat",javapathJTextField.getText(),
                            gamepathJTextField.getText(),
                            nativespathJTextField.getText(),
                            jsonpathJTextField.getText(),
                            Integer.valueOf(minmemoryJTextField.getText()),
                            Integer.valueOf(maxmemoryJTextField.getText()),
                            Integer.valueOf(widthwindowJTextField.getText()),
                            Integer.valueOf(heightwindowJTextField.getText()),
                            idJTextField.getText());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                LauncherScript.runScript(APPDATA + "\\.minecraft","EMCL.bat");
            }
        });
        button_launcher.setBounds(100, 250, 100, 30);
        contentPane.add(button_launcher);
    }


}
