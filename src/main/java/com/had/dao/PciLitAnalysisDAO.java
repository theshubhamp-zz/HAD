package com.had.dao;

import com.had.data.PciLitAnalysis;
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
public class PciLitAnalysisDAO implements AbstractDAO{

    List<PciLitAnalysis> pciLitAnalysises;
    private static final String STATE_NAME_COLUMN_NAME = "STATE_NAME";
    private static final String PCI_2010_2011_COLUMN_NAME = "PCI_2010_11";
    private static final String LIT_2011_COLUMN_NAME = "LIT_2011";
    String builtQuery="";
    public PciLitAnalysisDAO()
    {
        pciLitAnalysises = new ArrayList<>();
        List<String> columns = new ArrayList<>();
        Map<String,String> tables= new ConcurrentHashMap<>();
        List<String> whereEquals= new ArrayList<>();
        columns.add(STATE_NAME_COLUMN_NAME);
        columns.add(PCI_2010_2011_COLUMN_NAME);
        columns.add(LIT_2011_COLUMN_NAME);
        tables.put("literacy_statewise","ls");
        tables.put("main_table","mt");
        tables.put("pci_statewise","ps");
        whereEquals.add("ls.STATE_ID = mt.STATE_ID");
        whereEquals.add("ps.STATE_ID = mt.STATE_ID");
        whereEquals.add("ls.STATE_ID = ps.STATE_ID");
        builtQuery = QueryHelper.selectQuery(columns,tables,whereEquals,"mt.STATE_ID");
    }

    @Override
    public void addObject(Object obj) {
        pciLitAnalysises.add((PciLitAnalysis)obj);
    }

    @Override
    public List<?> getList() {
        query();
        return pciLitAnalysises;
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
                        addObject(new PciLitAnalysis(rs.getString(STATE_NAME_COLUMN_NAME), rs.getFloat(PCI_2010_2011_COLUMN_NAME), rs.getFloat(LIT_2011_COLUMN_NAME)));
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
