import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class ReleaseTrackerGUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReleaseTrackerGUI window = new ReleaseTrackerGUI();
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
	public ReleaseTrackerGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{144, 142, 0};
		gridBagLayout.rowHeights = new int[]{30, 14, 39, 23, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JLabel lblWelcomeToRelease = new JLabel("Welcome To Release Tracker!");
		GridBagConstraints gbc_lblWelcomeToRelease = new GridBagConstraints();
		gbc_lblWelcomeToRelease.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblWelcomeToRelease.insets = new Insets(0, 0, 5, 0);
		gbc_lblWelcomeToRelease.gridx = 1;
		gbc_lblWelcomeToRelease.gridy = 1;
		frame.getContentPane().add(lblWelcomeToRelease, gbc_lblWelcomeToRelease);
		
		JButton btnCheckNewReleases = new JButton("Check Newly Released");
		btnCheckNewReleases.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewReleaseGUI newNR = new NewReleaseGUI();
				newNR.openNR();
				
			}
		});
		GridBagConstraints gbc_btnCheckNewReleases = new GridBagConstraints();
		gbc_btnCheckNewReleases.insets = new Insets(0, 0, 5, 0);
		gbc_btnCheckNewReleases.gridx = 1;
		gbc_btnCheckNewReleases.gridy = 2;
		frame.getContentPane().add(btnCheckNewReleases, gbc_btnCheckNewReleases);
		
		JButton btnShowList = new JButton("Show Upcoming Releases");
		btnShowList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpcomingEventGUI newUE =new UpcomingEventGUI();
				newUE.openUE();
			}
		});
		GridBagConstraints gbc_btnShowList = new GridBagConstraints();
		gbc_btnShowList.insets = new Insets(0, 0, 5, 0);
		gbc_btnShowList.gridx = 1;
		gbc_btnShowList.gridy = 3;
		frame.getContentPane().add(btnShowList, gbc_btnShowList);
		
		JButton btnAddEvent = new JButton("Add Event");
		btnAddEvent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddEventGUI newAE=new AddEventGUI();
				newAE.openAE();
				
			}
		});
		GridBagConstraints gbc_btnAddEvent = new GridBagConstraints();
		gbc_btnAddEvent.insets = new Insets(0, 0, 5, 0);
		gbc_btnAddEvent.gridx = 1;
		gbc_btnAddEvent.gridy = 5;
		frame.getContentPane().add(btnAddEvent, gbc_btnAddEvent);
		
		JButton btnEditEventTypes = new JButton("Edit Event Types");
		btnEditEventTypes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditTypeGUI newET= new EditTypeGUI();
				newET.openET();
				
			}
		});
		GridBagConstraints gbc_btnEditEventTypes = new GridBagConstraints();
		gbc_btnEditEventTypes.insets = new Insets(0, 0, 5, 0);
		gbc_btnEditEventTypes.gridx = 1;
		gbc_btnEditEventTypes.gridy = 6;
		frame.getContentPane().add(btnEditEventTypes, gbc_btnEditEventTypes);
	}

}
