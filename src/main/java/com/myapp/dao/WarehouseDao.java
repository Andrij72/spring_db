package com.myapp.dao;

import com.myapp.model.Item;
import com.myapp.model.Warehouse;

import java.util.List;

public interface WarehouseDao {
    String ID_PARAMETER = "id";
    String ADDRESS_PARAMETER = "address";
    String COMMA = ", ";

    String SQL_FIND_ALL = "SELECT * FROM " + Warehouse.TABLE_NAME;
    String SQL_FIND_WAREHOUSES_WITH_ITEMS = "SELECT "
            + Warehouse.ALIAS_TABLE_NAME + "." + Warehouse.ID_COLUMN + COMMA
            + Warehouse.ALIAS_TABLE_NAME + "." + Warehouse.ADDRESS_COLUMN + COMMA
            + Item.ALIAS_TABLE_NAME + "." + Item.ID_COLUMN + " AS " + Item.ALIAS_ID_ITEM_COLUMN + COMMA
            + Item.ALIAS_TABLE_NAME + "." + Item.NAME_COLUMN + COMMA
            + Item.ALIAS_TABLE_NAME + "." + Item.WAREHOUSE_ID_COLUMN
            + " FROM " + Warehouse.TABLE_NAME + " " + Warehouse.ALIAS_TABLE_NAME
            + " LEFT JOIN " + Item.TABLE_NAME + " " + Item.ALIAS_TABLE_NAME
            + " ON " + Warehouse.ALIAS_TABLE_NAME + "." + Warehouse.ID_COLUMN + " = " + Item.ALIAS_TABLE_NAME + "." + Item.WAREHOUSE_ID_COLUMN;
    String PARAMETERIZED_SQL_FIND_BY_ID = SQL_FIND_ALL + " where " + Warehouse.ID_COLUMN + " = :" + ID_PARAMETER;
    String PARAMETERIZED_SQL_INSERT = "INSERT INTO " + Warehouse.TABLE_NAME + " (" + Warehouse.ADDRESS_COLUMN + ") VALUES (:" + ADDRESS_PARAMETER + ")";
    String PARAMETERIZED_SQL_UPDATE = "UPDATE " + Warehouse.TABLE_NAME + " SET " + Warehouse.ADDRESS_COLUMN + " = :" + ADDRESS_PARAMETER + " WHERE " + Warehouse.ID_COLUMN + " = :" + ID_PARAMETER;
    String PARAMETERIZED_SQL_DELETE = "DELETE FROM " + Warehouse.TABLE_NAME + " WHERE " + Warehouse.ID_COLUMN + " = :" + ID_PARAMETER;

    public List<Warehouse> findAll();

    public List<Warehouse> findWarehousesWithItems();

    public Warehouse findById(Long id);

    public Long insert(Warehouse warehouse);

    public void update(Warehouse warehouse);

    public void delete(Warehouse warehouse);
}