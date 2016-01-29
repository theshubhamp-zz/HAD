package com.had.dao;

import com.had.data.LiteracyRate;
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
 * @author Shubham S Patil
 * @since January 29, 2016
 */

public class LiteracyRateDAO implements AbstractDAO
{
    private static final String STATE_COLUMN_NAME = "STATE_NAME";
    private static final String LIT_2001_COLUMN_NAME = "LIT_2001";
    private static final String LIT_2011_COLUMN_NAME = "LIT_2011";
    List<LiteracyRate> literacyRates;
    private String builtQuery;
    public LiteracyRateDAO(){
        literacyRates = new ArrayList<>();
        List<String> columns = new ArrayList<>();
        Map<String,String> tables= new ConcurrentHashMap<>();
        List<String> whereEquals= new ArrayList<>();
        columns.add(STATE_COLUMN_NAME);
        columns.add(LIT_2001_COLUMN_NAME);
        columns.add(LIT_2011_COLUMN_NAME);
        tables.put("literacy_statewise","l");
        tables.put("main_table","m");
        whereEquals.add("l.STATE_ID = m.STATE_ID");
        builtQuery = QueryHelper.selectQuery(columns,tables,whereEquals,"m.STATE_ID");
        System.out.println(builtQuery);
    }

    @Override
    public void addObject(Object obj) {
        literacyRates.add((LiteracyRate) obj);
    }

    @Override
    public List getList() {
        query();
        return literacyRates;
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
                        addObject(new LiteracyRate(rs.getString(STATE_COLUMN_NAME), rs.getFloat(LIT_2001_COLUMN_NAME), rs.getFloat(LIT_2011_COLUMN_NAME)));

                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
