package com.realdolmen.jpa;

import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.slf4j.LoggerFactory;
import org.junit.Before;
import org.slf4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by JHRAU70 on 10/09/2014.
 */
public class DataSetPersistenceTest extends PersistenceTest {
    private static final Logger logger = LoggerFactory.getLogger(DataSetPersistenceTest.class);

    @Before
    public void loadDataSet() throws Exception{
        logger.info("Loading dataset");
        Connection jdbcConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
        IDatabaseConnection connection = new DatabaseConnection(jdbcConnection);
        IDataSet dataSet = new FlatXmlDataSetBuilder().build(getClass().getResource("/data.xml"));
        DatabaseOperation.CLEAN_INSERT.execute(connection, dataSet);
    }
}
