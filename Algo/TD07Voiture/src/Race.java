import java.util.Random;
import java.lang.Thread;

public class Race {
    Car cars[];
    String[][] map = {{"X","X","X","X","X","X","X","X","X","X"},
                      {"X","X","X","X","X","X"," "," "," ","X"},
                      {"X"," "," "," "," ","X"," ","X"," ","X"},
                      {"X"," ","X","X"," ","X"," ","X"," ","X"},
                      {"X"," ","X","X"," ","X"," ","X"," ","X"},
                      {"X"," ","X","X"," "," "," ","X"," ","X"},
                      {"X"," ","X","X","X","X","X","X"," ","X"},
                      {"X"," ","X"," "," "," "," ","X"," ","X"},
                      {"X"," "," "," ","X","X"," "," "," ","X"},
                      {"X","X","X","X","X","X","X","X","X","X"}};

    public Race(Car cars[]){
        this.cars = cars;
    }

    public String toString(){
        String s = "Race : \n";

        for (Car car : cars) {
            s += car.toString();
        }

        printMap(map);

        return s;
    }

    private void printMap(String[][] map){
        for (String[] row : map){
            for(String road : row){
                System.out.print(road + " ");
            }
            System.out.println();
        }
    }

    private String[][] refreshMap(){
        String[][] map = new String[this.map.length][this.map.length];
        for (int i = 0; i < map.length; i++){
            for (int j = 0; j < map[i].length; j++){
                map[i][j] = this.map[i][j];
            }
        }

        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map.length; j++){
                for (Car car : cars){
                    map[car.getRow()][car.getColumn()] =car.toString2();
                }
            }
        }

        return map;
    }

    private Car selectCarMove(Car[] cars){
        Random rand = new Random();
        int random = rand.nextInt(cars.length);
        return cars[random];
    }

    public void setDirections(){
        for (Car car : cars){
            if (car.getDirection()=="bottom"){
                if (map[car.getRow()+1][car.getColumn()] == " "){
                } else if (map[car.getRow()][car.getColumn()+1] == " "){
                    car.setDirection("right");
                } else if (map[car.getRow()][car.getColumn()-1] == " "){
                    car.setDirection(("left"));
                }
            } else if (car.getDirection()=="right"){
                if (map[car.getRow()][car.getColumn()+1] == " "){
                } else if (map[car.getRow()-1][car.getColumn()] == " "){
                    car.setDirection("top");
                } else if (map[car.getRow()+1][car.getColumn()] == " "){
                    car.setDirection(("bottom"));
                }
            } else if (car.getDirection()=="top"){
                if (map[car.getRow()-1][car.getColumn()] == " "){
                } else if (map[car.getRow()][car.getColumn()-1] == " "){
                    car.setDirection("left");
                } else if (map[car.getRow()][car.getColumn()+1] == " "){
                    car.setDirection(("right"));
                }
            } else if (car.getDirection()=="left"){
                if (map[car.getRow()][car.getColumn()-1] == " "){
                } else if (map[car.getRow()-1][car.getColumn()] == " "){
                    car.setDirection("top");
                } else if (map[car.getRow()+1][car.getColumn()] == " "){
                    car.setDirection(("bottom"));
                }
            } else {
                System.out.println("erreur");
            }
        }
    }

    private void progress() {
        Car carToMove = selectCarMove(cars);

        carToMove.moveForward();

        if (carToMove.goOver(new int[] {2, 1})){
            carToMove.increaseNbLap();
        }
    }

    public Car start(int nbLaps) throws InterruptedException {
        Car winner = null;
        boolean isFinished = false;

        for(Car car : cars){
            car.setCoordonnees(new int[] {2,1});
        }

        this.toString();

        while(!isFinished){
            progress();
            setDirections();
            this.printMap(refreshMap());

            for (Car car : cars){
                System.out.println(car.getName() + " : " + car.getNbLap() + "/" + nbLaps);
            }

            Thread.sleep(200);
            System.out.print("\033[H\033[2J");

            for (int i = 0; !isFinished && i < cars.length; i++){
                if (cars[i].getNbLap() == nbLaps){
                    winner = cars[i];
                    isFinished = true;
                }
            }
            }

        printWinner(winner);
        return winner;
    }

    public static void printWinner(Car car){
        System.out.println("Le vainqueur est : \n" + car);
    }

    private static int indexOf(Object object, Object[] objects){
        int index = -1;
        for (int i = 0; i < objects.length; i++){
            if (objects[i] == object){
                index = i;
            }
        }

        return index;
    }
}
