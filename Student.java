
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
	private String gradSubmissionDate;
	private String academicAdvisingDate;

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
	
	public String getGradSubmissionDate() {
		return gradSubmissionDate;
	}

	public void setGradSubmissionDate(String gradSubmissionDate) {
		this.gradSubmissionDate = gradSubmissionDate;
	}

	public String getAcademicAdvisingDate() {
		return academicAdvisingDate;
	}

	public void setAcademicAdvisingDate(String academicAdvisingDate) {
		this.academicAdvisingDate = academicAdvisingDate;
	}
	
	// Constructor
	public Student(String firstName, String lastName, String idNumber,
			String grade, String advising, String totalGPA, String majorGPA,
			String majorCredits, String upperLevelCredits, String totalCredits,
			String gradSubmissionDate, String academicAdvisingDate) {
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
		this.gradSubmissionDate = gradSubmissionDate;
		this.academicAdvisingDate = academicAdvisingDate;
	}

	// Default Constructor
	public Student() {
		this.firstName = "FirstName";
		this.lastName = "LastName";
		this.idNumber = "000";
		this.grade = "freshman";
		this.advising = "No";
		this.totalGPA = "0.0";
		this.majorGPA = "0.0";
		this.majorCredits = "0";
		this.upperLevelCredits = "0";
		this.totalCredits = "0";
		this.gradSubmissionDate = "01/01/2014";
		this.academicAdvisingDate = "01/01/2014";
	}
}
