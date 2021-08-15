package ObjecInfo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class PostException extends Exception {

    /**
     * Message exception
     *
     * @param string
     */
    public PostException(String string) {
        super("Post Exception : " + string);
    }

}
