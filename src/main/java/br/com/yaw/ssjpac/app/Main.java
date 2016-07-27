package br.com.yaw.ssjpac.app;


import java.util.Locale;

import br.com.yaw.ssjpac.controller.BuscarMercadoriaController;
import br.com.yaw.ssjpac.controller.ListaMercadoriaController;
import br.com.yaw.ssjpac.ui.BuscaMercadoriaFrame;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.swing.*;

/**
 * Ponto de entrada da aplicação.
 * 
 * @author YaW Tecnologia
 */
public class Main {
	
	public static void main(String[] args) {
		Locale.setDefault(new Locale("pl","PL"));
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("META-INF/spring-config.xml");
	}

}
