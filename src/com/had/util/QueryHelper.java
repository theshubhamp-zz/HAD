package com.had.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Shubham S Patil
 * @since January 23, 2016
 */
public class QueryHelper {
    public static String selectQuery(ArrayList<String> columns, HashMap<String,String> tables, HashMap<String,String> joins)
    {
        String query = "";
        query+="SELECT ";
        if (columns.size()==0)
        {
            query+= "* ";
        }
        else
        {
            for (int i = 0; i < columns.size(); i++) {
                query+= columns.get(i);
                if(i<columns.size()-1)
                {
                    query+= ",";
                }
            }
        }
        query+=" FROM ";
        int i=0;
        for (Map.Entry<String,String> entry: tables.entrySet()) {
            query+= " " + entry.getKey() + " AS " + entry.getValue() + " ";
            if(i<tables.size()-1)
                query+=",";
            i++;
        }
        i=0;
        if (!(joins.size()==0))
        {
            query+=" WHERE ";
            for (Map.Entry<String,String> entry: joins.entrySet()) {
                query+=" "+entry.getKey()+" = "+entry.getValue()+" ";
                if (i<joins.size()-1)
                    query+=" AND ";
                i++;
            }
        }
        return query;
    }
}
