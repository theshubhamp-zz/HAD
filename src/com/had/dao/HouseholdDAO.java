package com.had.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.had.data.Household;
import com.had.util.Constants;
import com.had.util.QueryHelper;

/**
 * @author Akshat Shukla
 * @since February 1, 2016
 */

public class HouseholdDAO implements AbstractDAO {
    
	private static final String STATE_COLUMN_NAME = "STATE_NAME";
    private static final String URT_ID_COLUMN_NAME = "URT_ID";
    private static final String HHSIZE_1_COLUMN_NAME = "HHSIZE_1";
    private static final String HHSIZE_2_COLUMN_NAME = "HHSIZE_2";
    private static final String HHSIZE_3_COLUMN_NAME = "HHSIZE_3";
    private static final String HHSIZE_4_COLUMN_NAME = "HHSIZE_4";
    private static final String HHSIZE_5_COLUMN_NAME = "HHSIZE_5";
    private static final String HHSIZE_6_COLUMN_NAME = "HHSIZE_6";
    private static final String HHSIZE_7_10_COLUMN_NAME = "HHSIZE_7_10";
    private static final String HHSIZE_11_14_COLUMN_NAME = "HHSIZE_11_14";
    private static final String HHSIZE_15_MORE_COLUMN_NAME = "HHSIZE_15_MORE";
    private static final String MEAN_HHSIZE_COLUMN_NAME = "MEAN_HHSIZE";
    int flag=0;
    
    List<Household> houseHold;
    private String builtQuery;
	public HouseholdDAO(Integer urtid) {
		houseHold = new ArrayList<>();
        List<String> columns = new ArrayList<>();
        Map<String,String> tables= new ConcurrentHashMap<>();
        List<String> whereEquals= new ArrayList<>();
        
        /* columns.add(STATE_COLUMN_NAME);
    columns.add(URT_ID_COLUMN_NAME);
    columns.add(HHSIZE_1_COLUMN_NAME);
    columns.add(HHSIZE_2_COLUMN_NAME);
    columns.add(HHSIZE_3_COLUMN_NAME);
    columns.add(HHSIZE_4_COLUMN_NAME);
    columns.add(HHSIZE_5_COLUMN_NAME);
    columns.add(HHSIZE_6_COLUMN_NAME);
    columns.add(HHSIZE_7_10_COLUMN_NAME);
    columns.add(HHSIZE_11_14_COLUMN_NAME);
    columns.add(HHSIZE_15_MORE_COLUMN_NAME);
    columns.add(MEAN_HHSIZE_COLUMN_NAME);
    tables.put("hh","h");
    tables.put("main_table","m");
    whereEquals.add("h.STATE_ID = m.STATE_ID");
    builtQuery = QueryHelper.selectQuery(columns,tables,whereEquals,"m.STATE_ID");
    System.out.println(builtQuery);
    */
      
        if(urtid == 0)
        {
        	flag = -1;
            columns.add(STATE_COLUMN_NAME);
            columns.add("SUM("+HHSIZE_1_COLUMN_NAME+")"+" as "+HHSIZE_1_COLUMN_NAME);
            columns.add("SUM("+HHSIZE_2_COLUMN_NAME+")"+" as "+HHSIZE_2_COLUMN_NAME);
            columns.add("SUM("+HHSIZE_3_COLUMN_NAME+")"+" as "+HHSIZE_3_COLUMN_NAME);
            columns.add("SUM("+HHSIZE_3_COLUMN_NAME+")"+" as "+HHSIZE_3_COLUMN_NAME);
            columns.add("SUM("+HHSIZE_4_COLUMN_NAME+")"+" as "+HHSIZE_4_COLUMN_NAME);
            columns.add("SUM("+HHSIZE_5_COLUMN_NAME+")"+" as "+HHSIZE_5_COLUMN_NAME);
            columns.add("SUM("+HHSIZE_6_COLUMN_NAME+")"+" as "+HHSIZE_6_COLUMN_NAME);
            columns.add("SUM("+HHSIZE_7_10_COLUMN_NAME+")"+" as "+HHSIZE_7_10_COLUMN_NAME);
            columns.add("SUM("+HHSIZE_11_14_COLUMN_NAME+")"+" as "+HHSIZE_11_14_COLUMN_NAME);
            columns.add("SUM("+HHSIZE_15_MORE_COLUMN_NAME+")"+" as "+HHSIZE_15_MORE_COLUMN_NAME);
            columns.add("SUM("+MEAN_HHSIZE_COLUMN_NAME+")"+" as "+MEAN_HHSIZE_COLUMN_NAME);
            tables.put("hh","h");
            tables.put("main_table","m");
            whereEquals.add("h.STATE_ID = m.STATE_ID");
            whereEquals.add("h.URT_ID = m.URT_ID");
            builtQuery = QueryHelper.selectQuery(columns,tables,whereEquals,"h.URT_ID");
        }
        
        else if(urtid == 1)
        {
        	flag = 0;
            columns.add(STATE_COLUMN_NAME);
            columns.add("SUM("+HHSIZE_1_COLUMN_NAME+")"+" as "+HHSIZE_1_COLUMN_NAME);
            columns.add("SUM("+HHSIZE_2_COLUMN_NAME+")"+" as "+HHSIZE_2_COLUMN_NAME);
            columns.add("SUM("+HHSIZE_3_COLUMN_NAME+")"+" as "+HHSIZE_3_COLUMN_NAME);
            columns.add("SUM("+HHSIZE_3_COLUMN_NAME+")"+" as "+HHSIZE_3_COLUMN_NAME);
            columns.add("SUM("+HHSIZE_4_COLUMN_NAME+")"+" as "+HHSIZE_4_COLUMN_NAME);
            columns.add("SUM("+HHSIZE_5_COLUMN_NAME+")"+" as "+HHSIZE_5_COLUMN_NAME);
            columns.add("SUM("+HHSIZE_6_COLUMN_NAME+")"+" as "+HHSIZE_6_COLUMN_NAME);
            columns.add("SUM("+HHSIZE_7_10_COLUMN_NAME+")"+" as "+HHSIZE_7_10_COLUMN_NAME);
            columns.add("SUM("+HHSIZE_11_14_COLUMN_NAME+")"+" as "+HHSIZE_11_14_COLUMN_NAME);
            columns.add("SUM("+HHSIZE_15_MORE_COLUMN_NAME+")"+" as "+HHSIZE_15_MORE_COLUMN_NAME);
            columns.add("SUM("+MEAN_HHSIZE_COLUMN_NAME+")"+" as "+MEAN_HHSIZE_COLUMN_NAME);
            tables.put("hh","h");
            tables.put("main_table","m");
            whereEquals.add("h.STATE_ID = m.STATE_ID");
            whereEquals.add("h.URT_ID = m.URT_ID");
            builtQuery = QueryHelper.selectQuery(columns,tables,whereEquals,"h.URT_ID");
        }
        
        else if(urtid == 2)
        {
        	flag = 1;
            columns.add(STATE_COLUMN_NAME);
            columns.add("SUM("+HHSIZE_1_COLUMN_NAME+")"+" as "+HHSIZE_1_COLUMN_NAME);
            columns.add("SUM("+HHSIZE_2_COLUMN_NAME+")"+" as "+HHSIZE_2_COLUMN_NAME);
            columns.add("SUM("+HHSIZE_3_COLUMN_NAME+")"+" as "+HHSIZE_3_COLUMN_NAME);
            columns.add("SUM("+HHSIZE_3_COLUMN_NAME+")"+" as "+HHSIZE_3_COLUMN_NAME);
            columns.add("SUM("+HHSIZE_4_COLUMN_NAME+")"+" as "+HHSIZE_4_COLUMN_NAME);
            columns.add("SUM("+HHSIZE_5_COLUMN_NAME+")"+" as "+HHSIZE_5_COLUMN_NAME);
            columns.add("SUM("+HHSIZE_6_COLUMN_NAME+")"+" as "+HHSIZE_6_COLUMN_NAME);
            columns.add("SUM("+HHSIZE_7_10_COLUMN_NAME+")"+" as "+HHSIZE_7_10_COLUMN_NAME);
            columns.add("SUM("+HHSIZE_11_14_COLUMN_NAME+")"+" as "+HHSIZE_11_14_COLUMN_NAME);
            columns.add("SUM("+HHSIZE_15_MORE_COLUMN_NAME+")"+" as "+HHSIZE_15_MORE_COLUMN_NAME);
            columns.add("SUM("+MEAN_HHSIZE_COLUMN_NAME+")"+" as "+MEAN_HHSIZE_COLUMN_NAME);
            tables.put("hh","h");
            tables.put("main_table","m");
            whereEquals.add("h.STATE_ID = m.STATE_ID");
            whereEquals.add("h.URT_ID = m.URT_ID");
            builtQuery = QueryHelper.selectQuery(columns,tables,whereEquals,"h.URT_ID");
        }
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
	                	if(flag == -1)
	                        addObject(new Household(rs.getString(STATE_COLUMN_NAME), rs.getString(URT_ID_COLUMN_NAME), rs.getFloat(HHSIZE_1_COLUMN_NAME), rs.getFloat(HHSIZE_2_COLUMN_NAME),
	                        		rs.getFloat(HHSIZE_3_COLUMN_NAME), rs.getFloat(HHSIZE_4_COLUMN_NAME), rs.getFloat(HHSIZE_5_COLUMN_NAME), rs.getFloat(HHSIZE_6_COLUMN_NAME), 
	                        		rs.getFloat(HHSIZE_7_10_COLUMN_NAME), rs.getFloat(HHSIZE_11_14_COLUMN_NAME), rs.getFloat(HHSIZE_15_MORE_COLUMN_NAME), rs.getFloat(MEAN_HHSIZE_COLUMN_NAME)));
	                	else if(flag == 0)
	                		addObject(new Household(rs.getString(STATE_COLUMN_NAME), rs.getString(URT_ID_COLUMN_NAME), rs.getFloat(HHSIZE_1_COLUMN_NAME), rs.getFloat(HHSIZE_2_COLUMN_NAME),
	                        		rs.getFloat(HHSIZE_3_COLUMN_NAME), rs.getFloat(HHSIZE_4_COLUMN_NAME), rs.getFloat(HHSIZE_5_COLUMN_NAME), rs.getFloat(HHSIZE_6_COLUMN_NAME), 
	                        		rs.getFloat(HHSIZE_7_10_COLUMN_NAME), rs.getFloat(HHSIZE_11_14_COLUMN_NAME), rs.getFloat(HHSIZE_15_MORE_COLUMN_NAME), rs.getFloat(MEAN_HHSIZE_COLUMN_NAME)));
	                	else if(flag == 1)
	                		addObject(new Household(rs.getString(STATE_COLUMN_NAME), rs.getString(URT_ID_COLUMN_NAME), rs.getFloat(HHSIZE_1_COLUMN_NAME), rs.getFloat(HHSIZE_2_COLUMN_NAME),
	                        		rs.getFloat(HHSIZE_3_COLUMN_NAME), rs.getFloat(HHSIZE_4_COLUMN_NAME), rs.getFloat(HHSIZE_5_COLUMN_NAME), rs.getFloat(HHSIZE_6_COLUMN_NAME), 
	                        		rs.getFloat(HHSIZE_7_10_COLUMN_NAME), rs.getFloat(HHSIZE_11_14_COLUMN_NAME), rs.getFloat(HHSIZE_15_MORE_COLUMN_NAME), rs.getFloat(MEAN_HHSIZE_COLUMN_NAME)));

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
	    houseHold.add((Household) obj);
	    }

	 @Override
	    public List<Household> getList() {
	    query();
	    return houseHold;
	    }
	}

   
