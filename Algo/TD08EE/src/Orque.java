import org.jetbrains.annotations.NotNull;

import java.util.Random;
import java.util.Scanner;

public class Orque {
    private int id;
    private float lifePoints;
    private int weight;
    private int dexterite;
    private int x;
    private int y;
    private Arene arene;

    public static Ensemble armes = new Ensemble(30, new int[] {0, 1, 2, 3, 4});
    public static int nbOrques = 0;
    public static Orque[] tabOrques = new Orque[100];

    public Orque(Arene arene){
        //Set le random
        Random rand = new Random();

        //On set les propriétés intrinsèques de l'orque
        this.id = nbOrques;
        this.lifePoints = rand.nextInt(40,50);
        this.weight = rand.nextInt(60, 100);
        this.dexterite = rand.nextInt(70, 101);
        this.arene = arene;
        this.x = rand.nextInt(this.arene.getxMax());
        this.y = rand.nextInt(this.arene.getyMax());

        //On ajoute l'orque à l'ensemble d'orques
        Orque.tabOrques[id] = this;
        Orque.nbOrques++;
    }

    public int combat(Orque orque){
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);

        Arme arme1 = getArme();
        Arme arme2 = getArme();

        System.out.println("Un combat a commencé entre Orque " + this.getId() + " et Orque " + orque.getId() +"\n");
        System.out.println("Orque " + this.getId() + " Arme : " + arme1);
        System.out.println("Orque " + orque.getId() + " Arme : " + arme2);
        sc.nextLine();

        while (this.lifePoints > 0 && orque.lifePoints > 0){
            int firstAttack = rand.nextInt(2) == 0 ? this.getId() : orque.getId();

            if (firstAttack == this.getId()){
                this.attack(orque, arme1);
                if (orque.lifePoints > 0){
                    orque.attack(this, arme2);
                }
            } else {
                orque.attack(this, arme2);
                if (this.lifePoints > 0){
                    this.attack(orque, arme1);
                }
            }
        }

        return this.lifePoints > orque.lifePoints ? this.getId() : orque.getId();
    }

    private Arme getArme(){
        return Arme.tabArmes[armes.selectionEltAleatoirement()];
    }

    private boolean isAttack(@NotNull Arme arme){
        Random rand = new Random();
        int proba = rand.nextInt(101);
        return proba < this.dexterite * arme.getProbaTouche();
    }

    private void attack(Orque adversaire, Arme arme){
        Scanner sc = new Scanner(System.in);
        if (isAttack(arme)){
            float damages = ((float)this.weight/100) * arme.getDamage();
            adversaire.lifePoints -= damages;
            System.out.println("Orque " + this.getId() + " attaque Orque " + adversaire.getId());
            adversaire.lifePoints = (adversaire.lifePoints < 0) ? 0 : adversaire.lifePoints;
            System.out.println("Orque " + adversaire.getId() + " perds " + damages + " points de vie.");
            System.out.println("Points de vie restant : " + adversaire.lifePoints);
        } else {
            System.out.println("Orque " + this.getId() + " a raté son attaque");
        }
        sc.nextLine();
    }

    public void move(){
        Random rand = new Random();
        int direction, xbis, ybis;

        do{
            direction = rand.nextInt(4);
            xbis = this.getX();
            ybis = this.getY();

            switch (direction) {
                case 1 -> xbis--;
                case 2 -> ybis++;
                case 3 -> ybis--;
                default -> xbis++;
            }
        } while (xbis < 0 || ybis < 0 || xbis >= this.arene.getxMax() || ybis >= this.arene.getyMax());

        this.setX(xbis);
        this.setY(ybis);

        //System.out.println("Orque : " + this.getId() + " | X : " + getX() + " | Y : " + getY());

    }

    public int getId(){
        return this.id;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
