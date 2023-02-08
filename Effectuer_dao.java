package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Effectuer_dao {

	private static final String N_bdd = Class_Connection.getNome_dataBase();
	public static void main(String[] args) {
		insert_Effectuer(1, 3);
	}
	public static void insert_Effectuer(int NUM_CL, int CODE_V) {
		if (CODE_V==0) {
			Operation.JoptionMessageError.message_error("Veuillez sélectionner le voyage avant d'appuyer sur le bouton .");
		}else if (CODE_V!=0) {
			try (
					Connection conn=Class_Connection.conn_oracle_jdbc();
					PreparedStatement p=conn.prepareStatement("INSERT INTO "+N_bdd+".Effectuer VALUES(?,?)");
					){
				p.setInt(1, NUM_CL);
				p.setInt(2, CODE_V);
				p.execute();
				Operation.JoptionMessageError.message_information("Le voyage a été enregistré avec succès .");
			} catch (SQLException e) {
				Operation.Style.style();
				Operation.JoptionMessageError.message_error("Vous ne pouvez pas réserver deux sièges ou plus sur le même voyage .");
				
			}
		}
	}
	

}
