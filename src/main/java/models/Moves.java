package models;

public abstract class Moves {
    private String name;
    private String type;
    private int strength;
    private int chance;

    public Moves(String name, String type, int strength, int chance) {
        this.name = name;
        this.type = type;
        this.chance = chance;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getStrength() {
        return strength;
    }

    public int getChance() {
        return chance;
    }

    public void setChance(int chance) {
        this.chance = chance;
    }

    public abstract void takeAction(Pokemon attackingPokemon, Pokemon defendingPokemon);
}
