package com.openlegacy.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.openlegacy.model.Item;

public interface ItemRepo extends JpaRepository<Item, Integer> {

}
