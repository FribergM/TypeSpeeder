package se.ju23.typespeeder.io;

import java.util.List;

public class Menu implements MenuService{

    private Language language;
    private IO io;

    public Menu(){
        this.io = new SystemIO();
    }

    @Override
    public void displayMenu(){
        if(language == null){
            chooseLanguage();
        }
        io.outputAll(getMenuOptions());
    }

    @Override
    public void displayGameMenu(){
        io.outputAll(getGameMenuOptions());
    }

    @Override
    public List<String> getMenuOptions(){
        if(language == null){
            language = new English();
        }
        return language.getMenuOptions();
    }

    @Override
    public List<String> getGameMenuOptions(){
        if(language == null){
            language = new English();
        }
        return language.getGameMenuOptions();
    }

    @Override
    public void chooseLanguage(){
        io.output("Välj språk (svenska/engelska):\nSelect language (swedish/english):");
        String langChoice = io.input();
        langChoice = langChoice.toLowerCase();


        switch(langChoice){
            case "swedish","svenska" -> {
                this.language = new Swedish();
                io.output(language.languageSelectedPrompt());
            }
            case "english","engelska" -> {
                this.language = new English();
                io.output(language.languageSelectedPrompt());
            }
            default -> {
                io.output("Invalid input. Default language provided.");
                this.language = new English();
            }
        }

    }

    @Override
    public void changeLanguage(){
        boolean continueLoop = true;

        do{
            String languagePrompt = changeLanguagePrompt();
            io.output(languagePrompt);

            String choice = io.input();

            switch(choice){
                case "1" -> {
                    if(languagePrompt.contains("Swedish")){
                        language = new Swedish();
                    }else{
                        language = new English();
                    }
                    continueLoop = false;
                }
                case "2" -> continueLoop = false;
                default -> io.output(menuErrorPrompt());
            }

            io.output(language.languageSelectedPrompt());

        }while(continueLoop);
    }

    @Override
    public String changeLanguagePrompt(){
        return language.changeLanguagePrompt();
    }

    @Override
    public String enterUsernamePrompt(){
        return language.enterUsernamePrompt();
    }

    @Override
    public String updateUsernamePrompt(){
        return language.updateUsernamePrompt();
    }

    @Override
    public String enterPasswordPrompt(){
        return language.enterPasswordPrompt();
    }

    @Override
    public String updatePasswordPrompt(){
        return language.updatePasswordPrompt();
    }

    @Override
    public String updateAliasPrompt(){
        return language.updateAliasPrompt();
    }

    @Override
    public String menuErrorPrompt(){
        return language.menuErrorPrompt();
    }

    @Override
    public String loginErrorPrompt(){
        return language.loginErrorPrompt();
    }

    @Override
    public String uNameTakenPrompt(){
        return language.uNameTakenPrompt();
    }

    @Override
    public String invalidUsernamePrompt(){
        return language.invalidUsernamePrompt();
    }

    @Override
    public String invalidPasswordPrompt(){
        return language.invalidPasswordPrompt();
    }

    @Override
    public String invalidAliasPrompt(){
        return language.invalidAliasPrompt();
    }
}
