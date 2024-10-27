
import java.util.ArrayList;
import java.util.Random;

public class Game {

	//random number to generate winning door and guesses
	Random rand = new Random();

	//Tracker for # of wins with KEEPING or CHANGING the door
	int winsKeep = 0;
	int winsChange = 0;

	//method to create an arraylist of type Door to store n doors.
	public ArrayList<Door> createDoors(int n){
		ArrayList<Door> doors = new ArrayList<Door>();
		for(int i=0; i<n; i++){
			//create all doors with initial value of 0 (not a winning door).
			Door d = new Door(false);
			doors.add(d);
		}
		return doors;
	}

	//method to play the game, keeping the same door each time
	//this method takes in 'plays' # of plays, and 'd' # of doors to play with
	public double keepDoor(int plays, int doors) {
		for(int i=0; i<plays; i++) {
			ArrayList<Door> D = createDoors(doors);
			
			//pick a random index of 'doors' to be the winning door
			int winningDoor = rand.nextInt(D.size());
			//use that random number and change that index of 'doors' to 1 (indicating a win)
			D.get(winningDoor).setWin(true);
			//pick a random index of 'doors' to be the initial guess
			int guess = rand.nextInt(D.size());
            //since we're NOT changing doors here, so we can just count the win when the door at index 'guess' = 1
			if(D.get(guess).getWin() == true) {
				winsKeep++;
			}
		}
		double avg = (double)winsKeep / (double)plays;
		//System.out.println("keep: "+avg);
		return avg;
	}

	public double changeDoor(int plays, int doors) {
		for(int i=0; i<plays; i++) {
			ArrayList<Door> D = createDoors(doors);
            
			//pick a random index of 'doors' to be the winning door
			int winningDoor = rand.nextInt(D.size());
			//use that random number and change that index of 'doors' to 1 (indicating a win)
			D.get(winningDoor).setWin(true);
			//pick a random index of 'doors' to be the initial guess
			int ini_guess = rand.nextInt(D.size());
			//We can remove our ini_guess from the list since we're changing doors and can't choose the same one twice
			D.remove(ini_guess);
			//next open a known 'goat' (losing door)
			for(int j=0; j<D.size(); j++){
				//remove the first door that is NOT the winning door
				if((D.get(j).getWin() != true)){
					D.remove(j);
				}
			}

			//now make a 2nd guess
			int fin_guess = rand.nextInt(D.size());
			//if fin_guess value is 1 add to the wins
			if(D.get(fin_guess).getWin() == true){
				winsChange++;
			}
	    }
		double avg = (double)winsChange / (double)plays;
		//System.out.println("change "+avg);
        return avg;
    }

    //playGame method takes in the number of times you want to simulate the game, and number of doors to play with
    //Ex: playGame(10000, 3); will play the game 10,000 times with 3 doors
	//it will also output the avg probability of winning when keeping doors vs changing doors
	public void playGame(int plays, int doors){
			//if less than 3 doors, end program (not enough doors for this experiment)
			if(plays < 1){
				System.out.println("Number of plays must be a positive Integer!");
				return;
			}
			if(doors < 3){
				System.out.println("At least three(3) doors needed to play!");
				return;
			}
			double avgKeep = keepDoor(plays, doors); 
			double avgChange = changeDoor(plays, doors);
			System.out.println("Average probability of winning when keeping doors over '" + plays + "' plays, with " + doors + " doors: " + avgKeep); 
			System.out.println("Average probability of winning when changing doors over '" + plays + "' plays, with " + doors + " doors: " + avgChange);
	}
	
}

