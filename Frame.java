import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Frame {
    public static void main(String[] args) {
        JFrame frame=new JFrame();
        frame.setVisible(true);
        frame.setSize(600, 614);
        frame.setLocationRelativeTo(null);
        frame.setAlwaysOnTop(true);
        frame.setDefaultCloseOperation(3);

        frame.setTitle("2048");
        frame.setLayout(null);

        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                JLabel Region_r=new JLabel(new ImageIcon("D:\\ImageIcon\\GenshinImpact.png"));
                Region_r.setBounds(45+130*j, 45+131*i, 120, 120);
                frame.getContentPane().add(Region_r);
            }
        }

    }
}
