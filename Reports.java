import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Reports {
	public JPanel reportsPanel;
	
	public JFrame frame1;
	public JPanel main;
	
	public Reports(JFrame frame, JPanel m){
		frame1 = frame;
		main = m;
		
		reportsPanel = new JPanel(new GridBagLayout());
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
				//display academicadvising panel choices
			}
		});
		
		JButton grad = new JButton("Grad Report");
		grad.setPreferredSize(new Dimension(200, 25));
		grad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				//display gradsubmission reports
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
}