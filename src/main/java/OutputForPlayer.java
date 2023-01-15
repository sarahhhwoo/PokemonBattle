public class OutputForPlayer {

    public void welcomingScreen() {
        System.out.println("");
        System.out.println("********************************************************");
        System.out.println("     Welcome to the Pokemon First Battle Simulator");
        System.out.println("********************************************************");
    }

    public void startingScreen() {
        System.out.println();
        System.out.println("Which region would you like to play?");
        System.out.print("(K)anto, (J)ohto, or (N)evermind to EXIT: ");
    }

    public void welcomeToRegion(String decision) {
        if(decision.equals("Kanto")) {
            System.out.println("\nProfessor Oak: \"Welcome to the Kanto region!\"");
        }
        if(decision.equals("Johto")) {
            System.out.println("\nProfessor Elm: \"Welcome to the Johto region!\"");
        }
    }

    public void askForName(String decision) {
        if(decision.equals("Kanto")) {
            System.out.print("Professor Oak: \"What is your name?\": ");
        }
        if(decision.equals("Johto")) {
            System.out.print("Professor Elm: \"What is your name?\": ");
        }
    }

    public void errorNameMessage(String decision) {
        if(decision.equals("Kanto")) {
            System.out.print("\nProfessor Oak: \"A name cannot be nothing!\"\n");
        }
        if(decision.equals("Johto")) {
            System.out.print("\nProfessor Elm: \"A name cannot be nothing!\"\n");
        }
    }

    public void askForOpponentName(String playerName, String decision) {
        if(decision.equals("Kanto")) {
            System.out.print("Professor Oak: \"Okay, " + playerName + ". What is your opponent's name?\": ");
        }
        if(decision.equals("Johto")) {
            System.out.println("Professor Elm: \"Okay, " + playerName + ". What is your opponent's name?\": ");
        }
    }

    public void askToChooseStarter(String decision) {
        if(decision.equals("Kanto")) {
            System.out.println("\nProfessor Oak: \"Please choose your first pokemon.\"");
            System.out.println("Bulbasaur - (g)rass pokemon");
            System.out.println("Charmander - (f)ire pokemon");
            System.out.println("Squirtle - (w)ater pokemon");
            System.out.println("\nProfessor Oak: \"Which pokemon would you like to start your adventure with?\": ");
        }
        if(decision.equals("Johto")) {
            System.out.println("\nProfessor Elm: \"Please choose your starting pokemon.\"");
            System.out.println("Chikorita - (g)rass pokemon");
            System.out.println("Cyndaquil - (f)ire pokemon");
            System.out.println("Totodile - (w)ater pokemon: ");
            System.out.print("\nProfessor Elm: \"Which pokemon would you like to start your adventure with?\": ");
        }
    }

    public void tryAgainChoosingPokemon() {
        System.out.println(" ");
        System.out.println("Please input one of the following letters: g, f, or w");
    }

    public void afterChoosing(String opponentName, Pokemon playerPokemon, Pokemon opponentPokemon) {
        System.out.println("\nYou chose " + playerPokemon.getName() + ", and your friend, " + opponentName + ", chose " + opponentPokemon.getName());
        System.out.println();
        System.out.println(opponentName + ": \"Your pokemon is weak! Let's battle and I'll show you why!!\"");
        System.out.print("Press \"enter\" to continue throughout the battle.");
    }

    public void startBattle(String opponentName) {
        System.out.println("\n************************************");
        System.out.println(opponentName + " challenged you to a battle!");
        System.out.println("************************************");
    }

    public void startBattle2 (String opponentName, Pokemon playerPokemon, Pokemon opponentPokemon) {
        System.out.println(opponentName + " sent out " + opponentPokemon.getName());
        System.out.println("You: \"Go " + playerPokemon.getName() +"!!!\"");
    }

    public void announceBeginningOfRoundHP(Pokemon playerPokemon, Pokemon opponentPokemon, int playerInitialHP, int opponentInitialHP) {
        String HPBar = "";
        for(int i = 0; i < (opponentPokemon.getHP() * 30.0 / opponentInitialHP); i++) {
            HPBar += "*";
        }
        System.out.println(String.format("%35s", "") + String.format("%-24s", opponentPokemon.getName() + ":") + String.format( "%-7s", "lvl " + opponentPokemon.getLevel()) );
        System.out.println(String.format("%35s", "") + String.format("%-30s", HPBar) + "|");
        //System.out.println(String.format("%35s", "") + String.format("%35s", opponentPokemon.getHP() + "/" + opponentInitialHP + "HP" ));
        HPBar = "";
        for(int i = 0; i < (playerPokemon.getHP() * 30.0 / playerInitialHP); i++) {
            HPBar += "*";
        }
        System.out.println("");
        System.out.println(String.format("%-24s", playerPokemon.getName() + ":") + String.format("%-7s", "lvl " + playerPokemon.getLevel()));
        System.out.println(String.format("%-30s", HPBar) + "|");
        System.out.println(String.format("%-70s", playerPokemon.getHP() + " / " + playerInitialHP + "HP" ));

    }

    public void chooseAMove(Pokemon playerPokemon) {
        System.out.println("It's your turn!");
        System.out.println("1) " + playerPokemon.getMove1().getName());
        System.out.println("2) " + playerPokemon.getMove2().getName());
        System.out.println("3) " + playerPokemon.getMove3().getName());
        System.out.print("Choose a move (input a number)!: ");
    }

    public void userMove(String userMove, Pokemon userPokemon, Pokemon enemyPokemon) {
        if(userMove.equals("1")) {
            userPokemon.getMove1().takeAction(userPokemon, enemyPokemon);
        } else if(userMove.equals("2")) {
            userPokemon.getMove2().takeAction(userPokemon, enemyPokemon);

        } else if(userMove.equals("3")) {
            userPokemon.getMove3().takeAction(userPokemon, enemyPokemon);
        }
    }

    public void opponentMove(int randomInt, Pokemon userPokemon, Pokemon enemyPokemon) {
        if (randomInt == 1) {
            enemyPokemon.getMove1().takeAction(enemyPokemon, userPokemon);
        } else if (randomInt == 2) {
            enemyPokemon.getMove2().takeAction(enemyPokemon, userPokemon);
        } else if (randomInt == 3) {
            enemyPokemon.getMove3().takeAction(enemyPokemon, userPokemon);
        }
    }


    public void announceFaintedEnemyHP(Pokemon playerPokemon, Pokemon opponentPokemon) {
        System.out.print(playerPokemon.getName() + " has " + playerPokemon.getHP() + "HP and " + opponentPokemon.getName() + " has 0HP");
    }

    public void announceFaintedUserHP(Pokemon playerPokemon, Pokemon opponentPokemon) {
        System.out.print(playerPokemon.getName() + " has 0HP and " + opponentPokemon.getName() + " has " + opponentPokemon.getHP() + "HP");
    }


    public void faintedMessage(Pokemon fainted) {
        System.out.println("\n************************************");
        System.out.println(fainted.getName() + " has fainted!");
    }

    public void battleOver(String opponentName, Pokemon userPokemon, Pokemon enemyPokemon) {
        System.out.println("The battle is over!");
        if (userPokemon.getHP() <= 0 ) {
            System.out.println("You lost! :( ");
            System.out.println("************************************");
            System.out.println("\n" + opponentName + ": \"HA! I told you that my pokemon was stronger!\"");
        } else if (enemyPokemon.getHP() <= 0 ) {
            System.out.println("You won! :)");
            System.out.println("************************************");
            System.out.println("\n" + opponentName + ": \"Pft... I was going easy on you... and you got lucky.\"");
        }
    }

    public void endingScreen() {
        System.out.println("********************************************************");
        System.out.println("                Thanks for playing!!!");
        System.out.println("********************************************************");

    }
}
