import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

class Reports {
	public JPanel reportsPanel;
	public JFrame frame1;
	public JPanel main;
	
	public JPanel advisingReportChoicePanel;
	public JPanel advisingReportPanel;
	public JPanel gradReportPanel;
	
	public Reports(JFrame frame, JPanel m){
		frame1 = frame;
		main = m;
		
		reportsPanel = new JPanel(new GridBagLayout());
		advisingReportPanel = new JPanel(new GridBagLayout());
		advisingReportChoicePanel = new JPanel(new GridBagLayout());
		gradReportPanel = new JPanel(new GridBagLayout());
		reportsMenu();
		displayPanel(reportsPanel);
		
	}
	
	public void displayPanel(JPanel panel){
		frame1.getContentPane().removeAll();
		frame1.add(panel);
		frame1.repaint();
		frame1.setVisible(true);
	}
	
	public void reportsMenu(){
		reportsPanel.removeAll();
		JLabel menuTitle = new JLabel("Reports");
		menuTitle.setFont(new Font("Arial", 2, 28));
		
		JButton academic = new JButton("Academic Reports");
		academic.setPreferredSize(new Dimension(200, 25));
		academic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				advisingReportChoice();
			}
		});
		
		JButton grad = new JButton("Grad Report");
		grad.setPreferredSize(new Dimension(200, 25));
		grad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				gradReport();
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
		Dimension size = menuTitle.getPreferredSize();
		reportsPanel.setBounds(250+insets.left, 50+insets.top, size.width, size.height);
						
		c.insets = new Insets(50, 50, 50, 50);
		
		reportsPanel.add(menuTitle, c);
		c.insets = new Insets(10,10,10,10);
		c.gridy = 2;
		reportsPanel.add(academic, c);
		c.gridy = 3;
		reportsPanel.add(grad, c);
		c.gridy = 4;
		reportsPanel.add(mainMenu, c);

	}
	public void advisingReportChoice(){
		advisingReportChoicePanel.removeAll();
		
		StudentModule run = new StudentModule();
		ArrayList<Student> students = run.getAllStudents();
		JCheckBox [] checkboxes = new JCheckBox[students.size()];
		
		JLabel menuTitle = new JLabel("Choose Students");
		menuTitle.setFont(new Font("Arial", 2, 28));
		
		JButton submit = new JButton("Submit");
		submit.setPreferredSize(new Dimension(200, 25));
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				//display academic reports for all checkboxes
			 	ArrayList<Student> toBeDisplayed = new ArrayList<Student>();
				for(JCheckBox checkbox : checkboxes){
					if(checkbox.isSelected()){
						Student s = run.findStudent(Integer.parseInt(checkbox.getText()));//can make just string when bruce finishes
						toBeDisplayed.add(s);
					}
					
				}
				advisingReport(toBeDisplayed);
			}
		});

		JButton back = new JButton("Back");
		back.setPreferredSize(new Dimension(200, 25));
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				displayPanel(reportsPanel);
			}
		});
		

		Student boom;
		for(int i = 0;i<students.size(); i++){
			boom = students.get(i);
			checkboxes[i] = new JCheckBox(Integer.toString(boom.getIdNumber()));
		}
		
		GridBagConstraints c = new GridBagConstraints();
		Insets insets = frame1.getInsets();
		Dimension size = menuTitle.getPreferredSize();
		advisingReportChoicePanel.setBounds(250+insets.left, 50+insets.top, size.width, size.height);
						
		c.insets = new Insets(50, 50, 50, 50);
		
		advisingReportChoicePanel.add(menuTitle, c);
		c.insets = new Insets(10,10,10,10);
		int x = 2;
		for(int i = 0; i<checkboxes.length; i++){
			c.gridy= x;
			advisingReportChoicePanel.add(checkboxes[i],c);
			x++;
		}
		c.gridy = x;
		advisingReportChoicePanel.add(submit,c);
		x++;
		c.gridy = x;
		advisingReportChoicePanel.add(back, c);
		advisingReportChoicePanel.revalidate();
		displayPanel(advisingReportChoicePanel);
		
	}
	public void advisingReport(ArrayList<Student> tbd){
		advisingReportPanel.removeAll();
		JLabel menuTitle = new JLabel("Report");
		menuTitle.setFont(new Font("Arial", 2, 28));
		
		GridBagConstraints c = new GridBagConstraints();
		Insets insets = frame1.getInsets();
		Dimension size = menuTitle.getPreferredSize();
		advisingReportPanel.setBounds(250+insets.left, 50+insets.top, size.width, size.height);
		c.insets = new Insets(50, 50, 50, 50);
		advisingReportPanel.add(menuTitle, c);
		
		
		JLabel name = new JLabel("Name");
		JLabel studentNumber = new JLabel("Student #");
		JLabel grade = new JLabel("Grade");
		JLabel academicAdvising = new JLabel("Academic Advising");
		JLabel date = new JLabel("Date");
		c.insets = new Insets(10,10,10,10);
		
		c.gridy = 1;
		c.gridx = 0;
		advisingReportPanel.add(name, c);
		c.gridx = 1;
		advisingReportPanel.add(studentNumber, c);
		c.gridx = 2;
		advisingReportPanel.add(grade, c);
		c.gridx = 3;
		advisingReportPanel.add(academicAdvising, c);
		c.gridx = 4;
		advisingReportPanel.add(date, c);
		
		int counter=2;
		for(Student student : tbd){
			c.gridy = counter;
			counter++;
			c.gridx = 0;
			advisingReportPanel.add(new JLabel(student.getFirstName()+ " " + student.getLastName()), c);
			c.gridx = 1;
			advisingReportPanel.add(new JLabel(Integer.toString(student.getIdNumber())), c);
			c.gridx = 2;
			advisingReportPanel.add(new JLabel(student.getGrade()), c);
			c.gridx = 3;
			advisingReportPanel.add(new JLabel(String.valueOf(student.isAdvising())), c);
			c.gridx = 4;
			advisingReportPanel.add(new JLabel(student.getDate()), c);
		}
		
		advisingReportPanel.revalidate();
		displayPanel(advisingReportPanel);
		
	}
	public void gradReport(){
		
		GridBagConstraints c = new GridBagConstraints();
		Insets insets = frame1.getInsets();

		StudentModule run = new StudentModule();
		ArrayList<Student> students = new ArrayList(run.getAllStudents());//change to just get grad students when ready
		
		c.insets = new Insets(10,10,10,10);
		c.gridy = 0;
		gradReportPanel.add(new JLabel("Name"),c);
		c.gridy = 1;
		gradReportPanel.add(new JLabel("Major GPA"), c);
		c.gridy = 2;
		gradReportPanel.add(new JLabel("Total GPA"), c);
		c.gridy = 3;
		gradReportPanel.add(new JLabel("Major Credits"), c);
		c.gridy = 4;
		gradReportPanel.add(new JLabel("Upper-Level Credits"), c);
		c.gridy = 5;
		gradReportPanel.add(new JLabel("Total Credits"), c);
		c.gridy = 6;
		gradReportPanel.add(new JLabel("Submission Date"), c);
		
		for(Student student : students){
			c.gridy = 0;
			gradReportPanel.add(new JLabel(student.getFirstName() + " " + student.getLastName() + " " + student.getIdNumber()),c);
			c.gridy = 1;
			gradReportPanel.add(new JLabel(String.valueOf(student.getMajorGPA())), c);
			c.gridy = 2;
			gradReportPanel.add(new JLabel(String.valueOf(student.getTotalGPA())), c);
			c.gridy = 3;
			gradReportPanel.add(new JLabel(String.valueOf(student.getMajorCredits())), c);
			c.gridy = 4;
			gradReportPanel.add(new JLabel(String.valueOf(student.getUpperLevelCredits())), c);
			c.gridy = 5;
			gradReportPanel.add(new JLabel(String.valueOf(student.getTotalCredits())), c);
			c.gridy = 6;
			gradReportPanel.add(new JLabel(student.getDate()), c);
		}
		displayPanel(gradReportPanel);
	}
}