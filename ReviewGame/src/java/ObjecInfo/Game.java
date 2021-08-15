package ObjecInfo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class Game {
    private int ID_Game;
    private int ID_Category;
    private String Name_Game;
    private String Image_Game;
    private String Video_Game;
    private String Description;
    private int CountRate;
    private int TotalRatePoint;
    private int Status;

    /**
     * Create game
     * @param ID_Game
     * @param ID_Category
     * @param Name_Game
     * @param Image_Game
     * @param Video_Game
     * @param Description
     * @param CountRate
     * @param TotalRatePoint
     * @param Status 
     */
    public Game(int ID_Game, int ID_Category, String Name_Game, String Image_Game, String Video_Game, String Description, int CountRate, int TotalRatePoint, int Status) {
        this.ID_Game = ID_Game;
        this.ID_Category = ID_Category;
        this.Name_Game = Name_Game;
        this.Image_Game = Image_Game;
        this.Video_Game = Video_Game;
        this.Description = Description;
        this.CountRate = CountRate;
        this.TotalRatePoint = TotalRatePoint;
        this.Status = Status;
    }

    /**
     * Get ID game
     * @return 
     */
    public int getID_Game() {
        return ID_Game;
    }

    /**
     * Set Id Game
     * @param ID_Game 
     */
    public void setID_Game(int ID_Game)throws GameException {
        if (ID_Game<0) {
            throw new GameException("Id game must greater than 0");
        }else{
            this.ID_Game = ID_Game;
        }
    }

    /**
     * Get ID category
     * @return 
     */
    public int getID_Category() {
        return ID_Category;
    }

    /**
     * Set ID category
     * @param ID_Category 
     */
    public void setID_Category(int ID_Category)throws GameException {
        if (ID_Category<0) {
            throw new GameException("Id category must greater than 0");
        }else{
            this.ID_Category = ID_Category;
        }
    }

    /**
     * Get name of game
     * @return 
     */
    public String getName_Game() {
        return Name_Game;
    }

    /**
     * Set name of game
     * @param Name_Game 
     */
    public void setName_Game(String Name_Game) throws GameException{
        if (Name_Game.equals("")) {
            throw new GameException("Name of game can't be empty");
        }else{
            this.Name_Game = Name_Game;
        }
    }

    /**
     * Get image of game
     * @return 
     */
    public String getImage_Game() {
        return Image_Game;
    }

    /**
     * Set image of game
     * @param Image_Game
     * @throws GameException 
     */
    public void setImage_Game(String Image_Game)throws GameException {
        if (Image_Game.equals("")) {
            throw new GameException("Image of game can't be empty");
        }else{
            this.Image_Game = Image_Game;
        }
    }

    /**
     * Get video of game
     * @return 
     */
    public String getVideo_Game() {
        return Video_Game;
    }

    /**
     * Set video of game
     * @param Video_Game
     * @throws GameException 
     */
    public void setVideo_Game(String Video_Game)throws GameException {
        if (Video_Game.equals("")) {
            throw new GameException("Video of game can't be empty");
        }else{
            this.Video_Game = Video_Game;
        }
    }

    /**
     * Get description
     * @return 
     */
    public String getDescription() {
        return Description;
    }

    /**
     * Set description
     * @param Description
     * @throws GameException 
     */
    public void setDescription(String Description)throws GameException {
        if (Description.equals("")) {
            throw new GameException("Description of game can't be empty");
        }else{
            this.Description = Description;
        }
    }

    /**
     * Get count rate
     * @return 
     */
    public int getCountRate() {
        return CountRate;
    }

    /**
     * Set count rate
     * @param CountRate
     * @throws GameException 
     */
    public void setCountRate(int CountRate)throws GameException {
        if (CountRate<0) {
            throw new GameException("CountRate must greater than 0");
        }else{
            this.CountRate = CountRate;
        }
    }

    /**
     * Get total rate point
     * @return 
     */
    public int getTotalRatePoint() {
        return TotalRatePoint;
    }

    /**
     * Set total rate point
     * @param TotalRatePoint
     * @throws GameException 
     */
    public void setTotalRatePoint(int TotalRatePoint)throws GameException {
        if (TotalRatePoint<0) {
            throw new GameException("TotalRatePoint must greater than 0");
        }else{
            this.TotalRatePoint = TotalRatePoint;
        }
    }

    /**
     * Get status
     * @return 
     */
    public int getStatus() {
        return Status;
    }

    /**
     * Set status
     * @param Status 
     */
    public void setStatus(int Status) {
        this.Status = Status;
    }
    
    
}
