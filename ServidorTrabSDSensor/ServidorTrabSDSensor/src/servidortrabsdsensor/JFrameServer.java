package servidortrabsdsensor;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.AWTEventMulticaster;
import java.awt.Button;
import java.awt.HeadlessException;
import java.awt.List;
import static java.awt.SystemColor.text;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class JFrameServer extends javax.swing.JFrame {

    private static ServerSocket ssocket;
    private static Socket socket;
    private static BufferedReader br;
    private static InputStreamReader inputsr;
    private static String message = "";
    private static int mensagem;
    Button bt;
    
    
    URL som = JFrameServer.class.getResource("som.wav");
    AudioClip Som = Applet.newAudioClip(som);


    
    
    
    
    public JFrameServer() {
        initComponents();
    }   
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jButton.setFont(new java.awt.Font("Haettenschweiler", 0, 24)); // NOI18N
        jButton.setForeground(new java.awt.Color(102, 0, 0));
        jButton.setText("STOP");
        jButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(jButton, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(93, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addComponent(jButton, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    
    
    static JFrameServer tocar;
    
    private void jButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonActionPerformed
       tocar.Som.stop();//new Eventoo(Som);        // TODO add your handling code here:
        
    }//GEN-LAST:event_jButtonActionPerformed

  
   
    
    public static void main(String args[]) throws IOException {
    
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameServer().setVisible(true);    
            }
        });
       
        
        int cont = 0;
        
        System.out.println("Server executando na porta 7003"); 
        try{           
             tocar = new JFrameServer();
             while(true){
                ssocket = new ServerSocket(7003);                
                socket = ssocket.accept(); // aceita uma nova conexao e cria um socket        
                
                inputsr = new InputStreamReader(socket.getInputStream()); // Conexao com o socket 
                br = new BufferedReader(inputsr); // Lê o que vem de inputsr (transformar para Leitura)
                
                
                
                message = br.readLine();
               
                //message = message.replace("|","\n");
                
                if("Proximo".equals(message)){
                    System.out.println(message);
                    //tocar.Som.play();
                    tocar.Som.loop();
                    if(cont >0){                   
                        tocar.Som.loop();
                        cont++;                 
                    }
                    cont++;
                }else{
                    System.out.println("Longe!");
                }
                
                
                 
                
    

                
                inputsr.close();
                br.close();
                ssocket.close();
                socket.close();
                

            }
        }catch (IOException e){
            e.printStackTrace();
        }  
        
     
    
    }
    
   
    

        
        
        
        

    
                                         
   
    
    /*public void som(){
            try{
                String resource = "./som.wav";
                InputStream input = getClass().getResourceAsStream(resource);
                Clip oClip = AudioSystem.getClip();
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(input);
                oClip.open(audioInput);
                
                oClip.loop(0);
                
                SwingUtilities.invokeLater(new Runnable(){
                    public void run(){
                        
                    }
                });
                }catch(IOException e){
                    e.printStackTrace();
                }
    }*/
 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton;
    // End of variables declaration//GEN-END:variables

    
}

