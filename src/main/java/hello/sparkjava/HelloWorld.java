package hello.sparkjava;

import static spark.Spark.*;
import static spark.SparkBase.*;
import hello.sparkjava.transformer.JsonTransformer;
import hello.sparkjava.viewmodel.HelloViewModel;

import java.awt.Desktop;
import java.net.URI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import spark.ModelAndView;
import spark.Spark;
import spark.servlet.SparkApplication;
import spark.template.freemarker.FreeMarkerEngine;

import com.google.gson.Gson;

public class HelloWorld implements SparkApplication {

	protected static final Logger LOGGER = LoggerFactory.getLogger("app");

	@Override
	public void init() {
		staticFileLocation("/public");

		get("/", (request, response) -> {
			//System.out.println(request.queryParams("p"));

			HelloViewModel model = new HelloViewModel();
			model.setTitle("Hello World!");

			// The hello.ftl file is located in directory:
			// src/main/resources/spark/template/freemarker
				return new ModelAndView(model, "hello.ftl");
			}, new FreeMarkerEngine());

		post("/hello",
				(request, response) -> {
					HelloViewModel model = new Gson().fromJson(request.body(), HelloViewModel.class);
					model.setMessage(model.getValue().equals("Ping") ? "Pong!" : "Hoge...");
					return model;
				}, new JsonTransformer());

		put("/data", (request, response) -> {
			return request;
		});

	}

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
