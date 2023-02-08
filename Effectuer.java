package Beans;

public class Effectuer {
	
	private int NUM_CL;
	private int CODE_V;

	public Effectuer() {
		super();
	}

	public Effectuer(int nUM_CL, int cODE_V) {
		super();
		
		NUM_CL = nUM_CL;
		CODE_V = cODE_V;
	}


	public int getNUM_CL() {
		return NUM_CL;
	}

	public void setNUM_CL(int nUM_CL) {
		NUM_CL = nUM_CL;
	}

	public int getCODE_V() {
		return CODE_V;
	}

	public void setCODE_V(int cODE_V) {
		CODE_V = cODE_V;
	}

}
