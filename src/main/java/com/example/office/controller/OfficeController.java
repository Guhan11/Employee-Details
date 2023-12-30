package com.example.office.controller;

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
		LOGGER.debug("OFFICE CONTROLLER ERROR");
		List<OfficeVO> officeVO = officeService.getAllEmployee();
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
	public OfficeVO createEmployee(@RequestBody OfficeVO officeVO) {
		LOGGER.debug(" OFFICE CONTROLLER  ERROR");
		OfficeVO updatedOfficeVO = officeService.createEmployee(officeVO);
		return updatedOfficeVO;
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updateEmplopyee(@PathVariable int id, @RequestBody OfficeVO officeVO) {
		LOGGER.debug(" OFFICE CONTROLLER  ERROR");
		return officeService.updateEmplopyee(id, officeVO);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteEmployee(@PathVariable int id) {
		LOGGER.debug(" OFFICE CONTROLLER  ERROR");
		return officeService.deleteEmployee(id);
	}
}