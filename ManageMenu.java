import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class ManageMenu {
	
	public JPanel addStudent;
	
	JFrame frame1;//take out when put classes together
	
	public ManageMenu(){
		addStudent = new JPanel(new GridBagLayout());
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
	
	public void addStudentPanel(){
		
		JLabel menuTitle = new JLabel("Add Student");
		menuTitle.setFont(new Font("Arial", 2, 28));
				
		JLabel a = new JLabel("First Name");
		JLabel b = new JLabel("Last Name");
		JLabel c = new JLabel("Student Number");
		JLabel d = new JLabel("Grade");
		
		JButton submit = new JButton("Submit");
		JButton back = new JButton("Back");
		
		JTextField a1 = new JTextField();//First Name
		JTextField b1 = new JTextField();//Last Name
		JTextField c1 = new JTextField();//Student Number
		JTextField d1 = new JTextField();//Grade
		
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
		
		
		displayPanel(addStudent);
	}
}