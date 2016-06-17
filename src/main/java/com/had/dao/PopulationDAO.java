package com.had.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

import com.had.data.Population;
import com.had.util.Constants;
import com.had.util.QueryHelper;

/**
 * @author Shubham S Patil
 * @since January 13, 2016
 */
public class PopulationDAO implements AbstractDAO{
    private static final String STATE_COLUMN_NAME = "STATE_NAME";
    private static final String DIST_COLUMN_NAME = "DIST_NAME";
    private static final String POP_2001_COLUMN_NAME = "POP_2001";
    private static final String POP_2011_COLUMN_NAME = "POP_2011";
    private boolean isStateQuery;
    List<Population> populations;
    private String builtQuery;
	public PopulationDAO(Integer stateid) {
        populations = new ArrayList<>();
        List<String> columns = new ArrayList<>();
        Map<String,String> tables= new ConcurrentHashMap<>();
        List<String> whereEquals= new ArrayList<>();
        if(stateid == -1)
        {
            isStateQuery = true;
            columns.add(STATE_COLUMN_NAME);
            columns.add("SUM("+POP_2011_COLUMN_NAME+")"+" as "+POP_2011_COLUMN_NAME);
            columns.add("SUM("+POP_2001_COLUMN_NAME+")"+" as "+POP_2001_COLUMN_NAME);
            tables.put("pop_districtwise","p");
            tables.put("main_table","m");
            whereEquals.add("p.STATE_ID = m.STATE_ID");
            whereEquals.add("p.DIST_ID = m.DIST_ID");
            builtQuery = QueryHelper.selectQuery(columns,tables,whereEquals,"p.STATE_ID");
        }
        else
        {
            isStateQuery = false;
            columns.add(DIST_COLUMN_NAME);
            columns.add(POP_2011_COLUMN_NAME);
            columns.add(POP_2001_COLUMN_NAME);
            tables.put("pop_districtwise","p");
            tables.put("main_table","m");
            whereEquals.add("p.STATE_ID = m.STATE_ID");
            whereEquals.add("p.DIST_ID = m.DIST_ID");
            whereEquals.add("p.STATE_ID = " + stateid.toString());
            builtQuery = QueryHelper.selectQuery(columns,tables,whereEquals,null);
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
                    if(isStateQuery)
                        addObject(new Population(rs.getString(STATE_COLUMN_NAME), rs.getInt(POP_2001_COLUMN_NAME), rs.getInt(POP_2011_COLUMN_NAME)));
                    else
                        addObject(new Population(rs.getString(DIST_COLUMN_NAME), rs.getInt(POP_2001_COLUMN_NAME), rs.getInt(POP_2011_COLUMN_NAME)));

                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void addObject(Object obj)
    {
        populations.add((Population) obj);
    }

    @Override
    public List<Population> getList() {
        query();
        return populations;
    }
}
