package se.ju23.typespeeder.account;

import se.ju23.typespeeder.data.entities.Player;

public class LoginStatus{
    private Player currentPlayer;
    private boolean loginStatus;

    public LoginStatus(Player currentPlayer, boolean loginStatus){
        this.currentPlayer = currentPlayer;
        this.loginStatus = loginStatus;
    }
    public LoginStatus(){

    }

    public Player getCurrentPlayer(){
        return currentPlayer;
    }

    public boolean getLoginStatus(){
        return loginStatus;
    }
}
