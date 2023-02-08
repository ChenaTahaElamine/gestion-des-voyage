package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Beans.Bus;
import Beans.Passager;
import Beans.Voyage;

public class User_DAO {
	private static final String N_bdd = Class_Connection.getNome_dataBase();

	public static Beans.Passager getPassager(String EMAIL_PS, String PASSWORD_PS) {
		Beans.Passager pass = null;
		try (Connection conn = Class_Connection.conn_oracle_jdbc();
				PreparedStatement p = conn.prepareStatement(
						"SELECT P.NUM_CL,P.NOM_PS,P.PRENOM_PS,P.NUM_TEL,P.EMAIL_PS,P.PASSWORD_PS FROM " + N_bdd
								+ ".passager P WHERE P.EMAIL_PS=? AND P.PASSWORD_PS=?");) {
			p.setString(1, EMAIL_PS);
			p.setString(2, PASSWORD_PS);
			ResultSet r = p.executeQuery();
			while (r.next()) {

				pass = new Passager(r.getInt("NUM_CL"), r.getString("NOM_PS"), r.getString("PRENOM_PS"),
						r.getInt("NUM_TEL"), "", r.getString("EMAIL_PS"), r.getString("PASSWORD_PS")

				);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return pass;
	}

	public static void insert_user(String NOM_PS, String PRENOM_PS, String NUM_TEL, String EMAIL_PS,
			String PASSWORD_PS) {
		if (NOM_PS.equals("") || PRENOM_PS.equals("") || NUM_TEL.equals("") || EMAIL_PS.equals("")
				|| PASSWORD_PS.equals("")) {
			Operation.JoptionMessageError.message_error("S'il vous plait monsieur remplir tous les Text Fild");

		} else if (NOM_PS != "" && PRENOM_PS != "" && NUM_TEL != "" && EMAIL_PS != "" && PASSWORD_PS != "") {
			try (Connection conn = Class_Connection.conn_oracle_jdbc();
					PreparedStatement sttmnt = conn.prepareStatement("INSERT INTO " + N_bdd
							+ ".Passager(NUM_CL,NOM_PS,PRENOM_PS,NUM_TEL,EMAIL_PS,PASSWORD_PS) VALUES(?,?,?,?,?,?)");) {
				Integer.valueOf(NUM_TEL);
				sttmnt.setInt(1, (int) (get_max_id_User() + 1));
				sttmnt.setString(2, NOM_PS);
				sttmnt.setString(3, PRENOM_PS);
				sttmnt.setString(4, NUM_TEL);
				sttmnt.setString(5, EMAIL_PS);
				sttmnt.setString(6, PASSWORD_PS);
				sttmnt.execute();
				Operation.JoptionMessageError
						.message_information("Monsieur " + NOM_PS + " vous avez ete enregistre avec succes .");
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			} catch (NumberFormatException e) {
				Operation.JoptionMessageError.message_error("Remplir le numero de telephone avec des valeurs integer");
			}
		} else {

		}

	}

	public static void delete_Users() {
		try (Connection conn = (Connection) Class_Connection.conn_oracle_jdbc();
				PreparedStatement p = (PreparedStatement) conn.prepareStatement("DELETE " + N_bdd + ".Passager");) {
			p.execute();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static int get_max_id_User() {
		int NUM_CL = 0;
		try (Connection conn = (Connection) Class_Connection.conn_oracle_jdbc();
				PreparedStatement p = (PreparedStatement) conn
						.prepareStatement("SELECT MAX(A.NUM_CL) AS MAX_ID FROM " + N_bdd + ".Passager A");) {
			ResultSet r = p.executeQuery();
			while (r.next()) {
				NUM_CL = r.getInt("MAX_ID");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return NUM_CL;
	}

	public static int delete_and_Order_ID_User_asc(int NUM_CL) {
		int row = 0;
		int max_id = get_max_id_User();
		try {
			// ----<
			Connection conn = Class_Connection.conn_oracle_jdbc();
			PreparedStatement p1 = conn.prepareStatement("DELETE " + N_bdd + ".Passager A WHERE A.NUM_CL=?");// --->
			PreparedStatement p2 = null;
			p1.setInt(1, NUM_CL);
			p1.execute();
			for (int i = NUM_CL; i < max_id; i++) {
				p2 = conn.prepareStatement(
						"UPDATE " + N_bdd + ".Passager A SET A.NUM_CL=" + (int) i + " WHERE A.NUM_CL=" + (int) (i + 1));
				row = p2.executeUpdate();
			}
			conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return row;
	}

	public static int scan_User(String EMAIL_PS, String PASSWORD_PS) {

		int i = 0;
		if (EMAIL_PS.equals("") || PASSWORD_PS.equals("")) {
			Operation.JoptionMessageError.message_error("Remplire tous les case .");
		} else if (EMAIL_PS != "" && PASSWORD_PS != "") {
			String email = null;
			String password = null;
			try (Connection conn = Class_Connection.conn_oracle_jdbc();
					PreparedStatement p = conn
							.prepareStatement("SELECT P.EMAIL_PS FROM " + N_bdd + ".Passager P WHERE P.PASSWORD_PS=?"); // Passager
					PreparedStatement p1 = conn.prepareStatement(
							"SELECT P.PASSWORD_PS FROM " + N_bdd + ".Passager P WHERE P.EMAIL_PS=?");) {
				p.setString(1, PASSWORD_PS);
				ResultSet r = p.executeQuery();
				p1.setString(1, EMAIL_PS);
				ResultSet r1 = p1.executeQuery();
				// r= true : PASSWORD_PS !=null
				// r1= true : email!=null
				while (r.next()) {
					email = r.getString("EMAIL_PS");
				}
				while (r1.next()) {
					password = r1.getString("PASSWORD_PS");
				}
				// -----------<
				if (email == null && password != null) {
					Operation.JoptionMessageError.message_error("Mot de passe incorrect");

				} else if (email != null && password == null) {
					Operation.JoptionMessageError.message_error("Vous avez une erreur dans l'e-mail");

				} else if (email != null && password != null) {
					Operation.JoptionMessageError.message_information("Les information sont correctes");
					i = 1;
				} else if (email == null && password == null) {
					Operation.JoptionMessageError.message_error("Vous avez un errour dans le mot passe et l'e-mail");
				}
				// ------------>
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}

		}

		return i;
	}

	public static String[][] get_voyageS() {
		String[][] data_voyage_bus = null;
		ArrayList<Beans.Voyage> voyage = new ArrayList<>();
		ArrayList<Beans.Bus> bus = new ArrayList<>();
		ArrayList<Beans.Destination> Destination = new ArrayList<>();

		try (Connection conn = Class_Connection.conn_oracle_jdbc();
				PreparedStatement p = conn.prepareStatement(
						"SELECT V.CODE_V,EXTRACT(YEAR FROM V.DATE_D) year,EXTRACT(MONTH FROM V.DATE_D) month,EXTRACT(DAY FROM V.DATE_D) day,B.MODEL,B.NOMBRE_PLACE,D.VILLE_DS\r\n"
								+ "FROM " + N_bdd + ".voyage V," + N_bdd + ".bus B," + N_bdd + ".Destination D," + N_bdd
								+ ".Constituer CO\r\n"
								+ "WHERE V.N_IMMUTRACULATION=B.N_IMMUTRACULATION AND CO.CODE_V=V.CODE_V AND CO.CODE_D=D.CODE_D\r\n"
								+ "ORDER BY V.CODE_V ASC");) {

			ResultSet r = p.executeQuery();
			while (r.next()) {
				bus.add(new Bus(0, N_bdd, r.getString("MODEL"), r.getInt("NOMBRE_PLACE"), N_bdd));
				voyage.add(new Voyage(r.getInt("CODE_V"),
						r.getString("year") + "/" + r.getString("month") + "/" + r.getString("day"), 0, 0, N_bdd));
				Destination.add(new Beans.Destination(0, r.getString("VILLE_DS"), ""));
				data_voyage_bus = new String[voyage.size()][6];
				for (int i = 0; i < voyage.size(); i++) {
					data_voyage_bus[i][0] = "" + voyage.get(i).getCODE_V();
					data_voyage_bus[i][1] = voyage.get(i).getDATE_D();

					data_voyage_bus[i][2] = bus.get(i).getMODEL();
					data_voyage_bus[i][3] = "" + bus.get(i).getNOMBRE_PLACE();
					data_voyage_bus[i][4] = "" + DAO.Add_Voyage_DAO.getN_place_vide(voyage.get(i).getCODE_V());
					data_voyage_bus[i][5] = Destination.get(i).getVILLE_DS();
				}
				// CODE_V | DATE_D | MODEL | NOMBRE_PLACE | N_place_vide | VILLE_DS
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return data_voyage_bus;
	}

	public static void Update_passager(String NOM_PS, String PRENOM_PS, String NUM_TEL, String EMAIL_PS,
			String PASSWORD_PS, String Confirm_PASSWORD_PS, int NUM_CL) {

		if (NOM_PS.equals("") || PRENOM_PS.equals("") || NUM_TEL.equals("") || EMAIL_PS.equals("")
				|| PASSWORD_PS.equals("") || Confirm_PASSWORD_PS.equals("")) {
			Operation.Style.style();
			Operation.JoptionMessageError.message_error("Remplir touts les case .");
		} else if (NOM_PS != ("") && PRENOM_PS != ("") && NUM_TEL != ("") && EMAIL_PS != ("") && PASSWORD_PS != ("")
				&& Confirm_PASSWORD_PS != ("")) {

			try {
				int I_NUM_TEL = Integer.valueOf(NUM_TEL);
				if (PASSWORD_PS.equals(Confirm_PASSWORD_PS)) {
					try (Connection conn = Class_Connection.conn_oracle_jdbc();
							PreparedStatement p = conn.prepareStatement("UPDATE " + N_bdd
									+ ".passager P SET P.NOM_PS=?,P.PRENOM_PS=?,P.NUM_TEL=?,P.EMAIL_PS=?,P.PASSWORD_PS=? WHERE P.NUM_CL=?");) {
						p.setString(1, NOM_PS);
						p.setString(2, PRENOM_PS);
						p.setInt(3, I_NUM_TEL);
						p.setString(4, EMAIL_PS);
						p.setString(5, PASSWORD_PS);
						p.setInt(6, NUM_CL);
						p.executeUpdate();
						Operation.Style.style();
						Operation.JoptionMessageError.message_information("Modification terminer");
					} catch (SQLException e) {
						System.out.println(e.getMessage());
					}
				} else if (PASSWORD_PS != Confirm_PASSWORD_PS) {
					Operation.Style.style();
					Operation.JoptionMessageError.message_error("Confirmer bien les valeur de mot pass avans de clic");
				}

			} catch (NumberFormatException e2) {
				Operation.Style.style();
				Operation.JoptionMessageError.message_error("Donner la valeur de NUM_TEL integer");
			}
		}

	}

}
