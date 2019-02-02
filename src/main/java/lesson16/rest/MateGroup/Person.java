package lesson16.rest.MateGroup;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * @author spasko
 */
@XmlTransient
@XmlSeeAlso({ Student.class, Teacher.class, HumanResource.class })
@JsonInclude(value = Include.NON_EMPTY)
public class Person implements Serializable {
	private String name;
	private String surname;
	private int yearOfBorn;
	private int personId;

	public Person() {
	}

	public Person(String name, String surname, int yearOfBorn, int personId) {
		this.name = name;
		this.surname = surname;
		this.yearOfBorn = yearOfBorn;
		this.personId = personId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getYearOfBorn() {
		return yearOfBorn;
	}

	public void setYearOfBorn(int yearOfBorn) {
		this.yearOfBorn = yearOfBorn;
	}

	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	@Override
	public String toString() {
		return "Person [id=" + personId + ", name=" + name + ", surname=" + surname + ", yearOfBorn=" + yearOfBorn + "]";
	}

}
