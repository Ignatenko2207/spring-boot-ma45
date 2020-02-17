package com.mainacad.dao;

import com.mainacad.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemDAO extends JpaRepository<Item, Integer> {

}
