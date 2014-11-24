//Import packages
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MainMenu {
	JFrame frame1;
	JPanel buttons;

	JPanel gradPanel;
	JPanel reportsPanel;

	
	public MainMenu(){
		//Create the frame
				frame1 = new JFrame ("Academic Advising 3000");
				//Set its size to 800x200 pixels
				frame1.setSize (600,600);
				//Prepare panel
				frame1.setLocationRelativeTo(null);
				
				buttons = new JPanel(new GridBagLayout());

				//set up contructor when I figure this out

				gradPanel = new JPanel(new GridBagLayout());
				reportsPanel = new JPanel(new GridBagLayout());
				
				
				makeButtons();
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
				ManageMenu x = new ManageMenu(frame1, buttons);
				//displayPanel(managePanel);
			}
		});
		
		JButton recordAdv = new JButton("Record Academic Advising");
		recordAdv.setPreferredSize(new Dimension(200, 25));
		recordAdv.addActionListener(new ActionListener() {
					
			public void actionPerformed(ActionEvent e){
				Record x = new Record(frame1, buttons);
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