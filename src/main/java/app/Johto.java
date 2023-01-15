package app;

import models.AttackMoves;
import models.EffectMoves;
import models.Pokemon;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Johto implements Readable {
    private List<String[]> listOfArraysAfterFileRead = new ArrayList<>();
    private List<Pokemon> listOfPokemon = new ArrayList<>();

    public Johto(String chosenPokemon){
        readFile(chosenPokemon);
        createPokemonAndMoves();
    }

    @Override
    public void readFile(String chosenPokemon) {
        if(chosenPokemon.equals("Chikorita")) {
            try(Scanner scanner = new Scanner(new File("files/JohtoGrass.txt"))){
                while(scanner.hasNextLine()) {
                    String eachLine = scanner.nextLine();
                    String[] splitEachLine = eachLine.split(",");
                    listOfArraysAfterFileRead.add(splitEachLine);
                }
            } catch (FileNotFoundException e) {
                System.out.println("File not found");
            }
        } else if(chosenPokemon.equals("Cyndaquil")) {
            try(Scanner scanner = new Scanner(new File("files/JohtoFire.txt"))){
                while(scanner.hasNextLine()) {
                    String eachLine = scanner.nextLine();
                    String[] splitEachLine = eachLine.split(",");
                    listOfArraysAfterFileRead.add(splitEachLine);
                }
            }catch (FileNotFoundException e) {
                System.out.println("File not found");
            }
        } else if(chosenPokemon.equals("Totodile")) {
            try(Scanner scanner = new Scanner(new File("files/JohtoWater.txt"))){
                while(scanner.hasNextLine()) {
                    String eachLine = scanner.nextLine();
                    String[] splitEachLine = eachLine.split(",");
                    listOfArraysAfterFileRead.add(splitEachLine);
                }
            } catch (FileNotFoundException e) {
                System.out.println("File not found");
            }
        }
    }

    public void createPokemonAndMoves(){
            for(String[] item: listOfArraysAfterFileRead) {
                EffectMoves effectMove = new EffectMoves(item[7], item[8], Integer.parseInt(item[9]), Integer.parseInt(item[10]));
                AttackMoves attackMove1 = new AttackMoves(item[11], item[12], Integer.parseInt(item[13]), Integer.parseInt(item[14]));
                AttackMoves attackMove2 = new AttackMoves(item[15], item[16], Integer.parseInt(item[17]), Integer.parseInt(item[18]));
                Pokemon newPokemon = new Pokemon(item[0], item[1], Integer.parseInt(item[2]), Integer.parseInt(item[3]), Double.parseDouble(item[4]), Double.parseDouble(item[5]), Double.parseDouble(item[6]), effectMove, attackMove1, attackMove2);
                listOfPokemon.add(newPokemon);
            }
    }


    public List<Pokemon> getListOfPokemon() {
        return listOfPokemon;
    }

}
