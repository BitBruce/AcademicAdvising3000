/*
 * For unit testing purposes, not to be integrated into main solution.
 */
public class TestCaseRunner {
	
	public static void main(String[] args) {
		
		StudentModule run = new StudentModule();
		
		/*
		 * Test case: Simply print first student's name
		 */
		//System.out.println(run.getNameFromFirstStudent());
		
		/*
		 * Test case: Simply print first student's name
		 */
		//run.addStudent();
		//System.out.println(run.getNameFromAStudent(2));
		
		/*
		 * Test case: Get name from searching by ID
		 */
		//System.out.println(run.getStudentName(123));
		// The most interesting bug I've found. It prints 154. Integer.toString() and String.valueOf() does not work
		//System.out.println(0232);
		
		/*
		 * Test case: Print the info to the text file
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
	}
}
