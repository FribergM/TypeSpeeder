package se.ju23.typespeeder.account;

import se.ju23.typespeeder.data.Player;
import se.ju23.typespeeder.data.PlayerRepository;
import se.ju23.typespeeder.io.IO;
import se.ju23.typespeeder.io.MenuService;

import java.util.List;

public class AccountManager{
    private PlayerRepository playerRepo;
    private IO io;
    private MenuService menu;
    private Player currentPlayer;

    public AccountManager(PlayerRepository playerRepo,IO io,MenuService menu,Player currentPlayer){
        this.playerRepo = playerRepo;
        this.io = io;
        this.menu = menu;
        this.currentPlayer = currentPlayer;
    }

    public void setMenu(MenuService menu){
        this.menu = menu;
    }

    public boolean login(){
        io.output(menu.enterUsernamePrompt());
        String username = io.input();
        if(username.equals("0")){
            return false;
        }
        io.output(menu.enterPasswordPrompt());
        String password = io.input();
        if(password.equals("0")){
            return false;
        }

        currentPlayer = playerRepo.findByUsernameAndPassword(username,password);

        if(currentPlayer == null){
            io.output(menu.loginErrorPrompt());
            return false;
        }else{
            return true;
        }

    }

    public boolean createAccount(){
        String username = getUsernameInput();
        if(username.equals("0")){
            return false;
        }
        String password = getPasswordInput();
        if(password.equals("0")){
            return false;
        }
        String alias = getAliasInput();
        if(alias.equals("0")){
            return false;
        }

        currentPlayer = new Player(username,password,alias);
        playerRepo.save(currentPlayer);

        return true;
    }



    private String getUsernameInput(){
        boolean validName;
        String username;
        do{
            io.output(menu.updateUsernamePrompt());
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
                io.output(menu.uNameTakenPrompt());
                return false;
            }
        }

        if(!username.matches("^[a-zA-Z]{4,15}$")){
            io.output(menu.invalidUsernamePrompt());
            return false;
        }
        return true;
    }

    private String getPasswordInput(){
        boolean validPassword;
        String password;
        do{
            io.output(menu.updatePasswordPrompt());
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
            io.output(menu.invalidPasswordPrompt());
            return false;
        }
        return true;
    }

    public String getAliasInput(){
        boolean validAlias;
        String alias;
        do{
            io.output(menu.updateAliasPrompt());
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
            io.output(menu.invalidAliasPrompt());
            return false;
        }
        return true;
    }

}
