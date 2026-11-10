package sugunam;
import java.util.ArrayList;
import java.util.Scanner;

public class Hospital {
	

	static class Patients{

	int patientId;
	String name;
	int age;
	String genter;
	long phone;
	String disease;
	
	Patients( int patientId, String name, int age, String genter, long phone, String disease){
	this.patientId=patientId;
	this.name=name;
	this.age=age;
	this.genter=genter;
	this.phone=phone;
	this.disease=disease;
}
	void displaypatient() {
		System.out.println("PatientId: "+patientId);
		System.out.println("Name: "+name);
		System.out.println("Age: "+age);
		System.out.println("Genter: "+genter);
		System.out.println("Phone: "+phone);
		System.out.println("Disease: "+disease);
	
}
	}
	
	static class Doctor{
		int doctorId;
		String name;
		String specialization;
		
		Doctor(int doctorId, String name, String specialization){
			this.doctorId=doctorId;
			this.name=name;
			this.specialization=specialization;	
		}
		
		void displayDoctor() {
			System.out.println("DoctorId: "+doctorId);
			System.out.println("Name: "+name);
			System.out.println("Specialization: "+specialization);
		}
	}
		
	static class Appointment{
		int appointmentId;
		int patientId;
		int doctorId;
		String date;
		
		Appointment(int appointment, int patientId, int doctorId, String date){
			this.appointmentId=appointment;
			this.doctorId=doctorId;
			this.patientId=patientId;
			this.date=date;
		}
		
		void displayAppointment() {
			System.out.println("AppointmentId: "+appointmentId);
			System.out.println("PatientId: "+patientId);
			System.out.println("DoctorId: "+doctorId);
			System.out.println("Date: "+date);
		}
	}
	
	ArrayList<Patients>patients =new ArrayList<>();
	ArrayList<Doctor> doctors =new ArrayList<>();
	ArrayList<Appointment> appointments =new ArrayList<>();
	
	void addPatient(Patients p) {
		patients.add(p);
		System.out.println("Patient added successfully");		
	}
	
	void addDoctor(Doctor d) {
		doctors.add(d);
		System.out.println("Doctor added successfully");
	}
	
	void bookAppointment(Appointment a) {
		
		boolean patientFound= false;
		boolean doctorFound= false;
		
		for(Patients p : patients) {
			
			if(p.patientId == a.patientId) {
				patientFound=true;
				break;
			}
		}
		
		for(Doctor d:doctors){
			
			if(d.doctorId == a.doctorId) {
				doctorFound=true;
				break;
			}
		}
		
		 if (patientFound  && doctorFound) {
			 appointments.add(a);
			 System.out.println("Appointment booked successfull");
		 }
		 
		 else {
			 System.out.println("Invalid PatientId or DoctorId"); 		 
		 }
		 	}
	
	          void viewPatient() {
	        	  
		if(patients.isEmpty()) {
			
			System.out.println("No Paitents available");
			return;
		}
		
		for (Patients p: patients) {
			System.out.println("------------"); 
			p.displaypatient();
		}
	}
	          
	    void viewDoctors() {
		
		if (doctors.isEmpty()) {
			System.out.println("No Doctors available");
			return;
		}
		
		for(Doctor d: doctors) {
			System.out.println("------------");
			d.displayDoctor();
		}
	}
	    
	void viewAppointment() {
		
		if(appointments.isEmpty()) {
			System.out.println("No Appointment available");
			return;
		}
		
		for(Appointment a:appointments) {
			System.out.println("---------");
			a.displayAppointment();
		}
	}
	
	void searchPatient(int id) {
		
		for(Patients p: patients) {
			
			if(p.patientId == id) {
				System.out.println("Patient found") ;
				p.displaypatient();
				return;
			}
		}
		System.out.println("Patient not found") ;
		}
		
	public static void main(String[] args) {
     Scanner s=new Scanner(System.in);
     Hospital h = new Hospital();
     int choice;
     do {
    	 
    	 System.out.println("\n ====== HOSPITAL MANAGEMENT SYSTEM ====== ");
    	 System.out.println("1.Add Patient");
    	 System.out.println("2.Add Doctor");
    	 System.out.println("3.Book Appointment");
    	 System.out.println("4.View patient details");
    	 System.out.println("5.view doctor details");
    	 System.out.println("6.view all patients");
    	 System.out.println("7.Search Patient");
    	 System.out.println("8.View appointment");
    	 System.out.println("9.Exit");
    	 System.out.println("10. Enter your choice");
    	 
    	 choice =Integer.parseInt(s.nextLine());
    	 switch(choice){
    	  
    	 case 1:
    		 System.out.println("Enter PatientId: "); 
    		 int pid = Integer.parseInt(s.nextLine());
    		 
    		 System.out.println("Enter Name");
    		 String name = s.nextLine();
    		 
    		 System.out.println("Enter age");
    		int age = Integer.parseInt(s.nextLine());
    		
    		System.out.println("Enter Genter");
    		String genter = s.nextLine();
    		
    		System.out.println("Enter phone");
    		long phone = s.nextLong();
    		
    		System.out.println("Enter disease");
    		String disease =s.nextLine();
    		 
    		 Patients p=new Patients(pid, name,age, genter, phone,disease);
    		 h.addPatient(p);
    		 break;
    		 
    	 case 2:
    		 System.out.println("Enter DoctorId");
    		 int did= Integer.parseInt(s.nextLine());
    		 
    		 System.out.println("Enter Name");
    		 String doctorname =s.nextLine();
    		 
    		 System.out.println("Enter Specialization ");
    		 String specialization =s.nextLine();
    		 
    		 Doctor d= new Doctor(did, doctorname, specialization);
    		 h.addDoctor(d);
    		 break;
    		 
    	 case 3:
    		 System.out.println("Enter Appointment");
             int aid =Integer.parseInt(s.nextLine());
             
             System.out.println("Enter PatientId");
             int patientid= Integer.parseInt(s.nextLine());
             
             System.out.println("Enter DoctorId");
             int doctorid= Integer.parseInt(s.nextLine());
             
             System.out.println("Enter Date");
             String date= s.nextLine();
             
             Appointment app = new Appointment (aid, patientid,doctorid, date);
             h .bookAppointment(app);
 
    	 case 4:
    		 h.viewPatient();
    		 break;
    		 
    	 case 5:
    		 h.viewDoctors();
    		 break;
    		 
    	 case 6:
    		 System.out.println("Enter PatientId: ");
    		 
    		 int seachId=Integer.parseInt(s.nextLine());
    		 h.searchPatient(seachId);	 
    		 break;
    		 
    	 case 7:
    		 h.viewAppointment();
    		 break;
    		 
    	 case 8:
    		 System.out.println("Thank you");
    		 break;
    		 
    		 default:
    			 System.out.println("Invalid choice");
    		 }
    	 }
     while(choice!=8);
     
     s.close();
}
}
