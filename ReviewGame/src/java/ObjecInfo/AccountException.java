package ObjecInfo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class AccountException extends Exception{
    
    /**
     * Account Exception
     * @param string 
     */
    public AccountException(String string) {
        super("Account exception " + string);
    }
}
