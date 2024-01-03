package com.example.office.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "employee_details")
@Data
public class EmployeeVO {

	@Id
	@GeneratedValue(strategy  = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String emailId;
	private String password;
	private int ssoType;
	private boolean activeAt = true;
	
	
}
	
