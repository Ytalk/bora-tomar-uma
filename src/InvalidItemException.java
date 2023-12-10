package src;

import javax.swing.JOptionPane;

public class InvalidItemException extends RuntimeException{
    
    String message, error_name;

    public InvalidItemException(String message, String error_name){
        this.message = message;
        this.error_name = error_name;
    }


    public void showMessage(){
        JOptionPane.showMessageDialog(null, message, error_name, JOptionPane.ERROR_MESSAGE);
    }

}