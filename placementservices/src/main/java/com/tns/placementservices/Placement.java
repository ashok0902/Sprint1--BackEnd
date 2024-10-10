package com.tns.placementservices;


import jakarta.persistence.*;

@Entity
public class Placement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String companyName;
    private String position;
    private String location;
    private String salaryPackage;
    private String driveDate;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getSalaryPackage() {
		return salaryPackage;
	}
	public void setSalaryPackage(String salaryPackage) {
		this.salaryPackage = salaryPackage;
	}
	public String getDriveDate() {
		return driveDate;
	}
	public void setDriveDate(String driveDate) {
		this.driveDate = driveDate;
	}
	public Placement() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Placement(Long id, String companyName, String position, String location, String salaryPackage,
			String driveDate) {
		super();
		this.id = id;
		this.companyName = companyName;
		this.position = position;
		this.location = location;
		this.salaryPackage = salaryPackage;
		this.driveDate = driveDate;
	}
    
    
}
