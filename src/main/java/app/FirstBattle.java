package app;

import models.Pokemon;
import userInterface.OutputForPlayer;
import userInterface.PlayerInput;

import java.util.List;
import java.util.Random;

public class FirstBattle {
    private PlayerInput inputObj = new PlayerInput();
    private OutputForPlayer outputObj = new OutputForPlayer();
    private List<Pokemon> pokemonList;


    public void start() {
        outputObj.welcomingScreen();
        while(true) {
            outputObj.startingScreen();
            String decision = inputObj.decideRegion();
            if(decision.equals("Kanto") || decision.equals("Johto")) {
                String playerName = "";
                outputObj.welcomeToRegion(decision);
                while(playerName.equals("")) {
                    outputObj.askForName(decision);
                    playerName = inputObj.playersName();
                    if (playerName.equals("")) {
                        outputObj.errorNameMessage(decision);
                    }
                }
                String opponentName = "";
                while(opponentName.equals("")) {
                    outputObj.askForOpponentName(playerName, decision);
                    opponentName = inputObj.opponentsName();
                    if (opponentName.equals("")) {
                        outputObj.errorNameMessage(decision);
                    }
                }
                outputObj.askToChooseStarter(decision);
                String chosenPokemon = inputObj.chosenPokemon(decision);
                while(chosenPokemon.equals("")) {
                    outputObj.tryAgainChoosingPokemon();
                    outputObj.askToChooseStarter(decision);
                    chosenPokemon = inputObj.chosenPokemon(decision);
                }
                if(decision.equals("Kanto")) {
                    Kanto kanto = new Kanto(chosenPokemon);
                    pokemonList = kanto.getListOfPokemon();
                } else {
                    Johto johto = new Johto(chosenPokemon);
                    pokemonList = johto.getListOfPokemon();
                }
                Pokemon userPokemon = pokemonList.get(0);
                Pokemon enemyPokemon = pokemonList.get(1);
                int initialUserPokemonHP = userPokemon.getHP();
                int initialEnemyPokemonHP = enemyPokemon.getHP();

                outputObj.afterChoosing(opponentName, userPokemon, enemyPokemon);
                inputObj.continueButton();

                outputObj.startBattle(opponentName);
                inputObj.continueButton();

                outputObj.startBattle2(opponentName, userPokemon, enemyPokemon);
                inputObj.continueButton();

                while(userPokemon.getHP() > 0 && enemyPokemon.getHP() > 0) {
                    outputObj.announceBeginningOfRoundHP(userPokemon, enemyPokemon, initialUserPokemonHP, initialEnemyPokemonHP);
                    inputObj.continueButton();

                    if (userPokemon.getSpeed() >= enemyPokemon.getSpeed()) {
                        outputObj.chooseAMove(userPokemon);
                        String userMove = inputObj.moveChoice();
                        System.out.println("");
                        outputObj.userMove(userMove, userPokemon, enemyPokemon);
                        inputObj.continueButton();
                        if(enemyPokemon.getHP() > 0) {
                            outputObj.announceBeginningOfRoundHP(userPokemon, enemyPokemon, initialUserPokemonHP, initialEnemyPokemonHP);
                            inputObj.continueButton();
                            System.out.println("It's " + opponentName + "'s turn.");
                            inputObj.continueButton();
                            int randomNumber = new Random().nextInt(3) + 1;
                            outputObj.opponentMove(randomNumber, userPokemon, enemyPokemon);
                            inputObj.continueButton();
                        } else {
                            outputObj.announceFaintedEnemyHP(userPokemon, enemyPokemon);
                            inputObj.continueButton();
                            outputObj.faintedMessage(enemyPokemon);
                            continue;
                        }
                        if(userPokemon.getHP() <= 0) {
                            outputObj.announceFaintedUserHP(userPokemon, enemyPokemon);
                            inputObj.continueButton();
                            outputObj.faintedMessage(userPokemon);
                        }
                    } else {
                        System.out.println("It's " + opponentName + "'s turn.");
                        int randomNumber = new Random().nextInt(3) + 1;
                        inputObj.continueButton();
                        outputObj.opponentMove(randomNumber, userPokemon, enemyPokemon);
                        inputObj.continueButton();
                        if (userPokemon.getHP() > 0 ) {
                            outputObj.announceBeginningOfRoundHP(userPokemon, enemyPokemon, initialUserPokemonHP, initialEnemyPokemonHP);
                            inputObj.continueButton();
                            outputObj.chooseAMove(userPokemon);
                            String userMove = inputObj.moveChoice();
                            System.out.println("");
                            outputObj.userMove(userMove, userPokemon, enemyPokemon);
                            inputObj.continueButton();
                        } else {
                            outputObj.announceFaintedUserHP(userPokemon, enemyPokemon);
                            inputObj.continueButton();
                            outputObj.faintedMessage(userPokemon);
                            continue;
                        }
                        if(enemyPokemon.getHP() <= 0) {
                            outputObj.announceFaintedEnemyHP(userPokemon, enemyPokemon);
                            inputObj.continueButton();
                            outputObj.faintedMessage(enemyPokemon);
                        }
                    }
                }
                outputObj.battleOver(opponentName, userPokemon, enemyPokemon);
                break;
            } else if(decision.equals("Nevermind")) {
                break;
            }
        }
        inputObj.continueButton();
        outputObj.endingScreen();
    }

}
