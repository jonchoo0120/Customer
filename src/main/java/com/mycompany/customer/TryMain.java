package com.mycompany.customer;
public class TryMain {
    private String username = "Matlus";
    private String userID = "Tp071085";
    private String contact = "018-1234567";
    
    public TryMain(){
        new CustomerMainMenu(username, userID, contact);
    }
    
    public static void main(String[] args) {
        // Create an instance of TryMain to invoke the constructor
        TryMain tryMain = new TryMain();
    }
}
