package com.had.dao;

import com.had.data.HhUrtAnalysis;
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
 * @since February 9, 2016
 */
public class HhUrtAnalysisDAO implements AbstractDAO{

    List<HhUrtAnalysis> hhUrtAnalysises;
    private static final String STATE_NAME_COLUMN_NAME = "STATE_NAME";
    private static final String URT_ID_COLUMN_NAME = "URT_ID";
    private static final String HH_NO_COLUMN_NAME = "HH_NO";
    String builtQuery="";
    public HhUrtAnalysisDAO()
    {
        hhUrtAnalysises = new ArrayList<>();
        List<String> columns = new ArrayList<>();
        Map<String,String> tables= new ConcurrentHashMap<>();
        List<String> whereEquals= new ArrayList<>();
        columns.add(STATE_NAME_COLUMN_NAME);
        columns.add(URT_ID_COLUMN_NAME);
        columns.add("HHSIZE_1+HHSIZE_2+HHSIZE_3+ HHSIZE_4+ HHSIZE_5+ HHSIZE_6+ HHSIZE_7_10+ HHSIZE_11_14+ HHSIZE_15_MORE"+" as "+HH_NO_COLUMN_NAME);
        tables.put("HH","HH");
        tables.put("MAIN_TABLE","MT");
        whereEquals.add("HH.STATE_ID=MT.STATE_ID");
        builtQuery = QueryHelper.selectQuery(columns,tables,whereEquals,"URT_ID,MT.STATE_ID");
    }

    @Override
    public void addObject(Object obj) {
        hhUrtAnalysises.add((HhUrtAnalysis)obj);
    }

    @Override
    public List<?> getList() {
        query();
        return hhUrtAnalysises;
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
                        addObject(new HhUrtAnalysis(rs.getString(STATE_NAME_COLUMN_NAME), rs.getInt(URT_ID_COLUMN_NAME), rs.getInt(HH_NO_COLUMN_NAME)));
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
