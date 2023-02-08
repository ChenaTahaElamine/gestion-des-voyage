package Beans;

public class Passager {

	private int NUM_CL;
	private String NOM_PS;
	private String PRENOM_PS;
	private int NUM_TEL;
	private String NOME_UTILISATEUR_AD;
	private String EMAIL_PS;
	private String PASSWORD_PS;

	public Passager(int nUM_CL, String nOM_PS, String pRENOM_PS, int nUM_TEL, String nOME_UTILISATEUR_AD,
			String EMAIL_PS, String PASSWORD_PS) {
		super();
		NUM_CL = nUM_CL;
		NOM_PS = nOM_PS;
		PRENOM_PS = pRENOM_PS;
		NUM_TEL = nUM_TEL;
		NOME_UTILISATEUR_AD = nOME_UTILISATEUR_AD;
		this.EMAIL_PS = EMAIL_PS;
		this.PASSWORD_PS = PASSWORD_PS;
	}

	public Passager() {

	}

	public String getEMAIL_PS() {
		return EMAIL_PS;
	}

	public void setEMAIL_PS(String eMAIL_PS) {
		EMAIL_PS = eMAIL_PS;
	}

	public String getPASSWORD_PS() {
		return PASSWORD_PS;
	}

	public void setPASSWORD_PS(String pASSWORD_PS) {
		PASSWORD_PS = pASSWORD_PS;
	}

	public String getNOME_UTILISATEUR_AD() {
		return NOME_UTILISATEUR_AD;
	}

	public void setNOME_UTILISATEUR_AD(String nOME_UTILISATEUR_AD) {
		NOME_UTILISATEUR_AD = nOME_UTILISATEUR_AD;
	}

	public int getNUM_CL() {
		return NUM_CL;
	}

	public void setNUM_CL(int nUM_CL) {
		NUM_CL = nUM_CL;
	}

	public String getNOM_PS() {
		return NOM_PS;
	}

	public void setNOM_PS(String nOM_PS) {
		NOM_PS = nOM_PS;
	}

	public String getPRENOM_PS() {
		return PRENOM_PS;
	}

	public void setPRENOM_PS(String pRENOM_PS) {
		PRENOM_PS = pRENOM_PS;
	}

	public int getNUM_TEL() {
		return NUM_TEL;
	}

	public void setNUM_TEL(int nUM_TEL) {
		NUM_TEL = nUM_TEL;
	}

}
