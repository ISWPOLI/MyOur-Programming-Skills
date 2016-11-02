package Conection;
import java.sql.Connection;
import java.sql.SQLException;
import oracle.jdbc.pool.OracleDataSource;
import java.sql.Statement;
import java.sql.ResultSet;

public class DataHandler {

//	public static String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";     con localhost y con ipv4 la de abajo
	public static String jdbcUrl = "jdbc:oracle:thin:@192.168.174.129:1521:xe";
	public static String userid;
	public static String password;
	public static Connection conn;
	public OracleDataSource ds;

	public static Statement stmt;
	public static ResultSet rset;
	public static String query;
	public static String sqlString;

	public DataHandler(String userid, String password) throws SQLException {
		this.userid= userid;
		this.password = password;
	}

	public static void getDBConnection() throws SQLException {
		OracleDataSource ds;
		ds = new OracleDataSource();
		ds.setURL(jdbcUrl);
		conn = ds.getConnection(userid, password);

	}

	public static ResultSet getAllEmployees(String sqlSentence) throws SQLException {
		getDBConnection();
		stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
		query = sqlSentence;
		System.out.println("\nExecuting query: " + query);
		rset = stmt.executeQuery(query);
		return rset;
	}

	public static boolean escribir(String sql) {
		try {
			Statement sentencia;
			sentencia = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
			sentencia.executeUpdate(sql);
			conn.commit();
			sentencia.close();
		} catch (SQLException e) {
			System.out.println(e);
			return false;
		}
		return true;
	}

	public boolean connect() {
		if (conn == null) {
			return false;
		}
		return true;
	}

	public void cerrar() throws SQLException {
		if (conn != null && conn.isClosed() == false) {
			conn.close();
		}
	}
}