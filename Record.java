import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


class Record {
	public JPanel recordPanel;
	JFrame frame1;
	public String seekWord;
	
	
	public Record(JFrame frame){
		recordPanel = new JPanel(new GridBagLayout());
		frame1 = frame;
		
		recordMenu();
		
		displayPanel(recordPanel);
	}
	
	public void displayPanel(JPanel panel){
		frame1.getContentPane().removeAll();
		frame1.add(panel);
		frame1.repaint();
		frame1.setVisible(true);
	}
	public void recordMenu(){
		JLabel menuTitle = new JLabel("Record Academic Advising");
		menuTitle.setFont(new Font("Arial", 2, 28));
		
		JLabel find = new JLabel("Enter Student Number");
		JTextField find1 = new JTextField(5);//Student Number
		
		JButton submit = new JButton("Submit");//set this button
		submit.addActionListener(new ActionListener() {
							
					public void actionPerformed(ActionEvent e){
						seekWord = find1.getText();
						//delete student at seekWord
						//back to mainmenu
					}
				});
		JButton back = new JButton("Back");
		back.addActionListener(new ActionListener() {
							
					public void actionPerformed(ActionEvent e){
						//back to mainmenu
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
		recordPanel.add(find1, con);
		
		con.gridy = 3;
		recordPanel.add(submit, con);
		con.gridx = 0;
		recordPanel.add(back, con);
		

	}
}