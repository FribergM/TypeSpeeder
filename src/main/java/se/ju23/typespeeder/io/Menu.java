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
    public void displayGameModes(){
        io.println(language.getGameModeOptions());
    }

    @Override
    public void displayDifficulties(){
        io.println(language.getDifficultyOptions());
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
        io.println("Välj språk (svenska/engelska):\nSelect language (swedish/english):");
        String langChoice = io.input();
        langChoice = langChoice.toLowerCase();


        switch(langChoice){
            case "swedish","svenska" -> {
                this.language = new Swedish();
                io.println(language.languageSelectedPrompt());
            }
            case "english","engelska" -> {
                this.language = new English();
                io.println(language.languageSelectedPrompt());
            }
            default -> {
                io.println("Invalid input. Default language provided.");
                this.language = new English();
            }
        }

    }

    @Override
    public void changeLanguage(){
        boolean continueLoop = true;

        do{
            String languagePrompt = language.changeLanguagePrompt();
            io.println(languagePrompt);

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
                default -> io.println(language.menuErrorPrompt());
            }

            io.println(language.languageSelectedPrompt());

        }while(continueLoop);
    }

    public Language getLanguage(){
        return language;
    }
}
