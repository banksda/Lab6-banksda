package lab6;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class L10NTest {
	private final ByteArrayOutputStream output = new ByteArrayOutputStream();
	
	@Before
	public void setUp() {
		System.setOut(new PrintStream(this.output));
	}
	
	@After
	public void tearDown() {
		System.setOut(null);
	}
	
	@Test
	public void testEnglish() {
		PrintBalance.main("en", "US", "name");
		Locale currentLocale = new Locale("en", "US");
		NumberFormat numFormat = NumberFormat.getCurrencyInstance(currentLocale);
		DateFormat dateFormat = DateFormat.getDateInstance(0, currentLocale);
		assertEquals("Hello world\n"+"Please enter your name\n" +
				"I am pleased to meet you name\n" +
				"As of: " + dateFormat.format(new Date()) +
				"\nYou owe the school " + numFormat.format(9876543.21) + 
				"\nGood Bye\n", output.toString());
	}
	
	@Test
	public void testGerman() {
		PrintBalance.main("de", "DE", "name");
		Locale currentLocale = new Locale("de", "DE");
		NumberFormat numFormat = NumberFormat.getCurrencyInstance(currentLocale);
		DateFormat dateFormat = DateFormat.getDateInstance(0, currentLocale);
		assertEquals(output.toString(), "Hallo welt\n" + "Bitte geben Sie Ihren Namen\n"
				+ "Ich freue mich, Sie kennen zu lernen name\n" +
				"Stand: " + dateFormat.format(new Date()) +
				"\nDu schuldest der Schule " + numFormat.format(9876543.21) +
				"\nAuf wiedersehen\n");
		
	}
	
	@Test
	public void testFrench() {
		PrintBalance.main("fr", "FR", "name");
		Locale currentLocale = new Locale("fr", "FR");
		NumberFormat numFormat = NumberFormat.getCurrencyInstance(currentLocale);
		DateFormat dateFormat = DateFormat.getDateInstance(0, currentLocale);
		assertEquals("Bonjour tout le monde\n" + "S'il vous plait entrer votre nom\n" + 
				"Je suis heureux de vous rencontrer name\n" + 
				"En date du: " + dateFormat.format(new Date()) +
				"\nVous devez l'ecole " + numFormat.format(9876543.21) +
				"\nAu revoir\n", output.toString());
	}
}
