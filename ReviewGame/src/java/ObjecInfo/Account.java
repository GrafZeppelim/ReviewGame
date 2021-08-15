package ObjecInfo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


public class Account {
    private int ID_Account;
    private int ID_TypeAccount;
    private String UserName;
    private String Password;
    private int Gender;
    private String Email;
    private String FullName;
    private String PhoneNumber;
    private int Status;

    /**
     * Create account 
     * @param ID_Account
     * @param ID_TypeAccount
     * @param UserName
     * @param Password
     * @param Gender
     * @param Email
     * @param FullName
     * @param PhoneNumber
     * @param Status 
     */
    public Account(int ID_Account, int ID_TypeAccount, String UserName, String Password, int Gender, String Email, String FullName, String PhoneNumber, int Status) {
        this.ID_Account = ID_Account;
        this.ID_TypeAccount = ID_TypeAccount;
        this.UserName = UserName;
        this.Password = Password;
        this.Gender = Gender;
        this.Email = Email;
        this.FullName = FullName;
        this.PhoneNumber = PhoneNumber;
        this.Status = Status;
    }

    /**
     * Get Id account
     * @return 
     */
    public int getID_Account() {
        return ID_Account;
    }

    /**
     * Set Id account
     * @param ID_Account
     * @throws Exception 
     */
    public void setID_Account(int ID_Account)throws AccountException {
        if (ID_Account<0) {
            throw new AccountException("Id must greater than 0");
        }else{
            this.ID_Account = ID_Account;
        }
    }

    /**
     * Get Id type account
     * @return 
     */
    public int getID_TypeAccount() {
        return ID_TypeAccount;
    }

    /**
     * Set Id type account
     * @param ID_TypeAccount 
     */
    public void setID_TypeAccount(int ID_TypeAccount) throws AccountException {
        if (ID_TypeAccount<=0) {
            throw new AccountException("Id type account must greater than 0");
        }else{
            this.ID_TypeAccount = ID_TypeAccount;
        }
    }

    /**
     * Get username
     * @return 
     */
    public String getUserName() {
        return UserName;
    }

    /**
     * Set username
     * @param UserName 
     */
    public void setUserName(String UserName)throws AccountException {
        if (UserName.equals("")) {
            throw new AccountException("user name can't be empty");
        }else{
            this.UserName = UserName;
        }
    }

    /**
     * Get password
     * @return 
     */
    public String getPassword() {
        return Password;
    }

    /**
     * Set password
     * @param Password
     * @throws AccountException 
     */
    public void setPassword(String Password)throws AccountException {
        if (Password.equals("")) {
            throw new AccountException("Password can't be empty");
        }else{
            this.Password = Password;
        }
    }

    /**
     * Get gender
     * @return 
     */
    public int getGender() {
        return Gender;
    }

    /**
     * Set gender
     * @param Gender
     * @throws AccountException 
     */
    public void setGender(int Gender)throws AccountException {
        if (Gender<0) {
            throw new AccountException("Gender must greater than 0");
        }else{
            this.Gender = Gender;
        }
    }

    /**
     * Get email
     * @return 
     */
    public String getEmail() {
        return Email;
    }

    /**
     * Set email
     * @param Email
     * @throws AccountException 
     */
    public void setEmail(String Email )throws AccountException {
        if (Email.equals("")) {
            throw new AccountException("Email can't be empty");
        }else{
            this.Email = Email;
        }
    }

    /**
     * Get full name
     * @return 
     */
    public String getFullName() {
        return FullName;
    }

    /**
     * Set full name
     * @param FullName
     * @throws AccountException 
     */
    public void setFullName(String FullName)throws AccountException {
        if (FullName.equals("")) {
            throw new AccountException("Full name can't be empty");
        }else{
            this.FullName = FullName;
        }
    }

    /**
     * Get phone number
     * @return 
     */
    public String getPhoneNumber() {
        return PhoneNumber;
    }

    /**
     * Set phone number
     * @param PhoneNumber
     * @throws AccountException 
     */
    public void setPhoneNumber(String PhoneNumber)throws AccountException {
        if (PhoneNumber.equals("")) {
            throw new AccountException("Phone number can't be empty");
        }else{
            this.PhoneNumber = PhoneNumber;
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
    public void setStatus(int Status){
        this.Status = Status;
    }
    
    
}
