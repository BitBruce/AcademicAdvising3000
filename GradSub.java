import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.text.*;
import java.util.*;
class GradSub {
	public JFrame frame1;
	public JPanel main;
	public JPanel gradPanel;
	public JPanel findStudent;
	public JPanel gradInput;
	public String seekWord;
	public JPanel recordGradPanel;
	
	public StudentModule stud;
	
	public GradSub(JFrame frame, JPanel m){
		frame1 = frame;
		main = m;
		
		stud = new StudentModule();
		findStudent = new JPanel(new GridBagLayout());
		gradPanel = new JPanel(new GridBagLayout());
		gradInput = new JPanel(new GridBagLayout());
		recordGradPanel = new JPanel(new GridBagLayout());
		recordGrad();
		gradMenu();
		findStudentPanel();
		displayPanel(gradPanel);
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
	
	public void gradMenu(){
			
				JLabel menuTitle = new JLabel("Graduation Submission");
				menuTitle.setFont(new Font("Arial", 2, 28));
				
				JButton record = new JButton("Record Grad Submission");
				record.setPreferredSize(new Dimension(200, 25));
				record.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e){
						displayPanel(recordGradPanel);
					}
				});
				
				JButton find = new JButton("Find Grad Student");
				find.setPreferredSize(new Dimension(200, 25));
				find.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e){
						displayPanel(findStudent);
					}
				});
				
				JButton mainMenu = new JButton("Main Menu");
				mainMenu.setPreferredSize(new Dimension(200, 25));
				mainMenu.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e){
						displayPanel(main);
					}
				});

				GridBagConstraints c = new GridBagConstraints();
				Insets insets = frame1.getInsets();
								
				c.insets = new Insets(50, 50, 50, 50);
				gradPanel.add(menuTitle, c);
				
				c.insets = new Insets(10,10,10,10);
				c.gridy = 2;
				gradPanel.add(find, c);
				
				c.gridy = 3;
				gradPanel.add(record, c);
				
				c.gridy = 4;
				gradPanel.add(mainMenu, c);
				

		}
		public void findStudentPanel(){
			JLabel menuTitle = new JLabel("Find Grad Student");
			menuTitle.setFont(new Font("Arial", 2, 28));
			
			JLabel find = new JLabel("Enter Student Number");			StudentModule run = new StudentModule();
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
							//find student at seekWord and get the appropriate Strings back
							Student test = stud.getStudent(seekWord);//test case
							gradSubmission(test);//use the found stuff
							
						}
					});
			JButton back = new JButton("Back");
			back.addActionListener(new ActionListener() {
								
						public void actionPerformed(ActionEvent e){
							//back to managePanel
							displayPanel(gradPanel);
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

		}
		
		public void gradSubmission(Student student){
			gradInput.removeAll();
			JLabel menuTitle = new JLabel(student.getFirstName() + " " + student.getLastName());
			menuTitle.setFont(new Font("Arial", 2, 28));
							
			JLabel a = new JLabel("Total GPA");
			JLabel b = new JLabel("Major GPA");
			JLabel c = new JLabel("Major Credits");
			JLabel d = new JLabel("Upper Level Credits");
			JLabel e = new JLabel("Total Credits");
				
			JTextField a1 = new JTextField(student.getTotalGPA(), 5);//GPA
			JTextField b1 = new JTextField(student.getMajorGPA(), 5);//Major GPA
			JTextField c1 = new JTextField(student.getMajorCredits(), 5);//Major Credits
			JTextField d1 = new JTextField(student.getUpperLevelCredits(), 5);//Upper Level Credits
			JTextField e1 = new JTextField(student.getTotalCredits(), 5);//total Credits
				
			JButton submit = new JButton("Submit");//set this button
			submit.addActionListener(new ActionListener() {
								
				public void actionPerformed(ActionEvent e){
					student.setTotalGPA(a1.getText());
					student.setMajorGPA(b1.getText());
					student.setMajorCredits(c1.getText());
					student.setUpperLevelCredits(d1.getText());
					student.setTotalCredits(e1.getText());
					StudentModule run = new StudentModule();
					run.deleteStudent(student.getIdNumber());
					run.addStudent(student);
					displayPanel(gradPanel);
					a1.setText(null);
					b1.setText(null);
					c1.setText(null);
					d1.setText(null);
					e1.setText(null);
								
					}
				});
			JButton back = new JButton("Back");
			back.addActionListener(new ActionListener() {
								
				public void actionPerformed(ActionEvent e){
					displayPanel(gradPanel);
					a1.setText(null);
					b1.setText(null);
					c1.setText(null);
					d1.setText(null);
					e1.setText(null);
				}
			});
					
			GridBagConstraints con = new GridBagConstraints();
			Insets insets = frame1.getInsets();
						
			con.insets = new Insets(50, 50, 50, 50);
			gradInput.add(menuTitle, con);
								
			con.insets = new Insets(10,10,10,10);
			
			con.gridx = 0;
			con.gridy = 2;
			gradInput.add(a, con);
			con.gridx=1;
			gradInput.add(a1, con);
				
			con.gridy = 3;
			gradInput.add(b1, con);
			con.gridx = 0;
			gradInput.add(b, con);
			
			con.gridy = 4;
			gradInput.add(c, con);
			con.gridx = 1;
			gradInput.add(c1, con);
					
			con.gridy = 5;
			gradInput.add(d1, con);
			con.gridx = 0;
			gradInput.add(d, con);
			
			con.gridy = 6;
			gradInput.add(e, con);
			con.gridx = 1;
			gradInput.add(e1, con);
			
			con.gridy = 7;
			gradInput.add(submit, con);
			con.gridx = 0;
			gradInput.add(back, con);
			gradInput.revalidate();
			displayPanel(gradInput);

			
			
		}
		public void recordGrad(){
			
				JLabel menuTitle = new JLabel("Record Grad Submission");
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
								String date = getCurrentTimeStamp();
								System.out.print(date);
								//add the date to gradsubdate
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
				recordGradPanel.add(menuTitle, con);
										
				con.insets = new Insets(10,10,10,10);
				
				con.gridx = 0;
				con.gridy = 2;
				recordGradPanel.add(find, con);
				con.gridx=1;
				recordGradPanel.add(studentList, con);
				
				con.gridy = 3;
				recordGradPanel.add(submit, con);
				con.gridx = 0;
				recordGradPanel.add(back, con);
		}
				


}