package se.ju23.typespeeder.account;

import se.ju23.typespeeder.data.entities.Player;
import se.ju23.typespeeder.data.repositories.PlayerRepository;
import se.ju23.typespeeder.io.IO;
import se.ju23.typespeeder.io.MenuService;

import java.util.List;

public class AccountManager{
    private PlayerRepository playerRepo;
    private IO io;
    private MenuService menu;
    private Player currentPlayer;

    public AccountManager(PlayerRepository playerRepo,
                          IO io,
                          MenuService menu){
        this.playerRepo = playerRepo;
        this.io = io;
        this.menu = menu;
    }

    public LoginStatus login(){

        io.println(menu.getLanguage().enterUsernamePrompt());
        String username = io.input();
        if(username.equals("0")){
            return new LoginStatus();
        }
        io.println(menu.getLanguage().enterPasswordPrompt());
        String password = io.input();
        if(password.equals("0")){
            return new LoginStatus();
        }
        currentPlayer = playerRepo.findByUsernameAndPassword(username,password);

        if(currentPlayer == null){
            io.println(menu.getLanguage().loginErrorPrompt());
            return new LoginStatus();
        }else if(currentPlayer.getUsername().equalsIgnoreCase(username) && currentPlayer.getPassword().equals(password)){
            boolean loginStatus = true;
            return new LoginStatus(currentPlayer,loginStatus);
        }else{
            currentPlayer = null;
            io.println(menu.getLanguage().loginErrorPrompt());
            return new LoginStatus();
        }

    }

    public LoginStatus createAccount(){
        String username = getUsernameInput();
        if(username.equals("0")){
            return new LoginStatus();
        }
        String password = getPasswordInput();
        if(password.equals("0")){
            return new LoginStatus();
        }
        String alias = getAliasInput();
        if(alias.equals("0")){
            return new LoginStatus();
        }

        currentPlayer = new Player(username,password,alias);
        playerRepo.save(currentPlayer);
        currentPlayer = playerRepo.findByUsernameAndPassword(username,password);
        boolean loginStatus = true;


        return new LoginStatus(currentPlayer,loginStatus);
    }



    private String getUsernameInput(){
        boolean validName;
        String username;
        do{
            io.println(menu.getLanguage().updateUsernamePrompt());
            username = io.input();

            if(username.equals("0")){
                return "0";
            }

            validName = validateUsername(username);
        }while(!validName);

        return username;
    }

    private boolean validateUsername(String username){
        List<Player> playerList = playerRepo.findAll();

        for(Player p : playerList){
            if(p.getUsername().equalsIgnoreCase(username)){
                io.println(menu.getLanguage().uNameTakenPrompt());
                return false;
            }
        }

        if(!username.matches("^[a-zA-Z0-9]{4,15}$")){
            io.println(menu.getLanguage().invalidUsernamePrompt());
            return false;
        }
        return true;
    }

    private String getPasswordInput(){
        boolean validPassword;
        String password;
        do{
            io.println(menu.getLanguage().updatePasswordPrompt());
            password = io.input();

            if(password.equals("0")){
                return "0";
            }

            validPassword = validatePassword(password);
        }while(!validPassword);

        return password;
    }

    private boolean validatePassword(String password){
        if(!password.matches("^[a-zA-Z0-9-_!@#$%^&*()+={}]{4,20}$")){
            io.println(menu.getLanguage().invalidPasswordPrompt());
            return false;
        }
        return true;
    }

    public String getAliasInput(){
        boolean validAlias;
        String alias;
        do{
            io.println(menu.getLanguage().updateAliasPrompt());
            alias = io.input();

            if(alias.equals("0")){
                return "0";
            }

            validAlias = validateAlias(alias);
        }while(!validAlias);

        return alias;
    }

    private boolean validateAlias(String alias){
        if(!alias.matches("^[a-zA-Z0-9-_!@#$%^&*()+={}]{1,15}$")){
            io.println(menu.getLanguage().invalidAliasPrompt());
            return false;
        }
        return true;
    }

}
