package Others;

/*
 * Author : Satheeshkumar Karuppusamy, satheeshusc@gmail.com
 * 
 * Problem : Find the average marks for each student given the list of test results
 * 
 * Algorithm : Extract the list of marks belonging to each user. Sort them by using Comparator function which sorts the mark list for each user
 * 			   Calculate average from top 5 subjects for each student
 * 
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


public class FinalScoreQuestion{
 
   Map <Integer, Double> calculateFinalScores (List<TestResult> results) {
	   Map<Integer,ArrayList<TestResult>> studentMap = new HashMap<Integer, ArrayList<TestResult>>();
	   Map<Integer, Double> resultMap = new HashMap<Integer, Double>();
	   for(TestResult result : results){
		   Integer studentId = result.getStudentId();
		   if(studentMap.containsKey(studentId)){
			   ArrayList<TestResult> currentList = studentMap.get(studentId);
			   currentList.add(result);
			   studentMap.put(studentId, currentList);
		   }
		   else{
			   ArrayList<TestResult> currentList = new ArrayList<TestResult>();
			   currentList.add(result);
			   studentMap.put(studentId, currentList);
		   }
	   }
	   for(Entry<Integer, ArrayList<TestResult>> entry : studentMap.entrySet()){
		   Integer key = entry.getKey();
		   ArrayList<TestResult> markList = entry.getValue();
		   Collections.sort(markList, new MarksListSort());
		   int count = 0;
		   int total = 0;
		   Double average = 0.0;
		   for(TestResult t1 : markList){
			   total += t1.getTestScore();
			   count++;
			   if(count==5)
				   break;
		   }
		   average = (double) (total / 5);
		   resultMap.put(key, average);
	   }
	   return resultMap;
   }
   
}

class MarksListSort implements Comparator<TestResult>{

	@Override
	public int compare(TestResult result1, TestResult result2) {
	   // TODO Auto-generated method stub
	   int mark1 = result1.getTestScore();
	   int mark2 = result2.getTestScore();
	   if(mark1 > mark2)
			return -1;
	   else if(mark1 == mark2)
		   return 0;
	   else
		   return 1;
	}
}
