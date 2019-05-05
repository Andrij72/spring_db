package com.myapp;

import com.myapp.dao.ItemDao;
import com.myapp.model.Item;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/*This  class  TestItem realise next methods:
 * - create a test object
 * - save the test object in the database
 * - pull the test object out of the database
 * - compare the pulled object from the database with the test object
 * - remove the test object from the database
 */
@ContextConfiguration("classpath:spring/spring-context.xml")
public class TestItem extends AbstractJUnit4SpringContextTests {
	@Autowired
	private ItemDao itemDao;
	
	@Test
	public void testInsertFind() {
		Item item = new Item();
		item.setName("Richard");
		item.setWarehouseId(2l);
		Long id = itemDao.insert(item);
		Item itemFromDb = itemDao.findById(id);
		assertEquals(item, itemFromDb);
		itemDao.delete(itemFromDb);
	}
	
	@Test
	public void testInsertFindUpdate() {
		Item item = new Item();
		item.setName("Andrew");
		item.setWarehouseId(2l);
		Long id = itemDao.insert(item);
		Item itemFromDb = itemDao.findById(id);
		itemFromDb.setName("Valdemar");
		itemDao.update(itemFromDb);
		Item updatedItemFromDb = itemDao.findById(itemFromDb.getId());
		assertEquals(itemFromDb, updatedItemFromDb);
		itemDao.delete(updatedItemFromDb);
	}
	
	@Test
	public void testDelete() {
		Item item = new Item();
		item.setName("Test prosedure");
		item.setWarehouseId(2l);
		Long id = itemDao.insert(item);
		Item itemToDelete = itemDao.findById(id);
		itemDao.delete(itemToDelete);
		Item itemAfterDeleting = itemDao.findById(id);

		assertNull(itemAfterDeleting);
	}
}