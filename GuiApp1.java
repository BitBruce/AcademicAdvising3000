<<<<<<< HEAD

=======
>>>>>>> Gui-first
//Import packages
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//Main class
public class GuiApp1{
	//Declare variables
	static JFrame frame1;
	static JPanel buttons;
	static JPanel managePanel;
	static JPanel recordPanel;
	static JPanel gradPanel;
	static JPanel reportsPanel;
	
<<<<<<< HEAD
	
	public static void mainMenu(JPanel panel){
		frame1.remove(panel);
=======
	public static void displayPanel(JPanel panel){
		frame1.getContentPane().removeAll();
		frame1.add(panel);
		frame1.repaint();
		frame1.setVisible(true);
	}
	public static void mainMenu(){
		frame1.getContentPane().removeAll();
>>>>>>> Gui-first
		frame1.add(buttons);
		frame1.repaint();
		frame1.setVisible(true);
	}
	public static void manageMenu(){
<<<<<<< HEAD
		JLabel menuTitle = new JLabel("Manage Student Info");
		menuTitle.setFont(new Font("Arial", 2, 28));
		JButton addStudent = new JButton("Add Student");
		addStudent.setPreferredSize(new Dimension(200, 25));
		JButton editStudent = new JButton("Edit Student");
		editStudent.setPreferredSize(new Dimension(200, 25));
		JButton deleteStudent = new JButton("Delete Student");
		deleteStudent.setPreferredSize(new Dimension(200, 25));
		JButton importStudent = new JButton("Import Student Text File");
		importStudent.setPreferredSize(new Dimension(200, 25));
=======
		
		JLabel menuTitle = new JLabel("Manage Student Info");
		menuTitle.setFont(new Font("Arial", 2, 28));
		
		JButton addStudent = new JButton("Add Student");
		addStudent.setPreferredSize(new Dimension(200, 25));
		
		JButton editStudent = new JButton("Edit Student");
		editStudent.setPreferredSize(new Dimension(200, 25));
		
		JButton deleteStudent = new JButton("Delete Student");
		deleteStudent.setPreferredSize(new Dimension(200, 25));
		
		JButton importStudent = new JButton("Import Student Text File");
		importStudent.setPreferredSize(new Dimension(200, 25));
		
>>>>>>> Gui-first
		JButton mainMenu = new JButton("Main Menu");
		mainMenu.setPreferredSize(new Dimension(200, 25));
		mainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
<<<<<<< HEAD
				mainMenu(managePanel);
=======
				mainMenu();
>>>>>>> Gui-first
			}
		});
		
		GridBagConstraints c = new GridBagConstraints();
		Insets insets = frame1.getInsets();
		
		c.insets = new Insets(50, 50, 50, 50);
		managePanel.add(menuTitle, c);
				
<<<<<<< HEAD
				
				
=======
>>>>>>> Gui-first
		c.insets = new Insets(10,10,10,10);
		c.gridx = 0;
		c.gridy = 2;
		managePanel.add(addStudent, c);
		c.gridy = 3;
		managePanel.add(editStudent, c);
		c.gridy = 4;
		managePanel.add(deleteStudent, c);
		c.gridy = 5;
		managePanel.add(importStudent, c);
		c.gridy = 6;
		managePanel.add(mainMenu, c);
<<<<<<< HEAD
		
		frame1.remove(buttons);
		frame1.add(managePanel);
		frame1.repaint();
		frame1.setVisible(true);
=======
>>>>>>> Gui-first

	}
	public static void recordMenu(){
		JLabel menuTitle = new JLabel("Record Academic Advising");
		menuTitle.setFont(new Font("Arial", 2, 28));
		
		JButton mainMenu = new JButton("Main Menu");
		mainMenu.setPreferredSize(new Dimension(200, 25));
		mainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
<<<<<<< HEAD
				mainMenu(recordPanel);
=======
				mainMenu();
>>>>>>> Gui-first
			}
		});

		GridBagConstraints c = new GridBagConstraints();
		Insets insets = frame1.getInsets();
		Dimension size = menuTitle.getPreferredSize();
		recordPanel.setBounds(250+insets.left, 100+insets.top, size.width, size.height);
						
		c.insets = new Insets(50, 50, 50, 50);
		recordPanel.add(menuTitle, c);
		c.gridy = 2;
		recordPanel.add(mainMenu, c);

<<<<<<< HEAD
		frame1.remove(buttons);
		frame1.add(recordPanel);
		frame1.repaint();
		frame1.setVisible(true);
	}
	public static void gradMenu(){
		
=======
	}
	public static void gradMenu(){
		
			frame1.getContentPane().removeAll();
			
>>>>>>> Gui-first
			JLabel menuTitle = new JLabel("Graduation Submission");
			menuTitle.setFont(new Font("Arial", 2, 28));
			
			JButton mainMenu = new JButton("Main Menu");
			mainMenu.setPreferredSize(new Dimension(200, 25));
			mainMenu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e){
<<<<<<< HEAD
					mainMenu(gradPanel);
=======
					mainMenu();
>>>>>>> Gui-first
				}
			});

			GridBagConstraints c = new GridBagConstraints();
			Insets insets = frame1.getInsets();
							
			c.insets = new Insets(50, 50, 50, 50);
			gradPanel.add(menuTitle, c);
			c.gridy = 2;
			gradPanel.add(mainMenu, c);
			
<<<<<<< HEAD
									
			frame1.remove(buttons);
			frame1.add(gradPanel);
			frame1.repaint();
			frame1.setVisible(true);
=======

>>>>>>> Gui-first
	}
	public static void reportsMenu(){
			JLabel menuTitle = new JLabel("Reports");
			menuTitle.setFont(new Font("Arial", 2, 28));
			
			JButton mainMenu = new JButton("Main Menu");
			mainMenu.setPreferredSize(new Dimension(200, 25));
			mainMenu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e){
<<<<<<< HEAD
					mainMenu(reportsPanel);
=======
					mainMenu();
>>>>>>> Gui-first
				}
			});

			GridBagConstraints c = new GridBagConstraints();
			Insets insets = frame1.getInsets();
			Dimension size = menuTitle.getPreferredSize();
			reportsPanel.setBounds(250+insets.left, 50+insets.top, size.width, size.height);
							
			c.insets = new Insets(50, 50, 50, 50);
			
			reportsPanel.add(menuTitle, c);
			c.gridy = 2;
			reportsPanel.add(mainMenu, c);
<<<<<<< HEAD
									
			frame1.remove(buttons);
			frame1.add(reportsPanel);
			frame1.repaint();
			frame1.setVisible(true);
	}
	public static void main (String args[]){
=======

	}
	public static void main (String args[]){
		
>>>>>>> Gui-first
		//Create the frame
		frame1 = new JFrame ("Academic Advising 3000");
		//Set its size to 800x200 pixels
		frame1.setSize (400,400);
		//Prepare panel
		frame1.setLocationRelativeTo(null);

<<<<<<< HEAD
		buttons = new JPanel(new GridBagLayout());
		
		managePanel = new JPanel(new GridBagLayout());
		recordPanel = new JPanel(new GridBagLayout());
		gradPanel = new JPanel(new GridBagLayout());
		reportsPanel = new JPanel(new GridBagLayout());

=======

		buttons = new JPanel(new GridBagLayout());
>>>>>>> Gui-first

		JLabel comboLbl = new JLabel("Academic Advising 3000"); 
		
		comboLbl.setFont(new Font("Arial", 2, 28));
		JButton manageInfo = new JButton("Manage Student Information");
		manageInfo.setPreferredSize(new Dimension(200, 25));
		
		manageInfo.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e){
				
<<<<<<< HEAD
				manageMenu();
=======
				displayPanel(managePanel);
>>>>>>> Gui-first
			}
		});
		
		JButton recordAdv = new JButton("Record Academic Advising");
		recordAdv.setPreferredSize(new Dimension(200, 25));
		recordAdv.addActionListener(new ActionListener() {
					
			public void actionPerformed(ActionEvent e){
<<<<<<< HEAD
				recordMenu();
=======
				displayPanel(recordPanel);
>>>>>>> Gui-first
			}
		});
		
		JButton gradSub = new JButton("Graduation Submission");
		gradSub.setPreferredSize(new Dimension(200, 25));
		gradSub.addActionListener(new ActionListener() {
					
			public void actionPerformed(ActionEvent e){
<<<<<<< HEAD
				gradMenu();
=======
				displayPanel(gradPanel);
>>>>>>> Gui-first
			}
		});
		
		JButton reports = new JButton("Find Reports");
		reports.setPreferredSize(new Dimension(200, 25));
<<<<<<< HEAD
		gradSub.addActionListener(new ActionListener() {
					
			public void actionPerformed(ActionEvent e){
				reportsMenu();
=======
		reports.addActionListener(new ActionListener() {
					
			public void actionPerformed(ActionEvent e){
				displayPanel(reportsPanel);
>>>>>>> Gui-first
			}
		});
		
		
<<<<<<< HEAD
				
 
		Insets insets = frame1.getInsets();
		Dimension size = comboLbl.getPreferredSize();
		//comboLbl.setBounds(250+insets.left, 100+insets.top, size.width, size.height);
		
		
		
		GridBagConstraints c = new GridBagConstraints();
		
		
		c.insets = new Insets(50, 50, 50, 50);
		buttons.add(comboLbl, c);
		
		
		
=======
		//set up contructor when I figure this out
		managePanel = new JPanel(new GridBagLayout());
		recordPanel = new JPanel(new GridBagLayout());
		gradPanel = new JPanel(new GridBagLayout());
		reportsPanel = new JPanel(new GridBagLayout());
		
		manageMenu();
		recordMenu();
		gradMenu();
		reportsMenu();
				
 
		Insets insets = frame1.getInsets();
	
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(50, 50, 50, 50);
		buttons.add(comboLbl, c);
		
>>>>>>> Gui-first
		c.insets = new Insets(10,10,10,10);
		c.gridx = 0;
		c.gridy = 2;
		buttons.add(manageInfo, c);
		c.gridy = 3;
		buttons.add(recordAdv, c);
		c.gridy = 4;
		buttons.add(gradSub, c);
		c.gridy = 5;
		buttons.add(reports, c);

<<<<<<< HEAD
		
=======
		frame1.getContentPane().removeAll();
>>>>>>> Gui-first
		frame1.add(buttons, BorderLayout.CENTER);
		frame1.repaint();
		
		
		frame1.setVisible (true);
<<<<<<< HEAD
	}
}
=======
		

	}
}
>>>>>>> Gui-first
