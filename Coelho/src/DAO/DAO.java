package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DAO {
	
//	private static final String URL = "JDBC:mysql://ulxk6mmvlglgqefb:auFekaDXaElVngMLQ6VV@bipmbrzaglwxmdvfn104-mysql.services.clever-cloud.com:3306/bipmbrzaglwxmdvfn104";
//	private static final String USER = "ulxk6mmvlglgqefb";
//	private static final String PASSWD = "auFekaDXaElVngMLQ6VV";
	
	private static final String URL = "jdbc:mysql://localhost:3306/residencia_18";
	private static final String USER = "root";
	private static final String PASSWD = "1234";
	
	public static Connection getConnection() {
		Connection connection = null;
		
		try {
			System.err.println("Conectando ao banco de dados...");
			connection = DriverManager.getConnection(URL, USER, PASSWD);
		} catch (SQLException e) {
			System.err.println("Erro de conexão: " + e);
		}
		
		return connection;
	}
	
	public static ResultSet executeQuery(Connection connection, String sql, List<Object> params) {
        try {
        	connection = DAO.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);

            if (params != null) {				
            	int indexParam = 1;
            	for (Object param : params) {
            		statement.setObject(indexParam++, param);
            	}
			}
            
            System.err.println("Executando query...");
            return statement.executeQuery();

        } catch (SQLException e) {
        	System.err.println("Falha ao executar a query: " + e);
            e.printStackTrace();
            return null;
        }
    }

    public static Integer executeUpdate(Connection connection, String sql, List<Object> params) {
        try {
        	connection = DAO.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);

            int indexParam = 1;
            for (Object param : params) {
                statement.setObject(indexParam++, param);
            }
            
            System.err.println("Executando query...");
            return statement.executeUpdate();
        } catch (SQLException e) {
        	System.err.println("Falha ao executar a query: " + e);
            e.printStackTrace();
            return null;
        }
    }

}