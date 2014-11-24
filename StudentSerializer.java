import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class StudentSerializer {
	private static final String fileName = "C:\\Users\\Geckomyecho\\workspace\\AcademicAdvising3000\\src\\StudentInfo.txt";
	
	/* 
	 * Creates an ArrayList of Student objects from parsing the text file
	 */
	public static ArrayList<Student> deserializeTextToStudents() {
		
		ArrayList<String> studentText = new ArrayList<String>();
		ArrayList<Student> students = new ArrayList<Student>();
		
		try {
			
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			
			String line;
			
			// while the file still has text
			while ( ((line = br.readLine()) != null) ) {
				
				// TODO: Should skip a blank line so text file can be better organized
				
				// if it encounters the next student, make a student object and reset the text arraylist
				helperAddStudent(studentText, students);
				
				//System.out.println("STUDENT TEXT SIZE = " + studentText.size());
				
				int lastIndex = line.lastIndexOf(":");
			    studentText.add(line.substring(lastIndex + 1).trim());
			    
			    //System.out.println("Line: " + line);
			    //System.out.println("Trim: " + line.substring(lastIndex + 1).trim());
			}
			
			// this is here because the while loop stops before it creates the last student
			helperAddStudent(studentText, students);
			
			br.close();
		}
		catch(Exception e) {
			 System.out.println("Could not read file.");
			 System.out.println(e);
		}
		
		return students;		
	}
	
	/*
	 * Adds a student to the arraylist from the arraylist of input strings
	 */
	private static void helperAddStudent(ArrayList<String> studentText, ArrayList<Student> students) {

		// This method's function is to reduce code duplication in deserializeTextToStudents() until
		// it can successfully add the last student (fix while loop)
		
		if (studentText.size() > 10) {
			
			/* String firstName, String lastName, 
			 * int idNumber, String grade, boolean advising, 
			 * double totalGPA, double majorGPA, double majorCredits, 
			 * double upperLevelCredits, double totalCredits, String date */
			
			students.add(new Student(studentText.remove(0), studentText.remove(0), 
		    		Integer.parseInt(studentText.remove(0)), studentText.remove(0), ((studentText.remove(0) == "Yes") ? true : false ), 
		    		Double.parseDouble(studentText.remove(0)), Double.parseDouble(studentText.remove(0)), Double.parseDouble(studentText.remove(0)), 
		    		Double.parseDouble(studentText.remove(0)), Double.parseDouble(studentText.remove(0)), studentText.remove(0)));
			
			studentText = new ArrayList<String>();	
		}
	}
}
