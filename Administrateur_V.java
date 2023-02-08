package Beans;

public class Administrateur_V {

	private String NOME_UTILISATEUR;
	private String NOME;
	private String PRENOM;
	private String EMAIL;
	private String PASSWORD;

	public Administrateur_V() {

	}

	public Administrateur_V(String nOME_UTILISATEUR, String nOME, String pRENOM, String eMAIL, String pASSWORD) {
		super();
		NOME_UTILISATEUR = nOME_UTILISATEUR;
		NOME = nOME;
		PRENOM = pRENOM;
		EMAIL = eMAIL;
		PASSWORD = pASSWORD;
	}

	public String getNOME_UTILISATEUR() {
		return NOME_UTILISATEUR;
	}

	public void setNOME_UTILISATEUR(String nOME_UTILISATEUR) {
		NOME_UTILISATEUR = nOME_UTILISATEUR;
	}

	public String getNOME() {
		return NOME;
	}

	public void setNOME(String nOME) {
		NOME = nOME;
	}

	public String getPRENOM() {
		return PRENOM;
	}

	public void setPRENOM(String pRENOM) {
		PRENOM = pRENOM;
	}

	public String getEMAIL() {
		return EMAIL;
	}

	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}

	public String getPASSWORD() {
		return PASSWORD;
	}

	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}

}
