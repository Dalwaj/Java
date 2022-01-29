import java.util.Random;
import java.util.Scanner;

class Marin {
    String name;
    int[] coord = {0, 0};

    public Marin(String name, Planche planche) {
        this.name = name;
        this.coord[0] = planche.largeur / 2;
    }

    public void move() {
        Random random = new Random();
        int n;

        n = random.nextInt(100) + 1;

        if (n <= 50) {
            this.coord[1]++;
            System.out.println(this.name + " a avancé d'un pas vers le haut de le planche.");
        } else if (n <= 70) {
            this.coord[0]++;
            System.out.println(this.name + " a avancé d'un pas vers la droite de le planche.");
        } else if (n <= 90) {
            this.coord[0]--;
            System.out.println(this.name + " a avancé d'un pas vers la gauche de la planche.");
        } else if (n <= 100 && this.coord[1] != 0) {
            this.coord[1]--;
            System.out.println(this.name + " a avancé d'un pas vers le bas de la planche.");
        }
    }
}

class Planche {
    int largeur, longueur;

    public Planche() {
        Scanner sc = new Scanner(System.in);

        int largeur, longueur;
        do {
            System.out.println("Combien de pas de large fait votre planche ?");
            largeur = sc.nextInt();
        } while (largeur % 2 != 1);

        do {
            System.out.println("Combien de pas de long fait votre planche ?");
            longueur = sc.nextInt();
        } while (longueur <= largeur);

        this.largeur = largeur;
        this.longueur = longueur;
    }
}

public class Main {
    static Scanner scan = new Scanner(System.in);

    public static boolean arivobato(boolean trace) {
        String name;

        System.out.println("Quel est le nom de votre Marin : ");
        name = scan.nextLine();

        Planche planche = new Planche();
        Marin marin = new Marin(name, planche);
        boolean estArrive = false;
        boolean boucle = true;

        while (boucle) {
            marin.move();

            System.out.println("Marin X : " + marin.coord[0]);
            System.out.println("Marin Y : " + marin.coord[1]);
            System.out.println("Longueur planche : " + planche.longueur);
            System.out.println("Largeur planche : " + planche.largeur);

            if (trace) {
                afficherSituation(marin, planche);
            }

            if ((marin.coord[0] >= planche.largeur) || (marin.coord[0] < 0)) {
                System.out.println("Plouf !");
                boucle = false;
            } else if (marin.coord[1] >= planche.longueur) {
                System.out.println("Let's gooooo !");
                boucle = false;
                estArrive = true;
            }

            scan.nextLine();
        }
        return estArrive;
    }

    public static void afficherSituation(Marin marin, Planche planche) {
        for (int i = 0; i < planche.largeur; i++) {
            for (int j = 0; j < planche.longueur; j++) {
                if (marin.coord[0] == i && marin.coord[1] == j) {
                    System.out.print("O");
                } else {
                    System.out.print("#");
                }
            }
            System.out.print('\n');
        }
    }

    public static void main(String[] args) {
        System.out.println(arivobato(true));
    }
}






    /*Random random = new Random();
        int n, length = 1000;
        int [] tab = {0, 0, 0, 0, 0};

        for (int i = 0; i < length; i++){
            n = random.nextInt(100) + 1;

            if ( n <= 50){
                tab[0]++;
            } else if (n <= 70){
                tab[1]++;
            } else if (n <= 90){
                tab[2]++;
            } else if (n <= 100){
                tab[3]++;
            }else {
                System.out.println("Erreur.");
                return;
            }
        }
        tab[4] = tab[0] + tab[1] + tab[2] + tab[3];

        //Debugging
        for (int j = 0; j < tab.length; j++){
            System.out.println(tab[j]);
        }

        System.out.println("Nb compris entre 1 et 50 : " + (double)tab[0]/tab[4]*100 + "%.\n" +
                "Nb compris entre 51 et 70 : " + (double)tab[1]/tab[4]*100 + "%.\n" +
                "Nb compris entre 71 et 90 : " + (double)tab[2]/tab[4]*100 + "%.\n" +
                "Nb compris entre 91 et 100 : " + (double)tab[3]/tab[4]*100 + "%.");*/
