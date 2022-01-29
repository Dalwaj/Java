import java.util.Random;

public class raceMain {
    public static void main(String[] args) throws InterruptedException {
        Car cars[] = {new Car("Dalwaj", 1),
                new Car("Jawad", 1),
                new Car("Hector", 1),
                new Car("Timothee", 1),
                new Car("Quentin", 1),
                new Car("Baptiste", 1)};
        Race race = new Race(cars);

    race.start(2);
    }
}
