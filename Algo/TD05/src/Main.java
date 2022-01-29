import java.lang.Math;
import java.util.Scanner;
import java.util.Vector;

public class Main {

    public static int compteChiffre(int n){
        int c = 0;
        while (n > 0){
            n/=10;
            c++;
        }

        return c;
    }

    public static void multiplication(int n) {
        String space = ""; String result;
        int nbChiffresMax;

        for(int i = 1; i <= 10; i++){
            space = " "; result ="";
            if (i < 10){
                space = "  ";
            }
            result = i + space + "* " + n + " = ";
            space = "";

            nbChiffresMax = compteChiffre(n*10);

            //System.out.println("Chiffre Max = " + nbChiffresMax);
            //System.out.println("compteChiffre i = " + compteChiffre(i*n));

            for (int j = compteChiffre(i*n); j < nbChiffresMax; j++){
                space += " ";
            }
            result += space + (i*n);

            System.out.println(result);
        }
    }

    public static String chiffreUnites (int n){
        String[] converter = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        //System.out.print(converter[n-1]);
        return converter[n];
    }

    public static String chiffreDizaines (int n){
        String[] converter = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        //System.out.print(converter[n-1]);
        return converter[n];
    }

    public static String chiffreCentaines (int n){
        String[] converter = {"", "C", "CC", "CCC", "DC", "D", "CD", "CDD", "CDDD", "CM"};
        //System.out.print(converter[n-1]);
        return converter[n];
    }

    public static String chiffreMilliers (int n){
        String[] converter = {"", "M", "MM", "MMM"};
        //System.out.print(converter[n-1]);
        return converter[n];
    }

    public static String chiffreRomain (int n, String signe, String signeMedullaire, String signeSuperieur){
        String[] converter = {signe, signe.repeat(2), signe.repeat(3), signeMedullaire+signe
                , signeMedullaire, signe+signeMedullaire, signe + signeMedullaire.repeat(2)
                , signe+signeMedullaire.repeat(3), signe+signeSuperieur};
        System.out.print(converter[n-1]);
        return converter[n-1];
    }

    public static String chiffresRomain (int n){
        String chiffre = "", unite = "";
        int nlength = (n+"").length(), nbis = 0;

        while (nlength > 0){
            nbis = n;

            for(int i = 0; i < nlength - 1; i++){
                nbis /= 10;
            }
            if (nlength == 4){
                chiffre += chiffreMilliers(nbis%10);
            } else if (nlength == 3){
                chiffre += chiffreCentaines(nbis%10);
            } else if (nlength == 2){
                chiffre += chiffreDizaines(nbis%10);
            } else {
                chiffre += chiffreUnites(nbis%10);
            }
            nlength--;
        }

        System.out.println(chiffre);
        return chiffre;
    }

    public static int racineParfaite(int c){
        double n;
        n = Math.sqrt(c);
        if ((int) n == n){
            return (int) n;
        } else {
            return -1;
        }
    }

    public static boolean estCarreParfait(double c){
        boolean estCarreParfait = false;
        for(int i = 0; !estCarreParfait && i*i <= c; i++){
            if (c == i*i){
                estCarreParfait = true;
            }
        }

        return estCarreParfait;
    }

    public static void determineCoteTriangleRec(int a, int b){
        double c = a*a + b*b;
        if (estCarreParfait(c)){
            System.out.println("Possible");
        } else {
            System.out.println("Pas possible");
        }
    }

    public static boolean sontNbAmis(int p, int q){
        int sommeDiv = 0;
        for(int i = 1; i < q; i++){
            if(q%i == 0){
                sommeDiv += i;
            }
        }

        if (p == sommeDiv){
            //System.out.println(p + " et " + q +" sont amis.");
            return true;
        } else {
            //System.out.println(p + " et " + q +" ne sont pas amis.");
            return false;
        }
    }

    public static void sontAmisInfN(int n){
        for (int i = 1; i < n; i++){
            for(int j = 1; j < n; j++){
                if (sontNbAmis(i, j)){
                    System.out.println(i + ", " + j);
                }
            }
        }
    }

    public static void compactage(int[] t){
        for(int i = 1; i < t.length; i++){
            if (t[i] != 0 && t[i-1] == 0){
                t[i-1] = t[i];
                t[i] = 0;
                i=1;
            }
        }
    }

    public static void compactage2(int[] t){
        Vector<Integer> tbis = new Vector<>();
        for(int i = 0, j = 0; i < t.length; i++){
            if (t[i] != 0) {
                tbis.add(t[i]);
                t[j] = tbis.get(j);
                j++;
            }
        }

        for(int i = tbis.size(); i< t.length; i++){
            t[i] = 0;
        }
    }

    public static void compactageRep(int[] t){
        int[] nbExisting = new int[9]; Vector<Integer> tbis = new Vector<>();
        for(int i = 0, j = 0; i < t.length; i++){
            if (t[i] != 0 && nbExisting[t[i]] == 0){
                nbExisting[t[i]]++;
                tbis.add(t[i]);
                t[j] = tbis.get(j);
                j++;
            }
        }

        for(int i = tbis.size(); i< t.length; i++){
            t[i] = 0;
        }
    }

    public static void elementConsecutif(char[] t){
        int[] values = {0, 1};
        int max = 1;
        for(int i = t.length-2; i > 0; i--){
            if(t[i] == t[i+1]){
                max++;
                if (max > values[1]){
                    values[1] = max;
                    values[0] = i;
                    max = 1;
                }
            }
        }

        System.out.println(values[0] + " ; " + values[1]);
    }

    public static int nbrPlusFrq(int[] t){
        int[] values = {0, 1};
        int max = 1;
        for(int i = t.length-2; i > 0; i--){
            if(t[i] == t[i+1]){
                max++;
                if (max > values[1]){
                    values[1] = max;
                    values[0] = i;
                    max = 1;
                }
            }
        }

        System.out.println(t[values[0]]);
        return t[values[0]];
    }

    public static void main(String[] args){
        //multiplication(100);
        //chiffresRomain(3999);
        //System.out.println(racineParfaite(7));
        //System.out.println(estCarreParfait(9));
        //determineCoteTriangleRec(3,4);
        //sontNbAmis(220, 204);
        //sontAmisInfN(50);
        //int[] tab = {4, 0, 5, 2, 0, 0, 2, 4, 0, 4};
        //compactage(tab);
        //compactage2(tab);
        //compactageRep(tab);
        /*for(int i = 0; i < tab.length; i++){
            System.out.print(tab[i] + ", ");
        }*/
        //char[] tab2 = {'A', 'Z', 'E', 'R', 'R', 'R', 'Z', 'E', 'Z', 'Z'};
        //elementConsecutif(tab2);
        //nbrPlusFrq(tab);
        Scanner sc = new Scanner(System.in);

        System.out.println("Entrez le nombre de personne qui souhaite entrer : ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++){
            System.out.println("Entrez votre âge : ");
            int age = sc.nextInt();

            if (age >= 18){
                System.out.println("Entrez");
            } else {
                System.out.println("Vous ne pouvez pas entrer");
            }
        }
    }
}
