package ObjecInfo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class Type_AccountException extends Exception{

    /**
     * Exception type account
     * @param string 
     */
    public Type_AccountException(String string) {
        super("Exception of Type account : " +string);
    }
    
}
