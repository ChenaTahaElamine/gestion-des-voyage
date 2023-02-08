package Beans;

public class Constituer {
	private double DUREE_S;
	private int CODE_V;
	private int CODE_D;

	public Constituer() {
		super();
	}

	public Constituer(double dUREE_S, int cODE_V, int cODE_D) {
		super();
		DUREE_S = dUREE_S;
		CODE_V = cODE_V;
		CODE_D = cODE_D;
	}

	public double getDUREE_S() {
		return DUREE_S;
	}

	public void setDUREE_S(double dUREE_S) {
		DUREE_S = dUREE_S;
	}

	public int getCODE_V() {
		return CODE_V;
	}

	public void setCODE_V(int cODE_V) {
		CODE_V = cODE_V;
	}

	public int getCODE_D() {
		return CODE_D;
	}

	public void setCODE_D(int cODE_D) {
		CODE_D = cODE_D;
	}

}
