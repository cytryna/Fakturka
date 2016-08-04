package diligentia.app;


import java.util.Locale;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	
	public static void main(String[] args) {
		Locale.setDefault(new Locale("pl","PL"));
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("META-INF/spring-config.xml");
	}

}
