import java.util.Random;

public class Main {

    public static void carreMagique(int longueur) {
        int[][] matrice = new int[longueur][longueur];

        matrice[0][longueur/2] = 1;

        for (int i = 2, j = (longueur/2)+1, k = (longueur/2)+1; i <= longueur * longueur; i++, j--, k++) {
            if (j < 0) {
                j = longueur-1;
            }
            if (k > longueur-1) {
                k = 0;
            }
            if (matrice[j][k] == 0) {
                matrice[j][k] = i;
            } else {
                i--;
                k++;
            }
            //System.out.print("J : " + j);
            //System.out.print(" | K : " + k);
            //System.out.print(" | I : " + i +"\n");
        }

        for (int i = 0; i < longueur; i++) {
            for (int j = 0; j < longueur; j++) {
                System.out.print(matrice[i][j] + ",");
            }
            System.out.print("\n");
        }
    }

    public static void matriceRangee(int n){
        int[][] matrice = new int[n][n];

        for (int i = 1, j = 0; i < n*n; j++){
            if(j > n-1){
                j = 0;
            }
            for(int k = 0; k < n; k++, i++){
                matrice[j][k] = i;
            }
        }

        for (int[] row : matrice){
            for(int nb : row){
                System.out.print(nb + ", ");
            }
            System.out.print("\n");
        }
    }

    public static void matriceSerpentin(int n){
        int[][] matrice = new int[n][n];
        boolean serpentin = false;
        int k;

        for(int i = 1, j = 0; i < n*n;){

            if (serpentin){
                k = n-1;
                serpentin = !serpentin;
            } else {
                k = 0;
                serpentin = !serpentin;
            }

            for(int l = 0; l < n; i++, l++){
                matrice[j][k] = i;
                if (!serpentin){
                    k--;
                } else {
                    k++;
                }
            }
                j++;
        }

        for (int[] row : matrice){
            for(int nb : row){
                System.out.print(nb + ", ");
            }
            System.out.print("\n");
        }
    }

    public static void matriceDiag(int n){
        int [][] matrice = new int[n][n];

        for(int i = 1; i <= factoriel(n);) {
            for (int j = 0; j < n; j++) {
                for (int l = j; l >= 0;) {
                    for (int k = 0; k <= j && i <= factoriel(n); k++, i++, l--) {
                        matrice[l][k] = i;
                    }
                }
            }
        }

        for(int i = n*n; i > factoriel(n);) {
            for (int j = n-1; j > 0; j--) {
                for (int l = j; l <= n-1;) {
                    for (int k = n-1; k >= j; k--, i--, l++) {
                        matrice[l][k] = i;
                    }
                }
            }
        }

        for (int[] row : matrice){
            for(int nb : row){
                System.out.print(nb + ", ");
            }
            System.out.print("\n");
        }
    }

    public static int factoriel(int n){
        for (int i = n-1; i > 0; i--){
            n+=i;
        }
        return n;
    }

    public static int[][] matriceSpirale(int n){
        int[][] matrice = new int[n][n];
        int j = n-1, row = 0, column = 0, i = 1;

        while(i <= n*n && j >= 0){

            while(row < j){
                matrice[column][row] = i;
                row++;
                i++;
            }

            while(column < j){
                matrice[column][row] = i;
                column++;
                i++;
            }

            while(row >= n-j){
                matrice[column][row] = i;
                i++;
                row--;
            }

            while(column > n-j){
                matrice[column][row] = i;
                column--;
                i++;
            }

            j--;
        }

        for(i = 0; i < matrice.length; i++){
            for( j = 0; j < matrice.length; j++){
                if (matrice[i][j] == 0){
                    matrice[i][j] = n*n;
                }
            }
        }

        for(i = 0; i < matrice.length; i++){
            for( j = 0; j < matrice.length; j++){
                System.out.print(matrice[i][j] + ", ");
            }
            System.out.println("");
        }

        return matrice;
    }

    public static void generateurCouleur(int c){
        Random random = new Random();
        int n;
        char[] converter = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};


        for(int j = 0; j < c ; j++) {
            String color = "";
            for (int i = 0; i < 6; i++) {
                n = random.nextInt(16);
                color += converter[n];
            }
            System.out.println(color);
        }
    }
    public static boolean estCarre(int[][] matrice){
        return matrice.length == matrice[0].length;
    }

    public static boolean verifSudoku(int[][] sudoku){
        boolean estCorrect = true;
        double n = Math.sqrt(sudoku.length);
        int[] frqChiffres = new int[sudoku.length + 1];

        if (n != (int) n){
            System.out.println("Ce n'est pas un sudoku valide");
            estCorrect = false;
        }
        if (!estCarre(sudoku)){
            System.out.println("Erreur : Le sudoku n'est pas un carré.");
            estCorrect = false;
        }

        for(int i = 0; i < sudoku.length; i++){
            for(int j = 0; j < sudoku[i].length; j++){
                frqChiffres[sudoku[i][j]]++;
                frqChiffres[sudoku[j][i]]++;
            }
            for(int k = 0; k < frqChiffres.length; k++){

                if (frqChiffres[k] > 2){
                    estCorrect = false;
                }
                frqChiffres[k] = 0;
            }
        }

        for(int i = 0; i < n*n; i+=n) {
            for (int l = 0; l < n*n; l+=n) {
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < n; k++) {
                        frqChiffres[sudoku[j + i][k + l]]++;
                    }
                }
                for (int k = 0; k < frqChiffres.length; k++) {

                    if (frqChiffres[k] > 1) {
                        estCorrect = false;
                    }
                    frqChiffres[k] = 0;
                }
            }
        }

        System.out.println(estCorrect);
        return estCorrect;
    }

    public static void main (String[] args){
        int[][] sudoku = {{5,6,1,8,4,7,9,2,3},{3,7,9,5,2,1,6,8,4},{4,2,8,9,6,3,1,7,5},{6,1,3,7,8,9,5,4,2},
                {7,9,4,6,5,2,3,1,8},{8,5,2,1,3,4,7,9,6},{9,3,5,4,7,8,2,6,1},{1,4,6,2,9,5,8,3,7},{2,8,7,3,1,6,4,5,9}};
        int[][] sudoku2 = {{1,2,3,4}
                         ,{2,1,4,3}
                         ,{3,4,1,2}
                         ,{4,3,2,1}};

        /*for (int i = 0; i < sudoku.length; i++){
            for (int j = 0; j < sudoku[i].length; j++){
                System.out.print(sudoku[i][j] + ", ");
            }
            System.out.println("");
        }
        System.out.println("");*/

        //carreMagique(4);
        //matriceRangee(4);
        //matriceSerpentin(5);
        //matriceDiag(4);
        //System.out.println(factoriel(4));
        matriceSpirale(8);
        //generateurCouleur(100);
        //verifSudoku(sudoku);

    }
}
