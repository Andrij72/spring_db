package com.myapp.jdbc;

import com.myapp.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.BatchSqlUpdate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.Types;

@Repository
public class InsertItem extends BatchSqlUpdate {
    public static final String NAME_PARAMETER = "name";
    private static final String SQL_INSERT_ITEMS = "INSERT INTO " + Item.TABLE_NAME
            + " (" + Item.NAME_COLUMN + ")"
            + " VALUES (:" + NAME_PARAMETER + ")";
    private static final int BATCH_SIZE = 10;

    @Autowired
    private DataSource dataSource;

    @PostConstruct
    public void init() {
        setDataSource(dataSource);
        setSql(SQL_INSERT_ITEMS);
        declareParameter(new SqlParameter(NAME_PARAMETER, Types.VARCHAR));
        setBatchSize(BATCH_SIZE);
        setGeneratedKeysColumnNames(new String[]{Item.ID_COLUMN});
        setReturnGeneratedKeys(true);
    }
}
