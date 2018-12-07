package core.builder;

public class TripDataBuilder {

	private String destination;
	private int daysFrom;
	private int daysTill;
	private int rooms;
	private int adults;
	private int children;

	public TripDataBuilder setDestination(String destination) {
		this.destination = destination;
		return this;
	}

	public TripDataBuilder setDaysFrom(int daysFrom) {
		this.daysFrom = daysFrom;
		return this;
	}

	public TripDataBuilder setDaysTill(int daysTill) {
		this.daysTill = daysTill;
		return this;
	}

	public TripDataBuilder setRooms(int rooms) {
		this.rooms = rooms;
		return this;
	}

	public TripDataBuilder setAdults(int adults) {
		this.adults = adults;
		return this;
	}

	public TripDataBuilder setChildren(int children) {
		this.children = children;
		return this;
	}

	public TripData build() {
		return new TripData(destination, daysFrom, daysTill, rooms, adults, children);
	}

}