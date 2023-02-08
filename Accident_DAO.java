package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Beans.Accident;

public class Accident_DAO {

	private static final String N_bdd = Class_Connection.getNome_dataBase();

	public static void create_Accident(Beans.Accident accident) {

		// Beans.Accident accident =new Accident((getMax_CLE_A()+1), "2023", "2", 2);
		// create_Accident(accident);

		accident.setCLE_A((getMax_CLE_A() + 1));

		if (accident.getN_SECURITE() == 0) {
			Operation.JoptionMessageError.message_error("Selectioner un chauffeur .");
		} else if (accident.getN_SECURITE() != 0) {
			if (accident.getANNEE().equals("") || accident.getN_ACCIDENT().equals("")) {
				Operation.JoptionMessageError.message_error("Remplire tout les case .");
			} else if (accident.getANNEE() != "" && accident.getN_ACCIDENT() != "") {
				if ((int) Operation.Scan_N_accident_anne.scan_N_accident_anne(accident) == 1) {
					try (Connection conn = Class_Connection.conn_oracle_jdbc();
							PreparedStatement p = conn
									.prepareStatement("INSERT INTO " + N_bdd + ".Accident VALUES(?,?,?,?)");) {
						p.setInt(1, accident.getCLE_A());
						p.setInt(2, Integer.valueOf(accident.getANNEE()));
						p.setInt(3, Integer.valueOf(accident.getN_ACCIDENT()));
						p.setInt(4, accident.getN_SECURITE());
						p.execute();
						Operation.JoptionMessageError.message_information("Accident enregistres");
					} catch (SQLException e) {
						System.out.println(e.getMessage());
					}
				}
			}
		}
	}

	
	public static int getMax_CLE_A() {
		int CLE_A = 0;
		try (Connection conn = Class_Connection.conn_oracle_jdbc();
				PreparedStatement p = conn
						.prepareStatement("SELECT MAX(V.CLE_A) AS max_code_v FROM " + N_bdd + ".Accident V");) {
			ResultSet r = p.executeQuery();
			while (r.next()) {
				CLE_A = r.getInt("max_code_v");
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return CLE_A;
	}

}
