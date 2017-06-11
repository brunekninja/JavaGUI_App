import sun.misc.Version;

import java.sql.*;
import java.util.LinkedList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Database connection
 */
public class DbConn {
    private LinkedList data;
    private Connection con = null;
    private Statement st = null;
    private ResultSet rs = null;

    public void runConn() {


        String url = "jdbc:mysql://localhost:3306/java_db?serverTimezone=UTC";
        String user = "root";
        String password = "1904";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM products;");
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(Version.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public LinkedList data(){
        LinkedList<String> arr = new LinkedList<>();

        try {
            while (rs.next()) {
                arr.add(rs.getString("name"));
            }
            System.out.println(arr);
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
        return data;
    }


}

