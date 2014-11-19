
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
	
	
	public static void mainMenu(JPanel panel){
		frame1.remove(panel);
		frame1.add(buttons);
		frame1.repaint();
		frame1.setVisible(true);
	}
	public static void manageMenu(){
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
		JButton mainMenu = new JButton("Main Menu");
		mainMenu.setPreferredSize(new Dimension(200, 25));
		mainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				mainMenu(managePanel);
			}
		});
		
		GridBagConstraints c = new GridBagConstraints();
		Insets insets = frame1.getInsets();
		
		c.insets = new Insets(50, 50, 50, 50);
		managePanel.add(menuTitle, c);
				
				
				
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
		
		frame1.remove(buttons);
		frame1.add(managePanel);
		frame1.repaint();
		frame1.setVisible(true);

	}
	public static void recordMenu(){
		JLabel menuTitle = new JLabel("Record Academic Advising");
		menuTitle.setFont(new Font("Arial", 2, 28));
		
		JButton mainMenu = new JButton("Main Menu");
		mainMenu.setPreferredSize(new Dimension(200, 25));
		mainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				mainMenu(recordPanel);
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

		frame1.remove(buttons);
		frame1.add(recordPanel);
		frame1.repaint();
		frame1.setVisible(true);
	}
	public static void gradMenu(){
		
			JLabel menuTitle = new JLabel("Graduation Submission");
			menuTitle.setFont(new Font("Arial", 2, 28));
			
			JButton mainMenu = new JButton("Main Menu");
			mainMenu.setPreferredSize(new Dimension(200, 25));
			mainMenu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e){
					mainMenu(gradPanel);
				}
			});

			GridBagConstraints c = new GridBagConstraints();
			Insets insets = frame1.getInsets();
							
			c.insets = new Insets(50, 50, 50, 50);
			gradPanel.add(menuTitle, c);
			c.gridy = 2;
			gradPanel.add(mainMenu, c);
			
									
			frame1.remove(buttons);
			frame1.add(gradPanel);
			frame1.repaint();
			frame1.setVisible(true);
	}
	public static void reportsMenu(){
			JLabel menuTitle = new JLabel("Reports");
			menuTitle.setFont(new Font("Arial", 2, 28));
			
			JButton mainMenu = new JButton("Main Menu");
			mainMenu.setPreferredSize(new Dimension(200, 25));
			mainMenu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e){
					mainMenu(reportsPanel);
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
									
			frame1.remove(buttons);
			frame1.add(reportsPanel);
			frame1.repaint();
			frame1.setVisible(true);
	}
	public static void main (String args[]){
		//Create the frame
		frame1 = new JFrame ("Academic Advising 3000");
		//Set its size to 800x200 pixels
		frame1.setSize (400,400);
		//Prepare panel
		frame1.setLocationRelativeTo(null);

		buttons = new JPanel(new GridBagLayout());
		
		managePanel = new JPanel(new GridBagLayout());
		recordPanel = new JPanel(new GridBagLayout());
		gradPanel = new JPanel(new GridBagLayout());
		reportsPanel = new JPanel(new GridBagLayout());


		JLabel comboLbl = new JLabel("Academic Advising 3000"); 
		
		comboLbl.setFont(new Font("Arial", 2, 28));
		JButton manageInfo = new JButton("Manage Student Information");
		manageInfo.setPreferredSize(new Dimension(200, 25));
		
		manageInfo.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e){
				
				manageMenu();
			}
		});
		
		JButton recordAdv = new JButton("Record Academic Advising");
		recordAdv.setPreferredSize(new Dimension(200, 25));
		recordAdv.addActionListener(new ActionListener() {
					
			public void actionPerformed(ActionEvent e){
				recordMenu();
			}
		});
		
		JButton gradSub = new JButton("Graduation Submission");
		gradSub.setPreferredSize(new Dimension(200, 25));
		gradSub.addActionListener(new ActionListener() {
					
			public void actionPerformed(ActionEvent e){
				gradMenu();
			}
		});
		
		JButton reports = new JButton("Find Reports");
		reports.setPreferredSize(new Dimension(200, 25));
		gradSub.addActionListener(new ActionListener() {
					
			public void actionPerformed(ActionEvent e){
				reportsMenu();
			}
		});
		
		
				
 
		Insets insets = frame1.getInsets();
		Dimension size = comboLbl.getPreferredSize();
		//comboLbl.setBounds(250+insets.left, 100+insets.top, size.width, size.height);
		
		
		
		GridBagConstraints c = new GridBagConstraints();
		
		
		c.insets = new Insets(50, 50, 50, 50);
		buttons.add(comboLbl, c);
		
		
		
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

		
		frame1.add(buttons, BorderLayout.CENTER);
		frame1.repaint();
		
		
		frame1.setVisible (true);
	}
}
