package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Constituer_DAO {
	private static final String N_bdd = Class_Connection.getNome_dataBase();
	
	
	
	public static void create_Constituer(double DUREE_S,int CODE_V,int CODE_D ) {
		/*DUREE_S,CODE_V,CODE_D*/
		try (
				Connection conn=Class_Connection.conn_oracle_jdbc();
				PreparedStatement p=conn.prepareStatement("INSERT INTO "+N_bdd+".Constituer(DUREE_S,CODE_V,CODE_D) VALUES(?,?,?)");
				){
			p.setDouble(1, DUREE_S);
			p.setInt(2, CODE_V);
			p.setInt(3, CODE_D);
			p.execute();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	public static void main(String[] args) {
		

	}

}
