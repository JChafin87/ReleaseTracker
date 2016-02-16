import java.awt.BorderLayout;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;


public class NewReleaseGUI extends JFrame {

	private JPanel contentPane;
	private JTable table1;

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
		setBounds(100, 100, 450, 423);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 240, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Get Event List
		EventList eTable = new EventList();
		eTable.readFile();
		
		//Create TableModel
		String[] col1 = {"Date","Name","Type"};
		DefaultTableModel nrTable = new DefaultTableModel(col1,0);
		
		//temp variables to populate Table
		EventDate tempDate = new EventDate();
		String tempDateName = "Jan 1 - 2015";
		String tempName = "Mario";
		String tempType = "Game";
		
		//populate Table and compare to today
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Calendar today = Calendar.getInstance();
		int todayID = Integer.valueOf(sdf.format(today.getTime()));
		for (int i = 0; i <eTable.eventList.size();i++) {
			Event tempEvent = new Event();
			tempEvent = eTable.eventList.get(i);
			int idCheck = tempEvent.getRemindID();
			if(idCheck <= todayID) {
				tempEvent = eTable.eventList.get(i);
				tempDate = tempEvent.getEventDate();
				tempDateName = tempDate.toString();
				tempName = tempEvent.getEventName();
				tempType = tempEvent.getEventTypeName();
				Object[] data = {tempDateName, tempName, tempType};
				nrTable.addRow(data);
			}
		}
		
		JTable table1 = new JTable(nrTable);
		table1.setFont(new Font("Arial", Font.PLAIN, 10));
		table1.setBackground(new Color(255, 255, 255));
		JScrollPane tableContainer = new JScrollPane(table1);
		
		
		tableContainer.setBounds(10, 23, 414, 228);
		contentPane.add(tableContainer);
		
		JButton btnGotIt = new JButton("Got It!");
		btnGotIt.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnGotIt.setBounds(26, 289, 89, 23);
		contentPane.add(btnGotIt);
		
		JButton btnChangeDate = new JButton("Change Date");
		btnChangeDate.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnChangeDate.setBounds(155, 289, 105, 23);
		contentPane.add(btnChangeDate);
		
		JButton btnRemindMeLater = new JButton("Remind Me Later");
		btnRemindMeLater.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnRemindMeLater.setBounds(294, 289, 130, 23);
		contentPane.add(btnRemindMeLater);
	}
}
