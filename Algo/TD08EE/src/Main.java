import java.awt.*;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        /*Random rand = new Random();
        Ensemble e1 = new Ensemble(10, new int[] {1,2,4,8,7});
        Ensemble e2 = new Ensemble(e1);
        Ensemble e3 = new Ensemble(10, "1 2 9 0 24");

        Ensemble e4 = Ensemble.intersection(e1, e3);
        System.out.println(e4);

        Ensemble e5 = Ensemble.reunion(e1, e3);
        System.out.println(e5);

        Ensemble e6 = Ensemble.difference(e1, e3);
        System.out.println(e6);*/

        Arene arene1 = new Arene(4, 3, 3);
        arene1.bataille();

    }
}
