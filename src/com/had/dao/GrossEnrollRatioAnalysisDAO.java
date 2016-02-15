package com.had.dao;

import com.had.data.GrossEnrollRatioAnalysis;
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

public class GrossEnrollRatioAnalysisDAO implements AbstractDAO
{

	private static final String STATE_COLUMN_NAME = "STATE_NAME";
    private static final String COL_COLUMN_NAME = "COL";
    private static final String VALUE_COLUMN_NAME = "VALUE";
    List<GrossEnrollRatioAnalysis> grossEnrollRatio;
    private String builtQuery;

    public GrossEnrollRatioAnalysisDAO(){
        grossEnrollRatio = new ArrayList<>();

        builtQuery = "(SELECT STATE_NAME, 'ALL_MALE' AS COL, ALL_MALE AS VALUE FROM gross_enroll_ratio ger, main_table mt WHERE ger.STATE_ID=mt.STATE_ID GROUP BY mt.STATE_ID) UNION (SELECT STATE_NAME, 'ALL_FEMALE' AS COL, ALL_FEMALE AS VALUE FROM gross_enroll_ratio ger, main_table mt WHERE ger.STATE_ID=mt.STATE_ID GROUP BY mt.STATE_ID) UNION (SELECT STATE_NAME, 'ALL_TOTAL' AS COL, ALL_TOTAL AS VALUE FROM gross_enroll_ratio ger, main_table mt WHERE ger.STATE_ID=mt.STATE_ID GROUP BY mt.STATE_ID) UNION (SELECT STATE_NAME, 'SC_MALE' AS COL, SC_MALE AS VALUE FROM gross_enroll_ratio ger, main_table mt WHERE ger.STATE_ID=mt.STATE_ID GROUP BY mt.STATE_ID) UNION (SELECT STATE_NAME, 'SC_FEMALE' AS COL, SC_FEMALE AS VALUE FROM gross_enroll_ratio ger, main_table mt WHERE ger.STATE_ID=mt.STATE_ID GROUP BY mt.STATE_ID) UNION (SELECT STATE_NAME, 'SC_TOTAL' AS COL, SC_TOTAL AS VALUE FROM gross_enroll_ratio ger, main_table mt WHERE ger.STATE_ID=mt.STATE_ID GROUP BY mt.STATE_ID) UNION (SELECT STATE_NAME, 'ST_MALE' AS COL, ST_MALE AS VALUE FROM gross_enroll_ratio ger, main_table mt WHERE ger.STATE_ID=mt.STATE_ID GROUP BY mt.STATE_ID) UNION (SELECT STATE_NAME, 'ST_FEMALE' AS COL, ST_FEMALE AS VALUE FROM gross_enroll_ratio ger, main_table mt WHERE ger.STATE_ID=mt.STATE_ID GROUP BY mt.STATE_ID) UNION (SELECT STATE_NAME, 'ST_TOTAL' AS COL, ST_TOTAL AS VALUE FROM gross_enroll_ratio ger, main_table mt WHERE ger.STATE_ID=mt.STATE_ID GROUP BY mt.STATE_ID);";

    }

    @Override
    public void addObject(Object obj) {
    	grossEnrollRatio.add((GrossEnrollRatioAnalysis) obj);
    }

    @Override
    public List<GrossEnrollRatioAnalysis> getList() {
        query();
        return grossEnrollRatio;
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
                        addObject(new GrossEnrollRatioAnalysis(rs.getString(STATE_COLUMN_NAME), rs.getString(COL_COLUMN_NAME), rs.getFloat(VALUE_COLUMN_NAME)));

                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
