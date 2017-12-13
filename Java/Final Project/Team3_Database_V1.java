
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
/**  
* Team3_Database_V1.java - This class works with the database to retrieve and update the data  
* @author  Alexander Saint-Hilaire
* @version 1.0 
*/ 
public class Team3_Database_V1 {
	
	private final String host ="jdbc:mysql://104.131.126.14:3306/Theatre?useSSL=false";
	private final String userName = "ASaint-Hilaire";
	private final String password="J@ffe&alex4life";
	private Connection connection;
	
   /**  
    * gets an instance of the database class  
    * @return Database object.  
    */  
	public static Team3_Database_V1 getInstance(){
		return new Team3_Database_V1(); 
	}
	
	public Team3_Database_V1(){ }
	
   /**  
    * Gets the movies playing for the day passed and receives a boolean to check if it is the current day  
    * @return list of movie objects.  
    */  
	public ArrayList<Team3_Movie_V1> getMovie(int day, boolean isToday)
	{  
		PreparedStatement movieQuery;
		Team3_Movie_V1 movie;
		SimpleDateFormat sdf = new SimpleDateFormat( "HH:mm" );
		ArrayList<Team3_Movie_V1>  movArr = new ArrayList<Team3_Movie_V1>();
		String query = "select id, movie_name, date_added, movie_status "
				+"from Theatre.movie "
				+"where id in (Select movie_fk "
				+"From Theatre.room Join Theatre.showtime on room.id = showtime.room_fk "
				+"Join Theatre.showtime_detail On showtime.id = showtime_detail.schedule_fk "
				+"Where showtime_detail.movie_day = ? and showtime_detail.start_time>=?)";
		
		try{  
				Class.forName("com.mysql.jdbc.Driver"); 
				connection=DriverManager.getConnection(host,userName,password);
				movieQuery=connection.prepareStatement(query);   
				movieQuery.setInt(1, day);
				
				if(isToday) movieQuery.setString(2,sdf.format(Calendar.getInstance().getTime()));
				else {
					movieQuery.setString(2,"00:00:00");
				}
				
				ResultSet rs=movieQuery.executeQuery();  
				while(rs.next())  
				{
					movie= new Team3_Movie_V1();
					
					if(rs.getString(4).toUpperCase().equals("OPEN")) movie.setStatus(true);
					else movie.setStatus(false);
					
					movie.setDtAdded(rs.getDate(3));
					movie.setName(rs.getString(2));
					movie.setId(rs.getInt(1));
					movArr.add(movie);
				}  
				connection.close();
		}
		catch(Exception e){ System.out.println(e);}  
		return movArr;
	}  
	
   /**  
    * gets the available movie rooms by day and movie  
    * @return list of movieroom objects.  
    */ 
	public ArrayList<Team3_MovieRoom_V1> getMovieRoomByMovie(Team3_Movie_V1 movie, int day)
	{  
		ArrayList<Team3_MovieRoom_V1>  lstMovieRoom = new ArrayList<Team3_MovieRoom_V1>();
		PreparedStatement movieRoomQuery;
		String query = "select id, room_num, capacity from room where movie_fk = ?";
		Team3_MovieRoom_V1 movieRoom;
		try{  
				Class.forName("com.mysql.jdbc.Driver"); 
				connection=DriverManager.getConnection(host,userName,password);
				movieRoomQuery=connection.prepareStatement(query); 
				movieRoomQuery.setInt(1, movie.getId());
				ResultSet rs=movieRoomQuery.executeQuery();  
				while(rs.next())  
				{	
					movieRoom = new Team3_MovieRoom_V1(getScheduleDetailByMovieRoomId(rs.getInt(1),day));
					movieRoom.setId(rs.getInt(1));
					movieRoom.setRoomLabel(rs.getString(2));
					movieRoom.setMovie(movie);
					lstMovieRoom.add(movieRoom);
				}  
				connection.close();
		}
		catch(Exception e){ System.out.println(e);}  
		return lstMovieRoom;
	}

   /**  
    * gets the schedule detail for movie rooms based on movieroom id and day  
    * @return list of scheduledetail objects.  
    */ 
	public ArrayList<Team3_ScheduleDetail_V1> getScheduleDetailByMovieRoomId(int movieRoomId, int day){
		ArrayList<Team3_ScheduleDetail_V1>  lstScheduleDetail = new ArrayList<Team3_ScheduleDetail_V1>();
		PreparedStatement scheduleQuery;
		String query = "SELECT showtime_detail.id, showtime_detail.movie_day, showtime_detail.start_time "
						+"FROM Theatre.showtime Join Theatre.showtime_detail ON showtime.id = showtime_detail.schedule_fk Where room_fk = ? "
						+"and showtime_detail.movie_day = ?";
		Team3_ScheduleDetail_V1 schedule;
		try{  
				Class.forName("com.mysql.jdbc.Driver"); 
				connection=DriverManager.getConnection(host,userName,password);
				scheduleQuery=connection.prepareStatement(query); 
				scheduleQuery.setInt(1, movieRoomId);
				scheduleQuery.setInt(2, day);
				ResultSet rs=scheduleQuery.executeQuery();  
				while(rs.next())  
				{
					schedule = new Team3_ScheduleDetail_V1();
					schedule.setId(rs.getInt(1));
					schedule.setStartTime(rs.getTime(3));
					lstScheduleDetail.add(schedule);
				}  
				connection.close();
		}
		catch(Exception e){ System.out.println(e);}  
		return lstScheduleDetail;
	}

   /**  
    * inserts transaction into the database  
    */  
	public void saveTransaction(Team3_Transaction_V1 transaction){
		PreparedStatement insertTransaction;
		int transactionId;
		String query = "INSERT INTO Theatre.trans(userID, GUID) ";
			query = query +"VALUES(?,?);";
		try{  
				Class.forName("com.mysql.jdbc.Driver"); 
				connection=DriverManager.getConnection(host,userName,password);
				insertTransaction=connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS); 
				insertTransaction.setString(1, "DEMO");
				insertTransaction.setString(2,transaction.getGuid().toString());
				
				insertTransaction.executeUpdate();
				ResultSet generatedKeys = insertTransaction.getGeneratedKeys();
				generatedKeys.next();
				transactionId = generatedKeys.getInt(1);
				
				query = "INSERT INTO Theatre.trans_detail(amount, ticket_type, ticket_quantity, movie_fk, trans_fk, movie_time, payment_type) ";
				query = query +"VALUES(?,?,?,?,?,?,?);";
				
				insertTransaction=connection.prepareStatement(query); 
				
				for(int i = 0;i<transaction.getNumOfTickets();i++){
					insertTransaction.setDouble(1, transaction.getTicketByIndex(i).getTotal());
					insertTransaction.setString(2, transaction.getTicketByIndex(i).getTicketType());
					insertTransaction.setInt(3, transaction.getTicketByIndex(i).getNumTickets());
					insertTransaction.setInt(4,transaction.getMovieRoom().getMovie().getId());
					insertTransaction.setInt(5,transactionId);
					insertTransaction.setTime(6, transaction.getMovieTime());
					insertTransaction.setString(7,transaction.getPaymentType());
					insertTransaction.executeUpdate();
				}
				

				connection.close();
		}
		catch(Exception e){ System.out.println(e);}  
	}
	
}

