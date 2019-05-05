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
public class InsertProvider extends SqlUpdate {
	public static final String NAME_PARAMETER = "name";
	
	private static final String PARAMETERIZED_SQL_INSERT_PROVDER = "INSERT INTO "
			+ Provider.TABLE_NAME + " (" + Provider.NAME_COLUMN
			+ ") VALUES (:" + NAME_PARAMETER + ")";	
	
	@Autowired
	private DataSource dataSource;
	
	@PostConstruct
	public void init() {
		setDataSource(dataSource);
		setSql(PARAMETERIZED_SQL_INSERT_PROVDER);
		declareParameter(new SqlParameter(NAME_PARAMETER, Types.VARCHAR));
		// Объявляем имя столбца для которого СУРБД генерирует ключ
		setGeneratedKeysColumnNames(new String[] { Provider.ID_COLUMN });
		// Заставить лежащий в основе драйвер JDBC извлечь сгенерированный ключ
		setReturnGeneratedKeys(true);
	}
}