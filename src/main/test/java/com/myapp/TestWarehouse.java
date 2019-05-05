package com.myapp;

import com.myapp.dao.WarehouseDao;
import com.myapp.model.Warehouse;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@ContextConfiguration("classpath:spring/spring-context.xml")
public class TestWarehouse extends AbstractJUnit4SpringContextTests {
	@Autowired
	private WarehouseDao warehouseDao;	
	
	@Test
	public void testInsertFind() {
		Warehouse warehouse = new Warehouse();
		warehouse.setAddress("vul. Kreschatik, 6");
		Long id = warehouseDao.insert(warehouse);
		Warehouse warehouseFromDb = warehouseDao.findById(id);
		assertEquals(warehouse, warehouseFromDb);
		warehouseDao.delete(warehouseFromDb);	}
	
	@Test
	public void testInsertFindUpdateDelete() {
		Warehouse warehouse = new Warehouse();
		warehouse.setAddress("vul. Kreschatik, 6");
		Long id = warehouseDao.insert(warehouse);
		Warehouse warehouseFromDb = warehouseDao.findById(id);
		warehouseFromDb.setAddress("vul.Musejna, 4");
		warehouseDao.update(warehouseFromDb);
		Warehouse updatedWarehouseFromDb = warehouseDao.findById(warehouseFromDb.getId());
		assertEquals(warehouseFromDb, updatedWarehouseFromDb);
		warehouseDao.delete(updatedWarehouseFromDb);	}
	
	@Test
	public void testInsertFindDelete() {
		Warehouse warehouse = new Warehouse();
		warehouse.setAddress("Test procedure");
		Long id = warehouseDao.insert(warehouse);
		Warehouse warehouseToDelete = warehouseDao.findById(id);
		warehouseDao.delete(warehouseToDelete);
		Warehouse warehouseAfterDeleting = warehouseDao.findById(id);
		assertNull(warehouseAfterDeleting);	}
}