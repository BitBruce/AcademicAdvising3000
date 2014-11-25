
public class Student {
	
	/* Attributes */
	private String firstName;
	private String lastName;
	private String idNumber;
	private String grade;
	private String advising;
	private String totalGPA;
	private String majorGPA;
	private String majorCredits;
	private String upperLevelCredits;
	private String totalCredits;
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

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getAdvising() {
		return advising;
	}

	public void setAdvising(String advising) {
		this.advising = advising;
	}

	public String getTotalGPA() {
		return totalGPA;
	}

	public void setTotalGPA(String totalGPA) {
		this.totalGPA = totalGPA;
	}

	public String getMajorGPA() {
		return majorGPA;
	}

	public void setMajorGPA(String majorGPA) {
		this.majorGPA = majorGPA;
	}

	public String getMajorCredits() {
		return majorCredits;
	}

	public void setMajorCredits(String majorCredits) {
		this.majorCredits = majorCredits;
	}

	public String getUpperLevelCredits() {
		return upperLevelCredits;
	}

	public void setUpperLevelCredits(String upperLevelCredits) {
		this.upperLevelCredits = upperLevelCredits;
	}

	public String getTotalCredits() {
		return totalCredits;
	}

	public void setTotalCredits(String totalCredits) {
		this.totalCredits = totalCredits;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	// Constructor
	public Student(String firstName, String lastName, String idNumber,
			String grade, String advising, String totalGPA, String majorGPA,
			String majorCredits, String upperLevelCredits, String totalCredits,
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
		this.idNumber = "111";
		this.grade = "eSports";
		this.advising = "No";
		this.totalGPA = "2.5";
		this.majorGPA = "3.0";
		this.majorCredits = "45";
		this.upperLevelCredits = "49";
		this.totalCredits = "124";
		this.date = "01/01/2014";
	}
}
