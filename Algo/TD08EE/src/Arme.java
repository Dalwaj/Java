public class Arme {
    private String type;
    private int damage;
    private int probaTouche;

    public static Arme[] tabArmes = new Arme[] {new Arme("Epée", 8, 90),
            new Arme("Hache", 12, 61),
            new Arme("Lance", 10, 73),
            new Arme("Fléau", 16, 46),
            new Arme("Faux", 6, 101)
    };

    public static int nbArmes = 0;

    public Arme(String type, int damage, int probaTouche){
        this.type = type;
        this.damage = damage;
        this.probaTouche = probaTouche;
    }

    public String toString(){
        return this.type + " : " + damage + " dégats, " + probaTouche + " précision.";
    }

    public int getDamage(){
        return this.damage;
    }

    public int getProbaTouche(){
        return this.probaTouche;
    }

    public String getType(){
        return this.type;
    }
}
