package Operation;

public class Gestion_exeption_salare_N_telephon_chafeur {

	public static int scan_Gestion_exeption_salare_N_telephon_chafeur(String SALARE, String N_telephon) {
		int i = 0;
		// NumberFormatException
		String ex_SALARE = "";
		String ex_N_telephon = "";
		try {
			Double.valueOf(SALARE);
		} catch (NumberFormatException e) {
			ex_SALARE = "ERROR";
			i = 1;
		}
		try {
			Double.valueOf(N_telephon);
		} catch (NumberFormatException e) {
			ex_N_telephon = "ERROR";
			i = 1;
		}
		if (ex_SALARE == "ERROR" && ex_N_telephon == "ERROR") {
			Operation.JoptionMessageError.message_error(
					"<html><body>Donner la valeur de salare et N_telephone <font color=red>Integer</font></body></html>");
		} else if (ex_SALARE == "" && ex_N_telephon == "ERROR") {
			Operation.JoptionMessageError.message_error(
					"<html><body>Donner la valeur de N_telephone <font color=red>Integer</font></body></html>");
		} else if (ex_SALARE == "ERROR" && ex_N_telephon == "") {
			Operation.JoptionMessageError.message_error(
					"<html><body>Donner la valeur de salare <font color=red>Integer</font></body></html>");
		} else if (ex_SALARE == "" && ex_N_telephon == "") {
			i = 0;
		}

		return i;
	}

}
