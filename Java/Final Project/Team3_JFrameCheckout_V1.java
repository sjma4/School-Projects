import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import java.awt.Color;

public class Team3_JFrameCheckout_V1 extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String[] columnNames = {"Quantity","Type","Movie","Price"};
	private String[][] data; 
	private JTable table;
	private Team3_Transaction_V1 transaction;

	/**
	 * Create the application.
	 */
	public Team3_JFrameCheckout_V1(Team3_Transaction_V1 newTransaction) {
		transaction = newTransaction;
		
		data = new String [newTransaction.getNumOfTickets()+1][4];
		String movieName = newTransaction.getMovieRoom().getMovie().getName();
		
		for(int i=0;i<newTransaction.getNumOfTickets();i++){
			data[i][0] = Integer.toString(newTransaction.getTicketByIndex(i).getNumTickets());
			data[i][1] = newTransaction.getTicketByIndex(i).getTicketType();
			data[i][2] = movieName;
			data[i][3] = String.format("%.2f", newTransaction.getTicketByIndex(i).getTotal());
		}
		
		data[data.length-1][2] = "Total";
		data[data.length-1][3]=String.format("%.2f", transaction.getTotal());
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//frame = new JFrame();
		setBounds(100, 100, 750, 650);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JButton btnPayCash = new JButton("Pay Cash");
		btnPayCash.setBounds(76, 485, 115, 29);
		getContentPane().add(btnPayCash);
		btnPayCash.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				transaction.setPaymentType("Cash");
				Team3_JFrameConfirmation_V1 jframeConfirmation = new Team3_JFrameConfirmation_V1(transaction);
				jframeConfirmation.setVisible(true);
				dispose();
			}
		});
		
		JButton btnPayCreditCard = new JButton("Pay Credit Card");
		btnPayCreditCard.setBounds(262, 485, 174, 29);
		getContentPane().add(btnPayCreditCard);
		btnPayCreditCard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				transaction.setPaymentType("Credit Card");
				Team3_JFrameConfirmation_V1 jframeConfirmation = new Team3_JFrameConfirmation_V1(transaction);
				jframeConfirmation.setVisible(true);
				dispose();
			}
		});
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(514, 485, 115, 29);
		getContentPane().add(btnCancel);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Team3_JFrameMain_V1 jframeMain = new Team3_JFrameMain_V1();
				jframeMain.setVisible(true);
				dispose();
			}
		});
		
		JLabel lblCart = new JLabel("Cart");
		lblCart.setBounds(327, 37, 69, 20);
		getContentPane().add(lblCart);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBounds(76, 98, 553, 317);
		getContentPane().add(scrollPane);
		
		table = new JTable(data,columnNames);
		scrollPane.setViewportView(table);
	}
	public boolean getTableCellSelectionEnabled() {
		return table.getCellSelectionEnabled();
	}
	public void setTableCellSelectionEnabled(boolean cellSelectionEnabled) {
		table.setCellSelectionEnabled(cellSelectionEnabled);
	}
}
