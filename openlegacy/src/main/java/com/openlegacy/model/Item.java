package com.openlegacy.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@ApiModel(description = "Details about the item")
public class Item {
	
	@Id
	@ApiModelProperty(notes = "The unique number of the item")
	private Integer itemNumber;
	@ApiModelProperty(notes = "The name of the item")
	private String  itemName;
	@ApiModelProperty(notes = "The number of item units in stock")
	private Integer itemAmount;
	@ApiModelProperty(notes = "The inventory code of the item")
	private Integer itemInventoryCode;
	
	public int getItemNumber() {
		return itemNumber;
	}
	public void setItemNumber(Integer itemNumber) {
		this.itemNumber = itemNumber;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getItemAmount() {
		return itemAmount;
	}
	public void setItemAmount(Integer itemAmount) {
		this.itemAmount = itemAmount;
	}
	public int getItemInventoryCode() {
		return itemInventoryCode;
	}
	public void setItemInventoryCode(Integer itemInventoryCode) {
		this.itemInventoryCode = itemInventoryCode;
	}
	@Override
	public String toString() {
		return "Item [itemNumber=" + itemNumber + ", itemName=" + itemName + ", itemAmount=" + itemAmount + ", itemInventoryCode=" + itemInventoryCode + "]";
	}

}
