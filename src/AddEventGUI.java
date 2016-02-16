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
	private JTextField textField;
	public int[] comboValues = {2016,01,01};
	public String typeValue;
	public JComboBox comboBox;
	public JComboBox comboBox_1;
	public JComboBox comboBox_2;
	public JComboBox comboBox_3;
	public String typeSelected;
	public int finalValue = 20160101;
	
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
			System.out.println(typeSelected);
			break;
		case 4:
			JButton b1 = (JButton) e.getSource();
			EventList eList = new EventList();
			EventDate ed = new EventDate(finalValue);
			Event ev = new Event(textField.getText().toString(), ed, typeSelected, finalValue);
			eList.readFile();
			eList.add(ev);
			eList.writeFile();
			JOptionPane.showMessageDialog(frame, ev.getEventName() + " has been added for " + ed);
			break;
			
			
		}
		finalValue = comboValues[0]*10000+comboValues[1]*100+comboValues[2];
		
		
		
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
	
	public AddEventGUI(int i) {
		this.finalValue = i;
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
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 3;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 4;
		gbc_textField.gridy = 2;
		frame.getContentPane().add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lblDate = new JLabel("Date");
		GridBagConstraints gbc_lblDate = new GridBagConstraints();
		gbc_lblDate.anchor = GridBagConstraints.EAST;
		gbc_lblDate.insets = new Insets(0, 0, 5, 5);
		gbc_lblDate.gridx = 3;
		gbc_lblDate.gridy = 3;
		frame.getContentPane().add(lblDate, gbc_lblDate);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setActionCommand("1");
		comboBox.addActionListener(this);
		String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		DefaultComboBoxModel dcbm = new DefaultComboBoxModel(months);
		comboBox.setModel(dcbm);
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 4;
		gbc_comboBox.gridy = 3;
		frame.getContentPane().add(comboBox, gbc_comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		comboBox_1.setActionCommand("2");
		comboBox_1.addActionListener(this);
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.gridx = 5;
		gbc_comboBox_1.gridy = 3;
		frame.getContentPane().add(comboBox_1, gbc_comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"2016", "2017", "2018", "2019", "2020"}));
		comboBox_2.setActionCommand("0");
		comboBox_2.addActionListener(this);
		GridBagConstraints gbc_comboBox_2 = new GridBagConstraints();
		gbc_comboBox_2.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_2.gridx = 6;
		gbc_comboBox_2.gridy = 3;
		frame.getContentPane().add(comboBox_2, gbc_comboBox_2);
		
		JLabel lblType = new JLabel("Type");
		GridBagConstraints gbc_lblType = new GridBagConstraints();
		gbc_lblType.anchor = GridBagConstraints.EAST;
		gbc_lblType.insets = new Insets(0, 0, 5, 5);
		gbc_lblType.gridx = 3;
		gbc_lblType.gridy = 4;
		frame.getContentPane().add(lblType, gbc_lblType);
		
		JComboBox comboBox_3 = new JComboBox();
		TypeList tL = new TypeList();
		tL.readFile();
		comboBox_3.setModel(new DefaultComboBoxModel(tL.toStringArray()));
		comboBox_3.setActionCommand("3");
		comboBox_3.addActionListener(this);
		GridBagConstraints gbc_comboBox_3 = new GridBagConstraints();
		gbc_comboBox_3.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_3.gridx = 4;
		gbc_comboBox_3.gridy = 4;
		frame.getContentPane().add(comboBox_3, gbc_comboBox_3);
		
		JButton btnAddEvent = new JButton("Add Event");
		btnAddEvent.setActionCommand("4");
		btnAddEvent.addActionListener(this);
		GridBagConstraints gbc_btnAddEvent = new GridBagConstraints();
		gbc_btnAddEvent.insets = new Insets(0, 0, 0, 5);
		gbc_btnAddEvent.gridx = 4;
		gbc_btnAddEvent.gridy = 6;
		frame.getContentPane().add(btnAddEvent, gbc_btnAddEvent);
	}

}
