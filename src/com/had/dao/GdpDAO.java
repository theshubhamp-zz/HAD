package com.had.dao;

import com.had.data.Gdp;
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
 * @since January 31, 2016
 */

public class GdpDAO implements AbstractDAO {
    private static final String STATE_COLUMN_NAME = "STATE_NAME";
    private static final String DIST_COLUMN_NAME = "DIST_NAME";
    private static final String GDP_2008_09_COLUMN_NAME = "GDP_2008_09";
    private static final String GDP_2009_10_COLUMN_NAME = "GDP_2009_10";
    private static final String GDP_2010_11_COLUMN_NAME = "GDP_2010_11";
    private boolean isStateQuery;
    List<Gdp> gdps;
    private String builtQuery;

    public GdpDAO(Integer stateid) {
        gdps = new ArrayList<>();
        List<String> columns = new ArrayList<>();
        Map<String, String> tables = new ConcurrentHashMap<>();
        List<String> whereEquals = new ArrayList<>();
        if (stateid == -1) {
            isStateQuery = true;
            columns.add(STATE_COLUMN_NAME);
            columns.add("SUM(" + GDP_2008_09_COLUMN_NAME + ")" + " as " + GDP_2008_09_COLUMN_NAME);
            columns.add("SUM(" + GDP_2009_10_COLUMN_NAME + ")" + " as " + GDP_2009_10_COLUMN_NAME);
            columns.add("SUM(" + GDP_2010_11_COLUMN_NAME + ")" + " as " + GDP_2010_11_COLUMN_NAME);
            tables.put("gdp_statewise", "g");
            tables.put("main_table", "m");
            whereEquals.add("g.STATE_ID = m.STATE_ID");
            whereEquals.add("g.DIST_ID = m.DIST_ID");
            builtQuery = QueryHelper.selectQuery(columns, tables, whereEquals, "g.STATE_ID");
        } else {
            isStateQuery = false;
            columns.add(DIST_COLUMN_NAME);
            columns.add(GDP_2008_09_COLUMN_NAME);
            columns.add(GDP_2009_10_COLUMN_NAME);
            columns.add(GDP_2010_11_COLUMN_NAME);
            tables.put("gdp_districtwise", "g");
            tables.put("main_table", "m");
            whereEquals.add("g.STATE_ID = m.STATE_ID");
            whereEquals.add("g.DIST_ID = m.DIST_ID");
            whereEquals.add("g.STATE_ID = " + stateid.toString());
            builtQuery = QueryHelper.selectQuery(columns, tables, whereEquals, null);
        }
    }

    @Override
    public void addObject(Object obj) {
        gdps.add((Gdp) obj);

    }

    @Override
    public List getList() {
        query();
        return gdps;
    }

    @Override
    public void query() {
        try {
            Class.forName(Constants.JDBC_DRIVER);
            try (Connection connection = DriverManager.getConnection(Constants.DB_URL, Constants.USER, Constants.PASS);
                 Statement statement = connection.createStatement();
                 ResultSet rs = statement.executeQuery(builtQuery)) {
                while (rs.next()) {
                    if (isStateQuery)
                        addObject(new Gdp(rs.getString(STATE_COLUMN_NAME), rs.getFloat(GDP_2008_09_COLUMN_NAME), rs.getFloat(GDP_2009_10_COLUMN_NAME), rs.getFloat(GDP_2010_11_COLUMN_NAME)));
                    else
                        addObject(new Gdp(rs.getString(DIST_COLUMN_NAME), rs.getFloat(GDP_2008_09_COLUMN_NAME), rs.getFloat(GDP_2009_10_COLUMN_NAME), rs.getFloat(GDP_2010_11_COLUMN_NAME)));

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
