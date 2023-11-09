package dto;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Patient {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	 int id;
	 String name;
	 long mobile1;
	 Date dob1;
	 int age;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

	public long getMobile1() {
		return mobile1;
	}

	public void setMobile1(long mobile1) {
		this.mobile1 = mobile1;
	}


	public Date getDob1() {
		return dob1;
	}

	public void setDob1(Date dob1) {
		this.dob1 = dob1;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	
}
