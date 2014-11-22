import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class ManageMenu {
	
	public JPanel addStudent;
	public JPanel editStudent;
	public JPanel findStudent;
	public JPanel deleteStudent;
	
	JFrame frame1;//take out when put classes together
	
	public ManageMenu(){
		addStudent = new JPanel(new GridBagLayout());
		editStudent = new JPanel(new GridBagLayout());
		findStudent = new JPanel(new GridBagLayout());
		deleteStudent = new JPanel(new GridBagLayout());
		//nothing
		frame1 = new JFrame ("Academic Advising 3000");
		//Set its size to 800x200 pixels
		frame1.setSize (400,400);
		//Prepare panel
		frame1.setLocationRelativeTo(null);
	}
	
	//prob take out when done testing
	public void displayPanel(JPanel panel){
		frame1.getContentPane().removeAll();
		frame1.add(panel);
		frame1.repaint();
		frame1.setVisible(true);
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
						//delete student
					}
				});
		JButton back = new JButton("Back");
		back.addActionListener(new ActionListener() {
							
					public void actionPerformed(ActionEvent e){
						//back to managePanel
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
		
		displayPanel(deleteStudent);
	}
	
	public void addStudentPanel(){
		
		JLabel menuTitle = new JLabel("Add Student");
		menuTitle.setFont(new Font("Arial", 2, 28));
				
		JLabel a = new JLabel("First Name");
		JLabel b = new JLabel("Last Name");
		JLabel c = new JLabel("Student Number");
		JLabel d = new JLabel("Grade");
		
		JButton submit = new JButton("Submit");//set this button
		submit.addActionListener(new ActionListener() {
							
					public void actionPerformed(ActionEvent e){
						//display managePanel
					}
				});
		JButton back = new JButton("Back");
		back.addActionListener(new ActionListener() {
							
					public void actionPerformed(ActionEvent e){
						//submit text fields and switch back to managePanel
					}
				});
		
		JTextField a1 = new JTextField(5);//First Name
		JTextField b1 = new JTextField(5);//Last Name
		JTextField c1 = new JTextField(5);//Student Number
		JTextField d1 = new JTextField(5);//Grade
		
		
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
		
		//take this out when done
		displayPanel(addStudent);
	}
	
	public void findStudentPanel(){
		JLabel menuTitle = new JLabel("Edit Student");
		menuTitle.setFont(new Font("Arial", 2, 28));
		
		JLabel find = new JLabel("Enter Student Number");
		JTextField find1 = new JTextField(5);//Student Number
		
		JButton submit = new JButton("Submit");//set this button
		submit.addActionListener(new ActionListener() {
							
					public void actionPerformed(ActionEvent e){
						//find student
						editStudentPanel("a","b","c","d");//use the found stuff
					}
				});
		JButton back = new JButton("Back");
		back.addActionListener(new ActionListener() {
							
					public void actionPerformed(ActionEvent e){
						//back to managePanel
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
		
		displayPanel(findStudent);
	}
	public void editStudentPanel(String first, String last, String number, String grade){
		JLabel menuTitle = new JLabel("Edit Student");
		menuTitle.setFont(new Font("Arial", 2, 28));
		
		JLabel a = new JLabel("First Name");
		JLabel b = new JLabel("Last Name");
		JLabel c = new JLabel("Student Number");
		JLabel d = new JLabel("Grade");
		
		JButton submit = new JButton("Submit");//set this button
		submit.addActionListener(new ActionListener() {
							
					public void actionPerformed(ActionEvent e){
						//display managePanel
					}
				});
		JButton back = new JButton("Back");
		back.addActionListener(new ActionListener() {
							
					public void actionPerformed(ActionEvent e){
						//submit text fields and switch back to managePanel
					}
				});
		
		JTextField a1 = new JTextField(first, 5);//First Name
		JTextField b1 = new JTextField(last, 5);//Last Name
		JTextField c1 = new JTextField(number, 5);//Student Number
		JTextField d1 = new JTextField(grade, 5);//Grade
		
		
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
		
		//take this out when done
		displayPanel(editStudent);
	}
}