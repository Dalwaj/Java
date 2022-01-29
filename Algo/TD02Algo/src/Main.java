/*Exercice 1
(x < y) et (z==4) sont bien des expressions booléennes
(x < y) est de type booléen mais (z et (t==4)) ne l'est pas en Java

Pour que (x ou (y et(z < 5)) soit une expression booléenne il faut que y et x soit de type booléan.
En Java l'expression (x ou (y et (x < 5)) n'est pas une expression booléenne et ne peut pas l'être.



Exercice 2
Si <condition1>
    si <condition2>
        <instructions1>
    sinon
        <instructions2>
    finSi
finSi

Dans ce cas, si condition 1 et condition 2 sont vraies, on exécute instructions1. Aussi, si la première condition est
vraie mais que la deuxième s'avère fausse alors le programme exécutera la seconde instruction.

Si <condition1>
    si <condition2>
        <instruction1>
    finSi
Sinon
    <instruction2>
finSi

Dans le cas ci-dessus, si condition1 et 2 sont vraies alors instruction 1 est exécutée, par contre si condition n'est
pas vraie alros ce sera la seconde instruction qui sera exécutée sans même passer par la seconde instruction.


Exercice 3

Les deux algorithmes sont effectivements équivalents.
 */

import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;
import java.lang.Math;

public class Main {
    public static void Exercice4(){
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int compteur = 1, nbPaire = 0, compteurMax = 0, n;
        do{
            System.out.println("Entrez une valeur max (pour le random) : ");
            n = sc.nextInt();
        } while(n <= 0);

        int [] tab = {0, 0, 0, 0};

        for (int i = 0; i < tab.length; i++){
            tab[i] = rand.nextInt(n)+1;
        }

        for (int i = 0; i < tab.length; i++){
            for (int j = i+1; j < tab.length; j++){
                if (tab[j] == tab[i]){
                    compteur++;
                } else {
                    compteur = 1;
                }
                if (compteur > compteurMax){
                    compteurMax = compteur;
                }
                if (compteur == 2){
                    nbPaire++;
                }
            }
        }

        System.out.println("Les numéros tirés : ");
        for (int i = 0; i < tab.length; i++){
            System.out.print(tab[i] + " ");
        }
        System.out.println("\nCartes similaires : " + compteurMax);

        switch (compteurMax){
            case 1 -> {System.out.println("Pas de chance !");}
            case 2 -> {if (nbPaire == 2){
            System.out.println("C'est une double paire !");}
                else {
                    System.out.println("C'est une paire!");
                }
            }
            case 3 -> {System.out.println("C'est un brelan!");}
            case 4 -> {System.out.println("C'est un carré!");}
            default -> {System.out.println("Unknown");}
        }
        sc.close();
    }

    public static void Exercice5(){
        Scanner sc = new Scanner(System.in);
        int n, compteur = 0;

        do{
            System.out.println("Entrez une valeur (pour stopper entrez 0) : ");
            n = sc.nextInt();

            if (n !=0){
                if (n%2 == 0){
                    System.out.println(n + " est un nombre pair.");
                    compteur++;
                } else {
                    System.out.println(n + " n'est pas un nombre pair.");
                }
            }
        } while (n != 0);

        System.out.println("Nombre de nombres pairs saisis : " + compteur);
        sc.close();
    }

    public static void Exercice6(){
        Scanner sc = new Scanner(System.in);
        int n, max;

        System.out.println("Entrez votre 1ère valeur : ");
        n = sc.nextInt();
        max = n;

        for (int i = 1; i < 20; i++){
            System.out.println("Entrez votre valeur " + (i+1) + " : ");
            n = sc.nextInt();

            if (max < n) {
                max = n;
            }
        }

        System.out.println("Plus grande valeur entrée : " + max);

        sc.close();
    }

    public static void Exercice7(){
        Scanner sc = new Scanner(System.in);
        double delta;
        double [] constantes = {0, 0, 0};

        for (int i = 0; i < constantes.length; i++){
            System.out.println("Entrez la valeur " + (i+1) + " : ");
            constantes[i] = sc.nextDouble();
        }

        if(constantes[0] != 0 && constantes[1] != 0 && constantes[2] != 0) {
            delta = (constantes[1] * constantes[1]) + (4 * constantes[0] * 4 * constantes[1]);
            System.out.println("Delta = " + delta + "\n");

            if (delta > 0){
                double x1, x2;

                x1 = (-constantes[1] - Math.sqrt(delta))/(2*constantes[0]);
                x2 = (-constantes[1] + Math.sqrt(delta))/(2*constantes[0]);

                System.out.println("L'équation " + constantes[0] + "x²+" + constantes[1] + "x+" + constantes[2] + " admet" +
                        " deux uniques solutions " + x1 + " et " + x2 + " sur R.");
            } else if (delta == 0){
                double x0 = (-constantes[1])/(2*constantes[0]);
                System.out.println("L'équation " + constantes[0] + "x²+" + constantes[1] + "x+" + constantes[2] + " admet" +
                        " une unique solution " + x0 + " sur R.");
            } else {
                System.out.println("L'équation " + constantes[0] + "x²+" + constantes[1] + "x+" + constantes[2] + " n'admet" +
                        " aucune solution sur R.");
            }
        } else {
            System.out.println("L'équation " + constantes[0] + "x²+" + constantes[1] + "x+" + constantes[2] + " admet " +
                    "toutes les solutions sur R.");
        }

        sc.close();
    }
    public static void Exercice8(){
        Scanner sc = new Scanner(System.in);
        char c;
        int compteur = 0, memory = 0;
        String phrase = "";

        do{
            System.out.println("Entrez un caractère : ");
            c = sc.nextLine().charAt(0);
            phrase += c;


        } while(c != '.');

        System.out.println(phrase);

        for (int i = 0; i < phrase.length(); i++){
            if (phrase.toCharArray()[i] == 'm'){
                compteur++;
            }
        }
        System.out.println("Il y a " + compteur + " 'm' dans '" + phrase + "'");
        compteur = 0;

        for (int i = 0; i < phrase.length(); i++){
            if (phrase.toCharArray()[i] == ' '){
                compteur++;
            }
        }
        System.out.println("Il y a " + (compteur+1) + " mot dans '" + phrase + "'");
        compteur = 0;

        for (int i = 0; i < phrase.length(); i++){
            if (phrase.toCharArray()[i] == 'l' && phrase.toCharArray()[i+1] == 'e'){
                compteur++;
            }
        }
        System.out.println("Il y a " + compteur + " 'le' dans '" + phrase + "'");
        compteur = 0;

        for (int i = 0; i < phrase.length(); i++){
            if (phrase.toCharArray()[i] != ' '){
                compteur++;
            } else {
                compteur = 0;
            }
        }
        System.out.println("Le dernier mot fait " + (compteur-1) + " lettres de long");
        compteur = 0;

        for (int i = 0; i < phrase.length(); i++){
            if (phrase.toCharArray()[i] != ' '){
                compteur++;
            } else {
                if (compteur > memory) {
                    memory = compteur;
                }
                compteur = 0;
            }
        }
        System.out.println("Le mot le plus long fait " + memory + " lettres de long");
        compteur = 0;

        sc.close();
    }

    public static void Exercice9(){
        Scanner sc = new Scanner(System.in);
        int nb, save = 0, somme = 0;

        do{
            System.out.println("Entrez un nombre entier strictement positif : ");
            nb = sc.nextInt();
        } while (nb <= 0);

        for (int i = 0; somme < nb; i++){
            save = somme;
            somme+=i;
            //System.out.println("Save : " + save);
            //System.out.println("Somme : " + somme);
        }

        if (nb-save <= somme-nb){
            System.out.println("La somme la plus proche est : " + save);
        } else {
            System.out.println("La somme la plus proche est : " + somme);
        }
        sc.close();
    }

    public static void Exercice10(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Entrez la valeur d'une année à tester : ");
        int annee = sc.nextInt();

        if (annee%4 == 0 && annee%100 != 0){
            System.out.println(annee + " est une année bissextile");
        } else if (annee%400 == 0) {
            System.out.println(annee + " est une année bissextile");
        } else {
            System.out.println(annee + " n'est pas une année bissextile");
        }

        sc.close();
    }

    public static void Exercice11(){
        Scanner sc = new Scanner(System.in);
        int [] date = {0, 0, 0};
        boolean estBissextile;

        System.out.println("Entrez les valeurs d'une date tel que que le format corresponde à : JJ/MM/AA.");
        System.out.println("Vous rentrerez les valeurs de 'JJ' en premier, puis de 'MM' et enfin de 'AA'.");
        for (int i = 0; i < date.length; i++){
            System.out.println("Entrez la " + (i+1) + " valeur : ");
            date[i] = sc.nextInt();
        }

        if (date[2]%4 == 0 && date[2]%100 != 0){
            estBissextile = true;
        } else if (date[2]%400 == 0) {
            estBissextile = true;
        } else {
            estBissextile = false;
        }

        System.out.print("Date : " + date[0] + "/" + date[1] + "/" + date[2] + " est ");
        if (date[2] < 0){
            System.out.println("invalide.");
        } else if (date[1] < 1 || date[1] > 12){
            System.out.println("invalide.");
        } else if ((date[1] <= 7 && date[1]%2 == 0) || (date[1] >= 8 && date[1]%2 == 1)) {
            if (estBissextile && date[1] == 2 && date[0] == 29) {
                System.out.println("valide");
            } else if(date[1] == 2 && date[0] > 28){
                System.out.println("invalide");
            } else if (date[0] < 1 || date[0] > 30) {
                System.out.println("invalide");
            }
        } else if (date[0] < 1 || date[0] > 31){
            System.out.println("invalide");
        } else {
            System.out.println("valide");
        }

        sc.close();
    }

    public static void Exercice12(){
        Scanner sc = new Scanner(System.in);
        int nbJours = 0;
        int [] date = {0, 0, 0};
        boolean estBissextile;

        System.out.println("Entrez les valeurs d'une date tel que que le format corresponde à : JJ/MM/AA.");
        System.out.println("Vous rentrerez les valeurs de 'JJ' en premier, puis de 'MM' et enfin de 'AA'.");
        for (int i = 0; i < date.length; i++){
            System.out.println("Entrez la " + (i+1) + " valeur : ");
            date[i] = sc.nextInt();
        }

        if (date[2]%4 == 0 && date[2]%100 != 0){
            estBissextile = true;
        } else if (date[2]%400 == 0) {
            estBissextile = true;
        } else {
            estBissextile = false;
        }

        for (int i = 1; i <= date[1]; i++){
            if((i <= 7 && i%2 == 1) || (i >= 8 && i%2 == 0)){
                if (i < date[1]){
                    nbJours += 31;
                } else {
                    nbJours += date[0];
                }
            } else if (i <= 7 && i%2 == 0 || (i >= 8 && i%2 == 1)) {
                if (i < date[1] && i != 2) {
                    nbJours += 30;
                } else if (i == date[1]) {
                    nbJours += date[0];
                } else if (i == 2) {
                    if (estBissextile) {
                        nbJours += 29;
                    } else {
                        nbJours += 28;
                    }
                }
            }
        }

        System.out.println("Il s'est écoulé " + nbJours + " jours depuis le début de l'année.");
        sc.close();
    }

    public static void main(String[] args){
        //Exercice4();
        //Exercice5();
        //Exercice6();
        //Exercice7();
        //Exercice8();
        //Exercice9();
        //Exercice10();
        //Exercice11();
        //Exercice12();
    }
}
