package com.myapp;

import com.myapp.dao.ItemDao;
import com.myapp.dao.ProviderDao;
import com.myapp.dao.ProviderSFDao;
import com.myapp.model.Item;
import com.myapp.model.Provider;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@ContextConfiguration("classpath:spring/spring-context.xml")
public class TestProvider extends AbstractJUnit4SpringContextTests {
	@Autowired
	private ProviderDao providerDao;
	@Autowired
	private ItemDao itemDao;
	@Autowired
	private ProviderSFDao providerSFDao;
	
	/**
	 * Test stored procedure
	 */
	@Test
	public void testStoredFunction() {
		String name = providerSFDao.getNameById(1l);
		assertEquals(name, "Gorge");
	}
	
	@Test
	public void testInsertProviderWithItems() {
		Provider provider = new Provider();
		provider.setName("Provider for testing");
		Set<Item> items = new HashSet<>();
		items.add(new Item("item1"));
		items.add(new Item("item2"));
		items.add(new Item("item3"));
		items.add(new Item("item4"));
		items.add(new Item("item5"));
		provider.setItems(items);
		Long id = providerDao.insertWithItems(provider);
		Provider providerFromDb = providerDao.findById(id);
		assertEquals(provider, providerFromDb);
		Set<Item> itemsFromDb = provider.getItems();

		for (Item itemFromDb : itemsFromDb) {
			assertEquals(items.contains(itemFromDb), true);
			itemDao.delete(itemFromDb);
		}
		providerDao.delete(providerFromDb);
	}		
	
	@Test
	public void testInsertFind() {
		Provider provider = new Provider();
		provider.setName("Provider for testing");
		Long id = providerDao.insert(provider);
		Provider providerFromDb = providerDao.findById(id);
		assertEquals(provider, providerFromDb);
		providerDao.delete(providerFromDb);		
	}
	
	@Test
	public void testInsertFindUpdate() {
		Provider provider = new Provider();
		provider.setName("Provider for testing");
		Long id = providerDao.insert(provider);
		Provider providerFromDb = providerDao.findById(id);
		providerFromDb.setName("Other provider");
		providerDao.update(providerFromDb);
		Provider updatedProviderFromDb = providerDao.findById(providerFromDb.getId());

		assertEquals(providerFromDb, updatedProviderFromDb);
		providerDao.delete(updatedProviderFromDb);	}
	
	@Test
	public void testDelete() {
		Provider provider = new Provider();
		provider.setName("Provider for testing");
		Long id = providerDao.insert(provider);
		Provider providerFromDb = providerDao.findById(id);
		providerDao.delete(providerFromDb);
		Provider providerAfterDeleting = providerDao.findById(providerFromDb.getId());

		assertNull(providerAfterDeleting);	}
}