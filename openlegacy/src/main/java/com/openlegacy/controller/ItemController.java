package com.openlegacy.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.openlegacy.dao.ItemRepo;
import com.openlegacy.model.Item;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;



@RestController
@RequestMapping("/api")
public class ItemController {

	@Autowired
	ItemRepo repo;
	
	@RequestMapping("/")
	public String home() {
		
		return "home.jsp";
	}
	
	@GetMapping("/items")
	@ApiOperation(value = "Lists all the items currently in the inventory")
	public List<Item> getItems() {
		
		return repo.findAll();
	}
	
	@RequestMapping("/item/{itemNumber}")
	@ApiOperation(value = "Fetches an item", notes = "Provide the number of the item to fetch", response = Item.class)
	public Optional<Item> getItem(@ApiParam(value = "The number of the item", required = true)
								  @PathVariable("itemNumber") int itemNumber) {
		
		return repo.findById(itemNumber);
	}	
	
	@PutMapping("/item")
	@ApiOperation(value = "Updates an item in the inventory", 
				  notes = "Provide the updated form of the item; returned message will indicate if the operation was successful", 
				  response = String.class)
	public String updateItem(@ApiParam(value = "The item itself", required = true)
							 @RequestBody Item item) {

		if (repo.findById(item.getItemNumber()).isPresent())
		{
			repo.save(item);
			
			return "Item successfuly updated";
		}
		else
		{
			return "Item not found!";
		}
	}
	
	@PostMapping("/item")
	@ApiOperation(value = "Adds an item to the inventory", 
	  			  notes = "Provide a new item; returned message will indicate if the operation was successful", 
	  			  response = String.class)
	public String addItem(@ApiParam(value = "The item itself", required = true)
						  @RequestBody Item item) {
		
		if (repo.findById(item.getItemNumber()).isEmpty())
		{
			repo.save(item);
			
			return "Item successfuly added";
		}
		else
		{
			return "Item already exists!";
		}
	}
	
	@DeleteMapping("/item/{itemNumber}")
	@ApiOperation(value = "Deletes an item from the inventory", 
	  			  notes = "Provide the number of the item to be deleted; returned message will indicate if the operation was successful", 
	  			  response = String.class)
	public String deleteItem(@ApiParam(value = "The number of the item", required = true)
							 @PathVariable int itemNumber) {
		
		if (repo.findById(itemNumber).isEmpty())
		{
			return "Item not found!";
		}
		repo.delete(repo.getOne(itemNumber));
		
		return "Item successfuly deleted!";
	}
	
}
