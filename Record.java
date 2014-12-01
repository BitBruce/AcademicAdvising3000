import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.text.*;
import java.util.*;
class Record {
	
	JFrame frame1;
	public JPanel main;//from main menu
	
	public JPanel recordPanel;
	public String seekWord;
	
	
	public Record(JFrame frame, JPanel m){
		recordPanel = new JPanel(new GridBagLayout());
		frame1 = frame;
		main = m;
		
		recordMenu();
		
		displayPanel(recordPanel);
	}
	
	public void displayPanel(JPanel panel){
		frame1.getContentPane().removeAll();
		frame1.add(panel);
		frame1.repaint();
		frame1.setVisible(true);
	}
	public static String getCurrentTimeStamp() {
	    SimpleDateFormat sdfDate = new SimpleDateFormat("MM/dd/yyyy");
	    Date now = new Date();
	    String strDate = sdfDate.format(now);
	    return strDate;
	}
	public void recordMenu(){
		JLabel menuTitle = new JLabel("Record Advising");
		menuTitle.setFont(new Font("Arial", 2, 28));
		
		JLabel find = new JLabel("Enter Student Number");
		
		StudentModule run = new StudentModule();
		ArrayList<Student> students = run.getAllStudents();
		String [] ids = new String[students.size()];
		
		Student boom;
		for(int i = 0;i<students.size(); i++){
			boom = students.get(i);
			ids[i] = boom.getIdNumber();
		}
		JComboBox studentList = new JComboBox(ids);
		
		JButton submit = new JButton("Submit");//set this button
		submit.addActionListener(new ActionListener() {
							
					public void actionPerformed(ActionEvent e){
						seekWord = studentList.getSelectedItem().toString();
						StudentModule run = new StudentModule();
						Student boom = run.getStudent(seekWord);
						
						run.deleteStudent(seekWord);
						boom.setAdvising("Yes");
						String date = getCurrentTimeStamp();
						//also possibly change this advising date with current date
						run.addStudent(boom);
						displayPanel(main);

					}
				});
		JButton back = new JButton("Back");
		back.addActionListener(new ActionListener() {
							
					public void actionPerformed(ActionEvent e){
						//back to mainmenu
						displayPanel(main);
					}
				});


		GridBagConstraints con = new GridBagConstraints();
		Insets insets = frame1.getInsets();
						
		con.insets = new Insets(50, 50, 50, 50);
		recordPanel.add(menuTitle, con);
								
		con.insets = new Insets(10,10,10,10);
		
		con.gridx = 0;
		con.gridy = 2;
		recordPanel.add(find, con);
		con.gridx=1;
		recordPanel.add(studentList, con);
		
		con.gridy = 3;
		recordPanel.add(submit, con);
		con.gridx = 0;
		recordPanel.add(back, con);
		

	}
}