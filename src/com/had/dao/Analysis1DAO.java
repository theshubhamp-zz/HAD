package com.had.dao;

import com.had.data.Analysis1;
import com.had.util.Constants;
import com.had.util.QueryHelper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Akshat Shukla
 * @since February 7, 2016
 */

public class Analysis1DAO implements AbstractDAO
{
    private static final String STATE_COLUMN_NAME = "STATE_NAME";
    private static final String DIST_COLUMN_NAME = "DIST_NAME";
    private static final String LIT_COLUMN_NAME = "LIT";
    private static final String LIT_2011_COLUMN_NAME = "LIT_2011";
    private static final String POP_2011_COLUMN_NAME = "POP_2011";
    private static final String POP_COLUMN_NAME = "POP";
    List<Analysis1> analysis1;
    private String builtQuery1;
    private String builtQuery2;

    public Analysis1DAO(){
        analysis1 = new ArrayList<>();
        List<String> columns = new ArrayList<>();
        Map<String,String> tables= new ConcurrentHashMap<>();
        List<String> whereEquals= new ArrayList<>();
        
        //Query 1
        columns.add(STATE_COLUMN_NAME);
        columns.add(LIT_COLUMN_NAME);
        columns.add("("+LIT_2011_COLUMN_NAME+"*"+"SUM("+POP_2011_COLUMN_NAME+"))/100 as value");
        tables.put("pop_districtwise","pd");
        tables.put("main_table","mt");
        tables.put("literacy_statewise","ls");
        whereEquals.add("pd.STATE_ID = mt.STATE_ID");
        whereEquals.add("pd.DIST_ID = mt.DIST_ID");
        whereEquals.add("ls.STATE_ID = mt.STATE_ID");
        builtQuery1 = QueryHelper.selectQuery(columns,tables,whereEquals,"mt.STATE_ID, pd.STATE_ID");

        //Query 2
        columns.add(STATE_COLUMN_NAME);
        columns.add(POP_COLUMN_NAME);
        columns.add("SUM("+POP_2011_COLUMN_NAME+")"+" as "+POP_2011_COLUMN_NAME);
        tables.put("pop_districtwise","pd");
        tables.put("main_table","mt");
        tables.put("literacy_statewise","ls");
        whereEquals.add("pd.STATE_ID = mt.STATE_ID");
        whereEquals.add("pd.DIST_ID = mt.DIST_ID");
        whereEquals.add("ls.STATE_ID = mt.STATE_ID");
        builtQuery2 = QueryHelper.selectQuery(columns,tables,whereEquals,"mt.STATE_ID, pd.STATE_ID");
        
        System.out.println("("+builtQuery1+") UNION ("+builtQuery2+")");
    }

    @Override
    public void addObject(Object obj) {
    	analysis1.add((Analysis1) obj);
    }

    @Override
    public List<Analysis1> getList() {
        query();
        return analysis1;
    }

    @Override
    public void query() {
        try
        {
            Class.forName(Constants.JDBC_DRIVER);
            try (Connection connection = DriverManager.getConnection(Constants.DB_URL, Constants.USER, Constants.PASS);
                 Statement statement = connection.createStatement();
                 ResultSet rs = statement.executeQuery("("+builtQuery1+") UNION ("+builtQuery2+")")) {
                while (rs.next()) {
                        addObject(new Analysis1(rs.getString(STATE_COLUMN_NAME), rs.getFloat(LIT_2011_COLUMN_NAME), rs.getInt(POP_2011_COLUMN_NAME)));

                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
