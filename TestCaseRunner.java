/*
 * For unit testing purposes, not to be integrated into main solution.
 */
public class TestCaseRunner {
	
	public static void main(String[] args) {
		
		StudentModule run = new StudentModule();
		
		/*
		 * Test case: Print a new student to the text file
		 */
		//run.addStudent();
		//run.saveStudentInfo();
		
		/*
		 * Test case: Delete a student and save
		 */
		//run.deleteStudent(456);
		//run.saveStudentInfo();
		
		/*
		 * Test case: Read more students from another file and save to main file
		 */
		//run.addMoreStudentsFromNewFile("NewStudentsInfo.txt");
		//run.saveStudentInfo();
		
		/*
		 * Test case: Testing to see if changing a Student object that is in an ArrayList will change the object IN the ArrayList
		 */
		//Student stu = run.getStudent(123);
		//stu.setFirstName("Stu");
		//run.saveStudentInfo();
	}
}
