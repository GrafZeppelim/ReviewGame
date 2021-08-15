package ObjecInfo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class Category {
    private int ID_Category;
    private String Name_Category;
    private int Status;

    /**
     * Create category
     * @param ID_Category
     * @param Name_Category
     * @param Status 
     */
    public Category(int ID_Category, String Name_Category, int Status) {
        this.ID_Category = ID_Category;
        this.Name_Category = Name_Category;
        this.Status = Status;
    }

    /**
     * Get Id Category
     * @return 
     */
    public int getID_Category() {
        return ID_Category;
    }

    /**
     * Set Id category
     * @param ID_Category
     * @throws CategoryException 
     */
    public void setID_Category(int ID_Category)throws CategoryException {
        if (ID_Category<0) {
            throw new CategoryException("Id category must greater than 0");
        }else{
            this.ID_Category = ID_Category;
        }
    }

    /**
     * Get name category
     * @return 
     */
    public String getName_Category() {
        return Name_Category;
    }

    /**
     * Set name category
     * @param Name_Category
     * @throws CategoryException 
     */
    public void setName_Category(String Name_Category) throws CategoryException {
        if (Name_Category.equals("")) {
            throw new CategoryException("Category name can't be empty");
        }else{
            this.Name_Category = Name_Category;
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
