package com.had.util;

import java.util.List;
import java.util.Map;

/**
 * @author Shubham S Patil
 * @since January 23, 2016
 */
public class QueryHelper {
    public static String selectQuery(List<String> columns, Map<String, String> tables, List<String> whereStmnts, String groupby) {
        String query = "";
        query += "SELECT ";
        if (columns.size() == 0) {
            query += "* ";
        } else {
            for (int i = 0; i < columns.size(); i++) {
                query += columns.get(i);
                if (i < columns.size() - 1) {
                    query += ", ";
                }
            }
        }
        query += " FROM ";
        int i = 0;
        for (Map.Entry<String, String> entry : tables.entrySet()) {
            query += entry.getKey() + " AS " + entry.getValue() + " ";
            if (i < tables.size() - 1)
                query += ", ";
            i++;
        }
        i = 0;
        if (!(whereStmnts.size() == 0)) {
            query += " WHERE ";
            for (String entry : whereStmnts) {
                query += " " + entry + " ";
                if (i < whereStmnts.size() - 1)
                    query += " AND ";
                i++;
            }
        }
        if (groupby != null)
            query += " GROUP BY " + groupby;
        return query;
    }
}
