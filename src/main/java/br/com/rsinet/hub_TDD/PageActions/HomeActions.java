package br.com.rsinet.hub_TDD.pageActions;

import br.com.rsinet.hub_TDD.Util.Log;
import br.com.rsinet.hub_TDD.pageFactory.HomePage;

public class HomeActions {
	
	public static String capturarQuemTaLogado() {
		if(HomePage.UserLog.isEnabled()) {
			Log.info("Usuario cadastrado");
			return HomePage.UserLog.getText();
		}
		Log.info("Usuario não cadastrado");
		return "";
	}
}
