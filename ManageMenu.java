import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.nio.file.Path;
import java.io.File;
import java.util.ArrayList;
class ManageMenu {
	
	public JFrame frame1;
	public JPanel main;//from main menu
	
	public JPanel addStudent;
	public JPanel editStudent;
	public JPanel findStudent;
	public JPanel deleteStudent;
	public JPanel managePanel;
	public String seekWord;
	
	public ManageMenu(JFrame frame, JPanel m){
		managePanel = new JPanel(new GridBagLayout());
		addStudent = new JPanel(new GridBagLayout());
		editStudent = new JPanel(new GridBagLayout());
		findStudent = new JPanel(new GridBagLayout());
		deleteStudent = new JPanel(new GridBagLayout());
		//nothing
		frame1 = frame;
		main = m;
		
		manageMenu();
		addStudentPanel();
	}
	
	public void displayPanel(JPanel panel){
		frame1.getContentPane().removeAll();
		frame1.add(panel);
		frame1.repaint();
		frame1.setVisible(true);
	}
	
	public void manageMenu(){
		
		JLabel menuTitle = new JLabel("Manage Student Info");
		menuTitle.setFont(new Font("Arial", 2, 28));
		
		JButton addStudentButton = new JButton("Add Student");
		addStudentButton.setPreferredSize(new Dimension(200, 25));
		addStudentButton.addActionListener(new ActionListener() {
							
					public void actionPerformed(ActionEvent e){
						displayPanel(addStudent);
					}
				});
		
		JButton editStudentButton = new JButton("Edit Student");
		editStudentButton.setPreferredSize(new Dimension(200, 25));
		editStudentButton.addActionListener(new ActionListener() {
							
					public void actionPerformed(ActionEvent e){
						findStudentPanel();
					}
				});		
		
		JButton deleteStudentButton = new JButton("Delete Student");
		deleteStudentButton.setPreferredSize(new Dimension(200, 25));
		deleteStudentButton.addActionListener(new ActionListener() {
							
					public void actionPerformed(ActionEvent e){
						deleteStudentPanel();
					}
				});
		
		JButton importStudentButton = new JButton("Import Student Text File");
		importStudentButton.setPreferredSize(new Dimension(200, 25));
		importStudentButton.addActionListener(new ActionListener() {
							
					public void actionPerformed(ActionEvent e){
						//import capabilities
						File input;
						String filename, dir;
						JFileChooser c = new JFileChooser();
					 	// Demonstrate "Open" dialog:
					 	int rVal = c.showOpenDialog(managePanel);
						input = new File(c.getSelectedFile().getPath());
					    filename= c.getSelectedFile().getName();
					    dir = c.getCurrentDirectory().toString();
				  	    
						//CALL IMPORT METHOD
						StudentModule run = new StudentModule();
						run.importStudents(String.valueOf(input));
						//System.out.println(String.valueOf(input));
					}
				});
		
		JButton mainMenuButton = new JButton("Main Menu");
		mainMenuButton.setPreferredSize(new Dimension(200, 25));
		mainMenuButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				displayPanel(main);
			}
		});
		
		GridBagConstraints c = new GridBagConstraints();
		Insets insets = frame1.getInsets();
		
		c.insets = new Insets(50, 50, 50, 50);
		managePanel.add(menuTitle, c);
				
		c.insets = new Insets(10,10,10,10);
		c.gridx = 0;
		c.gridy = 2;
		managePanel.add(addStudentButton, c);
		c.gridy = 3;
		managePanel.add(editStudentButton, c);
		c.gridy = 4;
		managePanel.add(deleteStudentButton, c);
		c.gridy = 5;
		managePanel.add(importStudentButton, c);
		c.gridy = 6;
		managePanel.add(mainMenuButton, c);
		
		displayPanel(managePanel);

	}
	

	//give vnumber to delete
	public void deleteStudentPanel(){
		deleteStudent.removeAll();
		JLabel menuTitle = new JLabel("Delete Student");
		menuTitle.setFont(new Font("Arial", 2, 28));
		
		JLabel find = new JLabel("Enter Student Number");
		
		StudentModule run = new StudentModule();
		ArrayList<Student> students = run.getAllStudents();
		String [] ids = new String[students.size()];
		
		Student boom;
		for(int i = 0;i<students.size(); i++){
			boom = students.get(i);
			ids[i] = boom.getIdNumber() + " " + boom.getFirstName() + " " + boom.getLastName();
		}
		JComboBox studentList = new JComboBox(ids);
		
		JButton submit = new JButton("Submit");//set this button
		submit.addActionListener(new ActionListener() {
							
					public void actionPerformed(ActionEvent e){
						seekWord = studentList.getSelectedItem().toString();
						String[] array = seekWord.split(" ");
						//delete student at seekWord
						StudentModule run = new StudentModule();

						makeSure(run.getStudent(array[0]));
						
						/*run.deleteStudent(seekWord);//need to add popup
						displayPanel(managePanel);*/
					}
				});
		JButton back = new JButton("Back");
		back.addActionListener(new ActionListener() {
							
					public void actionPerformed(ActionEvent e){
						//back to managePanel
						displayPanel(managePanel);
					}
				});
		
		GridBagConstraints con = new GridBagConstraints();
		Insets insets = frame1.getInsets();
						
		con.insets = new Insets(50, 50, 50, 50);
		deleteStudent.add(menuTitle, con);
								
		con.insets = new Insets(10,10,10,10);
		
		con.gridx = 0;
		con.gridy = 2;
		deleteStudent.add(find, con);
		con.gridx=1;
		deleteStudent.add(studentList, con);
		
		con.gridy = 3;
		deleteStudent.add(submit, con);
		con.gridx = 0;
		deleteStudent.add(back, con);
		displayPanel(deleteStudent);
		
	}
	public void makeSure(Student student){
		JFrame makeSureFrame = new JFrame("Delete Student");
		makeSureFrame.setSize (370,100);
		JPanel panel = new JPanel();
		
		JLabel x = new JLabel("Are you sure you want to delete " + student.getFirstName() + " " + student.getLastName() +"?");
		JButton submit = new JButton("I'm Sure");//set this button
		submit.addActionListener(new ActionListener() {
							
					public void actionPerformed(ActionEvent e){
						//delete the student at sekword
						StudentModule run = new StudentModule();
						run.deleteStudent(student.getIdNumber());
						//display deletepanel or just close frame
						makeSureFrame.dispatchEvent(new WindowEvent(makeSureFrame, WindowEvent.WINDOW_CLOSING));
						displayPanel(managePanel);
					}
				});
		JButton back = new JButton("Cancel");
		back.addActionListener(new ActionListener() {
							
					public void actionPerformed(ActionEvent e){
						//display deletepanel or just close frame
						makeSureFrame.dispatchEvent(new WindowEvent(makeSureFrame, WindowEvent.WINDOW_CLOSING));
					}
				});
				
		
		GridBagConstraints con = new GridBagConstraints();
		con.insets = new Insets(10,10,10,10);
		
		con.gridy = 0;
		con.gridx = 0;
		panel.add(x, BorderLayout.NORTH);
		con.gridy = 1;
		panel.add(back, con);
		con.gridx = 1;
		panel.add(submit, con);
		
		makeSureFrame.getContentPane().removeAll();
		makeSureFrame.add(panel);
		makeSureFrame.setLocationRelativeTo(null);
		makeSureFrame.pack();
		makeSureFrame.setVisible(true);
		
	}
	
	public void addStudentPanel(){
		
		JLabel menuTitle = new JLabel("Add Student");
		menuTitle.setFont(new Font("Arial", 2, 28));
				
		JLabel a = new JLabel("First Name");
		JLabel b = new JLabel("Last Name");
		JLabel c = new JLabel("Student Number");
		JLabel d = new JLabel("Grade");
		
		JTextField a1 = new JTextField(7);//First Name
		JTextField b1 = new JTextField(7);//Last Name
		JTextField c1 = new JTextField(7);//Student Number
		JTextField d1 = new JTextField(7);//Grade
		
		JButton submit = new JButton("Submit");//set this button
		submit.addActionListener(new ActionListener() {
							
					public void actionPerformed(ActionEvent e){
						Student boom = new Student();
						boom.setFirstName(a1.getText());
						boom.setLastName(b1.getText());
						boom.setIdNumber(c1.getText());
						boom.setGrade(d1.getText());
						boom.setGradSubmissionDate("");
						boom.setAcademicAdvisingDate("");
						//these are just for no errors, could have done this with contructor go back and fix
						boom.setAdvising("No");
						boom.setTotalGPA("");
						boom.setMajorGPA("");
						boom.setTotalCredits("");
						boom.setMajorCredits("");
						boom.setUpperLevelCredits("");
						//submit text fields and switch back to managePanel
						StudentModule run = new StudentModule();
						run.addStudent(boom);
						displayPanel(managePanel);
						a1.setText(null);
						b1.setText(null);
						c1.setText(null);
						d1.setText(null);
						
					}
				});
		JButton back = new JButton("Back");
		back.addActionListener(new ActionListener() {
							
					public void actionPerformed(ActionEvent e){
						//display managePanel
						displayPanel(managePanel);
						a1.setText(null);
						b1.setText(null);
						c1.setText(null);
						d1.setText(null);
					}
				});
		
		GridBagConstraints con = new GridBagConstraints();
		Insets insets = frame1.getInsets();
				
		con.insets = new Insets(50, 50, 50, 50);
		addStudent.add(menuTitle, con);
						
		con.insets = new Insets(10,10,10,10);
		
		con.gridx = 0;
		con.gridy = 2;
		addStudent.add(a, con);
		con.gridx=1;
		addStudent.add(a1, con);
		
		con.gridy = 3;
		addStudent.add(b1, con);
		con.gridx = 0;
		addStudent.add(b, con);
		
		con.gridy = 4;
		addStudent.add(c, con);
		con.gridx = 1;
		addStudent.add(c1, con);
		
		con.gridy = 5;
		addStudent.add(d1, con);
		con.gridx = 0;
		addStudent.add(d, con);
		
		con.gridy = 6;
		addStudent.add(back, con);
		con.gridx = 1;
		addStudent.add(submit, con);

		
	}
	
	public void findStudentPanel(){
		findStudent.removeAll();
		JLabel menuTitle = new JLabel("Edit Student");
		menuTitle.setFont(new Font("Arial", 2, 28));
		
		JLabel find = new JLabel("Enter Student Number");

		
		StudentModule run = new StudentModule();
		ArrayList<Student> students = run.getAllStudents();
		String [] ids = new String[students.size()];
		
		Student boom;
		for(int i = 0;i<students.size(); i++){
			boom = students.get(i);
			ids[i] = boom.getIdNumber() + " " + boom.getFirstName() + " " + boom.getLastName();
		}
		
		JComboBox studentList = new JComboBox(ids);
		JButton submit = new JButton("Submit");//set this button
		submit.addActionListener(new ActionListener() {
							
					public void actionPerformed(ActionEvent e){
						seekWord = studentList.getSelectedItem().toString();
						String[] array = seekWord.split(" ");
						//find student at seekWord and get the appropriate Strings back
						StudentModule run = new StudentModule();
						Student test = run.getStudent(array[0]);//change to string
						run.deleteStudent(array[0]);
						System.out.print(test.getFirstName());
						editStudentPanel(test);//use the found stuff

					}
				});
		JButton back = new JButton("Back");
		back.addActionListener(new ActionListener() {
							
					public void actionPerformed(ActionEvent e){
						//back to managePanel
						displayPanel(managePanel);
					}
				});
		
		GridBagConstraints con = new GridBagConstraints();
		Insets insets = frame1.getInsets();
						
		con.insets = new Insets(50, 50, 50, 50);
		findStudent.add(menuTitle, con);
								
		con.insets = new Insets(10,10,10,10);
		
		con.gridx = 0;
		con.gridy = 2;
		findStudent.add(find, con);
		con.gridx=1;
		findStudent.add(studentList, con);
		
		con.gridy = 3;
		findStudent.add(submit, con);
		con.gridx = 0;
		findStudent.add(back, con);
		
		displayPanel(findStudent);

	}
	public void editStudentPanel(Student student){
		editStudent.removeAll();
		JLabel menuTitle = new JLabel("Edit Student");
		menuTitle.setFont(new Font("Arial", 2, 28));
		
		JLabel a = new JLabel("First Name");
		JLabel b = new JLabel("Last Name");
		JLabel c = new JLabel("Student Number");
		JLabel d = new JLabel("Grade");

		
		JTextField a1 = new JTextField(student.getFirstName(), 7);//First Name
		JTextField b1 = new JTextField(student.getLastName(), 7);//Last Name
		JTextField c1 = new JTextField(student.getIdNumber(), 7);//Student Number
		JTextField d1 = new JTextField(student.getGrade(), 7);//Grade

		
		JButton submit = new JButton("Submit");//set this button
		submit.addActionListener(new ActionListener() {
							
					public void actionPerformed(ActionEvent e){
						student.setFirstName(a1.getText());
						student.setLastName(b1.getText());
						student.setIdNumber(c1.getText()); 
						student.setGrade(d1.getText());
						//set submission
						//send general to back end and display managePanel
						StudentModule run = new StudentModule();
						run.addStudent(student);
						displayPanel(managePanel);
						a1.setText(null);
						b1.setText(null);
						c1.setText(null);
						d1.setText(null);
						
					}
				});
		JButton back = new JButton("Back");
		back.addActionListener(new ActionListener() {
							
					public void actionPerformed(ActionEvent e){
						student.setFirstName(a1.getText());
						student.setLastName(b1.getText());
						student.setIdNumber(c1.getText());
						student.setGrade(d1.getText());

						//set submission
						//send general to back end and display managePanel
						StudentModule run = new StudentModule();
						run.addStudent(student);
						
						//switch back to managePanel
						displayPanel(managePanel);
						a1.setText(null);
						b1.setText(null);
						c1.setText(null);
						d1.setText(null);
						
					}
				});
		
		GridBagConstraints con = new GridBagConstraints();
		Insets insets = frame1.getInsets();
				
		con.insets = new Insets(50, 50, 50, 50);
		editStudent.add(menuTitle, con);
						
		con.insets = new Insets(10,10,10,10);
		
		con.gridx = 0;
		con.gridy = 2;
		editStudent.add(a, con);
		con.gridx=1;
		editStudent.add(a1, con);
		
		con.gridy = 3;
		editStudent.add(b1, con);
		con.gridx = 0;
		editStudent.add(b, con);
		
		con.gridy = 4;
		editStudent.add(c, con);
		con.gridx = 1;
		editStudent.add(c1, con);
		
		con.gridy = 5;
		editStudent.add(d1, con);
		con.gridx = 0;
		editStudent.add(d, con);
		
		con.gridy = 6;
		editStudent.add(back, con);
		con.gridx = 1;
		editStudent.add(submit, con);
		
		editStudent.revalidate();
		displayPanel(editStudent);
	}
}