package com.had.dao;

import com.had.data.GdpPciAnalysis;
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
public class GdpPciAnalysisDAO implements AbstractDAO{

    List<GdpPciAnalysis> gdpPciAnalysises;
    private static final String STATE_NAME_COLUMN_NAME = "STATE_NAME";
    private static final String GDP_2010_11_COLUMN_NAME = "GDP_2010_11";
    private static final String PCI_2010_11_COLUMN_NAME = "PCI_2010_11";
    String builtQuery="";
    public GdpPciAnalysisDAO()
    {
        gdpPciAnalysises = new ArrayList<>();
        List<String> columns = new ArrayList<>();
        Map<String,String> tables= new ConcurrentHashMap<>();
        List<String> whereEquals= new ArrayList<>();
        columns.add(STATE_NAME_COLUMN_NAME);
        columns.add("sum(" +GDP_2010_11_COLUMN_NAME+") as "+GDP_2010_11_COLUMN_NAME);
        columns.add(PCI_2010_11_COLUMN_NAME);
        tables.put("gdp_districtwise","gd");
        tables.put("main_table","mt");
        tables.put("pci_statewise","ps");
        whereEquals.add("ps.STATE_ID = mt.STATE_ID");
        whereEquals.add("gd.STATE_ID = mt.STATE_ID");
        whereEquals.add("mt.DIST_ID = gd.DIST_ID");
        builtQuery = QueryHelper.selectQuery(columns,tables,whereEquals,"gd.STATE_ID,mt.STATE_ID");
    }

    @Override
    public void addObject(Object obj) {
        gdpPciAnalysises.add((GdpPciAnalysis)obj);
    }

    @Override
    public List<?> getList() {
        query();
        return gdpPciAnalysises;
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
                        addObject(new GdpPciAnalysis(rs.getString(STATE_NAME_COLUMN_NAME), rs.getInt(GDP_2010_11_COLUMN_NAME), rs.getInt(PCI_2010_11_COLUMN_NAME)));
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
