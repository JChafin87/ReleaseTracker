import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JLabel;


public class NewReleaseGUI extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTable table;
	private JTable table1;
	private DefaultTableModel nrTable;
	private LinkedList<Event> nrList;
	
	
	
	public void actionPerformed(ActionEvent e) {
		int action = Integer.parseInt(e.getActionCommand());
		int rowSelected = table1.getSelectedRow();
		switch (action) {
		case 0: //Add Event
			AddEventGUI newAE=new AddEventGUI();
			newAE.openAE();
			break;
		case 1: //Change Date
			
			int selectedDate = nrList.get(rowSelected).getRemindID();
			String selectedName = nrList.get(rowSelected).getEventName();
			System.out.println(selectedName+selectedDate);
			int dateValue = nrList.get(rowSelected).getEventDate().getID();
			ChangeDateGUI newCD=new ChangeDateGUI();
			int newDateValue = newCD.openCD(selectedName, selectedDate);
			System.out.println(newDateValue);
		case 2:
			EventList newList = new EventList();
			newList.readFile();
			int opt = JOptionPane.YES_NO_OPTION;
			int confirm2 = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this event?", "Warning", opt);
			if (confirm2 == 0) {
				newList.remove(nrList.get(rowSelected));
				newList.writeFile();
				setVisible(false);
			}
			else {
				
			}
			break;

		}
		
	}
	/**
	 * Launch the application.
	 */
	public static void openNR() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewReleaseGUI frame = new NewReleaseGUI();
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
	public NewReleaseGUI() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 392);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		
		EventList eTable = new EventList();
		eTable.readFile();
		
		//Create TableModel
		String[] col1 = {"Date","Name","Type"};
		nrTable = new DefaultTableModel(col1,0);
		
		//temp variables to populate Table
		EventDate tempDate = new EventDate();
		String tempDateName = "Jan 1 - 2015";
		String tempName = "Mario";
		String tempType = "Game";
		
		//compare to today
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Calendar today = Calendar.getInstance();
		int todayID = Integer.valueOf(sdf.format(today.getTime()));
		
		
		nrList = new LinkedList<Event>();
		
		//weeds out input file Events that have already released
		for (int i = 0; i <eTable.getList().size();i++) {
			Event tempEvent = new Event();
			tempEvent = eTable.getList().get(i);
			int idCheck = tempEvent.getRemindID();
			if(idCheck <= todayID) {
				tempDate = tempEvent.getEventDate();
				tempDateName = tempDate.toString();
				tempName = tempEvent.getEventName();
				tempType = tempEvent.getEventTypeName();
				Object[] data = {tempDateName, tempName, tempType};
				nrList.add(tempEvent);
				nrTable.addRow(data);
			}
		}
		
		table1 = new JTable(nrTable);
		table1.setFont(new Font("Arial", Font.PLAIN, 10));
		table1.setBackground(new Color(255, 255, 255));
		JScrollPane tableContainer = new JScrollPane(table1);
		
		
		
		tableContainer.setBounds(10, 23, 414, 228);
		contentPane.add(tableContainer);
		
		JButton btnRemoveEvent = new JButton("Remove Event");
		btnRemoveEvent.addActionListener(this);
		btnRemoveEvent.setActionCommand("2");
		btnRemoveEvent.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnRemoveEvent.setBounds(163, 277, 110, 23);
		contentPane.add(btnRemoveEvent);
		
		JLabel lblNewReleases = new JLabel("New Releases");
		lblNewReleases.setBounds(163, -2, 137, 14);
		contentPane.add(lblNewReleases);
	}
}
