import java.util.ArrayList;

/*
 * HOW TO USE:
 * 
 * Create a StudentModule object which will create an ArrayList of students from the text file.
 * Then call its methods.
 */
public class StudentModule {
	
	// TODO: Retrieve info (send necessary info to front end)
		// 		Note: Currently, I'm just passing a Student object to him
	
	private static final String fileName = "StudentInfo.txt";
	private ArrayList<Student> students;
	
	/*
	 * Constructor: Initializes the students list
	 */
	public StudentModule() {
		
		students = StudentSerializer.deserializeTextToStudents(fileName);
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
	
	/*
	 * Flush students to file
	 */
	public void saveStudentInfo() {
		
		StudentSerializer.serializeStudentsToText(fileName, students);
	}
	
	/*
	 * Add a student
	 */
	public void addStudent() {
		
		Student newStudent = new Student();
		students.add(newStudent);
		
		// save file
	}

	/*
	 * Add more students from a new text file
	 */
	public void addMoreStudentsFromNewFile(String newFileName) {
		
		ArrayList<Student> newStudents = StudentSerializer.deserializeTextToStudents(newFileName);
		
		for (Student i : newStudents) {
			
			students.add(i);
		}
		
		// save file
	}
	
	/*
	 * Deletes a student from the list
	 */
	public void deleteStudent(int id) {
		
		students.remove(getStudent(id));
		
		// save file
	}
	
}
