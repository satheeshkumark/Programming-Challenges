package Others;

/* @author satheeshkumark
 * 
 * Basic class for FinalScoreQuestion Problem */

public class TestResult {
	private int studentId;
	private String testDate;
	private int testScore;
	
	public TestResult(){
		
	}
	
	public TestResult(int studentId, String testDate, int testScore){
		this.setStudentId(studentId);
		this.setTestDate(testDate);
		this.setTestScore(testScore);
	}
	
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getTestDate() {
		return testDate;
	}
	public void setTestDate(String testDate) {
		this.testDate = testDate;
	}
	public int getTestScore() {
		return testScore;
	}
	public void setTestScore(int testScore) {
		this.testScore = testScore;
	}
	
}