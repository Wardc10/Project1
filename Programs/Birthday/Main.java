public class Main{
    public static void main(String[] args){
        //initialize birthday Tester
        Tester t = new Tester();
        //testBirthdays loops from minPeople to maxPeople, testing if any 2 people share a birthday within their respective group
        //testBirthdays runs the simluation 'runs' number of times for each group of people and calculates the average that a shared bday is found
        //output is displayed on the terminal
        t.testBirthdays(10, 50, 10000);
        //graphBirthdays does the same as testBirthdays, but instead outputs the results to a CSV file
        t.graphBirthdays(10, 50, 10000);
    }
}