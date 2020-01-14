package br.com.rsinet.hub_TDD.pageActions;

import br.com.rsinet.hub_TDD.pageFactory.HomePage;

public class HomeActions {
	
	public static String capturarQuemTaLogado() {
		if(HomePage.UserLog.isEnabled()) {
			return HomePage.UserLog.getText();
		}
		return "";
	}
}
