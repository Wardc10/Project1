import java.util.Random;
import java.util.ArrayList;

public class Birthday {

    private Random random = new Random();

    //creates an arraylist of type Person, of size n, all with random birthdays (1-365)
    //Private because the 'sharedBirthdayAvg' is the only method that should use the 'createPeople' method
    private ArrayList<Person> createPeople(int n){
        ArrayList<Person> people = new ArrayList<Person>();
        //loop to create a random birthday for each person and add to the Person list (pList)
        for (int i=0; i<n; i++) {
            //Pick a Random day between 1 and 365
            int randomDay = random.nextInt(365) + 1;
            //add a new person with a random birthday to the list of people
            people.add(new Person(randomDay));
        }
        return people;
    }

    //method to create a list of type Person, with size of 'numPeople', and check  the probability that any 2 people share a birthday over 'runs' number of runs
    public double sharedBirthdayAvg(int runs, int numPeople) {
        //total number of runs where 2 people share a birthday
        int sharedRuns = 0;

        for(int i=0; i<runs; i++){
            //create the list of people for this run
            ArrayList<Person> pList = createPeople(numPeople);
            //keep track of whether current run has a bday match
            boolean match = false;
            //loop to compare each persons birthday to everyone else
            for (int j=0; j<pList.size(); j++) {
                for (int k=j+1; k<pList.size(); k++) {
                    if (pList.get(j).getBirthday() == pList.get(k).getBirthday()) {
                        //set match to true once we find one, and break out of this run
                        match = true;
                        break;
                    }
                }
                //break out of current run since we already found a match
                if(match == true){
                    break;
                }
            }
            //when you find a match add current run to the total of runs with shared bdays
            if(match == true){
                sharedRuns++;
            }
        }

        //create probability which is number of shared birthdays divided by total number of people
        double avg = sharedRuns/(double)runs;
        return avg;
    }
}