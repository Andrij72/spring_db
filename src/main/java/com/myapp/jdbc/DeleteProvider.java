package com.myapp.jdbc;

import com.myapp.model.Provider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlUpdate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.Types;

@Component
public class DeleteProvider extends SqlUpdate {
    public static final String ID_PARAMETER = "id";

    private static final String PARAMETERIZED_SQL_DELETE_PROVDER = "DELETE FROM "
            + Provider.TABLE_NAME
            + " WHERE " + Provider.ID_COLUMN + " = :" + ID_PARAMETER;

    @Autowired
    private DataSource dataSource;

    @PostConstruct
    public void init() {
        setDataSource(dataSource);
        setSql(PARAMETERIZED_SQL_DELETE_PROVDER);
        declareParameter(new SqlParameter(ID_PARAMETER, Types.INTEGER));
    }
}