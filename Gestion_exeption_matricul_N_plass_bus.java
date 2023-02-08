package Operation;

public class Gestion_exeption_matricul_N_plass_bus {

	public static int scan_valeur_Integr(String N_IMMUTRACULATION, String NOMBRE_PLACE) {
		int i = 1;
		int N_IMMUTRACULATION_t = 0;
		int NOMBRE_PLACE_t = 0;

		String N_IMMUTRACULATION_E = null;
		String NOMBRE_PLACE_E = null;
		try {
			N_IMMUTRACULATION_t = Integer.valueOf(N_IMMUTRACULATION);
		} catch (NumberFormatException e) {
			N_IMMUTRACULATION_E = "ERROR";
		}
		try {
			NOMBRE_PLACE_t = Integer.valueOf(NOMBRE_PLACE);
		} catch (NumberFormatException e) {
			NOMBRE_PLACE_E = "ERROR";
		}
		// ----------- if else
		if (N_IMMUTRACULATION_E == "ERROR" && NOMBRE_PLACE_E == "ERROR") {
			Operation.JoptionMessageError.message_error("Donner la valeur de Matricule et Nombre place integer");
		} else if (N_IMMUTRACULATION_E != "ERROR" && NOMBRE_PLACE_E != "ERROR") {
			i = 0;
		} else if (N_IMMUTRACULATION_E == "ERROR" && NOMBRE_PLACE_E != "ERROR") {
			Operation.JoptionMessageError.message_error("Donner la valeur de Matricule integer");
		} else if (N_IMMUTRACULATION_E != "ERROR" && NOMBRE_PLACE_E == "ERROR") {
			Operation.JoptionMessageError.message_error("Donner la valeur de nombre place integer");
		}

		return i;
	}

}
