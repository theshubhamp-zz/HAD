package com.had.dao;

import com.had.data.State;
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
 * @since February 3, 2016
 */
public class StateDAO implements AbstractDAO {
    private static final String STATE_ID_COLUMN_NAME = "STATE_ID";
    private static final String STATE_COLUMN_NAME = "STATE_NAME";
    private String builtQuery;
    List<State> states;

    public StateDAO() {
        states = new ArrayList<>();
        List<String> columns = new ArrayList<>();
        Map<String, String> tables = new ConcurrentHashMap<>();
        List<String> whereEquals = new ArrayList<>();
        columns.add(STATE_COLUMN_NAME);
        columns.add(STATE_ID_COLUMN_NAME);
        tables.put("main_table", "m");
        builtQuery = QueryHelper.selectQuery(columns, tables, whereEquals, "m.state_id");
    }

    @Override
    public void addObject(Object obj) {
        states.add((State) obj);
    }

    @Override
    public List<State> getList() {
        query();
        return states;
    }

    @Override
    public void query() {
        try {
            Class.forName(Constants.JDBC_DRIVER);
            try (Connection connection = DriverManager.getConnection(Constants.DB_URL, Constants.USER, Constants.PASS);
                 Statement statement = connection.createStatement();
                 ResultSet rs = statement.executeQuery(builtQuery)) {
                while (rs.next()) {
                    addObject(new State(rs.getString(STATE_COLUMN_NAME), rs.getInt(STATE_ID_COLUMN_NAME)));

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
