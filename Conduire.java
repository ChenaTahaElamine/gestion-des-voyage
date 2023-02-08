package Beans;

public class Conduire {
	private double DISTANCE=0;
	private int N_SECURITE=0;
	private int N_IMMUTRACULATION=0;
	private int N_SECURITE2=0;

	public Conduire() {
		super();
	}

	public Conduire(double dISTANCE, int n_SECURITE, int n_IMMUTRACULATION) {
		super();
		DISTANCE = dISTANCE;
		N_SECURITE = n_SECURITE;
		N_IMMUTRACULATION = n_IMMUTRACULATION;
	}

	public Conduire(double dISTANCE, int n_SECURITE, int n_IMMUTRACULATION, int N_SECURITE2) {
		this.DISTANCE = dISTANCE;
		this.N_SECURITE = n_SECURITE;
		this.N_IMMUTRACULATION = n_IMMUTRACULATION;
		this.N_SECURITE2 = N_SECURITE2;
	}

	public int getN_SECURITE2() {
		return N_SECURITE2;
	}

	public void setN_SECURITE2(int n_SECURITE2) {
		N_SECURITE2 = n_SECURITE2;
	}

	public double getDISTANCE() {
		
		return DISTANCE;
		
	}

	public void setDISTANCE(double dISTANCE) {
		DISTANCE = dISTANCE;
	}

	public int getN_SECURITE() {
		return N_SECURITE;
	}

	public void setN_SECURITE(int n_SECURITE) {
		N_SECURITE = n_SECURITE;
	}

	public int getN_IMMUTRACULATION() {
		return N_IMMUTRACULATION;
	}

	public void setN_IMMUTRACULATION(int n_IMMUTRACULATION) {
		N_IMMUTRACULATION = n_IMMUTRACULATION;
	}

}
