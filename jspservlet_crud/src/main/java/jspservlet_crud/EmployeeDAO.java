package jspservlet_crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * This class performs the database connectivity and insert operation
 */
public class EmployeeDAO {

	private static final String KEY_ID = "id";
	private static final String KEY_FIRST_NAME = "first_name";
	private static final String KEY_LAST_NAME = "last_name";
	private static final String KEY_ADDRESS = "address";
	private static final String KEY_USER_NAME = "username";
	private static final String KEY_PASSWORD = "password";
	private static final String KEY_CONTACT = "contact";

	/**
	 * To initialize the Database connection
	 * 
	 * @return Connection It returns the object
	 */
	static Connection initializeDatabase() throws SQLException, ClassNotFoundException {
		String dbDriver = "com.mysql.jdbc.Driver";
		String dbUrl = "jdbc:mysql://localhost:3306/";
		String dbName = "register";
		String dbUsername = "root";
		String dbPassword = "gaurav@123";

		Class.forName(dbDriver);
		// Step 1: Established the connection with database
		Connection connection = DriverManager.getConnection(dbUrl + dbName, dbUsername, dbPassword);
		System.out.println("Connection is successful !!!!!");
		return connection;
	}

	/**
	 * To get all employee list
	 */
	public List<Employee> getAllEmployee() {
		List<Employee> employeeList = new ArrayList<>();

		String SELECT_SQL = "SELECT * FROM employee";

		Connection connection = null;
		try {

			try {
				connection = EmployeeDAO.initializeDatabase();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// Step 2:Create a statement using connection object
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(SELECT_SQL);

			while (resultSet.next()) {
				Employee employee = new Employee();

				employee.setId(resultSet.getInt(KEY_ID));
				employee.setFirstName(resultSet.getString(KEY_FIRST_NAME));
				employee.setLastName(resultSet.getString(KEY_LAST_NAME));
				employee.setUsername(resultSet.getString(KEY_USER_NAME));
				employee.setAddress(resultSet.getString(KEY_ADDRESS));
				employee.setContact(resultSet.getString(KEY_CONTACT));

				employeeList.add(employee);
			}

			resultSet.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employeeList;
	}

	/**
	 * This method use to insert data in the database
	 * 
	 * @param employee It get the Employee class object
	 * @return It return 1 if the data successfully inserted
	 */
	public int registerEmployee(Employee employee) throws ClassNotFoundException {
		// Insert query
		String INSERT_USERS_SQL = "INSERT INTO employee"
				+ "  (first_name, last_name, username, password, address, contact) VALUES " + " (?, ?, ?, ?, ?, ?);";

		int result = 0;

		try {
			Connection connection = EmployeeDAO.initializeDatabase();
			// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);

			preparedStatement.setString(1, employee.getFirstName());
			preparedStatement.setString(2, employee.getLastName());
			preparedStatement.setString(3, employee.getUsername());
			preparedStatement.setString(4, employee.getPassword());
			preparedStatement.setString(5, employee.getAddress());
			preparedStatement.setString(6, employee.getContact());

			// Step 3: Execute the query or update query
			result = preparedStatement.executeUpdate();
			preparedStatement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * To update record
	 * 
	 * @param employee value that needs to be update
	 * @return It return 1 if operation success
	 */
	public int updateEmployeeRecord(Employee employee) {

		String UPDATE_USER_SQL = "UPDATE employee SET first_name = ?, last_name = ?, username = ?, password = ?, address = ?, contact = ?";
		UPDATE_USER_SQL += " WHERE id = ?";

		int result = 0;

		try {
			Connection connection = EmployeeDAO.initializeDatabase();
			PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER_SQL);
			preparedStatement.setString(1, employee.getFirstName());
			preparedStatement.setString(2, employee.getLastName());
			preparedStatement.setString(3, employee.getUsername());
			preparedStatement.setString(4, employee.getPassword());
			preparedStatement.setString(5, employee.getAddress());
			preparedStatement.setString(6, employee.getContact());

			// Step 3: Execute the query or update query
			result = preparedStatement.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;

	}

	/**
	 * To delete record from the database
	 * 
	 * @param employee value that needs to be delete from database
	 * @return It return 1 if operation success
	 */
	public int deleteEmployee(Employee employee) {
		String DELETE_USER_SQL = "DELETE FROM employee WHERE id = ?";
		int result = 0;

		try {
			Connection connection = EmployeeDAO.initializeDatabase();
			PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USER_SQL);
			preparedStatement.setString(1, employee.getFirstName());
			preparedStatement.setString(2, employee.getLastName());
			preparedStatement.setString(3, employee.getUsername());
			preparedStatement.setString(4, employee.getPassword());
			preparedStatement.setString(5, employee.getAddress());
			preparedStatement.setString(6, employee.getContact());

			// Step 3: Execute the query or update query
			result = preparedStatement.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * This method shows the exception message @see
	 * {@link EmployeeDAO#registerEmployee(Employee)}
	 */
	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}
	
}
