import java.util.ArrayList;
import java.util.List;

public class Theatre {
	private final String theatreName;
	private List<Seat> seats=new ArrayList<>();
	public Theatre(String theatreName,int numRows,int seatsPerRow) {
		
		this.theatreName = theatreName;
		int lastRow=numRows-1+'A';
		for(char row='A';row<=lastRow;row++)
		{
			for(int seatNum=1;seatNum<=seatsPerRow;seatNum++)
			{
				Seat seat=new Seat(row+String.format("%02d", seatNum),false);
				this.seats.add(seat);
			}
		}
	}
	public String getTheatreName() {
		return theatreName;
	}
	
	
	public boolean reserveSeat(String seatNumber)
	{
		Seat requestSeat=null;
		for(Seat seat: seats)
		{
			if(seat.getSeatNumber().equals(seatNumber))
			{
				requestSeat=seat;
				break;
			}
		}
		if(requestSeat==null)
		{
			System.out.println("there is no seat "+seatNumber);
			return false;
		}
		else
		{
			return requestSeat.reserve();
		}
	}
	
	
	public void getSeats()
	{
		for(Seat seat :seats)
		{
			System.out.println(seat.getSeatNumber());
		}
	}
	
	private class Seat
	{
		private final String seatNumber;
		
		private boolean reserved=false;

		public Seat(String seatNumber, boolean reserved) {
			this.seatNumber = seatNumber;
		}

		public String getSeatNumber() {
			return seatNumber;
		}

		public boolean isReserved() {
			return reserved;
		}
		
		
		public boolean reserve()
		{
			if(!this.reserved)
			{
				this.reserved=true;
				
				System.out.println("seat locked , now pay for this seat");
				return true;
			}
			else
			{
				System.out.println("this seat is no longer available");
				return false;
			}
		}
		
		public boolean cancel()
		{
			if(this.reserved)
			{
				this.reserved=false;
				System.out.println("reservation of seat "+this.getSeatNumber()+" has been successfully cancelled");
				return true;
			}
			return false;
		}
		
		
		
		
		
		
		
	}

	
	
	
	

}
