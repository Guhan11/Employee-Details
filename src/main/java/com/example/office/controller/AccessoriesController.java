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

import com.example.office.entity.AccessoriesVO;
import com.example.office.entity.PropertyVO;
import com.example.office.service.AccessoriesService;
import com.example.office.service.PropertyService;

@RestController
@RequestMapping("/items")
public class AccessoriesController {

	public static final Logger LOGGER = LoggerFactory.getLogger(AccessoriesController.class)	;
	
	@Autowired
	AccessoriesService accessService;
	@Autowired
	PropertyService propService;
	
//access	
@GetMapping
public List<AccessoriesVO> getAllHolders(){
	LOGGER.debug("ACCESSORIES CONTROLLER ERROR");
	List<AccessoriesVO> accessVO = accessService.getAllHolders();
	return accessVO;
}

//prop
@GetMapping("/items")
public List<PropertyVO> getAllItems(){
	LOGGER.debug("PROPERTY CONTROLLER ERROR");
List<PropertyVO> propertyVO = propService.getAllItems();
return propertyVO;
}

//access

@GetMapping("/{id}")
public AccessoriesVO getHoldersById(@PathVariable int id) {
	LOGGER.debug("ACCESSORIES CONTROLLER ERROR");
	AccessoriesVO accessVO = accessService.getHolderssById(id);
	return accessVO;
}

//prop
@GetMapping("/items/{id}")
public PropertyVO getItemsById(@PathVariable int id) {
		LOGGER.debug("PROPERTY CONTROLLER ERROR");
	PropertyVO propertyVO = propService.getItemsById(id);
	return propertyVO;
}
	
//Access
@PostMapping
public AccessoriesVO createHolders(@RequestBody AccessoriesVO accessoriesVO) {
	LOGGER.debug("ACCESSORIES CONTROLLER ERROR");
	AccessoriesVO accessVO = accessService.createHolders(accessoriesVO);
	return accessVO;
}

//Prop
@PostMapping("/items")
public PropertyVO creatItems(@RequestBody PropertyVO propertyVO) {
	LOGGER.debug("PROPERTY CONTROLLER ERROR");
	PropertyVO updatedProperty = propService.createItems(propertyVO);
	return updatedProperty;
}

//Access
@PutMapping("/{id}")
public ResponseEntity<?> updateHolders(@PathVariable int id,@RequestBody AccessoriesVO accessoriesVO){
	LOGGER.debug("ACCESSORIES CONTROLLER ERROR");
	return accessService.updateHolders(id,accessoriesVO);
}

//prop

@PutMapping("/items/{id}")
public ResponseEntity<?> updateItems(@PathVariable int id,@RequestBody PropertyVO propertyVO){
	LOGGER.debug("PROPERTY CONTROLLER ERROR");
	return propService.updateItems(id,propertyVO);
}

//Access
@DeleteMapping("/{id}")
public ResponseEntity<?> deleteHolders(@PathVariable int id){
	LOGGER.debug("ACCESSORIES CONTROLLER ERROR");
	return accessService.deleteHolders(id);
}

//prop
@DeleteMapping("/items/{id}")
public ResponseEntity<?> deleteItems(@PathVariable int id){
	LOGGER.debug("PROPERTY CONTROLLER ERROR");
	return propService.deleteItems(id);
}
}
