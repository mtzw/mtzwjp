package mtzwjp;

import hello.sparkjava.HelloWorld;

import java.awt.Desktop;
import java.net.URI;

import spark.Spark;

public class TestRun {

	public static void main(String[] args) throws Exception {
		try {
			new HelloWorld().init();
			Desktop.getDesktop().browse(URI.create("http://localhost:4567/"));

			while (System.in.available() == 0) {
				Thread.sleep(5000);
			}
			Spark.stop();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(100);
		}
	}

}
