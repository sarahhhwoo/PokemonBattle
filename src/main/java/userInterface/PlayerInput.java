package userInterface;

import java.util.Scanner;

public class PlayerInput {
    Scanner inputScanner = new Scanner(System.in);

    public String decideRegion() {
        String decision = inputScanner.nextLine();
        if(decision.equalsIgnoreCase("k")){
            return "Kanto";
        } else if (decision.equalsIgnoreCase("j")){
            return "Johto";
        } else if (decision.equalsIgnoreCase("n")){
            return "Nevermind";
        } else {
            System.out.println("\n*** Please input the correct letter indicated in parentheses ***");
            return "";
        }
    }

    public String playersName() {
        String name = inputScanner.nextLine();
        return name;
    }

    public String opponentsName() {
        String name = inputScanner.nextLine();
        return name;
    }

    public String chosenPokemon(String decision) {
        String pokemon = inputScanner.nextLine();
        String fullNamePokemon = "";
        if(decision.equals("Kanto")) {
            if(pokemon.equalsIgnoreCase("g")) {
                fullNamePokemon = "Bulbasaur";
            } else if(pokemon.equalsIgnoreCase("f")){
                fullNamePokemon = "Charmander";
            } else if(pokemon.equalsIgnoreCase("w")){
                fullNamePokemon = "Squirtle";
            }
        } else if(decision.equals("Johto")) {
            if(pokemon.equalsIgnoreCase("g")) {
                fullNamePokemon = "Chikorita";
            } else if(pokemon.equalsIgnoreCase("f")){
                fullNamePokemon = "Cyndaquil";
            } else if(pokemon.equalsIgnoreCase("w")){
                fullNamePokemon = "Totodile";
            }
        } else {
            fullNamePokemon = "";
        }
        return fullNamePokemon;
    }

    public String continueButton() {
       return inputScanner.nextLine();
    }

    public String moveChoice() {
        String choice = inputScanner.nextLine();
        if(choice.equals("1") || choice.equals("2") || choice.equals("3")) {
            return choice;
        } else {
            System.out.println("You didn't choose the right move! Sorry you lost your turn.");
            return "";
        }
    }

}
