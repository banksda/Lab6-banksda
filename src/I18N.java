import java.util.Locale;
import java.util.ResourceBundle;


public class I18N {
	public static void main(String[] args) {
		String language;
		String country;
		
		Locale currentLocale;
		ResourceBundle messages;
		
		currentLocale = new Locale("de", "DE");
		messages = ResourceBundle.getBundle("MessagesBundle", currentLocale);
		
		System.out.println(messages.getString("greetings"));
		System.out.println(messages.getString("inquiry"));
		System.out.println(messages.getString("farewell"));
	}
}
