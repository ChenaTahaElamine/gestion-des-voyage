package Beans;

public class Chauffeur {
	private int N_SECURITE;
	private String NOM_CHF;
	private String PRENOM_CHF;
	private int NEMURO_AD;
	private String NOME_UTILISATEUR_AD;
	private double SALARE;
	private String nome_ville_adress;

	public Chauffeur() {
		super();
	}

	public Chauffeur(int n_SECURITE, String nOM_CHF, String pRENOM_CHF, int nEMURO_AD, String NOME_UTILISATEUR_AD) {
		super();
		N_SECURITE = n_SECURITE;
		NOM_CHF = nOM_CHF;
		PRENOM_CHF = pRENOM_CHF;
		NEMURO_AD = nEMURO_AD;
		this.NOME_UTILISATEUR_AD = NOME_UTILISATEUR_AD;
	}

	public Chauffeur(int n_SECURITE, String nOM_CHF, String pRENOM_CHF, int nEMURO_AD, String NOME_UTILISATEUR_AD,
			double SALARE) {

		this.N_SECURITE = n_SECURITE;
		this.NOM_CHF = nOM_CHF;
		this.PRENOM_CHF = pRENOM_CHF;
		this.NEMURO_AD = nEMURO_AD;
		this.NOME_UTILISATEUR_AD = NOME_UTILISATEUR_AD;
		this.SALARE = SALARE;
	}

	public Chauffeur(int n_SECURITE, String nOM_CHF, String nome_ville_adress) {

		this.N_SECURITE = n_SECURITE;
		this.NOM_CHF = nOM_CHF;
		this.nome_ville_adress = nome_ville_adress;
	}

	public String getNome_ville_adress() {
		return nome_ville_adress;
	}

	public void setNome_ville_adress(String nome_ville_adress) {
		this.nome_ville_adress = nome_ville_adress;
	}

	public double getSALARE() {
		return SALARE;
	}

	public void setSALARE(double sALARE) {
		SALARE = sALARE;
	}

	public String getNOME_UTILISATEUR_AD() {
		return NOME_UTILISATEUR_AD;
	}

	public void setNOME_UTILISATEUR_AD(String nOME_UTILISATEUR_AD) {
		NOME_UTILISATEUR_AD = nOME_UTILISATEUR_AD;
	}

	public int getN_SECURITE() {
		return N_SECURITE;
	}

	public void setN_SECURITE(int n_SECURITE) {
		N_SECURITE = n_SECURITE;
	}

	public String getNOM_CHF() {
		return NOM_CHF;
	}

	public void setNOM_CHF(String nOM_CHF) {
		NOM_CHF = nOM_CHF;
	}

	public String getPRENOM_CHF() {
		return PRENOM_CHF;
	}

	public void setPRENOM_CHF(String pRENOM_CHF) {
		PRENOM_CHF = pRENOM_CHF;
	}

	public int getNEMURO_AD() {
		return NEMURO_AD;
	}

	public void setNEMURO_AD(int nEMURO_AD) {
		NEMURO_AD = nEMURO_AD;
	}

}
