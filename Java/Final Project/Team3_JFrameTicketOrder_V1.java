import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.BorderFactory;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

import javax.swing.SwingConstants;
import java.awt.Component;

public class Team3_JFrameTicketOrder_V1 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblGenAdCounter;
	private JLabel lblChildCounter;
	private JLabel lblSeniorCounter;
	private Team3_Counter_V1 genAdCounter;
	private Team3_Counter_V1 childAdCounter;
	private Team3_Counter_V1 seniorAdCounter;
	private Team3_Transaction_V1 transaction;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameTIcketOrder frame = new JFrameTIcketOrder(1,1);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public Team3_JFrameTicketOrder_V1(Team3_Transaction_V1 newTransaction) {
		transaction = newTransaction;
		genAdCounter = new Team3_Counter_V1();
		childAdCounter = new Team3_Counter_V1();;
		seniorAdCounter =new Team3_Counter_V1();;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 740, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		Border blackline;
		blackline = BorderFactory.createLineBorder(Color.black);
		
		JPanel panel = new JPanel();
		
		JPanel panel_1 = new JPanel();
		
		lblSeniorCounter = new JLabel("0");
		lblSeniorCounter.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeniorCounter.setBorder(blackline);
		
		JLabel lblSeniorCitizen = new JLabel("Senior Citizen:");
		
		JButton btnSeniorIncrement = new JButton("+");
		btnSeniorIncrement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seniorAdCounter.increment();
				lblSeniorCounter.setText(Integer.toString(seniorAdCounter.getCounter()));
			}
		});
		
		JButton btnSeniorDecrement = new JButton("-");
		btnSeniorDecrement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seniorAdCounter.decrement();
				lblSeniorCounter.setText(Integer.toString(seniorAdCounter.getCounter()));
			}
		});
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap(54, Short.MAX_VALUE)
					.addComponent(lblSeniorCitizen)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblSeniorCounter, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(btnSeniorDecrement, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnSeniorIncrement, GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(btnSeniorIncrement, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnSeniorDecrement, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(36)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(lblSeniorCitizen, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblSeniorCounter, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel_1.linkSize(SwingConstants.VERTICAL, new Component[] {btnSeniorIncrement, btnSeniorDecrement});
		panel_1.setLayout(gl_panel_1);
		
		JPanel panel_2 = new JPanel();
		
		lblChildCounter = new JLabel("0");
		lblChildCounter.setHorizontalAlignment(SwingConstants.CENTER);
		lblChildCounter.setBorder(blackline);
		
		JLabel lblChildren = new JLabel("Children:");
		
		JButton btnChildIncrement = new JButton("+");
		btnChildIncrement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				childAdCounter.increment();
				lblChildCounter.setText(Integer.toString(childAdCounter.getCounter()));
				
			}
		});
		
		JButton btnChildDecrement = new JButton("-");
		btnChildDecrement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				childAdCounter.decrement();
				lblChildCounter.setText(Integer.toString(childAdCounter.getCounter()));
			}
		});
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap(88, Short.MAX_VALUE)
					.addComponent(lblChildren)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblChildCounter, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(btnChildDecrement, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnChildIncrement, GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGap(0, 162, Short.MAX_VALUE)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(btnChildIncrement, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnChildDecrement, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(36)
							.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
								.addComponent(lblChildren, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblChildCounter, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel_2.linkSize(SwingConstants.VERTICAL, new Component[] {btnChildIncrement, btnChildDecrement});
		panel_2.setLayout(gl_panel_2);
		
		JButton btnContinue = new JButton("Continue");
		btnContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//ArrayList<Team3_ITicket_V1> ticket =new ArrayList<Team3_ITicket_V1>();
				
				if(Integer.parseInt(lblGenAdCounter.getText())>0)
					transaction.addTicket(new Team3_Ticket_V1(Integer.parseInt(lblGenAdCounter.getText())));
				if(Integer.parseInt(lblChildCounter.getText())>0)
					transaction.addTicket(new Team3_TicketChild_V1(Integer.parseInt(lblChildCounter.getText())));
				if(Integer.parseInt(lblSeniorCounter.getText())>0)
					transaction.addTicket(new Team3_TicketSenior_V1(Integer.parseInt(lblSeniorCounter.getText())));
				
				if(transaction.getNumOfTickets()>0){
					Team3_JFrameCheckout_V1 jframeCheckOut = new Team3_JFrameCheckout_V1(transaction);
					jframeCheckOut.setVisible(true);
					dispose();
				}
				else{
					JOptionPane.showMessageDialog(null, "Ticket amounts have not been selected.", "", JOptionPane.INFORMATION_MESSAGE);
				}
				
			}
		});
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Team3_JFrameMain_V1 jframeMain = new Team3_JFrameMain_V1();
				jframeMain.setVisible(true);
				dispose();
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 403, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 403, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel, GroupLayout.PREFERRED_SIZE, 403, GroupLayout.PREFERRED_SIZE))
							.addGap(158))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnContinue, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 452, Short.MAX_VALUE)
							.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(53)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnContinue, GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE))
					.addContainerGap())
		);
		
		JButton btnIncrementGenAdmission = new JButton("+");
		btnIncrementGenAdmission.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				genAdCounter.increment();
				lblGenAdCounter.setText(Integer.toString(genAdCounter.getCounter()));
			}
		});
		
		JButton btnDecrementGenAdmission = new JButton("-");
		btnDecrementGenAdmission.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				genAdCounter.decrement();;
				lblGenAdCounter.setText(Integer.toString(genAdCounter.getCounter()));
			}
		});
		
		lblGenAdCounter = new JLabel("0");
		lblGenAdCounter.setHorizontalAlignment(SwingConstants.CENTER);
		lblGenAdCounter.setBorder(blackline);
		
		JLabel lblGeneral = new JLabel("General Admission:");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap(19, Short.MAX_VALUE)
					.addComponent(lblGeneral, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblGenAdCounter, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(btnDecrementGenAdmission, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnIncrementGenAdmission, GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(btnIncrementGenAdmission, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnDecrementGenAdmission, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(36)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblGeneral, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblGenAdCounter, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel.linkSize(SwingConstants.VERTICAL, new Component[] {btnIncrementGenAdmission, btnDecrementGenAdmission});
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}
}
