package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import dto.Doctor;
import dto.Patient;
import dto.Staff;

public class HospitalDao {
EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("dev");
EntityManager entityManager=entityManagerFactory.createEntityManager();
EntityTransaction entityTransaction=entityManager.getTransaction();
public void doctorSignup(Doctor doctor) {
		entityTransaction.begin();
		entityManager.persist(doctor);
		entityTransaction.commit();
}
public void patientSignup(Patient patient) {
	entityTransaction.begin();
	entityManager.persist(patient);
	entityTransaction.commit();
}
public void staffSignup(Staff staff) {
	entityTransaction.begin();
	entityManager.persist(staff);
	entityTransaction.commit();
}
public Doctor findDoctor(long mobile) {
	List<Doctor> list = entityManager.createQuery("select x from Doctor x where mobile=?1").setParameter(1, mobile)
			.getResultList();
	if (list.isEmpty()) {
		return null;
	} else {
		return list.get(0);
	}
}

public Doctor findDoctor(String email) {
	List<Doctor> list = entityManager.createQuery("select x from Doctor x where email=?1").setParameter(1, email)
			.getResultList();
	if (list.isEmpty()) {
		return null;
	} else {
		return list.get(0);
	}
}
public List<Patient> fetchAllPatient() {
	return entityManager.createQuery("select x from Patient x").getResultList();
}
public Doctor findDoctor(int id) {
	return entityManager.find(Doctor.class,id);
	}
public Staff findStaff(int id) {
	return entityManager.find(Staff.class,id);
}
public Staff findStaff(long mobile) {
	List<Staff> list = entityManager.createQuery("select x from Staff x where mobile=?1").setParameter(1, mobile)
			.getResultList();
	if (list.isEmpty()) {
		return null;
	} else {
		return list.get(0);
	}
}
public Staff findStaff(String email) {
	List<Staff> list = entityManager.createQuery("select x from Staff x where email=?1").setParameter(1, email)
			.getResultList();
	if (list.isEmpty()) {
		return null;
	} else {
		return list.get(0);
	}
}
public List<Doctor> fetchAllDoctor() {
	return entityManager.createQuery("select x from Doctor x").getResultList();
}
public List<Staff> fetchAllStaff() {
	return entityManager.createQuery("select x from Staff x").getResultList();
}

public Patient fetchPatient(long mobile) {
	List<Patient> list = entityManager.createQuery("select x from Staff x where mobile=?1").setParameter(1, mobile)
			.getResultList();
	if (list.isEmpty()) {
		return null;
	} else {
		return list.get(0);
	}
}
public void savePatient(Patient patient) {
	entityTransaction.begin();
	entityManager.persist(patient);
	entityTransaction.commit();
}
public Patient fetchPatientById(int id){
	return entityManager.find(Patient.class, id);
}
public void updateAvailability(Doctor doctor) {
	entityTransaction.begin();
	entityManager.merge(doctor);
	entityTransaction.commit();
	
}
public void updateDoctor(Doctor doctor) {
	entityTransaction.begin();
	entityManager.merge(doctor);
	entityTransaction.commit();
}
public Doctor findAvailability() {
	return null;
	
}
public void updateStaff(Staff staff) {
	entityTransaction.begin();
	entityManager.merge(staff);
	entityTransaction.commit();
}
public Doctor fetchDoctorById(int id){
	return entityManager.find(Doctor.class, id);
}

public List<Doctor> fetchAvailableDoctors(){
	return entityManager.createQuery("select x from Doctor x where available=true").getResultList();
	
}
}
