import java.util.ArrayList;

/*
 * HOW TO USE:
 * 
 * Create a StudentModule object which will create an ArrayList of students from the text file.
 * 
 */
public class StudentModule {
	
	private ArrayList<Student> students;
	
	public StudentModule() {
		students = StudentSerializer.deserializeTextToStudents();
	}
	
	/*
	 * Add a student
	 * TODO: Doesn't save the student yet.
	 */
	public String addStudent() {
		
		try {
			
			Student newStudent = new Student();
			students.add(newStudent);
			
		} catch (Exception e) {
			return "Failure to add a student.";
		}
		return "Successfully added a student.";
	}
	
	/*
	 * Search for a student's name by ID
	 */
	public String getStudentName(int id) {
		
		Student newStudent = findStudent(id);
		
		if (newStudent != null) {
			
			return (newStudent.getFirstName() + " " + newStudent.getLastName());
		}
		
		return "Student not found";
	}
	
	/*
	 * Search for a student by ID
	 */
	public Student findStudent(int id) {
		
		for (Student i : students) {
			
			if (i.getIdNumber() == id) {
				
				return i;
				
			}
		}
		
		return null;
	}
	
	/*
	 * Simply return ArrayList<Student>
	 */
	public ArrayList<Student> getAllStudents() {
		
		return students;
	}
	
	// TODO: Retrieve info (send necessary info to front end)
	// TODO: Save info to text file
	// TODO: Delete a student
	
	/*
	 * TEST CASES BELOW
	 
	public String getNameFromFirstStudent() {
		
		ArrayList<Student> students = StudentSerializer.deserializeTextToStudents();
		
		return (students.get(0).getFirstName() + " " + students.get(0).getLastName());
	}
	
	public String getNameFromAStudent(int num) {
		
		// if the text file isn't empty // if the list isn't empty
		if (students.size() > 0) {
			return (students.get(num).getFirstName() + " " + students.get(num).getLastName());
		} else {
			return "No students available.";
		}
	}
	*/
}
