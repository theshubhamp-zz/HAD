package com.had.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.had.data.PerCapita;
import com.had.util.Constants;

/**
 * @author Akshat Shukla
 * @since January 19, 2016
 */
public class PerCapitaDAO {
    private static String STATE_COLUMN_NAME = "STATE_NAME";
    private static String PCI_2009_10_COLUMN_NAME = "PCI_2009_10";
    private static String PCI_2010_11_COLUMN_NAME = "PCI_2010_11";
    private static String LOAD_ALL_PCI_QUERY = "SELECT " + STATE_COLUMN_NAME + "," + PCI_2009_10_COLUMN_NAME
            + "," + PCI_2010_11_COLUMN_NAME + " FROM PCI_STATEWISE";
    List<PerCapita> percapita;
	public PerCapitaDAO() {
        percapita = new ArrayList<>();
        try
        {
            Class.forName(Constants.JDBC_DRIVER);
            try (Connection connection = DriverManager.getConnection(Constants.DB_URL, Constants.USER, Constants.PASS);
                 Statement statement = connection.createStatement();
                 ResultSet rs = statement.executeQuery(LOAD_ALL_PCI_QUERY)) {
                while (rs.next()) {
                    addPerCapita(
                            new PerCapita(rs.getString(STATE_COLUMN_NAME), rs.getInt(PCI_2009_10_COLUMN_NAME), rs.getInt(PCI_2010_11_COLUMN_NAME)));
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
	}
    public void addPerCapita(PerCapita obj)
    {
        percapita.add(obj);
    }
    public List<PerCapita> getPerCapita() {
        return percapita;
    }
}

