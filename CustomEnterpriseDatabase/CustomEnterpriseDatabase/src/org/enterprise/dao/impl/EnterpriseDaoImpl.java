package org.enterprise.dao.impl;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.enterprise.dao.EnterpriseDao;
import org.enterprise.entities.Employee;

public class EnterpriseDaoImpl implements EnterpriseDao {

	private static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost/customenterprise?useLegacyDatetimeCode=false&serverTimezone=America/Mexico_City";
	private static final String ID = "enterprise";
	private static final String PASS = "%h3llG4t37%";

	private Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName( DRIVER_NAME );
		return DriverManager.getConnection( DB_URL, ID, PASS );
	}

	//	public int insert( User user ) {
	//		Connection conn = null;
	//		PreparedStatement stmt = null;
	//
	//		try {
	//			conn = getConnection();
	//			stmt = conn.prepareStatement( INSERT, Statement.RETURN_GENERATED_KEYS );
	//			stmt.setString( 1, user.getName() );
	//			stmt.setString( 2, user.getTel() );
	//			stmt.setString( 3, user.getPasswd() );
	//
	//			int result = stmt.executeUpdate();
	//			ResultSet rs = stmt.getGeneratedKeys();
	//
	//			if ( rs.next() ) {
	//				user.setId( rs.getInt( 1 ) );
	//			}
	//
	//			return result;
	//		} catch ( SQLException e ) {
	//			// e.printStackTrace();
	//			throw new RuntimeException( e );
	//		} finally {
	//			close( stmt );
	//			close( conn );
	//		}
	//	}

	public List< Employee > getEmployeeList() {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		List< Employee > employees = null;
		try {
			conn = getConnection();
			st = conn.createStatement();
			rs = st.executeQuery( "SELECT emp_id,emp_fname,emp_sname,emp_salary,emp_addres1,emp_addres2,emp_phone_number,emp_cellphone_number FROM employee" );
			if ( rs != null ) {
				employees = new ArrayList< Employee >();
				while ( rs.next() ) {
					Employee emp = new Employee();
					emp.setId( rs.getInt( "emp_id" ) );
					emp.setFirstName( rs.getString( "emp_fname" ).toCharArray() );
					emp.setLastName( rs.getString( "emp_sname" ).toCharArray() );
					emp.setSalary( rs.getDouble( "emp_salary" ) );
					emp.setAddress1( rs.getString( "emp_addres1" ) );
					emp.setAddress2( rs.getString( "emp_addres1" ) );
					emp.setPhone_number( new BigInteger( rs.getString( "emp_phone_number" ) )  );
					emp.setCellphone_number( new BigInteger( rs.getString( "emp_cellphone_number" ) ) );
					employees.add( emp );
				}
			}
			rs.close();
			st.close();
		} catch ( ClassNotFoundException e ) {
			e.printStackTrace();
		} catch ( SQLException e ) {
			e.printStackTrace();
		} catch ( Exception ex ) {
			ex.printStackTrace();
		} finally {
			if ( rs != null ) {
				try {
					rs.close();
				} catch ( SQLException e ) {
					if ( rs != null ) {
						try {
							rs.close();
						} catch ( Exception ex ) {
							ex.printStackTrace();
						}
					}
				}
			}
			if ( st != null ) {
				close( st );
			}
			if ( conn != null ) {
				close( conn );
			}
		}
		return employees;
	}

	private static void close( Connection conn ) {
		if ( conn != null ) {
			try {
				conn.close();
			} catch ( SQLException e ) {
				// e.printStackTrace();
				throw new RuntimeException( e );
			}
		}
	}

	private static void close( Statement stmt ) {
		if ( stmt != null ) {
			try {
				stmt.close();
			} catch ( SQLException e ) {
				// e.printStackTrace();
				throw new RuntimeException( e );
			}
		}
	}
}
