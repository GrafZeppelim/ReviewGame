package ObjecInfo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class CategoryException extends Exception{

    /**
     * Category exception
     * @param string 
     */
    public CategoryException(String string) {
        super("Category exception "+string);
    }
    
}
