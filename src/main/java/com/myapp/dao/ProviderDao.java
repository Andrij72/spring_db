package com.myapp.dao;

import com.myapp.model.Provider;

import java.util.List;

public interface ProviderDao {
	public Provider findById(Long id);
	public Long insert(Provider provider);
	public List<Provider> findAll();
	public void update(Provider provider);
	public void delete(Provider provider);
	public Long insertWithItems(Provider provider);
}
