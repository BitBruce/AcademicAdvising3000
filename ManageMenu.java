import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class ManageMenu {
	
	JFrame frame1;
	public JPanel main;//from main menu
	
	public JPanel addStudent;
	public JPanel editStudent;
	public JPanel findStudent;
	public JPanel deleteStudent;
	public JPanel managePanel;
	public String seekWord;
	public String [] general;
	
	public ManageMenu(JFrame frame, JPanel m){
		managePanel = new JPanel(new GridBagLayout());
		addStudent = new JPanel(new GridBagLayout());
		editStudent = new JPanel(new GridBagLayout());
		findStudent = new JPanel(new GridBagLayout());
		deleteStudent = new JPanel(new GridBagLayout());
		general = new String[4];
		//nothing
		frame1 = frame;
		main = m;
		

		
		manageMenu();
		addStudentPanel();
		deleteStudentPanel();
		findStudentPanel();
		//editStudentPanel will probably be a problem with going more than once to the screen
	}
	
	//prob take out when done testing
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
						displayPanel(findStudent);
					}
				});		
		
		JButton deleteStudentButton = new JButton("Delete Student");
		deleteStudentButton.setPreferredSize(new Dimension(200, 25));
		deleteStudentButton.addActionListener(new ActionListener() {
							
					public void actionPerformed(ActionEvent e){
						displayPanel(deleteStudent);
					}
				});
		
		JButton importStudentButton = new JButton("Import Student Text File");
		importStudentButton.setPreferredSize(new Dimension(200, 25));
		importStudentButton.addActionListener(new ActionListener() {
							
					public void actionPerformed(ActionEvent e){
						//have to add import capabilities
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

		JLabel menuTitle = new JLabel("Delete Student");
		menuTitle.setFont(new Font("Arial", 2, 28));
		
		JLabel find = new JLabel("Enter Student Number");
		JTextField find1 = new JTextField(5);//Student Number
		
		JButton submit = new JButton("Submit");//set this button
		submit.addActionListener(new ActionListener() {
							
					public void actionPerformed(ActionEvent e){
						seekWord = find1.getText();
						//delete student at seekWord
						displayPanel(managePanel);
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
		deleteStudent.add(find1, con);
		
		con.gridy = 3;
		deleteStudent.add(submit, con);
		con.gridx = 0;
		deleteStudent.add(back, con);
		
	}
	
	public void addStudentPanel(){
		
		JLabel menuTitle = new JLabel("Add Student");
		menuTitle.setFont(new Font("Arial", 2, 28));
				
		JLabel a = new JLabel("First Name");
		JLabel b = new JLabel("Last Name");
		JLabel c = new JLabel("Student Number");
		JLabel d = new JLabel("Grade");
		
		JTextField a1 = new JTextField(5);//First Name
		JTextField b1 = new JTextField(5);//Last Name
		JTextField c1 = new JTextField(5);//Student Number
		JTextField d1 = new JTextField(5);//Grade
		
		JButton submit = new JButton("Submit");//set this button
		submit.addActionListener(new ActionListener() {
							
					public void actionPerformed(ActionEvent e){
						general[0] = a1.getText();
						general[1] = b1.getText();
						general[2] = c1.getText();
						general[3] = d1.getText();
						//submit text fields and switch back to managePanel
						
						displayPanel(managePanel);
						
					}
				});
		JButton back = new JButton("Back");
		back.addActionListener(new ActionListener() {
							
					public void actionPerformed(ActionEvent e){
						//display managePanel
						displayPanel(managePanel);
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
		JLabel menuTitle = new JLabel("Edit Student");
		menuTitle.setFont(new Font("Arial", 2, 28));
		
		JLabel find = new JLabel("Enter Student Number");
		JTextField find1 = new JTextField(5);//Student Number
		
		JButton submit = new JButton("Submit");//set this button
		submit.addActionListener(new ActionListener() {
							
					public void actionPerformed(ActionEvent e){
						seekWord = find1.getText();
						//find student at seekWord and get the appropriate Strings back
						editStudentPanel("a","b","c","d");//use the found stuff
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
		findStudent.add(find1, con);
		
		con.gridy = 3;
		findStudent.add(submit, con);
		con.gridx = 0;
		findStudent.add(back, con);

	}
	public void editStudentPanel(String first, String last, String number, String grade){
		JLabel menuTitle = new JLabel("Edit Student");
		menuTitle.setFont(new Font("Arial", 2, 28));
		
		JLabel a = new JLabel("First Name");
		JLabel b = new JLabel("Last Name");
		JLabel c = new JLabel("Student Number");
		JLabel d = new JLabel("Grade");
		
		
		JTextField a1 = new JTextField(first, 5);//First Name
		JTextField b1 = new JTextField(last, 5);//Last Name
		JTextField c1 = new JTextField(number, 5);//Student Number
		JTextField d1 = new JTextField(grade, 5);//Grade
		
		JButton submit = new JButton("Submit");//set this button
		submit.addActionListener(new ActionListener() {
							
					public void actionPerformed(ActionEvent e){
						general[0] = a1.getText();
						general[1] = b1.getText();
						general[2] = c1.getText();
						general[3] = d1.getText();
						//send general to back end and display managePanel
						
						displayPanel(managePanel);
					}
				});
		JButton back = new JButton("Back");
		back.addActionListener(new ActionListener() {
							
					public void actionPerformed(ActionEvent e){
						//switch back to managePanel
						displayPanel(managePanel);
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
		
		
		displayPanel(editStudent);
	}
}