import java.util.Arrays;
import java.util.Random;

public class Ensemble {
    private int[] ensTab;
    private int cardinal;

    public Ensemble(int max){
        this.ensTab = new int[max];
        this.cardinal = 0;
    }

    public Ensemble(int max, int[] elements){
        this(max);
        cardinal = elements.length;
        for(int i = 0; i < cardinal; i++){
            ensTab[i] = elements[i];
        }
    }

    public Ensemble(Ensemble ensemble){
        this.ensTab = ensemble.ensTab;
        this.cardinal = ensemble.cardinal;
    }

    public Ensemble(int max, String entiersChaine){
        this(max);
        String[] entiers = entiersChaine.split(" ");
        for (int i = 0; i < entiers.length; i++){
            ensTab[i] = Integer.parseInt(entiers[i]);
            cardinal++;
        }

    }

    @Override
    public String toString(){
        String s = "{";
        for (int i = 0; i < cardinal; i++){
            if (!(i == cardinal - 1)) {
                s = s.concat(ensTab[i] + ", ");
            } else {
                s = s.concat(ensTab[i] + "");
            }
        }
        s = s.concat("}." + cardinal);

        return s;
    }

    public int getCardinal(){
        return this.cardinal;
    }

    //Renvoie l'indice i de n dans l'ensemble
    private int contientPratique(int n){
        int k = -1;
        for(int i = 0; i < cardinal; i++){
            if (ensTab[i] == n){
                k = i;
            }
        }

        return k;
    }

    //Retourne true si le tableau contient l'élément
    private boolean contient(int n){
        return contientPratique(n) != -1;
    }

    //Ajoute l'élement e à l'ensemble
    private void ajoutPratique(int e){
        ensTab[cardinal] = e;
        cardinal++;
    }

    //Retire l'élément à la ième place et le retourne
    public int retraitPratique(int i){
        int n = ensTab[i];
        cardinal --; // {1, 2, 3, 4, 5, 0, 0, 0}

        ensTab[i] = ensTab[cardinal];
        ensTab[cardinal] = 0;

        return n;
    }

    private boolean estVide(){
        return cardinal == 0;
    }

    private boolean deborde(){
        return cardinal == ensTab.length;
    }

    public boolean retraitElt(int n){
        boolean retrait = false;

        if (contient(n)){
            retraitPratique(contientPratique(n));
            retrait = true;
        }

        return retrait;
    }

    public int ajoutElt(int n){
        int ajout = -1;

        if (!deborde()){
            if(contient(n)){
                ajout = 0;
            } else {
                ajoutPratique(n);
                ajout = 1;
            }
        }

        return ajout;
    }

    public int retraitEltAleatoirement(){
        Random rand = new Random();
        int i = rand.nextInt(this.cardinal);
        int n = -1;

        if (contient(ensTab[i])){
            n = ensTab[i];
            retraitPratique(ensTab[i]);
        }

        return n;
    }

    public int selectionEltAleatoirement(){
        Random rand = new Random();
        int i = rand.nextInt(this.cardinal);
        int n = -1;

        if (contient(ensTab[i])){
            n = ensTab[i];
        }

        return n;
    }

    public int selectionElt(){
        return this.ensTab[this.cardinal-1];
    }

    public int selectionEltDep(){
        return this.ensTab[0];
    }

    public static boolean estInclus(Ensemble e1, Ensemble e2){
        boolean contient = true;
        for(int element : e1.ensTab){
            if (!e2.contient(element)){
                contient = false;
            }
        }

        return contient;
    }

    public static boolean estEgal(Ensemble e1, Ensemble e2){
        return estInclus(e1, e2) && estInclus(e2, e1);
    }

    public static boolean estDisjoint(Ensemble e1, Ensemble e2){
        boolean disjoint = true;

        for(int element : e1.ensTab){
            if (e2.contient(element)){
                disjoint = false;
            }
        }

        return disjoint;
    }

    public static Ensemble intersection(Ensemble e2, Ensemble e1){
        Ensemble intersection = new Ensemble(e2.cardinal > e1.cardinal? e1.cardinal : e2.cardinal);

        for (int i = 0; i < e1.cardinal; i++){
            if (e2.contient(e1.ensTab[i])) {
                intersection.ajoutPratique(e1.ensTab[i]);
            }
        }

        return intersection;
    }

    public static Ensemble reunion(Ensemble a, Ensemble b){
        Ensemble reunion = new Ensemble(a.cardinal + b.cardinal);
        Ensemble intersect = intersection(a, b);

        for (int i = 0; i < a.cardinal; i++){
            reunion.ajoutPratique(a.ensTab[i]);
        }

        for(int i = 0; i < b.cardinal; i++){
            reunion.ajoutElt(b.ensTab[i]);
        }

        return reunion;
    }

    public static Ensemble difference(Ensemble a, Ensemble b){
        Ensemble diff = new Ensemble(a);

        for(int i = 0; i < a.cardinal; i++){
            if (b.contient(a.ensTab[i])){
                diff.retraitElt(a.ensTab[i]);
                a.cardinal--;
            }
        }

        return diff;
    }

    public int[] getEnsTab() {
        return ensTab;
    }
}
