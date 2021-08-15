package ObjecInfo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


public class Comment {
    //Declare variables

    int ID_Comment;
    int ID_Account;
    int ID_Post;
    String Content_Comment;
    String Date_Comment;
    int Status;

    public Comment() {
    }

    /**
     * Create constructor
     *
     * @param ID_Comment
     * @param ID_Account
     * @param ID_Post
     * @param Content_Comment
     * @param Date_Comment
     * @param Status
     */
    public Comment(int ID_Comment, int ID_Account, int ID_Post, String Content_Comment, String Date_Comment, int Status) {
        this.ID_Comment = ID_Comment;
        this.ID_Account = ID_Account;
        this.ID_Post = ID_Post;
        this.Content_Comment = Content_Comment;
        this.Date_Comment = Date_Comment;
        this.Status = Status;
    }

    //create getter ID_Comment
    public int getID_Comment() {
        return ID_Comment;
    }

    //create setter ID_Comment
    public void setID_Comment(int ID_Comment) throws Exception{
        if(ID_Comment < 0){
            throw new CommentException("Error ID Comment cannot smaller than 0");
        }
        else{
            this.ID_Comment = ID_Comment;
        }      
    }

    //create getter ID_Account
    public int getID_Account() {
        return ID_Account;
    }

    //create setter ID_Account
    public void setID_Account(int ID_Account) throws Exception {
        if(ID_Account < 0){
            throw new CommentException("Error ID Account cannot smaller than 0");
        }
        else{
            this.ID_Account = ID_Account;
        }
        
    }

    //create getter ID_Post
    public int getID_Post() {
        return ID_Post;
    }

    //create setter ID_Post
    public void setID_Post(int ID_Post) throws Exception {
        if(ID_Post < 0){
            throw new CommentException("Error ID Post cannot smaller than 0");
        }
        else{
             this.ID_Post = ID_Post;
        }
       
    }

    //create getter Content_Comment
    public String getContent_Comment() {
        return Content_Comment;
    }

    //create setter Content_Comment
    public void setContent_Comment(String Content_Comment) throws Exception {
        if(Content_Comment.trim().equals("")){
            throw new CommentException("Error content comment cannot null");
        }
        else{
             this.Content_Comment = Content_Comment;
        }
        
    }

    //create getter Date_Comment
    public String getDate_Comment() {
        return Date_Comment;
    }

    //create setter Date_Comment
    public void setDate_Comment(String Date_Comment) throws Exception{
        if(Date_Comment.trim().equals("")){
            throw new CommentException("Error date comment cannot null");
        }
        else{
            this.Date_Comment = Date_Comment;
        }
        
    }

    //create getter Status
    public int getStatus() {
        return Status;
    }

    //create setter Status
    public void setStatus(int Status) {
        this.Status = Status;
    }
    
   
}
