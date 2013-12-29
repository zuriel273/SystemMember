/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sgm;

import java.awt.Rectangle;
import java.awt.Toolkit;
import java.util.logging.*;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import view.Principal;


/**
 *
 * @author Arlindo
 */
public class SGM {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
       // Teste  
             
        try {
           // UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
     UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
            Principal principal = new Principal();
            principal.setExtendedState(JFrame.MAXIMIZED_BOTH);
            Toolkit theKit = principal.getToolkit(); // for Fullscreen  
            principal.setBounds(new Rectangle(theKit.getScreenSize()));  
            principal.setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SGM.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(SGM.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(SGM.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(SGM.class.getName()).log(Level.SEVERE, null, ex);
        }
           /* try {
//            UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
            new Principal_old().setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        
    }
}
