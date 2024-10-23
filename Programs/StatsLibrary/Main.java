public class Main {
    public static void main(String[] args){

        //initialie TestStatsLibrary object
        TestStatsLibrary tester = new TestStatsLibrary();
        //populate the test array from '1.0' to 'd.d'. This is used for several tests
        tester.populateTestArray(10.0);
        //run the tests with the now populated array
        tester.testStatsFunctions();
        //print the results of our stats tests
        tester.printTestResults();
    }
}