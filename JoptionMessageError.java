package Operation;

import javax.swing.JOptionPane;

public class JoptionMessageError {

	public static void message_error(String message_dialeg) {
		JOptionPane.showMessageDialog(null, message_dialeg, "l'utilisateur", JOptionPane.ERROR_MESSAGE);
	}

	public static void message_information(String message_dialeg) {
		JOptionPane.showMessageDialog(null, message_dialeg, "l'utilisateur", JOptionPane.INFORMATION_MESSAGE);
	}

}
