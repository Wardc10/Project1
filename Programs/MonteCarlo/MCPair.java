public class MCPair {
    private int sims;
    private double avg;

    //Pair constructor that takes in 'people' as x value and the 'avg' as y value
    public MCPair(int sims, double avg){
        this.sims = sims;
        this.avg = avg;
    }

    //override the toString method to return "sims,avg" for easy CSV exporting
    @Override
    public String toString(){
        return sims + "," + avg;
    }
}