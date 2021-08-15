package ObjecInfo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


public class CommentException extends Exception {

    /**
     * Message exception
     *
     * @param string
     */
    public CommentException(String string) {
        super("Comment Exception : " + string);
    }

}
