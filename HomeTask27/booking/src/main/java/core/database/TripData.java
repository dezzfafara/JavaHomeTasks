package core.database;

public class TripData {

	private String destination;
	private int daysFrom;
	private int daysTill;
	private int rooms;
	private int adults;
	private int children;

	public String getDestination() {
		return this.destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public int getDaysFrom() {
		return this.daysFrom;
	}

	public void setDaysFrom(int daysFrom) {
		this.daysFrom = daysFrom;
	}

	public int getDaysTill() {
		return this.daysTill;
	}

	public void setDaysTill(int daysTill) {
		this.daysTill = daysTill;
	}

	public int getRooms() {
		return this.rooms;
	}

	public void setRooms(int rooms) {
		this.rooms = rooms;
	}

	public int getAdults() {
		return this.adults;
	}

	public void setAdults(int adults) {
		this.adults = adults;
	}

	public int getChildren() {
		return this.children;
	}

	public void setChildren(int children) {
		this.children = children;
	}

}
