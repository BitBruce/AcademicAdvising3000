import java.util.ArrayList;

/*
 * HOW TO USE:
 * 
 * Create a StudentModule object which will create an ArrayList of students from the text file.
 * Then call its methods.
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
		
		Student newStudent = getStudent(id);
		
		if (newStudent != null) {
			
			return (newStudent.getFirstName() + " " + newStudent.getLastName());
		}
		
		return "Student not found";
	}
	
	/*
	 * Search for a student by ID
	 */
	public Student getStudent(int id) {
		
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
}
