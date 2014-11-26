package arraylist;

public class Contact {
	
	private String firstName;
	private String lastName;
	private String email;
	private String age;
	
	public Contact(){
		this("no first name", "no last name", "no email", "no age");
	}
	
	public Contact(String firstName, String lastName, String email, String age){
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.age = age;
	}
	
	public String getFirstName(){
		return this.firstName;
	}
	
	public String getLastName(){
		return this.lastName;
	}
	
	public String getEmail(){
		return this.email;
	}
	
	public String getAge(){
		return this.age;
	}
	
	public String toString(){
		return "{ Last Name: " + lastName + ", First Name: " + firstName + ", Email: " + email + ", age: " + age + "}";
	}

	public boolean equals(Object e){
		if(((Contact) e).getFirstName() == this.getFirstName() && ((Contact) e).getLastName() == this.getLastName() && ((Contact) e).getEmail() == this.getEmail() && ((Contact) e).getAge() == this.getAge())
			return true;
		return false;
	}

}
