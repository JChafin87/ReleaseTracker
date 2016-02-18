import java.awt.EventQueue;





import javax.swing.JFrame;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;


public class AddEventGUI extends JFrame implements ActionListener {

	private JFrame frame;
	private JTextField nameField;
	
	public JComboBox monthBox;
	public JComboBox dayBox;
	public JComboBox yearBox;
	public JComboBox typeBox;
	public JButton btnAddEvent;
	public int[] comboValues = {2016,01,01};
	public String typeSelected = "Choose Type";
	public int dateInt = 20160101;
	
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
			JComboBox cb3 = (JComboBox) e.getSource();
			String newSelection4 = (String) cb3.getSelectedItem();
			typeSelected = newSelection4;
			break;
		case 4:
			JButton b1 = (JButton) e.getSource();
			if (typeSelected.equals("Choose Type")) {
				JOptionPane.showMessageDialog(frame, "Please choose an event type");
			}
			else {
				EventList eList = new EventList();
				EventDate ed = new EventDate(dateInt);
				Event ev = new Event(nameField.getText().toString(), ed, typeSelected, dateInt);
				eList.readFile();
				eList.add(ev);
				eList.writeFile();
				JOptionPane.showMessageDialog(frame, ev.getEventName() + " has been added for " + ed);
			}
			break;
			
			
		}
		dateInt = comboValues[0]*10000+comboValues[1]*100+comboValues[2];
		
		
		
	}
	
	



	/**
	 * Launch the application.
	 */
	public static void openAE() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddEventGUI window = new AddEventGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AddEventGUI() {
		initialize();
	}
	


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JLabel lblAddeditEvent = new JLabel("Add/Edit Event");
		GridBagConstraints gbc_lblAddeditEvent = new GridBagConstraints();
		gbc_lblAddeditEvent.insets = new Insets(0, 0, 5, 5);
		gbc_lblAddeditEvent.gridx = 4;
		gbc_lblAddeditEvent.gridy = 0;
		frame.getContentPane().add(lblAddeditEvent, gbc_lblAddeditEvent);
		
		JLabel lblEventName = new JLabel("Event Name");
		GridBagConstraints gbc_lblEventName = new GridBagConstraints();
		gbc_lblEventName.insets = new Insets(0, 0, 5, 5);
		gbc_lblEventName.gridx = 3;
		gbc_lblEventName.gridy = 2;
		frame.getContentPane().add(lblEventName, gbc_lblEventName);
		
		nameField = new JTextField();
		GridBagConstraints gbc_nameField = new GridBagConstraints();
		gbc_nameField.gridwidth = 3;
		gbc_nameField.insets = new Insets(0, 0, 5, 5);
		gbc_nameField.fill = GridBagConstraints.HORIZONTAL;
		gbc_nameField.gridx = 4;
		gbc_nameField.gridy = 2;
		frame.getContentPane().add(nameField, gbc_nameField);
		nameField.setColumns(10);
		
		JLabel lblDate = new JLabel("Date");
		GridBagConstraints gbc_lblDate = new GridBagConstraints();
		gbc_lblDate.anchor = GridBagConstraints.EAST;
		gbc_lblDate.insets = new Insets(0, 0, 5, 5);
		gbc_lblDate.gridx = 3;
		gbc_lblDate.gridy = 3;
		frame.getContentPane().add(lblDate, gbc_lblDate);
		
		monthBox = new JComboBox();
		monthBox.setActionCommand("1");
		monthBox.addActionListener(this);
		String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		DefaultComboBoxModel dcbm = new DefaultComboBoxModel(months);
		monthBox.setModel(dcbm);
		GridBagConstraints gbc_monthBox = new GridBagConstraints();
		gbc_monthBox.insets = new Insets(0, 0, 5, 5);
		gbc_monthBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_monthBox.gridx = 4;
		gbc_monthBox.gridy = 3;
		frame.getContentPane().add(monthBox, gbc_monthBox);
		
		dayBox = new JComboBox();
		dayBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		dayBox.setActionCommand("2");
		dayBox.addActionListener(this);
		GridBagConstraints gbc_dayBox = new GridBagConstraints();
		gbc_dayBox.insets = new Insets(0, 0, 5, 5);
		gbc_dayBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_dayBox.gridx = 5;
		gbc_dayBox.gridy = 3;
		frame.getContentPane().add(dayBox, gbc_dayBox);
		
		yearBox = new JComboBox();
		yearBox.setModel(new DefaultComboBoxModel(new String[] {"2016", "2017", "2018", "2019", "2020"}));
		yearBox.setActionCommand("0");
		yearBox.addActionListener(this);
		GridBagConstraints gbc_yearBox = new GridBagConstraints();
		gbc_yearBox.insets = new Insets(0, 0, 5, 5);
		gbc_yearBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_yearBox.gridx = 6;
		gbc_yearBox.gridy = 3;
		frame.getContentPane().add(yearBox, gbc_yearBox);
		
		JLabel lblType = new JLabel("Type");
		GridBagConstraints gbc_lblType = new GridBagConstraints();
		gbc_lblType.anchor = GridBagConstraints.EAST;
		gbc_lblType.insets = new Insets(0, 0, 5, 5);
		gbc_lblType.gridx = 3;
		gbc_lblType.gridy = 4;
		frame.getContentPane().add(lblType, gbc_lblType);
		
		typeBox = new JComboBox();
		TypeList tL = new TypeList();
		tL.readFile();
		typeBox.setModel(new DefaultComboBoxModel(tL.toStringArray()));
		typeBox.setActionCommand("3");
		typeBox.addActionListener(this);
		GridBagConstraints gbc_typeBox = new GridBagConstraints();
		gbc_typeBox.insets = new Insets(0, 0, 5, 5);
		gbc_typeBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_typeBox.gridx = 4;
		gbc_typeBox.gridy = 4;
		frame.getContentPane().add(typeBox, gbc_typeBox);
		
		btnAddEvent = new JButton("Add Event");
		btnAddEvent.setActionCommand("4");
		btnAddEvent.addActionListener(this);
		GridBagConstraints gbc_btnAddEvent = new GridBagConstraints();
		gbc_btnAddEvent.insets = new Insets(0, 0, 0, 5);
		gbc_btnAddEvent.gridx = 4;
		gbc_btnAddEvent.gridy = 6;
		frame.getContentPane().add(btnAddEvent, gbc_btnAddEvent);
	}

}
