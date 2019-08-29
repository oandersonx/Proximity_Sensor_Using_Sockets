package servidortrabsdsensor;

import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;

/**
*
* @author Francisco Elves
*/
/*public class ClassePrincipal {
    URL som = ClassePrincipal.class.getResource("som.WAV");
    AudioClip Som = Applet.newAudioClip(som);
    
    public static void main(String args[]) {
        
        ClassePrincipal tocar = new ClassePrincipal();
        tocar.Som.play();
        
        
    }
}*/

/*public class ClassePrincipal {
    URL som = ClassePrincipal.class.getResource("audio.wav");
    AudioClip Som = Applet.newAudioClip(som);
    
    public static void main(String[] args) {
        ClassePrincipal tocar = new ClassePrincipal();
        tocar.Som.play();
    }
    
            
}*/

public class ClassePrincipal{
     public static void main(String[] args) {
         System.out.println("metodo principal");
         File Clap = new File("som.wav");
         System.out.println(Clap);
         PlaySound(Clap);
    }
     
     static void PlaySound(File Sound){
         System.out.println("aqui");
         try{
             System.out.println("aqui2");
             Clip clip = AudioSystem.getClip();
             System.out.println("aqui3");
             clip.open(AudioSystem.getAudioInputStream(Sound));
             System.out.println("aqui4");
             clip.start();
             clip.loop(100);
             System.out.println("aqui5");
             Thread.sleep(clip.getMicrosecondLength()/1000);
             
         }catch(Exception e){
             
         }
     }
    
}