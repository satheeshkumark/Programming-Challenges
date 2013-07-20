package Others;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/*
 * Author : Satheeshkumar Karuppusamy, satheeshusc@gmail.com
 * 
 * Problem : Find the average marks for each student given the list of test results
 * 
 * Algorithm : Extract the list of marks belonging to each user. Sort them by using Comparator function which sorts the mark list for each user
 * 			   Calculate average from top 5 subjects for each student
 *
 * Runtime : O(n* mlogm)
 * 			 n - number of students
 * 			 m - highest number of tests attended by any student 
*/

public class FinalScoreQuestionMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestResult t1 = new TestResult(1,"1-Jan-2013",50);
		TestResult t2 = new TestResult(1,"1-Jan-2013",60);
		TestResult t3 = new TestResult(1,"1-Jan-2013",60);
		TestResult t4 = new TestResult(1,"1-Jan-2013",70);
		TestResult t5 = new TestResult(1,"1-Jan-2013",70);
		TestResult t6 = new TestResult(1,"1-Jan-2013",80);
		TestResult t7 = new TestResult(1,"1-Jan-2013",100);
		TestResult t11 = new TestResult(11,"11-Jan-2013",90);
		TestResult t12 = new TestResult(11,"1-Jan-2013",80);
		TestResult t13 = new TestResult(11,"1-Jan-2013",70);
		TestResult t14 = new TestResult(11,"1-Jan-2013",60);
		TestResult t15 = new TestResult(11,"1-Jan-2013",50);
		TestResult t16 = new TestResult(11,"1-Jan-2013",40);
		TestResult t17 = new TestResult(11,"1-Jan-2013",40);
		List<TestResult> testResults= new ArrayList<TestResult>();
		testResults.add(t1);
		testResults.add(t2);
		testResults.add(t3);
		testResults.add(t4);
		testResults.add(t5);
		testResults.add(t6);
		testResults.add(t7);
		testResults.add(t11);
		testResults.add(t12);
		testResults.add(t13);
		testResults.add(t14);
		testResults.add(t15);
		testResults.add(t16);
		testResults.add(t17);
		FinalScoreQuestion f1 = new FinalScoreQuestion();
		Map<Integer, Double> resultMap = f1.calculateFinalScores(testResults);
		
		for(Entry<Integer, Double> entry : resultMap.entrySet()){
			System.out.println("Student Id : " + entry.getKey());
			System.out.println("Average : " + entry.getValue());
		}
	}

}
