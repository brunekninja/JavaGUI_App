import sun.misc.Version;

import java.sql.*;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Database connection
 */
public class DbConn {
    private Connection con = null;
    private Statement st = null;
    private ResultSet rs = null;

    /**
     * create database connection method, try catch for error exception handling
     */
    public void runConn() {

        String url = "jdbc:mysql://localhost:3306/java_db?serverTimezone=UTC";
        String user = "root";
        String password = "1904";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
            st = con.createStatement();
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(Version.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param query
     * gets database SQL query
     * @param column
     * select which database column to loop and execute
     * @return
     */
    public LinkedList data(String query, String column){
        LinkedList<String> arr = new LinkedList<>();

        try {
            //run sql query passed through function
            rs = st.executeQuery(query);

            while (rs.next()) {
                if(column != null){
                    arr.add(rs.getString(column));
                } else {
                    arr.add(rs.getString("id"));
                    arr.add(rs.getString("name"));
                }
            }

        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(Version.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {
                Logger lgr = Logger.getLogger(Version.class.getName());
                lgr.log(Level.WARNING, ex.getMessage(), ex);
            }
        }
        return arr;
    }


}

