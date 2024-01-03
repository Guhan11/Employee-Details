package com.example.office.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.office.entity.OfficeVO;
import com.example.office.service.OfficeService;

@RestController
@RequestMapping("/office")

public class OfficeController {

	public static final Logger LOGGER = LoggerFactory.getLogger(OfficeController.class);

	@Autowired
	OfficeService officeService;

	@GetMapping
	public List<OfficeVO> getAllEmployee() {
		LOGGER.debug("getAllEmplopyee Service Call Started...");
		List<OfficeVO> officeVO = new  ArrayList<>();
		try{
			 officeVO = officeService.getAllEmployee();
		LOGGER.info("Employee information get successfully for getAllEmploee");
		} catch (Exception e) {
			LOGGER.error("Failed to Fetch Employee Record for getAllEmployee", e.getMessage());
		}
		LOGGER.debug("getAllEmployee Service call Ended");
		return officeVO;
	}

	@GetMapping("/{id}")
	public OfficeVO getAllEmployeeById(@PathVariable int id) {
		LOGGER.debug("getAllEmployeeById Service call Started...");
		OfficeVO officeVO = new OfficeVO();
		try {
			officeVO = officeService.getAllEmployeeById(id);
			LOGGER.info("Employee information get successfully for id : {}", id);
		} catch (Exception e) {
			LOGGER.error("Failed to fetch employee record for id :{} error : {}", id, e.getMessage());
		}
		LOGGER.debug("getAllEmployeeById Service call Ended...");
		return officeVO;
	}

	@PostMapping
	public OfficeVO createEmployee(@RequestBody OfficeVO offVO) {
		LOGGER.debug(" createEmployee Service Call Strated...");
		OfficeVO officeVO = new OfficeVO();
		try {
			officeVO = officeService.createEmployee(offVO);
		LOGGER.info("Employee Information get successfull for officeVO", offVO);
		} catch (Exception e) {
		LOGGER.error("Failed to fetch employee record for officeVO ",offVO, e.getMessage());
		}
		LOGGER.debug("createEmployee Service Call Ended...");
		return officeVO;
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updateEmplopyee(@PathVariable int id, @RequestBody OfficeVO officeVO) {
		LOGGER.debug("updateEmployee Service Call Strated...");
		try {
			LOGGER.info("employee information get successfull for id and officeVO",id, officeVO);
		 officeService.updateEmplopyee(id, officeVO);		 
		} catch (Exception e) {
			LOGGER.error("Failed to fetch employee record for id and officeVO", id, officeVO, e.getMessage());
		}
		 LOGGER.debug("updateEmployee Service Call Ended...");
		 return ResponseEntity.ok().body("Updated Successfully");
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteEmployee(@PathVariable int id) {
		LOGGER.debug("deleteEmployee Service Call Strated...");
		try {
		 officeService.deleteEmployee(id);
		 LOGGER.info("Employee Information get successfull for id ", id);
		} catch (Exception e) {
			LOGGER.error("Failed to fetch employee record for id", id,e.getMessage());
		}
		LOGGER.debug("deleteEmployee Service Call Ended");
		 return ResponseEntity.ok().body("Deleted Successfully");
	}
}