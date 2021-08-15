package ObjecInfo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class Type_Account {
    //declare variable
    private int ID_TypeAccount;
    private String Name_Type;
    private int Status;

    /**
     * type account constructor
     */
    public Type_Account() {
    }

    /**
     * constructor type account
     * @param ID_TypeAccount
     * @param Name_Type
     * @param Status 
     */
    public Type_Account(int ID_TypeAccount, String Name_Type, int Status) {
        this.ID_TypeAccount = ID_TypeAccount;
        this.Name_Type = Name_Type;
        this.Status = Status;
    }

    //getter ID_TypeAccount
    public int getID_TypeAccount() {
        return ID_TypeAccount;
    }

    //setter ID_TypeAccount
    public void setID_TypeAccount(int ID_TypeAccount) throws Exception {
        if (ID_TypeAccount < 0) {
            throw new PostException("Error ID TypeAccount cannot smaller than 0");
        } else {
             this.ID_TypeAccount = ID_TypeAccount;
        }
       
    }

    //getter Name_Type
    public String getName_Type() {
        return Name_Type;
    }

    //setter Name_Type
    public void setName_Type(String Name_Type) throws Exception{
        if (Name_Type.trim().equals("")) {
            throw new CommentException("Error content post cannot null");
        } else {
            this.Name_Type = Name_Type;
        }
    }

    //getter Status
    public int getStatus() {
        return Status;
    }

    //setter Status
    public void setStatus(int Status) {
        this.Status = Status;
    }   
}
