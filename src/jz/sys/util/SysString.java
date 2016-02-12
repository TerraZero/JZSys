package jz.sys.util;

public class SysString {

	public static String placeholder(String message, String... placeholders) {
		if (placeholders != null) {
			for (int i = 0; i < placeholders.length; i++) {
				message = message.replaceAll("\\[" + i + "\\]", "'" + placeholders[i] + "'");
			}
		}
		return message;
	}
	
	public static String placeholder(String message, Object... placeholders) {
		String[] pl = new String[placeholders.length];
		for (int i = 0; i < placeholders.length; i++) {
			if (placeholders[i] != null) {
				pl[i] = placeholders[i].toString();
			} else {
				pl[i] = "NULL";
			}
		}
		return SysString.placeholder(message, pl);
	}
	
}
