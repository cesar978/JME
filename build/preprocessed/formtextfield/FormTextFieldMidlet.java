/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formtextfield;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.Item;
import javax.microedition.lcdui.ItemStateListener;
import javax.microedition.lcdui.StringItem;
import javax.microedition.lcdui.TextField;
import javax.microedition.midlet.*;

/**
 * @author cesar
 */
public class FormTextFieldMidlet extends MIDlet 
implements CommandListener, ItemStateListener{
    
   private Form mainForm;
   private TextField tfNum1;
    private TextField tfNum2;
     private TextField tfoperador;
      private TextField tfresultado;
   private StringItem msg;
   private double num1, num2, result;
   private String oper;
   private Command cmdExit; 
   private Command cmdGo;

    public void startApp() {
         mainForm = new Form("Forulario calculadora");
      tfNum1 = new TextField("Numero 1:", "", 10, TextField.DECIMAL);
      tfNum2 = new TextField("Numero 2:", "", 10, TextField.DECIMAL);
      tfoperador = new TextField("Operacion:", "", 1, TextField.ANY);
      tfresultado = new TextField("Resultado: ", "", 10, TextField.DECIMAL);
      msg = new StringItem("", "Escriba los numeros, asigne" + "operacion  S para sumar o M para "
              + "multiplicar"  + "D para Dividir y R para Restar " + "y presionamos Go");
              
      mainForm.append(tfNum1);
      mainForm.append(tfNum2);
      mainForm.append(tfoperador);
      mainForm.append(tfresultado);
      mainForm.append(msg);
      
      cmdExit = new Command("Exit", Command.EXIT, 2);
      cmdGo = new Command("GO", Command.SCREEN, 1);
      
      mainForm.addCommand(cmdExit);
      mainForm.addCommand(cmdGo);
      
      mainForm.setCommandListener(this);
      mainForm.setItemStateListener(this);
      
       Display.getDisplay(this).setCurrent(mainForm);
      
    }
    
    public void pauseApp() {
    }
    
    public void destroyApp(boolean unconditional) {
    }

    public void commandAction(Command c, Displayable d) {
         if (c == cmdGo) {
         if (oper.equalsIgnoreCase("S")) {
            result = num1 + num2;
         } 
         if (oper.equalsIgnoreCase("M")) {
            result = num1 * num2;
         }
         
         if (oper.equalsIgnoreCase("D")) {
            result = num1 / num2;
         }
         if (oper.equalsIgnoreCase("R")) {
            result = num1 - num2;
         }
         tfresultado.setString(result + "");
      } 
         if (c == cmdExit) {
         destroyApp(true);
         notifyDestroyed();
    }
    }

    public void itemStateChanged(Item item) {
     if (item == tfNum1) {
         num1 = Double.parseDouble(tfNum1.getString());
      }
      if (item == tfNum2) {
         num2 = Double.parseDouble(tfNum2.getString());
      }
      if (item == tfoperador) {
         oper = tfoperador.getString();
      }
    }
}
