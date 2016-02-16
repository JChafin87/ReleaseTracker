import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;


public class ChangeDateGUI extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	private JComboBox comboBox_2;
	private int finalValue;
	public int[] comboValues = {2016,01,01};
	private Event ev;
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void openCD() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChangeDateGUI frame = new ChangeDateGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public int openCD(String s, int i) {
		this.finalValue = i;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try {
					
					ChangeDateGUI frame = new ChangeDateGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		return this.finalValue;
	}
	
	public int getFinalValue() {
		return finalValue;
	}
	public void setFinalValue(int finalValue) {
		this.finalValue = finalValue;
	}
	public void actionPerformed(ActionEvent e) {
		int action = Integer.parseInt(e.getActionCommand());
		switch(action) {
		case 0:
			JComboBox cb = (JComboBox) e.getSource();
			int newSelection = cb.getSelectedIndex();
		    comboValues[0] = (newSelection+2016);
			break;
		case 1:
			JComboBox cb1 = (JComboBox) e.getSource();
			int newSelection2 = cb1.getSelectedIndex();
		    comboValues[1] = newSelection2+1;
		    break;
		case 2:
			JComboBox cb2 = (JComboBox) e.getSource();
			int newSelection3 = cb2.getSelectedIndex();
			comboValues[2]=newSelection3+1;
			break;
		case 3:
			break;
		case 4:
			JButton b1 = (JButton) e.getSource();
			EventList eList = new EventList();
			JOptionPane.showMessageDialog(frame, "The type: has been added.");
			setVisible(false);
			break;
			
			
		}
		finalValue = comboValues[0]*10000+comboValues[1]*100+comboValues[2];
		
		
		
	}
	

	/**
	 * Create the frame.
	 */
	public ChangeDateGUI() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMonth = new JLabel("Month");
		lblMonth.setBounds(62, 52, 46, 14);
		contentPane.add(lblMonth);
		
		JLabel lblDay = new JLabel("Day");
		lblDay.setBounds(62, 109, 46, 14);
		contentPane.add(lblDay);
		
		JLabel lblYear = new JLabel("Year");
		lblYear.setBounds(62, 156, 46, 14);
		contentPane.add(lblYear);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(this);
		comboBox.setActionCommand("1");
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"}));
		comboBox.setBounds(134, 49, 119, 20);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.addActionListener(this);
		comboBox_1.setActionCommand("2");
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		comboBox_1.setBounds(134, 106, 46, 20);
		contentPane.add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.addActionListener(this);
		comboBox_2.setActionCommand("0");
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"2016", "2017", "2018", "2019", "2020"}));
		comboBox_2.setBounds(134, 153, 77, 20);
		contentPane.add(comboBox_2);
		
		JButton btnAccept = new JButton("Accept");
		btnAccept.addActionListener(this);
		btnAccept.setActionCommand("4");
		btnAccept.setBounds(164, 205, 89, 23);
		contentPane.add(btnAccept);
		
		JLabel lblChangeDate = new JLabel("Change Date");
		lblChangeDate.setBounds(191, 11, 97, 14);
		contentPane.add(lblChangeDate);
	}
}
