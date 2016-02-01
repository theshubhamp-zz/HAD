package com.had.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.had.data.GrossEnrollRatio;
import com.had.util.Constants;
import com.had.util.QueryHelper;

/**
 * @author Akshat Shukla
 * @since February 1, 2016
 */

public class GrossEnrollRatioDAO implements AbstractDAO {
    
	private static final String STATE_COLUMN_NAME = "STATE_NAME";
    private static final String ALL_MALE_COLUMN_NAME = "ALL_MALE";
    private static final String ALL_FEMALE_COLUMN_NAME = "ALL_FEMALE";
    private static final String ALL_TOTAL_COLUMN_NAME = "ALL_TOTAL";
    private static final String SC_MALE_COLUMN_NAME = "SC_MALE";
    private static final String SC_FEMALE_COLUMN_NAME = "SC_FEMALE";
    private static final String SC_TOTAL_COLUMN_NAME = "SC_TOTAL";
    private static final String ST_MALE_COLUMN_NAME = "ST_MALE";
    private static final String ST_FEMALE_COLUMN_NAME = "ST_FEMALE";
    private static final String ST_TOTAL_COLUMN_NAME = "ST_TOTAL";
    
    List<GrossEnrollRatio> grossEnroll;
    private String builtQuery;
	public GrossEnrollRatioDAO() {
		grossEnroll = new ArrayList<>();
        List<String> columns = new ArrayList<>();
        Map<String,String> tables= new ConcurrentHashMap<>();
        List<String> whereEquals= new ArrayList<>();
        columns.add(STATE_COLUMN_NAME);
        columns.add(ALL_MALE_COLUMN_NAME);
        columns.add(ALL_FEMALE_COLUMN_NAME);
        columns.add(ALL_TOTAL_COLUMN_NAME);
        columns.add(SC_MALE_COLUMN_NAME);
        columns.add(SC_FEMALE_COLUMN_NAME);
        columns.add(SC_TOTAL_COLUMN_NAME);
        columns.add(ST_MALE_COLUMN_NAME);
        columns.add(ST_FEMALE_COLUMN_NAME);
        columns.add(ST_TOTAL_COLUMN_NAME);
        tables.put("gross_enroll_ratio","ger");
        tables.put("main_table","m");
        whereEquals.add("ger.STATE_ID = m.STATE_ID");
        builtQuery = QueryHelper.selectQuery(columns,tables,whereEquals,"m.STATE_ID");
        System.out.println(builtQuery);
		
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
	                        addObject(new GrossEnrollRatio(rs.getString(STATE_COLUMN_NAME), rs.getFloat(ALL_MALE_COLUMN_NAME), rs.getFloat(ALL_FEMALE_COLUMN_NAME), rs.getFloat(ALL_TOTAL_COLUMN_NAME),
	                        		rs.getFloat(SC_MALE_COLUMN_NAME), rs.getFloat(SC_FEMALE_COLUMN_NAME), rs.getFloat(SC_TOTAL_COLUMN_NAME), rs.getFloat(ST_MALE_COLUMN_NAME), 
	                        		rs.getFloat(ST_FEMALE_COLUMN_NAME), rs.getFloat(ST_TOTAL_COLUMN_NAME)));

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
	    grossEnroll.add((GrossEnrollRatio) obj);
	    }

	 @Override
	    public List<GrossEnrollRatio> getList() {
	    query();
	    return grossEnroll;
	    }
	}

   
