public class Door {
    private boolean win;

    //default door constructor
    public Door(boolean win){
        this.win = win;
    } 

    //getter for door value
    public boolean getWin(){
        return win;
    }

    //setter for door value
    public void setWin(boolean win){
        this.win = win;
    }
}
