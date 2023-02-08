package Beans;

public class Adress {
	private int NEMURO_AD;
	private String NOM_RUE;
	private String VILLE_AD;
	private int CODE_POSTAL;
	private String NOME_UTILISATEUR_AD;

	public Adress() {
		super();
	}

	public Adress(int nEMURO_AD, String nOM_RUE, String vILLE_AD, int cODE_POSTAL, String NOME_UTILISATEUR_AD) {
		super();
		NEMURO_AD = nEMURO_AD;
		NOM_RUE = nOM_RUE;
		VILLE_AD = vILLE_AD;
		CODE_POSTAL = cODE_POSTAL;
		this.NOME_UTILISATEUR_AD = NOME_UTILISATEUR_AD;
	}

	public String getNOME_UTILISATEUR_AD() {
		return NOME_UTILISATEUR_AD;
	}

	public void setNOME_UTILISATEUR_AD(String nOME_UTILISATEUR_AD) {
		NOME_UTILISATEUR_AD = nOME_UTILISATEUR_AD;
	}

	public int getNEMURO_AD() {
		return NEMURO_AD;
	}

	public void setNEMURO_AD(int nEMURO_AD) {
		NEMURO_AD = nEMURO_AD;
	}

	public String getNOM_RUE() {
		return NOM_RUE;
	}

	public void setNOM_RUE(String nOM_RUE) {
		NOM_RUE = nOM_RUE;
	}

	public String getVILLE_AD() {
		return VILLE_AD;
	}

	public void setVILLE_AD(String vILLE_AD) {
		VILLE_AD = vILLE_AD;
	}

	public int getCODE_POSTAL() {
		return CODE_POSTAL;
	}

	public void setCODE_POSTAL(int cODE_POSTAL) {
		CODE_POSTAL = cODE_POSTAL;
	}

}
