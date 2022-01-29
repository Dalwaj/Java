import java.util.Scanner;

public class Arene {
    private Ensemble ensOrques;
    private int xMax;
    private int yMax;

    public Arene(int nbo, int xMax, int yMax){
        this.xMax = xMax;
        this.yMax = yMax;

        ensOrques = new Ensemble(20);
        for (int i = 0; i < nbo; i++){
            ensOrques.ajoutElt(new Orque(this).getId());
        }
    }

    public void bataille(){
        Scanner sc = new Scanner(System.in);

        Orque battleOrcs[];
        int vainqueur = 0;
        while(ensOrques.getCardinal() > 1){
            System.out.println("Voici l'ensemble des Orques encore en liste : ");
            System.out.println(ensOrques);

            battleOrcs = this.moveO();
            this.display();
            sc.nextLine();

            Orque orque1 = battleOrcs[0];
            Orque orque2 = battleOrcs[1];

            if (orque1 != null && orque2 != null){
                vainqueur = orque1.combat(orque2);
                ensOrques.retraitElt(orque2.getId());
            }
        }

        System.out.println(ensOrques);
    }

    public void display(){
        System.out.println();
        for(int i = 0; i < this.getxMax(); i++){
            for(int j = 0; j < this.getyMax(); j++){
                boolean orcPlace = false;
                for(int k = 0; k < ensOrques.getCardinal(); k++){
                    if (Orque.tabOrques[ensOrques.getEnsTab()[k]].getX() == i &&
                            Orque.tabOrques[ensOrques.getEnsTab()[k]].getY() == j && !orcPlace) {
                        System.out.print("|" + Orque.tabOrques[ensOrques.getEnsTab()[k]].getId());
                        orcPlace = true;
                    }
                }
                if (!orcPlace){
                    System.out.print("| ");
                }
                if (j + 1 == getxMax()){
                    System.out.println("|");
                }
            }
        }
        System.out.println();
    }

    public Orque[] moveO(){
        Orque orques[] = new Orque[2];
        Orque orque = Orque.tabOrques[ensOrques.selectionEltAleatoirement()];
        orque.move();

        for (int i = 0; i < ensOrques.getCardinal(); i++){
            if (orque.getId() != Orque.tabOrques[ensOrques.getEnsTab()[i]].getId() &&
                orque.getX() == Orque.tabOrques[ensOrques.getEnsTab()[i]].getX() &&
                    orque.getY() == Orque.tabOrques[ensOrques.getEnsTab()[i]].getY()){
                Orque orque2 = Orque.tabOrques[ensOrques.getEnsTab()[i]];

                orques[0] = orque;
                orques[1] = orque2;
            }
        }

        return orques;
    }

    public int getxMax(){
        return this.xMax;
    }

    public int getyMax(){
        return this.yMax;
    }
}
