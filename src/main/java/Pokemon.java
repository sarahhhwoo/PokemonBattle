public class Pokemon {
    private String name;
    private String type;
    private int level;
    private int HP;
    private double attack;
    private double defense;
    private double speed;
    private Moves move1;
    private Moves move2;
    private Moves move3;

    public Pokemon(String name, String type, int level, int HP, double attack, double defense, double speed, Moves move1, Moves move2, Moves move3){
        this.name = name;
        this.type = type;
        this.level = level;
        this.HP = HP;
        this.attack = attack;
        this.defense = defense;
        this.speed = speed;
        this.move1 = move1;
        this.move2 = move2;
        this.move3 = move3;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getLevel() {
        return level;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public double getAttack() {
        return attack;
    }

    public void setAttack(double attack) {
        this.attack = attack;
    }

    public double getDefense() {
        return defense;
    }

    public void setDefense(double defense) {
        this.defense = defense;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public Moves getMove1() {
        return move1;
    }

    public Moves getMove2() {
        return move2;
    }

    public Moves getMove3() {
        return move3;
    }
}
