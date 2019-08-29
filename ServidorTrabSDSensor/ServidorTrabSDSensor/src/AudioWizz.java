import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class AudioWizz extends JPanel implements ActionListener {

    private static final long serialVersionUID = 1L; //you like your cereal and the program likes their "serial"

    static AudioWizz a;
    static JButton playBuddon;
    static JFrame frame;

    public static void main(String arguments[]){

        frame= new JFrame("AudioWizz");
        frame.setSize(300,300);
        frame.setVisible(true);
        a= new AudioWizz();
        playBuddon= new JButton("PUSH ME");
        playBuddon.setBounds(10,10,80,30);
        playBuddon.addActionListener(a);

        frame.add(playBuddon);
        frame.add(a);
    }

    public void actionPerformed(ActionEvent e){ //an eventListener
        if (e.getSource() == playBuddon) {
            try {
                InputStream in = new FileInputStream("audio.wav");
                AudioStream sound = new AudioStream(in);
                AudioPlayer.player.start(sound);
            } catch(FileNotFoundException e1) {
                e1.printStackTrace();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

}