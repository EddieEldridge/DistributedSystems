package ie.gmit.sw.RMIServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class BookingRMIServerImpl extends UnicastRemoteObject implements BookingRMIServerInterface
{
	// Variables
	String url = "jdbc:mysql://localhost:3306/G00337490BookingDB";
	String username = "root";
	String password = "";
	Statement statement = null;
	Connection connection = null;
	

	private static final long serialVersionUID = 1L;

	public BookingRMIServerImpl() throws RemoteException, SQLException
	{
		// Setup connection to database
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, username, password);
		} 
		catch (Exception e)
		{
			System.out.println("Connection error to database: "+e);
		}
	}


	// Shows all current bookings
	public List<BookingObject> getBookings()
	{
		// http://localhost:8080/DistributedSystemsG00337490/webapi/BookingSystem/showAllBookings
		
		// Create list to store bookings 
		List<BookingObject> bookingsList = new ArrayList<>();
		
		System.out.println("Getting all bookings...");
		        
		// Create the sql statement we went to execute on our db
		String sql = "select * from booking;";
		
		// Execute the statement
        try
		{
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
        	System.out.println("Executing statement: " + sql);

        	// While there is text read from the database
			while(rs.next())
			{
				// Create a new empty instance of bookingObject for each booking
				BookingObject bookingObject = new BookingObject();
				
				// Read in the data from the database to our object
				bookingObject.setBookingID(rs.getInt("bookingID"));
				bookingObject.setCustomerID(rs.getInt("customerID"));
				bookingObject.setCarID(rs.getInt("carID"));
				bookingObject.setBookingStartDate(rs.getString("bookingStartDate"));
				bookingObject.setBookingEndDate(rs.getString("bookingEndDate"));
				bookingObject.setCarRegistration(rs.getInt("carRegistration"));
				
				// Add the booking to our list of bookings retrieved from the database
				bookingsList.add(bookingObject);
			}
		} 
        catch (SQLException e)
		{
			System.out.println("SQL Error: " +e);
		}
           
        // Returns a list of booking objects from the database
		return bookingsList;
	}

	// Shows bookings with a specified ID
	@Override
	public BookingObject getBooking(int bookingID) throws RemoteException, SQLException
	{
		System.out.println("Getting booking...!");
		
		// Get all the bookings using the above getbookings Method
		List<BookingObject> bookingsList =  getBookings();
		BookingObject bookingObjectToReturn = new BookingObject();
			
		// Create the sql statement we went to execute on our
		String sql = "select * from booking where bookingID=" + bookingID +";";
		
		for (BookingObject booking : bookingsList) 
		 {
			  if (booking.getBookingID() == bookingID)
			  {
				  System.out.println("Booking found!");
				  bookingObjectToReturn = booking;
				  System.out.println(bookingObjectToReturn);
			  }
		  }
		return bookingObjectToReturn;		

	}

	// Create a booking
	@Override
	public void createBooking(BookingObject booking) throws RemoteException
	{
		
		// Create the sql statement we went to execute on our db
		System.out.println(url);
		String sql = "insert into booking(bookingID, customerID, carID, bookingStartDate, bookingEndDate, carRegistration) VALUES(" 
		+ booking.getBookingID() + "," 
		+ booking.getCustomerID() + ","
		+ booking.getCarID() + ","
		+ "'" + booking.getBookingStartDate() + "',"
		+ "'" + booking.getBookingEndDate() + "',"
		+ "'" + booking.getCarRegistration() + "')"
		+ ";";
				
		System.out.println("Creating booking...!");
		
		// Execute the statement
        try
		{
			Statement statement = connection.createStatement();
			statement.executeUpdate(sql);
        	System.out.println("Executing statement: " + sql);
		} 
        catch (SQLException e)
		{
			System.out.println("SQL Error: " +e);
		}
	}
	
	// Deletes a booking
	@Override
	public void deleteBooking(int bookingID) throws RemoteException
	{
		System.out.println("Deleting booking...!");
		
		// Create the sql statement we went to execute on our db
		String sql = "DELETE FROM Booking WHERE bookingID=" + bookingID +";";
		
		// Execute the statement
        try
		{
			Statement statement = connection.createStatement();
			statement.executeUpdate(sql);
        	System.out.println("Executing statement: " + sql);

			// Print result
			System.out.println("Booking deleted!");

		}
        catch (SQLException e)
		{
			System.out.println("SQL Error: " +e);
		}
        
	}

}
