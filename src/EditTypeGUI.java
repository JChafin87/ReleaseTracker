import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import javax.swing.SpringLayout;

import java.awt.FlowLayout;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.DefaultComboBoxModel;


public class EditTypeGUI extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnAdd;
	private JComboBox typeBox;
	private JButton btnRemove;
	private JTextField newTypeField;
	private String type ="Choose Type";
	private JFrame frame;
	
	public void actionPerformed(ActionEvent e) {
		int action = Integer.parseInt(e.getActionCommand());
		switch(action) {
		case 0: 
			String s;
			s = newTypeField.getText().toString();
			TypeList t = new TypeList();
			t.readFile();
			t.add(s);
			t.writeFile();
			JOptionPane.showMessageDialog(frame, "The type: " + s + " has been added.");
			setVisible(false);
			break;
			
		case 1:
			JComboBox cb = (JComboBox) e.getSource();
			String sF = (String) cb.getSelectedItem();
			type = sF;
			break;
			
		case 2:
			JButton b1 = (JButton) e.getSource();
			TypeList t1 = new TypeList();
			t1.readFile();
			String toRemove = this.type;
			if (toRemove.equals("Choose Type")) {
				JOptionPane.showMessageDialog(frame, "Please choose a type to remove");
				
			}
			else {
				int opt = JOptionPane.YES_NO_OPTION;
				int confirm2 = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete Event Type: " + toRemove +"?", "Warning", opt);
				if (confirm2 == 0) {
						t1.remove(0);
						t1.writeFile();
						
				}
				else {
					
				}
			}
			break;
		
			
		}
	}
	/**
	 * Launch the application.
	 */
	public static void openET() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditTypeGUI frame = new EditTypeGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public EditTypeGUI() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 415, 189);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{39, 111, 46, 87, 106, 0};
		gbl_contentPane.rowHeights = new int[]{23, 23, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblAddNewType = new JLabel("Add New Type");
		GridBagConstraints gbc_lblAddNewType = new GridBagConstraints();
		gbc_lblAddNewType.anchor = GridBagConstraints.EAST;
		gbc_lblAddNewType.insets = new Insets(0, 0, 5, 5);
		gbc_lblAddNewType.gridx = 1;
		gbc_lblAddNewType.gridy = 1;
		contentPane.add(lblAddNewType, gbc_lblAddNewType);
		
		newTypeField = new JTextField();
		GridBagConstraints gbc_newTypeField = new GridBagConstraints();
		gbc_newTypeField.gridwidth = 2;
		gbc_newTypeField.fill = GridBagConstraints.HORIZONTAL;
		gbc_newTypeField.insets = new Insets(0, 0, 5, 5);
		gbc_newTypeField.gridx = 2;
		gbc_newTypeField.gridy = 1;
		contentPane.add(newTypeField, gbc_newTypeField);
		newTypeField.setColumns(10);
		
		btnAdd = new JButton("Add");
		btnAdd.addActionListener(this);
		btnAdd.setActionCommand("0");
		GridBagConstraints gbc_btnAdd = new GridBagConstraints();
		gbc_btnAdd.anchor = GridBagConstraints.NORTH;
		gbc_btnAdd.insets = new Insets(0, 0, 5, 0);
		gbc_btnAdd.gridx = 4;
		gbc_btnAdd.gridy = 1;
		contentPane.add(btnAdd, gbc_btnAdd);
		
		JLabel lblSelectTypeTo = new JLabel("Select Type to Remove");
		GridBagConstraints gbc_lblSelectTypeTo = new GridBagConstraints();
		gbc_lblSelectTypeTo.anchor = GridBagConstraints.WEST;
		gbc_lblSelectTypeTo.insets = new Insets(0, 0, 5, 5);
		gbc_lblSelectTypeTo.gridx = 1;
		gbc_lblSelectTypeTo.gridy = 3;
		contentPane.add(lblSelectTypeTo, gbc_lblSelectTypeTo);
		
		typeBox = new JComboBox();
		TypeList tL = new TypeList();
		tL.readFile();
		typeBox.setModel(new DefaultComboBoxModel(tL.toStringArray()));
		typeBox.addActionListener(this);
		typeBox.setActionCommand("1");
		GridBagConstraints gbc_typeBox = new GridBagConstraints();
		gbc_typeBox.insets = new Insets(0, 0, 5, 5);
		gbc_typeBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_typeBox.gridwidth = 2;
		gbc_typeBox.gridx = 2;
		gbc_typeBox.gridy = 3;
		contentPane.add(typeBox, gbc_typeBox);
		
		btnRemove = new JButton("Remove");
		btnRemove.setActionCommand("2");
		btnRemove.addActionListener(this);
		GridBagConstraints gbc_btnRemove = new GridBagConstraints();
		gbc_btnRemove.insets = new Insets(0, 0, 5, 0);
		gbc_btnRemove.gridx = 4;
		gbc_btnRemove.gridy = 3;
		contentPane.add(btnRemove, gbc_btnRemove);
	}
}
