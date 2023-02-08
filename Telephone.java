package Beans;

public class Telephone {
	private int N_TELEPHONE;
	private int N_SECURITE;
	private String NOME_UTILISATEUR_AD;

	public Telephone() {
		super();
	}

	public Telephone(int n_TELEPHONE, int n_SECURITE, String NOME_UTILISATEUR_AD) {
		super();
		this.NOME_UTILISATEUR_AD = NOME_UTILISATEUR_AD;
		N_TELEPHONE = n_TELEPHONE;
		N_SECURITE = n_SECURITE;
	}

	public String getNOME_UTILISATEUR_AD() {
		return NOME_UTILISATEUR_AD;
	}

	public void setNOME_UTILISATEUR_AD(String nOME_UTILISATEUR_AD) {
		NOME_UTILISATEUR_AD = nOME_UTILISATEUR_AD;
	}

	public int getN_TELEPHONE() {
		return N_TELEPHONE;
	}

	public void setN_TELEPHONE(int n_TELEPHONE) {
		N_TELEPHONE = n_TELEPHONE;
	}

	public int getN_SECURITE() {
		return N_SECURITE;
	}

	public void setN_SECURITE(int n_SECURITE) {
		N_SECURITE = n_SECURITE;
	}

}
