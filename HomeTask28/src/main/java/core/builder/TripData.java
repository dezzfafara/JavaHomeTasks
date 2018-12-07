package core.builder;

public class TripData {
	private String destination;
	private int daysFrom;
	private int daysTill;
	private int rooms;
	private int adults;
	private int children;

	public TripData(String destination, int daysFrom, int daysTill, int rooms, int adults, int children) {
		this.destination = destination;
		this.daysFrom = daysFrom;
		this.daysTill = daysTill;
		this.rooms = rooms;
		this.adults = adults;
		this.children = children;
	}

	public String getDestination() {
		return destination;
	}

	public int getDaysFrom() {
		return daysFrom;
	}

	public int getDaysTill() {
		return daysTill;
	}

	public int getRooms() {
		return rooms;
	}

	public int getAdults() {
		return adults;
	}

	public int getChildren() {
		return children;
	}

	@Override
	public String toString() {
		return "TripData:: [destination=" + destination + ", daysFrom=" + daysFrom + ", daysTill=" + daysTill
				+ ", rooms=" + rooms + ", adults=" + adults + ", children=" + children + "]";
	}

}