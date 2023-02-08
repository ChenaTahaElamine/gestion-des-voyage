package Operation;

public class Gestion_exeption_voyage_duree_distence {

	// NumberFormatException
	public static int scan_duree_distence(String duree, String distence) {
		int i = 0;
		double double_duree=0,double_distence=0;
		
		String String_duree="",String_distence="";
		
		try {
			double_duree=Double.valueOf(duree);
		} catch (NumberFormatException e) {
			String_duree="ERROR";
		}
		try {
			double_distence=Double.valueOf(distence);
		} catch (NumberFormatException e) {
			String_distence="ERROR";
		}
		//__________ Controle
		if (String_duree=="ERROR" && String_distence=="ERROR") {
			Operation.JoptionMessageError.message_error("Donnez-moi la valeur de duree est distence par les chiffres .");
		}else if (String_duree=="ERROR" && String_distence=="") {
			Operation.JoptionMessageError.message_error("Donnez-moi la valeur de duree par les chiffres .");
		}else if (String_duree=="" && String_distence=="ERROR") {
			Operation.JoptionMessageError.message_error("Donnez-moi la valeur de distence par les chiffres .");
		}else if (String_duree=="" && String_distence=="") {
			i=1;
		}
		
		
		return i;
	}

	

}
