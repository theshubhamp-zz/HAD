package com.had.dao;

import com.had.data.PopulationLiteracyAnalysis;
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

public class PopulationLiteracyAnalysisDAO implements AbstractDAO
{

	private static final String STATE_COLUMN_NAME = "STATE_NAME";
    private static final String COL_COLUMN_NAME = "COL";
    private static final String VALUE_COLUMN_NAME = "VALUE";
    List<PopulationLiteracyAnalysis> populationLiteracy;
    private String builtQuery;

    public PopulationLiteracyAnalysisDAO(){
        populationLiteracy = new ArrayList<>();

        builtQuery = "(SELECT STATE_NAME, 'LIT' AS COL, (LIT_2011*SUM(POP_2011))/100 AS VALUE FROM POP_DISTRICTWISE PD, MAIN_TABLE MT,LITERACY_STATEWISE LS WHERE MT.STATE_ID = PD.STATE_ID AND MT.DIST_ID=PD.DIST_ID AND LS.STATE_ID=MT.STATE_ID GROUP BY MT.STATE_ID, PD.STATE_ID) UNION (SELECT STATE_NAME, 'POP' AS COL, SUM(POP_2011) FROM POP_DISTRICTWISE PD, MAIN_TABLE MT,LITERACY_STATEWISE LS WHERE MT.STATE_ID = PD.STATE_ID AND MT.DIST_ID=PD.DIST_ID AND LS.STATE_ID=MT.STATE_ID GROUP BY MT.STATE_ID, PD.STATE_ID);";

    }

    @Override
    public void addObject(Object obj) {
    	populationLiteracy.add((PopulationLiteracyAnalysis) obj);
    }

    @Override
    public List<PopulationLiteracyAnalysis> getList() {
        query();
        return populationLiteracy;
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
                        addObject(new PopulationLiteracyAnalysis(rs.getString(STATE_COLUMN_NAME), rs.getString(COL_COLUMN_NAME), rs.getInt(VALUE_COLUMN_NAME)));

                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
