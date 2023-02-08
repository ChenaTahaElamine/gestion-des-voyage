package Operation;

import Beans.Accident;

public class Scan_N_accident_anne {

	
	public static int scan_N_accident_anne(Beans.Accident accident) {
		int i=0;
		//accident.setN_ACCIDENT(0);
		//accident.setANNEE(N_bdd);
		int test_value_N_ACCIDENT=0,test_value_ANNEE=0;
		String error_value_N_ACCIDENT="",error_value_ANNEE="";
		try {
			test_value_N_ACCIDENT=Integer.valueOf(accident.getN_ACCIDENT());
		} catch (NumberFormatException e) {
			error_value_N_ACCIDENT="ERROR";
		}
		try {
			test_value_ANNEE=Integer.valueOf(accident.getANNEE());
		} catch (NumberFormatException e) {
			error_value_ANNEE="ERROR";
		}
		//______________if else
		if (error_value_N_ACCIDENT.equals("ERROR") && error_value_ANNEE.equals("ERROR")) {
			Operation.JoptionMessageError.message_error("Donner le N_accident,anne type integer");
		}else if (error_value_N_ACCIDENT!=("ERROR") && error_value_ANNEE!=("ERROR")) {
			i=1;
		}else if (error_value_N_ACCIDENT!=("ERROR") && error_value_ANNEE==("ERROR")) {
			Operation.JoptionMessageError.message_error("Donner le anne type integer");
		}else if (error_value_N_ACCIDENT==("ERROR") && error_value_ANNEE!=("ERROR")) {
			Operation.JoptionMessageError.message_error("Donner le N_accident type integer");
		}
		return i;
	}
	

}
