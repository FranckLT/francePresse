package fr.france_presse.db.utils;

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
import java.sql.Types;
import java.util.ArrayList;

public class DBDispatchUtils {
	// ------------------------------------------------------------
	// Constants
	// ------------------------------------------------------------
	private final static String QUERY_FIND_DISPATCHS = "SELECT * FROM dispatch LEFT JOIN reporter on reporter.id_reporter = dispatch.id_reporter ORDER BY publishTime ASC";
	private final static String QUERY_FIND_ONE_DISPATCH = "SELECT * FROM dispatch LEFT JOIN reporter on reporter.id_reporter = dispatch.id_reporter WHERE title=(?)";
	private final static String QUERY_FIND_ONE_DISPATCH_BY_ID = "SELECT * FROM dispatch LEFT JOIN reporter on reporter.id_reporter = dispatch.id_reporter WHERE id_dispatch=(?)";
	private final static String QUERY_INSERT_DISPATCH = "insert into dispatch values (null, (?), (?), (?))";
	private final static String QUERY_DELETE_DISPATCH = "DELETE FROM dispatch where name_dispatch=(?)";
	
	// ------------------------------------------------------------
	// Gets all Dispatch from the DB
	// ------------------------------------------------------------
	public static ArrayList<Dispatch> returnAllDispatch() throws Exception, SQLException {
		
		ArrayList<Dispatch> dispatchList = new ArrayList<>();

		Connection con = null;
		Statement stmt = null;
		// PreparedStatement stmtUser = null;

		try {
			// Relative instruction to work with Tomcat and Mysql
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			con = DriverManager.getConnection(ConnexionJDBC.URL, ConnexionJDBC.LOGIN, ConnexionJDBC.PASSWORD);
			stmt = con.createStatement();

			// Execute SQL instruction for finding messages
			ResultSet rSetRooms = stmt.executeQuery(QUERY_FIND_DISPATCHS);

			// Convert the SLQ Table into an arrayList of MessageBean
			while (rSetRooms.next()) {

				// Then converts the Message Table into an ArrayList of Messages
				dispatchList.add(rsetToDispatchs(rSetRooms));
                                
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
	
	public static ArrayList<Dispatch> returnOneDispatch(Dispatch dispatch) throws Exception, SQLException {
		
		ArrayList<Dispatch> dispatchList = new ArrayList<>();

			Connection con = null;
			PreparedStatement stmtNumber = null;

			try {
				// Relative instruction to work with Tomcat and Mysql
				DriverManager.registerDriver(new com.mysql.jdbc.Driver());
				con = DriverManager.getConnection(ConnexionJDBC.URL, ConnexionJDBC.LOGIN, ConnexionJDBC.PASSWORD);
				stmtNumber = con.prepareStatement(QUERY_FIND_ONE_DISPATCH);

				stmtNumber.setString(1, dispatch.getTitle());
				
				ResultSet resultSet = stmtNumber.executeQuery();
				
				while (resultSet.next()) {

					dispatchList.add(rsetToDispatchs(resultSet));
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
	
public static ArrayList<Dispatch> returnOneDispatchByID(String id) throws Exception, SQLException {
		
		ArrayList<Dispatch> dispatchList = new ArrayList<>();

			Connection con = null;
			PreparedStatement stmtNumber = null;

			try {
				// Relative instruction to work with Tomcat and Mysql
				DriverManager.registerDriver(new com.mysql.jdbc.Driver());
				con = DriverManager.getConnection(ConnexionJDBC.URL, ConnexionJDBC.LOGIN, ConnexionJDBC.PASSWORD);
				stmtNumber = con.prepareStatement(QUERY_FIND_ONE_DISPATCH_BY_ID);

				stmtNumber.setString(1, id);
				
				ResultSet resultSet = stmtNumber.executeQuery();
				
				while (resultSet.next()) {

					dispatchList.add(rsetToDispatchs(resultSet));
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
	
	public static void insertDispatch( Dispatch dispatch ) throws Exception, SQLException {

		Connection con = null;
		PreparedStatement stmtDispatch = null;
                Timestamp sTimestamp = Method.localDateTimeToTimestamp(dispatch.getPublishTime());
                Reporter reporter = fr.france_presse.db.method.Method.isReporterExists(dispatch.getReporterName()).get(0);
	
		try {
                    
                    
			// Relative instruction to work with Tomcat and Mysql
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			con = DriverManager.getConnection(ConnexionJDBC.URL, ConnexionJDBC.LOGIN, ConnexionJDBC.PASSWORD);
			stmtDispatch = con.prepareStatement(QUERY_INSERT_DISPATCH);
	
                        stmtDispatch.setString(1, dispatch.getTitle());
                        stmtDispatch.setTimestamp(2, sTimestamp);
                        if (!dispatch.getReporterName().isEmpty()) {
                            stmtDispatch.setInt(3, reporter.getId());
                        } else {
                            stmtDispatch.setNull(3, Types.INTEGER);
                        }
                        
                        
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
	
	public static void deleteDispatch( Dispatch dispatch ) throws Exception, SQLException {

		Connection con = null;
		PreparedStatement stmtHardware = null;

		try {
			// Relative instruction to work with Tomcat and Mysql
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			con = DriverManager.getConnection(ConnexionJDBC.URL, ConnexionJDBC.LOGIN, ConnexionJDBC.PASSWORD);
			stmtHardware = con.prepareStatement(QUERY_DELETE_DISPATCH);

			stmtHardware.setString(1, dispatch.getTitle());
			stmtHardware.executeUpdate();
			
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

	public static Dispatch rsetToDispatchs(ResultSet rset) throws Exception {
            
		Dispatch dispatch = new Dispatch();
                
                dispatch.setTitle(rset.getString("title"));
                
                dispatch.setIdDispatch(rset.getInt("id_dispatch"));
                
                dispatch.setReporterName(rset.getString("name_reporter"));
                
                System.out.println(dispatch.getIdDispatch()+" "+dispatch.getTitle()+" "+dispatch.getReporterName());
               
		return dispatch;
	}
	
}
