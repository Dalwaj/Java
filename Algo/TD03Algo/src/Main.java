import java.util.Scanner;
import java.lang.Math;

public class Main {

    public static void afficherTabEntiers(int[] tab) {
        System.out.print("[");
        for (int i = 0; i < tab.length; i++) {
            if (i + 1 != tab.length) {
                System.out.print(tab[i] + ", ");
            } else {
                System.out.print(tab[i] + "]\n");
            }
        }
    }

    public static int[] saisirTabEntiers(int taille){
        Scanner sc = new Scanner(System.in);
        int n;
        int[] tab = new int[taille];
        for (int i = 0; i < taille; i++){
            System.out.println("Saisissez une valeur à entrer à la case " + (i+1) +
                    " du tableau : ");
            n = sc.nextInt();
            tab[i] = n;
        }

        sc.close();
        return tab;
    }

    public static double moyenne(int[] tab){
        float moyenne;
        int somme = 0;

        for (int i = 0; i < tab.length; i ++){
            somme += tab[i];
        }

        moyenne = (float)somme/tab.length;
        return moyenne;
    }

    public static void traiterTabEntiers(int [] tab){
        System.out.print("Ton tableau ");
        afficherTabEntiers(tab);

        System.out.println("Moyenne : " + moyenne(tab));

        for (int i = 0; i < tab.length; i++){
            if (tab[i]%2 == 0){
                tab[i] = 1;
            }
        }

        System.out.print("Ton nouveaux tableau ");
        afficherTabEntiers(tab);

    }

    public static int max2(int a, int b){
        if (a >= b) return a;
        else return b;
    }

    public static int max3(int a, int b, int c){
        int max = max2(a, b);
        if (c >= max) return c;
        else return max;
    }

    public static int ultimateMax(int n){
        Scanner sc = new Scanner(System.in);
        int [] tab = new int[n];
        int max;

        for (int i = 0; i < n; i++){
            System.out.println("Entrez la valeur " + (i+1) + " :");
            tab[i] = sc.nextInt();
        }

        max = tab[0];
        for (int i = 0; i < n; i ++){
            if (tab[i] > max){
                max = tab[i];
            }
        }

        sc.close();
        return max;
    }

    public static int nbChiffres(int n){
        int i;

        for (i = 1; n/10 != 0; i++){
            n/=10;
        }

        return i;
    }

    public static int nbChiffresDuCarre(int n){
        n *= n;
        int i;

        for (i = 1; n/10 != 0; i++){
            n/=10;
        }

        return i;
    }

    public static int [] frequencesChiffres(int n){
        int q;
        int [] tab = new int [10];

        while (n != 0){
            q = n%10;
            n/=10;
            tab[q]++;
        }

        return tab;
    }

    public static boolean aChiffresTousDifferents(int n){
        int [] tab = frequencesChiffres(n);
        boolean aChiffresDifferents = true;

        for (int i = 0; aChiffresDifferents && i < tab.length; i++){
            if (tab[i] > 1){
                aChiffresDifferents = false;
            }
        }

        return aChiffresDifferents;
    }

    public static boolean aChiffresTousDifferentsBis(int n){
        int q;
        int[] mem = new int[10];

        while (n != 0){
            q = n%10;
            n /= 10;
            mem[q] ++;
        }

        boolean aChiffresDifferents = true;

        for (int i = 0; aChiffresDifferents && i < mem.length; i++){
            if (mem[i] > 1){
                aChiffresDifferents = false;
            }
        }

        return aChiffresDifferents;
    }

    public static boolean estPalindrome(String s){
        boolean estPalindrome = true;
        s = s.toLowerCase();

        for(int i = 0, j = s.length()-1; j >= i; i++, j--){

            //System.out.println("s[i] : " + s.toCharArray()[i]);
            //System.out.println("s[j] : " + s.toCharArray()[j]);

            if (s.toCharArray()[i] != s.toCharArray()[j]){
                estPalindrome = false;
            }
        }

        return estPalindrome;
    }

    public static void testPalin(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Entrez un mot afin de vérifier s'il est un palindrome : ");
        String s = sc.nextLine();

        if (estPalindrome(s)){
            System.out.println(s + " est un palindrome.");
        } else {
            System.out.println(s + " n'est pas une palindrome");
        }
    }

    public static void repeteCarac(int n, char c){
        for (int i = 0; i < n; i++){
            System.out.print(c);
        }
    }

    public static void pyramideSimple(int h, char c){
        int k = 1;
        for (int i = 0; i < h; i++){
            for (int j = h-i ; j > 0; j--){
                System.out.print(' ');
            }
            for (int l = 0; l < k; l++){
                System.out.print(c);
            }
            System.out.print('\n');
            k+=2;
        }
    }

    public static void afficheNombresCroissants(int n1, int n2){
        while(n1 <= n2){
            String s = Integer.toString(n1);
            System.out.print(s.toCharArray()[s.length()-1]);
            n1++;
        }
    }

    public static void afficheNombresDecroissants(int n1, int n2){
        while(n2 >= n1){
            String s = Integer.toString(n2);
            System.out.print(s.toCharArray()[s.length()-1]);
            n2--;
        }
    }

    public static void pyramide(int n){
        int k = 1;
        for (int i = 0; i <= n; i++){
            for (int j = n-i; j > 0; j--){
                System.out.print(' ');
            }

            afficheNombresCroissants(i+1, k);
            afficheNombresDecroissants(i+1, k-1);
            System.out.print('\n');
            k+=2;
        }
    }

    public static void triangleRectangle(int n){

    }

    public static boolean estSyracusien(int n){
        while (n>1){
            if (n%2 == 0){
                n/=2;
            } else {
                n = 3*n + 1;
            }
        }

        return true;
    }

    public static boolean nbSyracusien(int n, int nbMaxOp){
        for (int i = 0; n > 1 && i < nbMaxOp; i++){
            if (n%2 == 0){
                n/=2;
            } else {
                n = 3*n + 1;
            }
            //System.out.println("Tour " + (i+1) + ", n = " + n);
        }

        return n == 1;
    }

    public static void estimationE(int n){
        double e = 0, denom = 2; int s = 1+(2*(n-1));

        for (int i = 0; i < n; i++, s-=2){
            denom = -(1/denom) + s;
            denom = (1/denom)+2;
            //System.out.println("denom = " + denom);
            //System.out.println("S = " + s);
        }

        e = denom - 1;

        System.out.println("Approximation de e : " + e);
    }

    public static int compteRectangle(int n){
        int compteur = 0;

        for(double a = 1, b = 1, c = Math.sqrt(a*a + b*b); a + b + c < n; a++){
            for(b = 1; a + b + c < n; b++){
                c = Math.sqrt(a*a + b*b);

                if (c == (int) c){
                    compteur++;
                }
            }

            b = 1;
        }

        System.out.println(compteur);
        return compteur;
    }

    public static void main(String args[]) {
        //afficherTabEntiers(new int[]{1, 2, 3});
        //saisirTabEntiers(5);
        //moyenne(saisirTabEntiers(5));
        //traiterTabEntiers(saisirTabEntiers(10));
        //System.out.println(max2(15, 7));
        //System.out.println(max3(15, 6, 8));
        //System.out.println(ultimateMax(5));
        //System.out.println("Nombre de chiffre : " + nbChiffres(10));
        //System.out.println("Nombre de chiffre : " + nbChiffresDuCarre(10));
        //afficherTabEntiers(frequencesChiffres(559812));
        //System.out.println(aChiffresTousDifferents(156));
        //System.out.println(estPalindrome("Vache"));
        //testPalin();
        //repeteCarac(5, '*');
        //pyramideSimple(5, '*');
        //afficheNombresCroissants(150, 175);
        //afficheNombresDecroissants(125, 140);
        //pyramide(10);
        /*for(int i = 1; i <= 10; i ++){
            if (estSyracusien(i)){
                System.out.println(i + " est un nombre syracusien.");
            }
        }*/
        //System.out.println(nbSyracusien(9, 3));
        //estimationE(3);
        //System.out.println(aChiffresTousDifferentsBis(123));
        //compteRectangle(15000)
    }
}
