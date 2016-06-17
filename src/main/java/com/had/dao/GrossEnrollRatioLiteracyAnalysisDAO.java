package com.had.dao;

import com.had.data.GrossEnrollRatioLiteracyAnalysis;
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
 * @since February 9, 2016
 */

public class GrossEnrollRatioLiteracyAnalysisDAO implements AbstractDAO
{
    private static final String STATE_COLUMN_NAME = "STATE_NAME";
    private static final String ALL_TOTAL_COLUMN_NAME = "ALL_TOTAL";
    private static final String LIT_2011_COLUMN_NAME = "LIT_2011";
    List<GrossEnrollRatioLiteracyAnalysis> grossEnrollRatioLiteracy;
    private String builtQuery;

    public GrossEnrollRatioLiteracyAnalysisDAO(){
    	grossEnrollRatioLiteracy = new ArrayList<>();
        List<String> columns = new ArrayList<>();
        Map<String,String> tables= new ConcurrentHashMap<>();
        List<String> whereEquals= new ArrayList<>();
        columns.add(STATE_COLUMN_NAME);
        columns.add(ALL_TOTAL_COLUMN_NAME);
        columns.add(LIT_2011_COLUMN_NAME);
        tables.put("gross_enroll_ratio","ger");
        tables.put("main_table","mt");
        tables.put("literacy_statewise","ls");
        whereEquals.add("ls.STATE_ID = mt.STATE_ID");
        whereEquals.add("ger.STATE_ID = mt.STATE_ID");
        whereEquals.add("ls.STATE_ID = ger.STATE_ID");
        builtQuery = QueryHelper.selectQuery(columns,tables,whereEquals,"mt.STATE_ID");

    }

    @Override
    public void addObject(Object obj) {
    	grossEnrollRatioLiteracy.add((GrossEnrollRatioLiteracyAnalysis) obj);
    }

    @Override
    public List<GrossEnrollRatioLiteracyAnalysis> getList() {
        query();
        return grossEnrollRatioLiteracy;
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
                        addObject(new GrossEnrollRatioLiteracyAnalysis(rs.getString(STATE_COLUMN_NAME), rs.getFloat(ALL_TOTAL_COLUMN_NAME), rs.getFloat(LIT_2011_COLUMN_NAME)));

                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
