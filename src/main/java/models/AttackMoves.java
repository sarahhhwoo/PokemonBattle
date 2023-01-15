package models;

import models.Moves;
import models.Pokemon;

public class AttackMoves extends Moves {

    public AttackMoves(String name, String type, int strength, int chance){
        super(name, type, strength, chance);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String getType() {
        return super.getType();
    }

    @Override
    public int getStrength() {
        return super.getStrength();
    }

    @Override
    public int getChance() {
        return super.getChance();
    }

    @Override
    public void setChance(int chance) {
        super.setChance(chance);
    }

    @Override
    public void takeAction(Pokemon attackingPokemon, Pokemon defendingPokemon) {
        System.out.println(attackingPokemon.getName() + " used " + getName());
        double damageEquation = (((((((8 * defendingPokemon.getLevel()) / 4) + 3) * getStrength() * (attackingPokemon.getAttack() / defendingPokemon.getDefense())) / 40) + 2) * typeConversion(defendingPokemon)) + 3;
        int newHP = (int) (defendingPokemon.getHP() - damageEquation);
        defendingPokemon.setHP(newHP);
    }

    public double typeConversion(Pokemon defendingPokemon) {
        double typeNum = 1;
        if (super.getType().equals("Grass")) {
            if (defendingPokemon.getType().equals("Water")){
                typeNum = 2;
                System.out.println("It's super effective");
            } else if (defendingPokemon.getType().equals("Fire")) {
                typeNum = 0.5;
                System.out.println("It's not very effective");
            }
        } else if (super.getType().equals("Fire")) {
            if (defendingPokemon.getType().equals("Grass")){
                typeNum = 2;
                System.out.println("It's super effective");
            } else if (defendingPokemon.getType().equals("Water")) {
                typeNum = 0.5;
                System.out.println("It's not very effective");
            }
        } else if (super.getType().equals("Water")) {
            if (defendingPokemon.getType().equals("Fire")){
                typeNum = 2;
                System.out.println("It's super effective");
            } else if (defendingPokemon.getType().equals("Grass")) {
                typeNum = 0.5;
                System.out.println("It's not very effective");
            }
        }
        return typeNum;
    }
}
