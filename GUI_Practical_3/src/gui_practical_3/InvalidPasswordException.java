/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui_practical_3;

/**
 *
 * @author admin
 */
public class InvalidPasswordException extends Exception {
    
    public InvalidPasswordException() {
        super("Invalid Password Exception");
    }
    
    public InvalidPasswordException(String errMsg) {
        super(errMsg);
    }
    
 }
