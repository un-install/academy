package hw12;

import java.io.Serializable;

import javax.xml.bind.annotation.*;

/**
 * @author spasko
 */
@XmlRootElement(name = "Room")
public class Room implements Serializable {
	private String city;
	private String street;
	private int house;
	private int number;
	private Person roomOwner;

	public Room() {
	}

	public Room(String city, String street, int house, int number, Person roomOwner) {
		this.city = city;
		this.street = street;
		this.house = house;
		this.number = number;
		this.roomOwner = roomOwner;
	}

	@XmlAttribute
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@XmlAttribute
	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getHouse() {
		return house;
	}

	public void setHouse(int house) {
		this.house = house;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	@XmlElement(type = RoomOwner.class)
	public Person getRoomOwner() {
		return roomOwner;
	}

	public void setRoomOwner(Person roomOwner) {
		this.roomOwner = roomOwner;
	}

	@Override
	public String toString() {
		return "Room [city=" + city + ", street=" + street + ", house=" + house + ", number=" + number + "]";
	}

}
