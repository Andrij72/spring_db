package com.myapp.dao;

import com.myapp.model.Item;

import java.util.List;

public interface ItemDao {
    public Long insert(Item item);
    public List<Item> findAll();
    public Item findById(Long id);
    public Item findByName(String name);
    public void update(Item item);
    public void delete(Item item);
}
