/*
 * Student class
 * Holds: name, id, marks in 3 subjects, mobile no., email, branch
 */

package DayWiseAssignment.Day_7July;

import java.util.Arrays;

public class Student {
	private String name;
    private int id;
    private int[] marks; // marks in 3 subjects
    private String mobileNo;
    private String email;
    private String branch;

    public Student(String name, int id, int[] marks, String mobileNo, String email, String branch) {
        this.name = name;
        this.id = id;
        this.marks = marks;
        this.mobileNo = mobileNo;
        this.email = email;
        this.branch = branch;
    }
    
    public String getName() {
		return name;
	}
    

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int[] getMarks() {
		return marks;
	}

	public void setMarks(int[] marks) {
		this.marks = marks;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", id=" + id + ", marks=" + Arrays.toString(marks) + ", mobileNo=" + mobileNo
				+ ", email=" + email + ", branch=" + branch + "]";
	}
}
