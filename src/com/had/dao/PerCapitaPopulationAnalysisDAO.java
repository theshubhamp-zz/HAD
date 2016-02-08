package com.had.dao;

import com.had.data.PerCapitaPopulationAnalysis;
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

public class PerCapitaPopulationAnalysisDAO implements AbstractDAO
{
    private static final String STATE_COLUMN_NAME = "STATE_NAME";
    private static final String DIST_COLUMN_NAME = "DIST_NAME";
    private static final String PCI_2010_11_COLUMN_NAME = "PCI_2010_11";
    private static final String POP_2011_COLUMN_NAME = "POP_2011";
    List<PerCapitaPopulationAnalysis> perCapitaPopulation;
    private String builtQuery;

    public PerCapitaPopulationAnalysisDAO(){
        perCapitaPopulation = new ArrayList<>();
        List<String> columns = new ArrayList<>();
        Map<String,String> tables= new ConcurrentHashMap<>();
        List<String> whereEquals= new ArrayList<>();
        columns.add(STATE_COLUMN_NAME);
        columns.add(PCI_2010_11_COLUMN_NAME);
        columns.add("SUM("+POP_2011_COLUMN_NAME+")"+" as "+POP_2011_COLUMN_NAME);
        tables.put("pop_districtwise","pd");
        tables.put("main_table","mt");
        tables.put("pci_statewise","ps");
        whereEquals.add("pd.STATE_ID = mt.STATE_ID");
        whereEquals.add("ps.STATE_ID = mt.STATE_ID");
        whereEquals.add("pd.STATE_ID = ps.STATE_ID");
        whereEquals.add("pd.DIST_ID = mt.DIST_ID");
        builtQuery = QueryHelper.selectQuery(columns,tables,whereEquals,"mt.STATE_ID, pd.STATE_ID");

    }

    @Override
    public void addObject(Object obj) {
    	perCapitaPopulation.add((PerCapitaPopulationAnalysis) obj);
    }

    @Override
    public List<PerCapitaPopulationAnalysis> getList() {
        query();
        return perCapitaPopulation;
    }

    @Override
    public void query() {
        try
        {
            Class.forName(Constants.JDBC_DRIVER);
            try (Connection connection = DriverManager.getConnection(Constants.DB_URL, Constants.USER, Constants.PASS);
                 Statement statement = connection.createStatement();
                 ResultSet rs = statement.executeQuery(builtQuery) {
                while (rs.next()) {
                        addObject(new PerCapitaPopulationAnalysis(rs.getString(STATE_COLUMN_NAME), rs.getFloat(PCI_2010_11_COLUMN_NAME), rs.getInt(POP_2011_COLUMN_NAME)));

                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
