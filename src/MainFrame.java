import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainFrame extends JFrame{
    private int frmW=300,frmH = 150,screenW,screenH;
    private Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    private JButton jbnMax = new JButton("Max(Alt+Z)");
    private JButton jbnMin = new JButton("Min(Alt+X)");
    private JLabel jlab=new JLabel(new ImageIcon("Penguins.jpg"));
    private int labx,laby;
    public MainFrame(){
        initcomp();
    }
    private void initcomp(){
        screenW = dim.width;
        screenH = dim.height;
        this.setBounds(screenW/2-frmW/2,screenH/2-frmH/2,frmW,frmH);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
            }
        });
        this.setLayout(null);
        jbnMax.setBounds(10,0,100,60);
        jbnMax.setBackground(Color.lightGray);
        jbnMax.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                labx+= 5;
                laby+= 5;
                jlab.setBounds(100,100,400+labx,400+laby);
                KeyStroke.getKeyStroke('Z',Toolkit.getDefaultToolkit().getMenuShortcutKeyMask());

            }
        });
        jbnMax.setMnemonic(KeyEvent.VK_Z);
        this.add(jbnMax);

        jbnMin.setBounds(150,0,100,60);
        jbnMin.setBackground(Color.lightGray);
        jbnMin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                labx-= 5;
                laby-= 5;
                jlab.setBounds(100,100,400+labx,400+laby);
            }
        });
        jbnMin.setMnemonic(KeyEvent.VK_X);
        this.add(jbnMin);

        jlab.setBounds(100,100,400,400);
        jlab.setOpaque(true);
        this.add(jlab);






    }
}
