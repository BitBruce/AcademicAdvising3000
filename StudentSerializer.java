import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class StudentSerializer {
	
	/* 
	 * Creates an ArrayList of Student objects from parsing the text file
	 */
	public static ArrayList<Student> deserializeTextToStudents(String fileName) {
		
		ArrayList<String> studentText = new ArrayList<String>();
		ArrayList<Student> students = new ArrayList<Student>();
		
		try {
			
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			
			String line;
			
			// while the file still has text
			while ( ((line = br.readLine()) != null) ) {
				
				// TODO: Should skip a blank line so text file can be better organized
				
				helperCreateStudent(studentText, students);
				
				int lastIndex = line.lastIndexOf(":");
			    studentText.add(line.substring(lastIndex + 1).trim());
			}
			
			// this is here because the while loop stops before it creates the last student. rewrite this?
			helperCreateStudent(studentText, students);
			
			br.close();
		}
		catch(Exception e) {
			 System.out.println("Could not read file.");
			 System.out.println(e);
		}
		
		return students;		
	}
	
	/*
	 * Writes the ArrayList<Student> to the file
	 */
	public static void serializeStudentsToText(String fileName, ArrayList<Student> students) {
		
		PrintWriter writer;
		
		try {
			
			writer = new PrintWriter(fileName);
			
			for (Student i : students) {
				  writer.write("FirstName: " + i.getFirstName() + "\r\n");
				  writer.write("LastName: " + i.getLastName() + "\r\n");
				  writer.write("VID: " + i.getIdNumber() + "\r\n");
				  writer.write("Grade: " + i.getGrade() + "\r\n");
				  writer.write("Advising: " + i.getAdvising() + "\r\n");
				  writer.write("TotalGPA: " + i.getTotalGPA() + "\r\n");
				  writer.write("MajorGPA: " + i.getMajorGPA() + "\r\n");
				  writer.write("MajorCredits: " + i.getMajorCredits() + "\r\n");
				  writer.write("UpperLevelCredits: " + i.getUpperLevelCredits() + "\r\n");
				  writer.write("TotalCredits: " + i.getTotalCredits() + "\r\n");
				  writer.write("GradSubmissionDate: " + i.getGradSubmissionDate() + "\r\n");
				  writer.write("AcademicSubmissionDate: " + i.getAcademicAdvisingDate() + "\r\n");
			}
			
			writer.close();
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * PRIVATE: Adds a student to the arraylist from the arraylist of input strings
	 */
	private static void helperCreateStudent(ArrayList<String> studentText, ArrayList<Student> students) {

		// This method's function is to reduce code duplication in deserializeTextToStudents() until
		// it can successfully add the last student (fix while loop)
		
		if (studentText.size() > 11) {
			
			students.add(new Student(studentText.remove(0), studentText.remove(0), 
		    		studentText.remove(0), studentText.remove(0), studentText.remove(0), 
		    		studentText.remove(0), studentText.remove(0), studentText.remove(0), 
		    		studentText.remove(0), studentText.remove(0), studentText.remove(0), studentText.remove(0)));
			
			studentText = new ArrayList<String>();	
		}
	}
}
