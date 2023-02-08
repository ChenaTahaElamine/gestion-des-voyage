package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Telephone_DAO {

	private static final String N_bdd = Class_Connection.getNome_dataBase();

	//problame de tikrar n telephone
	public static void Create_Telephone(int N_TELEPHONE, int N_SECURITE, String NOME_UTILISATEUR_AD) {
		// N_TELEPHONE,N_SECURITE,NOME_UTILISATEUR_AD
		try (Connection conn = Class_Connection.conn_oracle_jdbc();
				PreparedStatement p = conn.prepareStatement("INSERT INTO " + N_bdd
						+ ".Telephone(N_TELEPHONE,N_SECURITE,NOME_UTILISATEUR_AD) VALUES(?,?,?)");) {
			p.setInt(1, N_TELEPHONE);
			p.setInt(2, N_SECURITE);
			p.setString(3, NOME_UTILISATEUR_AD);
			p.execute();
		} catch (SQLException e) {
			
			System.out.println(e.getMessage());
			
		}

	}

	public static void delete_Telephones() {
		try (Connection conn = (Connection) Class_Connection.conn_oracle_jdbc();
				PreparedStatement p = (PreparedStatement) conn.prepareStatement("DELETE " + N_bdd + ".Telephone");) {
			p.execute();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static int delete_N_TELEPHONE(int N_TELEPHONE) {
		int row = 0;
		try (PreparedStatement p = Class_Connection.conn_oracle_jdbc()
				.prepareStatement("DELETE " + N_bdd + ".Telephone T WHERE T.N_TELEPHONE=?");) {
			p.setInt(1, N_TELEPHONE);
			p.execute();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return row;
	}

	public static void Update_Telephone(int N_TELEPHONE, int N_SECURITE, String NOME_UTILISATEUR_AD) {
		try (//

				Connection conn = Class_Connection.conn_oracle_jdbc();
				PreparedStatement p = conn.prepareStatement("UPDATE " + N_bdd
						+ ".Telephone C SET C.N_SECURITE=?,C.NOME_UTILISATEUR_AD=? WHERE C.N_TELEPHONE=?");) {
			p.setInt(1, N_SECURITE);
			p.setString(2, NOME_UTILISATEUR_AD);
			p.setInt(3, N_TELEPHONE);
			p.execute();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	/*
	 * public static void main(String[] args) { //Create_Telephone(658368576, 1,
	 * "taha"); //delete_Telephones(); //Create_Telephone(658368576, 1, "taha");
	 * //Create_Telephone(658368577, 1, "taha"); //Create_Telephone(658368578, 1,
	 * "taha"); //delete_N_TELEPHONE_asc(658368576); Update_Telephone(658368578, 1,
	 * "amine123"); System.out.println("oki");
	 * 
	 * }
	 */

}
