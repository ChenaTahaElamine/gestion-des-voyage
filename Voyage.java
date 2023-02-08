package Beans;

public class Voyage {
	private int CODE_V;
	private String DATE_D;
	private double DUREE;
	private int N_IMMUTRACULATION;
	private String NOME_UTILISATEUR_AD;

	public Voyage() {
		super();
	}

	public Voyage(int cODE_V, String dATE_D, double dUREE, int n_IMMUTRACULATION, String NOME_UTILISATEUR_AD) {
		super();
		CODE_V = cODE_V;
		DATE_D = dATE_D;
		DUREE = dUREE;
		N_IMMUTRACULATION = n_IMMUTRACULATION;
		this.NOME_UTILISATEUR_AD = NOME_UTILISATEUR_AD;
	}

	public String getNOME_UTILISATEUR_AD() {
		return NOME_UTILISATEUR_AD;
	}

	public void setNOME_UTILISATEUR_AD(String nOME_UTILISATEUR_AD) {
		NOME_UTILISATEUR_AD = nOME_UTILISATEUR_AD;
	}

	public int getCODE_V() {
		return CODE_V;
	}

	public void setCODE_V(int cODE_V) {
		CODE_V = cODE_V;
	}

	public String getDATE_D() {
		return DATE_D;
	}

	public void setDATE_D(String dATE_D) {
		DATE_D = dATE_D;
	}

	public double getDUREE() {
		return DUREE;
	}

	public void setDUREE(double dUREE) {
		DUREE = dUREE;
	}

	public int getN_IMMUTRACULATION() {
		return N_IMMUTRACULATION;
	}

	public void setN_IMMUTRACULATION(int n_IMMUTRACULATION) {
		N_IMMUTRACULATION = n_IMMUTRACULATION;
	}

}
