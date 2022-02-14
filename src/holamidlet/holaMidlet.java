/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package holamidlet;

import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Form;
import javax.microedition.midlet.*;

/**
 * @author cesar
 */
public class holaMidlet extends MIDlet {
    private Display pantalla;
    private Form formulario;
    
     public void startApp(){
         pantalla = Display.getDisplay(this);
         formulario = new Form("Hola mundo midlet");
         pantalla.setCurrent(formulario);
     }
    
    public void pauseApp() {
    }
    
    public void destroyApp(boolean unconditional) {
    }
}
