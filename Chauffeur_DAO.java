package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Beans.Chauffeur;
import Beans.Destination;

public class Chauffeur_DAO {
	private static final String N_bdd = Class_Connection.getNome_dataBase();

	public static void Create_Chauffeur(String NOM_CHF, String PRENOM_CHF, String SALARE, String NEMURO_AD,
			String NOME_UTILISATEUR_AD, String N_telephon) {

		// scan_Gestion_exeption_salare_N_telephon_chafeur
		if (NEMURO_AD == "0") {
			Operation.JoptionMessageError.message_error(
					"<html><body><font color=red>Veuillez selectionner un adress <br />ou ajouter un nouveau adress . </font></body></html>");
		} else if (NEMURO_AD != "0") {
			
			if (NOM_CHF.equals("") || PRENOM_CHF.equals("") || SALARE.equals("")
					|| NEMURO_AD.equals("") && NOME_UTILISATEUR_AD.equals("") || N_telephon.equals("")) {
				Operation.JoptionMessageError.message_error("Remplir tous les case");
			} else if (NOM_CHF != "" && PRENOM_CHF != "" && SALARE != "" && NEMURO_AD != "" && NOME_UTILISATEUR_AD != ""
					&& N_telephon != "") {
				if (Operation.Gestion_exeption_salare_N_telephon_chafeur
						.scan_Gestion_exeption_salare_N_telephon_chafeur(SALARE, N_telephon) == 0) {
					try (Connection conn = Class_Connection.conn_oracle_jdbc();
							PreparedStatement p = conn
									.prepareStatement("INSERT INTO " + N_bdd + ".Chauffeur  VALUES(?,?,?,?,?,?)");) {// (C.N_SECURITE,C.NOM_CHF,C.PRENOM_CHF,C.SALARE,C.NEMURO_AD,C.NOME_UTILISATEUR_AD)
						p.setInt(1, (int) (get_max_idChauffeur() + 1));
						p.setString(2, NOM_CHF);
						p.setString(3, PRENOM_CHF);
						p.setInt(4, Integer.valueOf(NEMURO_AD));
						p.setString(5, NOME_UTILISATEUR_AD);
						p.setDouble(6, Double.valueOf(SALARE));
						p.execute();
						// -------------
						DAO.Telephone_DAO.Create_Telephone(Integer.valueOf(N_telephon), (int) (get_max_idChauffeur()),
								NOME_UTILISATEUR_AD);
						Operation.JoptionMessageError.message_information("Enregistre avec succes");
					} catch (SQLException e) {
						System.out.println(e.getMessage());
					}

				}
			}
		}
		
		
	}
	 
	public static int get_max_idChauffeur() {
		int N_SECURITE = 0;
		try (Connection conn = (Connection) Class_Connection.conn_oracle_jdbc();
				PreparedStatement p = (PreparedStatement) conn
						.prepareStatement("SELECT MAX(A.N_SECURITE) AS MAX_ID FROM " + N_bdd + ".Chauffeur A");) {
			ResultSet r = p.executeQuery();
			while (r.next()) {
				N_SECURITE = r.getInt("MAX_ID");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return N_SECURITE;
	}

	public static void delete_Chauffeurs() {
		try (Connection conn = (Connection) Class_Connection.conn_oracle_jdbc();
				PreparedStatement p = (PreparedStatement) conn.prepareStatement("DELETE " + N_bdd + ".Chauffeur");) {
			p.execute();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static int delete_and_Order_N_SECURITE_asc(int N_SECURITE) {
		int row = 0;
		int max_id = get_max_idChauffeur();
		try {
			// ----<
			Connection conn = Class_Connection.conn_oracle_jdbc();
			PreparedStatement p1 = conn.prepareStatement("DELETE " + N_bdd + ".Chauffeurs A WHERE A.N_SECURITE=?");// --->
			PreparedStatement p2 = null;
			p1.setInt(1, N_SECURITE);
			p1.execute();
			for (int i = N_SECURITE; i < max_id; i++) {
				p2 = conn.prepareStatement("UPDATE " + N_bdd + ".Chauffeurs A SET A.N_SECURITE=" + (int) i
						+ " WHERE A.N_SECURITE=" + (int) (i + 1));
				row = p2.executeUpdate();
			}
			conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return row;
	}

	public static void Update_Chauffeur(int N_SECURITE, String NOM_CHF, String PRENOM_CHF, int NEMURO_AD,
			String NOME_UTILISATEUR_AD) {
		try (// C.NOM_CHF=?,C.PRENOM_CHF=?,C.NEMURO_AD=?,C.NOME_UTILISATEUR_AD=? WHERE
				// C.N_SECURITE=?

				Connection conn = Class_Connection.conn_oracle_jdbc();
				PreparedStatement p = conn.prepareStatement("UPDATE " + N_bdd
						+ ".Chauffeur C SET C.NOM_CHF=?,C.PRENOM_CHF=?,C.NEMURO_AD=?,C.NOME_UTILISATEUR_AD=? WHERE C.N_SECURITE=?");) {
			p.setString(1, NOM_CHF);
			p.setString(2, PRENOM_CHF);
			p.setInt(3, NEMURO_AD);
			p.setString(4, NOME_UTILISATEUR_AD);
			p.setInt(5, N_SECURITE);
			p.execute();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static String[][] get_touts_Chauffeur() {
		String[][] tout_Chauffeur = null;
		ArrayList<Beans.Chauffeur> tout_Chauffeur_array = new ArrayList<>();
		try (Connection conn = (Connection) Class_Connection.conn_oracle_jdbc();
				PreparedStatement p = (PreparedStatement) conn.prepareStatement(
						"select c.N_SECURITE,c.NOM_CHF,a.VILLE_AD" + "  from " + N_bdd + ".adress a," + N_bdd
								+ ".Chauffeur c" + "  where c.NEMURO_AD=a.NEMURO_AD order by c.N_SECURITE asc");) {
			ResultSet r = p.executeQuery();
			while (r.next()) {

				tout_Chauffeur_array
						.add(new Chauffeur(r.getInt("N_SECURITE"), r.getString("NOM_CHF"), r.getString("VILLE_AD"))

						);

			}

			tout_Chauffeur = new String[tout_Chauffeur_array.size()][3];
			for (int i = 0; i < tout_Chauffeur_array.size(); i++) {
				tout_Chauffeur[i][0] = "" + tout_Chauffeur_array.get(i).getN_SECURITE();
				tout_Chauffeur[i][1] = tout_Chauffeur_array.get(i).getNOM_CHF();
				tout_Chauffeur[i][2] = tout_Chauffeur_array.get(i).getNome_ville_adress();

			}
			// N_SECURITE :0 | NOM_CHF:1 | Nome_ville_adress : 2
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return tout_Chauffeur;
	}
	public static Beans.Chauffeur cherch_chauffeur(int N_SECURITE){
		Beans.Chauffeur chauffeur=new Chauffeur();
		try (
				Connection conn=Class_Connection.conn_oracle_jdbc();
				PreparedStatement p=conn.prepareStatement("select c.N_SECURITE,c.NOM_CHF,a.VILLE_AD" + "  from " + N_bdd + ".adress a," + N_bdd
						+ ".Chauffeur c" + "  where c.NEMURO_AD=a.NEMURO_AD AND c.N_SECURITE=? order by c.N_SECURITE asc");
				){
			p.setInt(1, N_SECURITE);
			ResultSet r=p.executeQuery();
			while (r.next()) {
				chauffeur.setN_SECURITE(r.getInt("N_SECURITE"));
				chauffeur.setNOM_CHF(r.getString("NOM_CHF"));
				chauffeur.setPRENOM_CHF(r.getString("VILLE_AD"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return chauffeur;
	}
	
}
