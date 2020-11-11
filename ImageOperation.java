import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.FlowLayout;
import java.io.File;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import javax.swing.JLabel;

import javax.swing.ImageIcon;


public class ImageOperation {

    public static void operation(int key) {

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.showOpenDialog(null);
        File file = fileChooser.getSelectedFile();
        // file FileInputStream
        try {

            FileInputStream fis = new FileInputStream(file);

            byte[] data = new byte[fis.available()];
            fis.read(data);
            int i = 0;
            for (byte b : data) {
                System.out.println(b);
                data[i] = (byte) (b ^ key);
                i++;
            }

            FileOutputStream fos = new FileOutputStream(file);
            fos.write(data);
            fos.close();
            fis.close();
            JOptionPane.showMessageDialog(null, "Successfully Done");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        System.out.println("We have started testing it");

        JFrame f = new JFrame();
        f.setTitle("Security");
        f.setSize(1360, 750);
        f.setLocationRelativeTo(null);
        f.setLocation(200, 100);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(null);

        ImageIcon i1 = new ImageIcon(
                new ImageIcon("./Images/ImageSecurity.jpg").getImage().getScaledInstance(1200, 700, Image.SCALE_DEFAULT));

        JLabel l1 = new JLabel(i1);

        l1.setBounds(0, 150, 1360, 530);
        f.add(l1);

        Font font = new Font("Roboto", Font.BOLD, 25);
        // creating button
        JButton button = new JButton();
        button.setText("Upload File");
        button.setFont(font);

      

        // creating text field

        JTextField textField = new JTextField(10);
        textField.setFont(font);
        JLabel id = new JLabel();
        id.setBounds(0, 0, 1360, 750);

        JLabel lid = new JLabel("IMAGE ENCRYPTION & DECRYPTION");
        lid.setBounds(80, 30, 1500, 100);
        lid.setFont(new Font("serif", Font.PLAIN, 70));
        
        id.add(lid);
        id.setLayout(new FlowLayout());
        id.add(button);
        id.add(textField);
        f.add(id);

        
        button.addActionListener(e->{
            System.out.println("Button clicked");
            String text=textField.getText();
            int temp=Integer.parseInt(text);
            operation(temp);
        });

        

        // f.add(button);
        
        f.setVisible(true);

    }
}