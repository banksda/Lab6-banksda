package lab6;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;


/**
 * TODO A simple class that needs to be localized
 *
 * @author mohan.
 *         Created Mar 27, 2010.
 */
public class PrintBalance{
	/**
	 * Simple Java Method that is crying out to be localized.
	 *
	 * @param args
	 */
	public static void main(String lang, String loc, String n)
	{
		Locale currentLocale;
		ResourceBundle messages;
		currentLocale = new Locale(lang, loc);
		messages = ResourceBundle.getBundle("MessagesBundle", currentLocale);
		DateFormat dateStyle = DateFormat.getDateInstance(0, currentLocale);
		NumberFormat currencyStyle = NumberFormat.getCurrencyInstance(currentLocale);
		Scanner scanInput = new Scanner(System.in);
		Date today = new Date();
		
		//Greeting
		System.out.print(messages.getString("hello")+"\n");
		
		//Get User's Name
		System.out.print(messages.getString("prompt")+"\n");
		String name = n;
		System.out.print(messages.getString("greet") + name + "\n");
		
		//print today's date, balance and bid goodbye
		System.out.print(messages.getString("now")+ dateStyle.format(today)+"\n");
		System.out.print(messages.getString("owe") + currencyStyle.format(9876543.21)+"\n");
		System.out.print(messages.getString("goodbye")+ "\n");
	}
}