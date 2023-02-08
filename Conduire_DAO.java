package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Beans.Conduire;

public class Conduire_DAO {
	private static final String N_bdd = Class_Connection.getNome_dataBase();
	
	
	public static int create_Conduire(Beans.Conduire conduire) {
		int i=0;
		//DISTANCE,N_SECURITE ,N_IMMUTRACULATION , N_SECURITE2
		if (conduire.getN_SECURITE2()==0) {
			try(
					Connection conn=Class_Connection.conn_oracle_jdbc();
					PreparedStatement p=conn.prepareStatement("INSERT INTO "+N_bdd+".Conduire(DISTANCE,N_SECURITE ,N_IMMUTRACULATION) VALUES(?,?,?)");
					) {
				p.setDouble(1, (double)conduire.getDISTANCE());
				p.setInt(2, (int)conduire.getN_SECURITE());
				p.setInt(3, (int)conduire.getN_IMMUTRACULATION());
				p.execute();
				
			} catch (SQLException e) {
				Operation.JoptionMessageError.message_error("Changer le bus ou changer le chauffeur .");
				System.out.println(e.getMessage());
				i=1;
			}
		}else if (conduire.getN_SECURITE2()!=0) {
			try(
					Connection conn=Class_Connection.conn_oracle_jdbc();
					PreparedStatement p=conn.prepareStatement("INSERT INTO "+N_bdd+".Conduire(DISTANCE,N_SECURITE ,N_IMMUTRACULATION , N_SECURITE2) VALUES(?,?,?,?)");
					) {
				p.setDouble(1, (double)conduire.getDISTANCE());
				p.setInt(2, (int)conduire.getN_SECURITE());
				p.setInt(3, (int)conduire.getN_IMMUTRACULATION());
				p.setInt(4, (int)conduire.getN_SECURITE2());
				p.execute();
				
			} catch (SQLException e) {
				Operation.JoptionMessageError.message_error("Changer le bus ou changer le chauffeur .");
				System.out.println(e.getMessage());
				i=1;
			}
		}
		return i;
	}
	public static int scan_id_conduire(int SECURITE,int N_IMMUTRACULATION) {
		int i=0;// i: 0 true
				// i: 1 false
		String N_IMMUTRACULATION1="";
		try (
				Connection conn=Class_Connection.conn_oracle_jdbc();
				PreparedStatement p=conn.prepareStatement
						("SELECT C.N_SECURITE,C.N_IMMUTRACULATION"
					  + " FROM "+N_bdd+".conduire C "
					  + "WHERE C.N_SECURITE=? AND C.N_IMMUTRACULATION=?");
				){
			//N_SECURITE, N_IMMUTRACULATION
			p.setInt(1, SECURITE);
			p.setInt(2, N_IMMUTRACULATION);
			ResultSet r=p.executeQuery();
			while (r.next()) {
				System.out.println("ok1");
				N_IMMUTRACULATION1=""+r.getInt("N_IMMUTRACULATION");
				System.out.println("ok2");
			}
			if (N_IMMUTRACULATION1!="") {
				Operation.JoptionMessageError.message_error("Changer le bus ou changer le chauffeur .");
				i=1;
			}else if (N_IMMUTRACULATION1=="") {
				i=0;
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return i;
	} 
	

}
