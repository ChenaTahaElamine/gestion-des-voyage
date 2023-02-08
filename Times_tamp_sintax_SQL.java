package Beans;

public class Times_tamp_sintax_SQL {

	private static int annee;
	private static int month;
	private static int day;
	private static int hour;
	private static int min;
	private static int seq;

	public Times_tamp_sintax_SQL() {
	}

	public Times_tamp_sintax_SQL(int annee, int month, int day, int hour, int min, int seq) {
		this.annee = annee;
		this.month = month;
		this.day = day;
		this.hour = hour;
		this.min = min;
		this.seq = seq;
	}

	public static int getAnnee() {
		return annee;
	}

	public static void setAnnee(int annee) {
		Times_tamp_sintax_SQL.annee = annee;
	}

	public static int getMonth() {
		return month;
	}

	public static void setMonth(int month) {
		Times_tamp_sintax_SQL.month = month;
	}

	public static int getDay() {
		return day;
	}

	public static void setDay(int day) {
		Times_tamp_sintax_SQL.day = day;
	}

	public static int getHour() {
		return hour;
	}

	public static void setHour(int hour) {
		Times_tamp_sintax_SQL.hour = hour;
	}

	public static int getMin() {
		return min;
	}

	public static void setMin(int min) {
		Times_tamp_sintax_SQL.min = min;
	}

	public static int getSeq() {
		return seq;
	}

	public static void setSeq(int seq) {
		Times_tamp_sintax_SQL.seq = seq;
	}
	public static String Timstamp_sintax_sql(String statut_temporel) {

		return "TO_TIMESTAMP('" + day + "-" + month + "-" + annee + " " + hour + ":" + min + ":" + seq + " "
				+ statut_temporel + "','DD-MM-YYYY HH:MI:SS " + statut_temporel + "')";
		// DD-MM-YYYY HH:MI:SS PM

	}
	
}
