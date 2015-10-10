/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.UIManager;

/**
 *
 * @author Paulo Cesar
 */
public class Main {
    public static void main(String[] args) {
        new Main();
            
    }
    Main(){
         try {  
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);

            }
        });
    }
    
}
