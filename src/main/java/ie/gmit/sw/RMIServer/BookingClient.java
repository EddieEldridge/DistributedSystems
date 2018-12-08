package ie.gmit.sw.RMIServer;

import java.rmi.ConnectException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class BookingClient
{

	public static void main(String[] args) throws NotBoundException, RemoteException
	{

		try
		{

			// Create stub
			BookingRMIServerInterface bookingServiceStub = new BookingRMIServerImpl();

			// Bind the bookingServiceStub to the databaseServuce
			Naming.rebind("databaseService", bookingServiceStub);

			// Remote methods
			// bookingServiceStub.getBooking(1);
			bookingServiceStub.createBooking(null);

		}
		catch (Exception e)
		{
			System.out.println("Could not find registry: " + e);
		}

	}

}