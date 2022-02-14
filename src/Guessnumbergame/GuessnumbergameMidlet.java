/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Guessnumbergame;

import java.util.Random;
import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.AlertType;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.TextBox;
import javax.microedition.lcdui.TextField;
import javax.microedition.midlet.*;

/**
 * @author cesar
 */
public class GuessnumbergameMidlet extends MIDlet implements CommandListener {
    
   private TextBox textBox;
   private Command cmdExit,  cmdTry;
   private Alert alert;
   private Random rand = new Random();
   private int secretNumber;
   private int numTrial = 0;
   private String msgPrompt = " Adivine el numero entre (1 - 99): ";

    public void startApp() {
      textBox = new TextBox("Adivina el numero", msgPrompt, 60, TextField.PLAIN);
      cmdExit = new Command("Exit", Command.EXIT, 2);
      cmdTry = new Command("Intentar", Command.SCREEN, 1);
      textBox.addCommand(cmdTry);
      textBox.addCommand(cmdExit);
      textBox.setCommandListener(this);
      alert = new Alert("Resultado", "", null, AlertType.CONFIRMATION);
      
      secretNumber = rand.nextInt(100);
        Display.getDisplay(this).setCurrent(textBox);  
    }
    
    public void pauseApp() {
    }
    
    public void destroyApp(boolean unconditional) {
    }

    public void commandAction(Command c, Displayable d) {
      
           if (c == cmdTry) {
         textBox.delete(0, msgPrompt.length());  
         alert.setString(checkNumber(textBox.getString()));
         Display.getDisplay(this).setCurrent(alert);
         textBox.setString(msgPrompt);
      } if (c == cmdExit) {
         destroyApp(true);
         notifyDestroyed();
        
    }
}

    private String checkNumber(String strNumberIn) {
        int numberIn = Integer.parseInt(strNumberIn);
      numTrial++;
      if (numberIn == secretNumber) {
         // Regenerate secret number for the next game
         int numTrialSaved = numTrial;
         numTrial = 0;
         secretNumber = rand.nextInt(100);
         return "Felicidades\n" + "Loconsguiste en" +numTrialSaved + " intentos";
      }  if (numberIn > secretNumber) {
         return "Intenta un numero menor";
      } else {
         return "Intenta un numero mayor";
      } 
    }
}

  
