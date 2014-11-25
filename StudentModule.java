import java.util.ArrayList;

/*
 * HOW TO USE:
 * 
 * Create a StudentModule object which will create an ArrayList of students from the text file.
 * Then call its methods.
 */
public class StudentModule {
	
	// TODO: Retrieve info (send necessary info to front end)
	// Note: Currently, a Student object is just being passed to the front end

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
	 * Return an ArrayList<Student> before a date
	 */
	public ArrayList<Student> getStudentsByDate(String newDate) {
		
		ArrayList<Student> newStudents = new ArrayList<Student>();
		
		String date;
		
		for (Student i : students) {
			
			// if date is before, add to newStudents
			date = i.getDate();
			
			//System.out.println("Date: " + date);
			//System.out.println("Year: " + date.substring(6, date.length()));
			//System.out.println("Month: " + date.substring(0, 2));
			//System.out.println("Day: " + date.substring(3, 5));
			
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
	 * Flush students to file
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
	 * Deletes a student from the list
	 */
	public void deleteStudent(int id) {
		
		students.remove(getStudent(id));
		
		this.saveStudentInfo();
	}
}
