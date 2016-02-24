package com.had.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.had.data.PerCapita;
import com.had.util.Constants;
import com.had.util.QueryHelper;

/**
 * @author Akshat Shukla
 * @since January 19, 2016
 */

public class PerCapitaDAO implements AbstractDAO {
    
	private static final String STATE_COLUMN_NAME = "STATE_NAME";
    private static final String PCI_2009_10_COLUMN_NAME = "PCI_2009_10";
    private static final String PCI_2010_11_COLUMN_NAME = "PCI_2010_11";
    
    List<PerCapita> perCapita;
    private String builtQuery;
	public PerCapitaDAO() {
		perCapita = new ArrayList<>();
        List<String> columns = new ArrayList<>();
        Map<String,String> tables= new ConcurrentHashMap<>();
        List<String> whereEquals= new ArrayList<>();
        columns.add(STATE_COLUMN_NAME);
        columns.add(PCI_2009_10_COLUMN_NAME);
        columns.add(PCI_2010_11_COLUMN_NAME);
        tables.put("pci_statewise","pc");
        tables.put("main_table","m");
        whereEquals.add("pc.STATE_ID = m.STATE_ID");
        builtQuery = QueryHelper.selectQuery(columns,tables,whereEquals,"m.STATE_ID");
		
	}
   
	 @Override
	    public void query() {
	        try
	        {
	            Class.forName(Constants.JDBC_DRIVER);
	            try (Connection connection = DriverManager.getConnection(Constants.DB_URL, Constants.USER, Constants.PASS);
	                 Statement statement = connection.createStatement();
	                 ResultSet rs = statement.executeQuery(builtQuery)) {
	                while (rs.next()) {
	                        addObject(new PerCapita(rs.getString(STATE_COLUMN_NAME), rs.getFloat(PCI_2009_10_COLUMN_NAME), rs.getFloat(PCI_2010_11_COLUMN_NAME)));
	                }
	            }
	        }
	        catch (Exception e)
	        {
	            e.printStackTrace();
	        }
	    }

    @Override
    public void addObject(Object obj) {
        perCapita.add((PerCapita) obj);
    }

    @Override
    public List<PerCapita> getList() {
        query();
        return perCapita;
    }
}
