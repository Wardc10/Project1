import java.math.BigInteger;
import java.util.ArrayList;

public class TestStatsLibrary {

	//initialize the StatsLibrary
	private StatsLibrary test = new StatsLibrary();

	//initilize our array of userInputNumbers
	ArrayList<Double> userInputNumbers = new ArrayList<>();

	// Declare variables to hold test results
    private double meanResults;
    private double medianResults;
    private double modeResults;
    private double varianceResults;
    private double sdResults;
    private BigInteger factorialResult;
    private BigInteger permutationResults;
    private BigInteger combinationResults;
    private double geometricResults;
    private double binomialResults;
    private double hypergeometricResults;
    private double negativeBinomialResults;
    private double poissonResults;

	//this method will fill the userInputNumbers array with doubles from 1.0 to d
	public ArrayList<Double> populateTestArray(Double d){
		
		//fill array with values
		for(Double i=1.0; i<d; i++){
			userInputNumbers.add(i);
		}
		return userInputNumbers;
	}

	public void testStatsFunctions(){
		meanResults = test.findMean(userInputNumbers);
		medianResults = test.findMedian(userInputNumbers);
		modeResults = test.findMode(userInputNumbers);
		varianceResults = test.findVariance(userInputNumbers);
		sdResults = test.findSD(userInputNumbers);
		factorialResult = test.factorial(25);
		permutationResults = test.findPermutation(6, 4);
		combinationResults = test.findCombination(8, 3);
		geometricResults = test.geometric(0.4, 0.6, 3);
		binomialResults = test.binomial(5, 2, 0.4, 0.6);
		hypergeometricResults = test.hypergeometric(6, 4, 20, 5);
		negativeBinomialResults = test.negative_binomial(4, 2, 0.4, 0.6);
		poissonResults = test.poisson(1, 0);
	}

	public void printTestResults(){
		System.out.println("This is the mean of userInputNumbers: " + meanResults);
		System.out.println("This is the median of userInputNumbers: " + medianResults);
		System.out.println("This is the mode of userInputNumbers: " + modeResults);
		System.out.println("This is the variance of userInputNumbers: " + varianceResults);
		System.out.println("This is the Standard Deviation of userInputNumbers: " + sdResults);
		System.out.println("This is the BigInteger test of factorial: " + factorialResult);
		System.out.println("This is the Permutation: " +  permutationResults);
		System.out.println("This is the Combination: " +  combinationResults);
		System.out.println("This is the Geometric Distribution: " + geometricResults);
		System.out.println("This is the Binomial Distribution: " + binomialResults);
		System.out.println("This is the Hypergeometric Distribution: " + hypergeometricResults);
		System.out.println("This is the Negative Binomial Distribution: " + negativeBinomialResults);
		System.out.println("This is the Poisson Distribution: " + poissonResults);
	}

}
