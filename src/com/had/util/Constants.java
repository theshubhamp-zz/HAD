package com.had.util;

/**
 * @author Shubham S Patil
 * @since January 16, 2016
 */

public class Constants {
    // JDBC driver name and database URL
    public static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    public static final String DB_URL;
    //  Database credentials
    public static final String USER;
    public static final String PASS;
    static {
        if(System.getenv("OPENSHIFT_MYSQL_DB_HOST")!=null)
        {
            USER = System.getenv("OPENSHIFT_MYSQL_DB_USERNAME");
            PASS = System.getenv("OPENSHIFT_MYSQL_DB_PASSWORD");
            DB_URL = "jdbc:mysql://"+System.getenv("OPENSHIFT_MYSQL_DB_HOST")+":"+System.getenv("$OPENSHIFT_MYSQL_DB_PORT")+"/jbossews";
        }
        else
        {
            DB_URL = "jdbc:mysql://localhost/had";
            USER = "root";
            PASS = "mysqlroot";
        }
    }
}
