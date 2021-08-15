package ObjecInfo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class Posts {
    //declare variables

    private int ID_Post;
    private int ID_Account;
    private int ID_Game;
    private String Content_Post;
    private String Title_Post;
    private String Image_Post;
    private String Video_Post;
    private int Status;

    /**
     * Post constructor
     */
    public Posts() {
    }

    /**
     * constructor Posts
     *
     * @param ID_Post
     * @param ID_Account
     * @param ID_Game
     * @param Content_Post
     * @param Title_Post
     * @param Image_Post
     * @param Video_Post
     * @param Status
     */
    public Posts(int ID_Post, int ID_Account, int ID_Game, String Content_Post, String Title_Post, String Image_Post, String Video_Post, int Status) {
        this.ID_Post = ID_Post;
        this.ID_Account = ID_Account;
        this.ID_Game = ID_Game;
        this.Content_Post = Content_Post;
        this.Title_Post = Title_Post;
        this.Image_Post = Image_Post;
        this.Video_Post = Video_Post;
        this.Status = Status;
    }

    //create getter ID_Post
    public int getID_Post() {
        return ID_Post;
    }

    //create setter ID_Post
    public void setID_Post(int ID_Post) throws Exception {
        if (ID_Post < 0) {
            throw new PostException("Error ID Post cannot smaller than 0");
        } else {
            this.ID_Post = ID_Post;
        }
    }

    //create getter ID_Account
    public int getID_Account() {
        return ID_Account;
    }

    //create setter ID_Account
    public void setID_Account(int ID_Account) throws Exception {
        if (ID_Account < 0) {
            throw new PostException("Error ID Account cannot smaller than 0");
        } else {
            this.ID_Account = ID_Account;

        }

    }

    //create getter ID_Game
    public int getID_Game() {
        return ID_Game;
    }

    //create setter ID_Game
    public void setID_Game(int ID_Game) throws Exception {
        if (ID_Game < 0) {
            throw new PostException("Error ID Game cannot smaller than 0");
        } else {
            this.ID_Game = ID_Game;
        }

    }

    //create getter Content_Post
    public String getContent_Post() {
        return Content_Post;
    }

    //create setter Content_Post
    public void setContent_Post(String Content_Post) throws Exception {
        if (Content_Post.trim().equals("")) {
            throw new CommentException("Error content post cannot null");
        } else {
            this.Content_Post = Content_Post;
        }

    }

    //create getter Title_Post
    public String getTitle_Post() {
        return Title_Post;
    }

    //create setter Title_Post
    public void setTitle_Post(String Title_Post) throws Exception {
        if (Title_Post.trim().equals("")) {
            throw new CommentException("Error Title post cannot null");
        } else {
            this.Title_Post = Title_Post;
        }

    }

    //create getter Image_Post
    public String getImage_Post() {
        return Image_Post;
    }

    //create setter Image_Post
    public void setImage_Post(String Image_Post) throws Exception {
        if (Image_Post.trim().equals("")) {
            throw new CommentException("Error Image post cannot null");
        } else {
            this.Image_Post = Image_Post;
        }

    }

    //create getter Video_Post
    public String getVideo_Post() {
        return Video_Post;
    }

    //create setter Video_Post
    public void setVideo_Post(String Video_Post) throws Exception {
        if (Video_Post.trim().equals("")) {
            throw new CommentException("Error Video post cannot null");
        } else {
            this.Video_Post = Video_Post;
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
