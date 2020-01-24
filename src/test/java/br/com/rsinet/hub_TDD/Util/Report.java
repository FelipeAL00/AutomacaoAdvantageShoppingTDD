package br.com.rsinet.hub_TDD.Util;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Report {
	
	private static ExtentHtmlReporter htmlReporter;
	private static ExtentReports extent;
	private static ExtentTest test;

	public static ExtentReports setReport() {
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/target/reportRelatorio/"+ Generator.dataHoraParaArquivo()+".html");

		htmlReporter.config().setDocumentTitle("Automation Report");
		htmlReporter.config().setReportName("Functional Report");
		htmlReporter.config().setTheme(Theme.DARK);

		extent = new ExtentReports();

		extent.attachReporter(htmlReporter);

		extent.setSystemInfo("HostName", "LocalHost");
		extent.setSystemInfo("OS", "Windows");
		extent.setSystemInfo("Tester Name", "Felipe Almeida");
		extent.setSystemInfo("Browser", "Chrome");
		return extent;
	}

	public static ExtentTest createTest(String testName) {
		test = extent.createTest(testName);
		return test;
	}

	public static void statusReported(ExtentTest test, String caminho, WebDriver driver) throws IOException {

		String screenPath = Printar.gerarScreenShot(driver, caminho);
					
			test.addScreenCaptureFromPath(screenPath);
	}

	public static void quitExtent(ExtentReports extent) {
		extent.flush();
	}
}
