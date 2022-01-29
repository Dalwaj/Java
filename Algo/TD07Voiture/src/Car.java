public class Car {
    private String name;
    private int[] coordonnees = {0,0};
    private String direction = "bottom";
    private int speed;
    private int nbLap = 0;

    public Car(String name, int speed) {
        this.name = name;
        this.speed = speed;
    }

    public String toString(){
        return this.name + " \nVitesse de pointe : " + this.speed*100 + "km/h";
    }

    public String toString2(){
        char firstLetter = name.toCharArray()[0];
        String car = "";
        /*
        if (direction == "left" ){
            car = "<"+firstLetter+"-|";
        } else if (direction == "right"){
            car = "|-"+firstLetter+">";
        } else if (direction == "top"){
            car = "^\n" +
                    firstLetter + "\n" +
                    "|\n" +
                    "_";
        } else if (direction == "bottom") {
            car = "_\n" +
                    "|\n" +
                    firstLetter + "\n" +
                    "v";
        }*/

        return car+firstLetter;
    }
    public String getName(){
        return this.name;
    }

    public int getRow() {
        return coordonnees[0];
    }

    public int getColumn(){
        return coordonnees[1];
    }

    public int getNbLap(){
        return nbLap;
    }

    public void setCoordonnees(int[] coordonnees){
        for (int i = 0; i < coordonnees.length; i++){
            this.coordonnees[i] = coordonnees[i];
        }
    }

    public boolean goOver(int[] startLine){
        return coordonnees[0] == startLine[0] && coordonnees[1] == startLine[1];
    }

    public void increaseNbLap() { nbLap++; }

    public void setDirection(String direction){
        this.direction = direction;
    }

    public String getDirection(){
        return this.direction;
    }

    public void moveForward(){
        if (direction == "right"){
            this.coordonnees[1]+=speed;
        } else if (direction == "left"){
            this.coordonnees[1]-=speed;
        } else if (direction == "top"){
            this.coordonnees[0]-=speed;
        }else if (direction == "bottom"){
            coordonnees[0]+=speed;
        } else {
            System.out.println("Erreur");
        }
    }

}