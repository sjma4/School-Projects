import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Team3_JFrameConfirmation_V1 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	/**
	 * Create the frame.
	 */
	public Team3_JFrameConfirmation_V1(Team3_Transaction_V1 transaction) {
		
		Team3_Database_V1.getInstance().saveTransaction(transaction);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblConfirmation = new JLabel(transaction.toString());
		lblConfirmation.setBounds(192, 230, 366, 167);
		contentPane.add(lblConfirmation);
		
		JButton btnFinished = new JButton("Finished");
		btnFinished.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Team3_JFrameMain_V1 jframeMain = new Team3_JFrameMain_V1();
				jframeMain.setVisible(true);
				dispose();
			}
		});
		btnFinished.setBounds(36, 566, 167, 43);
		contentPane.add(btnFinished);
	}

}
