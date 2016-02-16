import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class ComboBoxExp extends JFrame implements ActionListener{

	private JPanel contentPane;
	public int comboBoxInt =0;
	public JComboBox comboBox;
	public JButton btnPrint;
	
	
	
	public void actionPerformed(ActionEvent e) {
		int action = Integer.parseInt(e.getActionCommand());
		if (action == 1)
		{
			JComboBox cb = (JComboBox) e.getSource();
			int newSelection = cb.getSelectedIndex();
		    comboBoxInt = newSelection;
		    System.out.println(comboBoxInt);
		}
		else if (action == 2) {
			System.out.println("The index of the combo box is: " + comboBoxInt);
		}
		
		System.out.println(comboBox.getSelectedIndex());
		
	}
	


	public int getComboBoxInt() {
		return comboBoxInt;
	}

	public void setComboBoxInt(int comboBoxInt) {
		this.comboBoxInt = comboBoxInt;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ComboBoxExp frame = new ComboBoxExp();
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
	public ComboBoxExp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		String[] s = {"I", "finally", "got", "this", "to", "work"};
		JComboBox comboBox = new JComboBox(s);
		comboBox.setActionCommand("1");
		//comboBox.addActionListener(this);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"I", "finally", "got", "this", "to", "work"}));
		contentPane.add(comboBox);
		
		JButton btnPrint = new JButton("Print");
		btnPrint.setActionCommand("2");
		btnPrint.addActionListener(this);
		contentPane.add(btnPrint);
	}

}
