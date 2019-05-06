package com.myapp.impl;


import com.myapp.dao.ProviderSFDao;
import com.myapp.jdbc.SFNameById;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProviderSFDaoImpl implements ProviderSFDao {
    @Autowired
    private SFNameById sfNameById;

    public String getNameById(Long id) {
        List<String> result = sfNameById.execute(id);
        try {
            return result.get(0);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }
}