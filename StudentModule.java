import java.util.ArrayList;

public class StudentModule {

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
	public Student getStudent(String id) {
		
		for (Student i : students) {
			
			if (i.getIdNumber().equals(id)) {
				
				return i;
			}
		}
		
		return null;
	}
	
	/*
	 * Returns the list of all students
	 */
	public ArrayList<Student> getAllStudents() {
		
		return students;
	}
	
	/*
	 * Return a list of students whose date is before parameter date
	 */
	public ArrayList<Student> getStudentsByDate(String newDate) {
		
		ArrayList<Student> newStudents = new ArrayList<Student>();
		
		String date;
		
		for (Student i : students) {
			
			// if date is before, add to newStudents
			date = i.getDate();
			
			/*
			 *  I would ideally like to use a Date data type of some sort, or write a method to handle the specific parsing of date string, because the substrings below are messy
			 *  Interesting note: Something weird happens with leading zeros when Integer.parseInt();
			 *  IMPORTANT: Make sure date follows mm/dd/yyyy and not mm/d/yyyy etc.
			 */
			
			// if year < year
			if ( Integer.parseInt(date.substring(6, date.length())) < Integer.parseInt(newDate.substring(6, newDate.length())) )  {
				
				newStudents.add(i);
			}
			// else if year == year, compare months
			else if ( Integer.parseInt(date.substring(6, date.length())) == Integer.parseInt(newDate.substring(6, newDate.length())) ) {
				
				// if month < month
				if ( Integer.parseInt(date.substring(0, 2)) < Integer.parseInt(newDate.substring(0, 2)) ) {
					
					newStudents.add(i);
				}
				// else if month == month, compare days
				else if ( Integer.parseInt(date.substring(0, 2)) == Integer.parseInt(newDate.substring(0, 2)) ) {
					
					// if day < day
					if ( Integer.parseInt(date.substring(3, 5)) <= Integer.parseInt(newDate.substring(3, 5)) ) {
						
						newStudents.add(i);
					}
				}
			}
		}
		
		return newStudents;
	}
	
	/*
	 * Save students to file
	 */
	public void saveStudentInfo() {
		
		StudentSerializer.serializeStudentsToText(fileName, students);
	}
	
	/*
	 * Add a student
	 */
	public void addStudent(Student newStudent) {
		
		students.add(newStudent);
		
		this.saveStudentInfo();
	}

	/*
	 * Add more students from a new text file
	 */
	public void importStudents(String newFileName) {
		
		ArrayList<Student> newStudents = StudentSerializer.deserializeTextToStudents(newFileName);
		
		for (Student i : newStudents) {
			
			students.add(i);
		}
		
		this.saveStudentInfo();
	}
	
	/*
	 * Deletes a student
	 */
	public void deleteStudent(String id) {
		
		students.remove(getStudent(id));
		
		this.saveStudentInfo();
	}
}
