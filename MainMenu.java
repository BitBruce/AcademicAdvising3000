//Import packages
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MainMenu {
	JFrame frame1;
	JPanel buttons;
	JPanel managePanel;
	JPanel recordPanel;
	JPanel gradPanel;
	JPanel reportsPanel;
;
	
	public MainMenu(){
		//Create the frame
				frame1 = new JFrame ("Academic Advising 3000");
				//Set its size to 800x200 pixels
				frame1.setSize (400,400);
				//Prepare panel
				frame1.setLocationRelativeTo(null);
				
				buttons = new JPanel(new GridBagLayout());

				//set up contructor when I figure this out
				managePanel = new JPanel(new GridBagLayout());
				recordPanel = new JPanel(new GridBagLayout());
				gradPanel = new JPanel(new GridBagLayout());
				reportsPanel = new JPanel(new GridBagLayout());
				
				
				makeButtons();
				manageMenu();
				recordMenu();
				gradMenu();
				reportsMenu();
				
				//where the frme should start
				frame1.getContentPane().removeAll();
				frame1.add(buttons, BorderLayout.CENTER);
				frame1.repaint();
				
				
				frame1.setVisible (true);
						
	}
	public void makeButtons(){
		JLabel comboLbl = new JLabel("Academic Advising 3000"); 
		
		comboLbl.setFont(new Font("Arial", 2, 28));
		JButton manageInfo = new JButton("Manage Student Information");
		manageInfo.setSize(new Dimension(200, 25));
		
		manageInfo.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e){
				
				displayPanel(managePanel);
			}
		});
		
		JButton recordAdv = new JButton("Record Academic Advising");
		recordAdv.setPreferredSize(new Dimension(200, 25));
		recordAdv.addActionListener(new ActionListener() {
					
			public void actionPerformed(ActionEvent e){
				displayPanel(recordPanel);
			}
		});
		
		JButton gradSub = new JButton("Graduation Submission");
		gradSub.setMinimumSize(new Dimension(200, 25));
		gradSub.addActionListener(new ActionListener() {
					
			public void actionPerformed(ActionEvent e){
				displayPanel(gradPanel);
			}
		});
		
		JButton reports = new JButton("Find Reports");
		reports.setMinimumSize(new Dimension(200, 25));
		reports.addActionListener(new ActionListener() {
					
			public void actionPerformed(ActionEvent e){
				displayPanel(reportsPanel);
			}
		});
		
		

 
		Insets insets = frame1.getInsets();
	
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



	}

	public void displayPanel(JPanel panel){
		frame1.getContentPane().removeAll();
		frame1.add(panel);
		frame1.repaint();
		frame1.setVisible(true);
	}
	public void mainMenu(){
		frame1.getContentPane().removeAll();
		frame1.add(buttons);
		frame1.repaint();
		frame1.setVisible(true);
	}
	public void manageMenu(){
		
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
				mainMenu();
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

	}
	public void recordMenu(){
		JLabel menuTitle = new JLabel("Record Academic Advising");
		menuTitle.setFont(new Font("Arial", 2, 28));
		
		JButton mainMenu = new JButton("Main Menu");
		mainMenu.setPreferredSize(new Dimension(200, 25));
		mainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				mainMenu();
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

	}
	public void gradMenu(){
		
			frame1.getContentPane().removeAll();
			
			JLabel menuTitle = new JLabel("Graduation Submission");
			menuTitle.setFont(new Font("Arial", 2, 28));
			
			JButton mainMenu = new JButton("Main Menu");
			mainMenu.setPreferredSize(new Dimension(200, 25));
			mainMenu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e){
					mainMenu();
				}
			});

			GridBagConstraints c = new GridBagConstraints();
			Insets insets = frame1.getInsets();
							
			c.insets = new Insets(50, 50, 50, 50);
			gradPanel.add(menuTitle, c);
			c.gridy = 2;
			gradPanel.add(mainMenu, c);
			

	}
	public void reportsMenu(){
			JLabel menuTitle = new JLabel("Reports");
			menuTitle.setFont(new Font("Arial", 2, 28));
			
			JButton mainMenu = new JButton("Main Menu");
			mainMenu.setPreferredSize(new Dimension(200, 25));
			mainMenu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e){
					mainMenu();
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

	}
}