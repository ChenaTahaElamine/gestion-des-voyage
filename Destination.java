package Beans;

public class Destination {

	private int CODE_D;
	private String VILLE_DS;
	private String NOME_UTILISATEUR_AD;

	public Destination() {
		super();
	}

	public Destination(int cODE_D, String vILLE_DS, String NOME_UTILISATEUR_AD) {
		super();
		CODE_D = cODE_D;
		VILLE_DS = vILLE_DS;
		this.NOME_UTILISATEUR_AD = NOME_UTILISATEUR_AD;
	}

	public String getNOME_UTILISATEUR_AD() {
		return NOME_UTILISATEUR_AD;
	}

	public void setNOME_UTILISATEUR_AD(String nOME_UTILISATEUR_AD) {
		NOME_UTILISATEUR_AD = nOME_UTILISATEUR_AD;
	}

	public int getCODE_D() {
		return CODE_D;
	}

	public void setCODE_D(int cODE_D) {
		CODE_D = cODE_D;
	}

	public String getVILLE_DS() {
		return VILLE_DS;
	}

	public void setVILLE_DS(String vILLE_DS) {
		VILLE_DS = vILLE_DS;
	}

}
