package com.mainacad.service;

import com.mainacad.dao.ItemDAO;
import com.mainacad.dao.mongo.NoSQLItemDAO;
import com.mainacad.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    ItemDAO itemDAO;

    @Autowired
    NoSQLItemDAO noSQLItemDAO;

    // SQL
    public Item save(Item item){
        return itemDAO.save(item);
    }

    public List<Item> getAll() {
        return itemDAO.findAll();
    }

    // NoSQL
    public void saveToMongo(Item item) {
        noSQLItemDAO.save(item);
    }

    public List<Item> getAllFromMongo() {
        return noSQLItemDAO.getAll();
    }

}
