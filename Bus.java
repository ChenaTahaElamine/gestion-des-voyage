package Beans;

public class Bus {
	private int N_IMMUTRACULATION;
	private String MARQUE;
	private String MODEL;
	private int NOMBRE_PLACE;
	private String NOME_UTILISATEUR_AD;

	public Bus() {
		super();
	}

	public Bus(int n_IMMUTRACULATION, String mARQUE, String mODEL, int nOMBRE_PLACE, String NOME_UTILISATEUR_AD) {
		super();
		N_IMMUTRACULATION = n_IMMUTRACULATION;
		MARQUE = mARQUE;
		MODEL = mODEL;
		NOMBRE_PLACE = nOMBRE_PLACE;
		this.NOME_UTILISATEUR_AD = NOME_UTILISATEUR_AD;
	}

	public String getNOME_UTILISATEUR_AD() {
		return NOME_UTILISATEUR_AD;
	}

	public void setNOME_UTILISATEUR_AD(String nOME_UTILISATEUR_AD) {
		NOME_UTILISATEUR_AD = nOME_UTILISATEUR_AD;
	}

	public int getN_IMMUTRACULATION() {
		return N_IMMUTRACULATION;
	}

	public void setN_IMMUTRACULATION(int n_IMMUTRACULATION) {
		N_IMMUTRACULATION = n_IMMUTRACULATION;
	}

	public String getMARQUE() {
		return MARQUE;
	}

	public void setMARQUE(String mARQUE) {
		MARQUE = mARQUE;
	}

	public String getMODEL() {
		return MODEL;
	}

	public void setMODEL(String mODEL) {
		MODEL = mODEL;
	}

	public int getNOMBRE_PLACE() {
		return NOMBRE_PLACE;
	}

	public void setNOMBRE_PLACE(int nOMBRE_PLACE) {
		NOMBRE_PLACE = nOMBRE_PLACE;
	}

}
