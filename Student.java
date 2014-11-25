
public class Student {
	
	/* Attributes */
	private String firstName;
	private String lastName;
	private int idNumber;
	private String grade;
	private boolean advising;
	private double totalGPA;
	private double majorGPA;
	private double majorCredits;
	private double upperLevelCredits;
	private double totalCredits;
	private String date;
	
	/* Accessors/Mutators */
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(int idNumber) {
		this.idNumber = idNumber;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public boolean isAdvising() {
		return advising;
	}
	public void setAdvising(boolean advising) {
		this.advising = advising;
	}
	public double getTotalGPA() {
		return totalGPA;
	}
	public void setTotalGPA(double totalGPA) {
		this.totalGPA = totalGPA;
	}
	public double getMajorGPA() {
		return majorGPA;
	}
	public void setMajorGPA(double majorGPA) {
		this.majorGPA = majorGPA;
	}
	public double getMajorCredits() {
		return majorCredits;
	}
	public void setMajorCredits(double majorCredits) {
		this.majorCredits = majorCredits;
	}
	public double getUpperLevelCredits() {
		return upperLevelCredits;
	}
	public void setUpperLevelCredits(double upperLevelCredits) {
		this.upperLevelCredits = upperLevelCredits;
	}
	public double getTotalCredits() {
		return totalCredits;
	}
	public void setTotalCredits(double totalCredits) {
		this.totalCredits = totalCredits;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	public Student(String firstName, String lastName, int idNumber,
			String grade, boolean advising, double totalGPA, double majorGPA,
			double majorCredits, double upperLevelCredits, double totalCredits,
			String date) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.idNumber = idNumber;
		this.grade = grade;
		this.advising = advising;
		this.totalGPA = totalGPA;
		this.majorGPA = majorGPA;
		this.majorCredits = majorCredits;
		this.upperLevelCredits = upperLevelCredits;
		this.totalCredits = totalCredits;
		this.date = date;
	}
	
	// Default Constructor
	public Student() {
		this.firstName = "Nate";
		this.lastName = "Whitehead";
		this.idNumber = 111;
		this.grade = "eSports";
		this.advising = false;
		this.totalGPA = 0;
		this.majorGPA = 0;
		this.majorCredits = 0;
		this.upperLevelCredits = 0;
		this.totalCredits = 0;
		this.date = "no date";
	}
}
