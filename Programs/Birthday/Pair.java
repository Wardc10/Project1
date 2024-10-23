public class Pair {
    private int people;
    private double avg;

    //Pair constructor that takes in 'people' as x value and the 'avg' as y value
    //this is solely for handling the x y points for the CSV file
    public Pair(int people, double avg){
        this.people = people;
        this.avg = avg;
    }

    //override the toString method to return "people,avg" for easy CSV exporting
    @Override
    public String toString(){
        return people + "," + avg;
    }
}
