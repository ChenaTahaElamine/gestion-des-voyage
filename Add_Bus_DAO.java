package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Beans.Bus;
import Beans.Destination;

public class Add_Bus_DAO {
	private static final String N_bdd = Class_Connection.getNome_dataBase();

	// N_IMMUTRACULATION,MARQUE,MODEL,NOMBRE_PLACE,NOME_UTILISATEUR_AD
	public static void create_Bus(String N_IMMUTRACULATION, String MARQUE, String MODEL, String NOMBRE_PLACE,
			String NOME_UTILISATEUR_AD) {
		int i = 0;
		if (N_IMMUTRACULATION.equals("") || MARQUE.equals("") || MODEL.equals("") || NOMBRE_PLACE.equals("")
				|| NOME_UTILISATEUR_AD.equals("")) {
			Operation.JoptionMessageError.message_error("Remplir tous les case");

		} else if (N_IMMUTRACULATION != "" && MARQUE != "" && MODEL != "" && NOMBRE_PLACE != ""
				&& NOME_UTILISATEUR_AD != "") {
			if (Operation.Gestion_exeption_matricul_N_plass_bus.scan_valeur_Integr(N_IMMUTRACULATION,
					NOMBRE_PLACE) == 0) {

				if (scann_N_IMMUTRACULATION(Integer.valueOf(N_IMMUTRACULATION)) == 0) {

					try (Connection conn = Class_Connection.conn_oracle_jdbc();
							PreparedStatement p = conn.prepareStatement("INSERT INTO " + N_bdd
									+ ".Bus(N_IMMUTRACULATION,MARQUE,MODEL,NOMBRE_PLACE,NOME_UTILISATEUR_AD) VALUES(?,?,?,?,?)");) {
						p.setInt(1, Integer.valueOf(N_IMMUTRACULATION));
						p.setString(2, MARQUE);
						p.setString(3, MODEL);
						p.setInt(4, Integer.valueOf(NOMBRE_PLACE));
						p.setString(5, NOME_UTILISATEUR_AD);
						p.execute();
						Operation.JoptionMessageError.message_information("Enregistre avec succes");
					} catch (SQLException e) {
						System.out.println(e.getMessage());
					}

				} else if (scann_N_IMMUTRACULATION(Integer.valueOf(N_IMMUTRACULATION)) != 0) {
					Operation.JoptionMessageError.message_error("N_IMMUTRACULATION est repeter");
				}

			}
		}

	}

	public static int scann_N_IMMUTRACULATION(int N_IMMUTRACULATION) {
		int i = 0;
		if (N_IMMUTRACULATION == 0) {
			i = 1;
		} else if (N_IMMUTRACULATION != 0) {
			try (Connection conn = Class_Connection.conn_oracle_jdbc();
					PreparedStatement p = conn.prepareStatement(
							"SELECT B.N_IMMUTRACULATION FROM " + N_bdd + ".Bus B WHERE B.N_IMMUTRACULATION=?");) {
				p.setInt(1, N_IMMUTRACULATION);
				ResultSet r = p.executeQuery();
				while (r.next()) {

					i = r.getInt("N_IMMUTRACULATION");

				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}

		return i;
	}

	public static void delete_Bus() {
		try (Connection conn = (Connection) Class_Connection.conn_oracle_jdbc();
				PreparedStatement p = (PreparedStatement) conn.prepareStatement("DELETE " + N_bdd + ".Bus");) {
			p.execute();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static String[][] get_touts_Bus() {
		String[][] tout_Bus = null;
		ArrayList<Beans.Bus> tout_Bus1 = new ArrayList<>();
		try (Connection conn = (Connection) Class_Connection.conn_oracle_jdbc();
				PreparedStatement p = (PreparedStatement) conn
						.prepareStatement("SELECT A.* FROM " + N_bdd + ".Bus A ORDER BY A.N_IMMUTRACULATION ASC");) {
			ResultSet r = p.executeQuery();
			while (r.next()) {
				tout_Bus1.add(new Bus(r.getInt("N_IMMUTRACULATION"), r.getString("MARQUE"), r.getString("MODEL"),
						r.getInt("NOMBRE_PLACE"), r.getString("NOME_UTILISATEUR_AD")));

			}
			// N_IMMUTRACULATION ,MARQUE,MODEL,NOMBRE_PLACE,NOME_UTILISATEUR_AD
			// 0 , 1, 2,3,4
			tout_Bus = new String[tout_Bus1.size()][5];
			for (int i = 0; i < tout_Bus1.size(); i++) {
				tout_Bus[i][0] = "" + tout_Bus1.get(i).getN_IMMUTRACULATION();
				tout_Bus[i][1] = tout_Bus1.get(i).getMARQUE();
				tout_Bus[i][2] = tout_Bus1.get(i).getMODEL();
				tout_Bus[i][3] = "" + tout_Bus1.get(i).getNOMBRE_PLACE();
				tout_Bus[i][4] = tout_Bus1.get(i).getNOME_UTILISATEUR_AD();
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return tout_Bus;
	}

}
