/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.france_presse.db.utils;

import static fr.france_presse.db.utils.DBDispatchUtils.rsetToDispatchs;
import fr.france_presse.java_bean.Dispatch;
import fr.france_presse.java_bean.Reporter;
import fr.france_presse.utils.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class DBReporterUtils {
    
    // ------------------------------------------------------------
	// Constants
	// ------------------------------------------------------------
	private final static String QUERY_FIND_REPORTERS = "SELECT * FROM reporter";
	private final static String QUERY_FIND_ONE_REPORTER_BY_ID = "SELECT * FROM reporter WHERE id_reporter=(?)";
        private final static String QUERY_FIND_ONE_REPORTER_BY_NAME = "SELECT * FROM reporter WHERE name_reporter=(?)";
        private final static String QUERY_INSERT_REPORTER = "INSERT INTO reporter VALUES (null, (?))";
	private final static String QUERY_DELETE_REPORTER = "DELETE FROM reporter WHERE id_reporter=(?)";

        // ------------------------------------------------------------
	// Gets all Reporter from the DB
	// ------------------------------------------------------------
	public static ArrayList<Reporter> returnAllDispatch() throws Exception, SQLException {
		
		ArrayList<Reporter> dispatchList = new ArrayList<>();

		Connection con = null;
		Statement stmt = null;
		// PreparedStatement stmtUser = null;

		try {
			// Relative instruction to work with Tomcat and Mysql
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			con = DriverManager.getConnection(ConnexionJDBC.URL, ConnexionJDBC.LOGIN, ConnexionJDBC.PASSWORD);
			stmt = con.createStatement();

			// Execute SQL instruction for finding messages
			ResultSet rSetRooms = stmt.executeQuery(QUERY_FIND_REPORTERS);

			// Convert the SLQ Table into an arrayList of MessageBean
			while (rSetRooms.next()) {

				// Then converts the Message Table into an ArrayList of Messages
				dispatchList.add(rsetToReporter(rSetRooms));
			}
			return dispatchList;
		} finally {
			// Close the connection
			if (con != null) {
				try {
					con.close();
				} catch (final SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
        
        public static ArrayList<Reporter> returnOneReporterByID(String id) throws Exception, SQLException {
		
		ArrayList<Reporter> reporterList = new ArrayList<>();

			Connection con = null;
			PreparedStatement stmtNumber = null;

			try {
				// Relative instruction to work with Tomcat and Mysql
				DriverManager.registerDriver(new com.mysql.jdbc.Driver());
				con = DriverManager.getConnection(ConnexionJDBC.URL, ConnexionJDBC.LOGIN, ConnexionJDBC.PASSWORD);
				stmtNumber = con.prepareStatement(QUERY_FIND_ONE_REPORTER_BY_ID);

				stmtNumber.setString(1, id);
				
				ResultSet resultSet = stmtNumber.executeQuery();
				
				while (resultSet.next()) {

					reporterList.add(rsetToReporter(resultSet));
				}
				
				return reporterList;
				
			} finally {
				// Close the connection
				if (con != null) {
					try {
						con.close();
					} catch (final SQLException e) {
						e.printStackTrace();
					}
				}
			}
		}
        
        public static List<Reporter> returnOneReporterByName(String name) throws Exception, SQLException {
		
		ArrayList<Reporter> reporterList = new ArrayList<>();

			Connection con = null;
			PreparedStatement stmtNumber = null;

			try {
				// Relative instruction to work with Tomcat and Mysql
				DriverManager.registerDriver(new com.mysql.jdbc.Driver());
				con = DriverManager.getConnection(ConnexionJDBC.URL, ConnexionJDBC.LOGIN, ConnexionJDBC.PASSWORD);
				stmtNumber = con.prepareStatement(QUERY_FIND_ONE_REPORTER_BY_NAME);

				stmtNumber.setString(1, name);
				
				ResultSet resultSet = stmtNumber.executeQuery();
				
				while (resultSet.next()) {

					reporterList.add(rsetToReporter(resultSet));
				}
				
				return reporterList;
				
			} finally {
				// Close the connection
				if (con != null) {
					try {
						con.close();
					} catch (final SQLException e) {
						e.printStackTrace();
					}
				}
			}
		}
	
	public static void insertReporter( String name ) throws Exception, SQLException {

		Connection con = null;
		PreparedStatement stmtDispatch = null;
                
	
		try {
			// Relative instruction to work with Tomcat and Mysql
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			con = DriverManager.getConnection(ConnexionJDBC.URL, ConnexionJDBC.LOGIN, ConnexionJDBC.PASSWORD);
			stmtDispatch = con.prepareStatement(QUERY_INSERT_REPORTER);
	
			stmtDispatch.setString(1, name);
			stmtDispatch.executeUpdate();
			
		} finally {
			// Close the connection
			if (con != null) {
				try {
					con.close();
				} catch (final SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
        
        
        public static Reporter rsetToReporter(ResultSet rset) throws Exception {
		
		Reporter reporter = new Reporter(rset.getInt("id_reporter"), rset.getString("name_reporter"));

		return reporter;
	}
        
        
}
