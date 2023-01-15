package models;

import models.Moves;
import models.Pokemon;

public class EffectMoves extends Moves {

    public EffectMoves(String name, String type, int strength, int chance){
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
        if(getType().equals("LD")){
            defendingPokemon.setDefense(defendingPokemon.getDefense() * 0.6);
            System.out.println(attackingPokemon.getName() + " used " + getName());
            System.out.println(attackingPokemon.getName() + " lowered " + defendingPokemon.getName() + "'s defense!");
        } else {
            defendingPokemon.setAttack(defendingPokemon.getAttack() * 0.6);
            System.out.println(attackingPokemon.getName() + " used " + getName());
            System.out.println(attackingPokemon.getName() + " lowered " + defendingPokemon.getName() + "'s attack!");
        }
    }
}
