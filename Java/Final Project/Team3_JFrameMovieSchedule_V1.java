import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Team3_JFrameMovieSchedule_V1 extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnCancel;
	private int day;
	private ArrayList<Team3_Movie_V1>  lstMovie;
	Map<String,Team3_ScheduleDetail_V1> btnNameToScheduleDetail = new HashMap<String,Team3_ScheduleDetail_V1>(200);
	Map<Integer,Team3_MovieRoom_V1> scheduleDetailToMovieRoom = new HashMap<Integer,Team3_MovieRoom_V1>(200);

	/**
	 * Create the frame.
	 */
	public Team3_JFrameMovieSchedule_V1(int newDay, ArrayList<Team3_Movie_V1> newLstMovie) {
		lstMovie = newLstMovie;
		day = newDay;
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		createLabels(contentPane);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 650);
		
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(this);
		btnCancel.setBounds(575, 554, 117, 53);
		contentPane.add(btnCancel);
	}
	
	public void actionPerformed(ActionEvent e){
		Team3_ScheduleDetail_V1 selectedScheduleDetail;
		Team3_MovieRoom_V1 selectedMovieRoom;
		Team3_Transaction_V1 transaction;
		
		if(e.getSource() == btnCancel)
		{
			String arg [] = new String [1];
			Team3_JFrameMain_V1.main(arg);
			dispose();
		}
		else
		{
					JButton j = (JButton) e.getSource();
					
					selectedScheduleDetail=btnNameToScheduleDetail.get(j.getText());
					selectedMovieRoom = scheduleDetailToMovieRoom.get(selectedScheduleDetail.getId());
					transaction = new Team3_Transaction_V1(selectedMovieRoom,selectedScheduleDetail.getStartTime());
					
					
					Team3_JFrameTicketOrder_V1 jframeTicketOrder = new Team3_JFrameTicketOrder_V1(transaction);
					jframeTicketOrder.setVisible(true);
					dispose();
		}
	}
	
	private void createLabels(JPanel panel){
		JLabel lblMovies;
		int y = 27;//starting point
		for(int i = 0;i<lstMovie.size();i++){
			lblMovies = new JLabel(lstMovie.get(i).getName());
			lblMovies.setBounds(6, y,(int)Math.ceil(lstMovie.get(i).getName().length()*8.71428571), 16);
			contentPane.add(lblMovies);
			y = createButtons(y,lstMovie.get(i));
		}
	}
	
	//buttons are created based on the schedule
	private int createButtons(int y, Team3_Movie_V1 movie){
		ArrayList<Team3_MovieRoom_V1> lstMovieRoom = Team3_Database_V1.getInstance().getMovieRoomByMovie(movie,day);
		JButton btnMovieTime;
		y +=15;
		int x = 6;
		int count = 1;
		int index = 0;
		for(int i = 0;i<lstMovieRoom.size();i++){
			
			for(int j = 0;j<lstMovieRoom.get(i).getNumOfSchedules();j++){
				
				btnNameToScheduleDetail.put(lstMovieRoom.get(i).getRoomLabel()+":"+lstMovieRoom.get(i).getScheduleByIndex(j).getStartTimeFormatted(), 
						lstMovieRoom.get(i).getScheduleByIndex(j));
				
				scheduleDetailToMovieRoom.put(lstMovieRoom.get(i).getScheduleByIndex(j).getId(), lstMovieRoom.get(i));
				
				btnMovieTime = new JButton(lstMovieRoom.get(i).getRoomLabel()+":"+lstMovieRoom.get(i).getScheduleByIndex(j).getStartTimeFormatted());
				btnMovieTime.setBounds(x, y, 117, 53);
				contentPane.add(btnMovieTime);
				btnMovieTime.addActionListener(this);
				
				index=index+1;
				
				if (count%4 ==0 && lstMovieRoom.get(i).getNumOfSchedules()>count) 
				{
					y = y+53;
					x = 6;
				}
				else x = x + 117;
				
				count = count +1;
			}
			y = y+60;
		}
		
		return y;
	}

}
