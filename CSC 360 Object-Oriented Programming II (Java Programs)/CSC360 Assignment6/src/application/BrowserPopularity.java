package application;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.chart.Axis;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/*
File Name: BrowserPopularity.java 
Author: Corey Shrader
Course: CSC 360-002
Date: 4/24/15
 */

// This will create a line graph that shows the popularity of a certain number of top browsers in a given region from 2008 to the present.
public class BrowserPopularity extends Application {

	Region africa = new Region("Africa","/Users/EntheoMac/Documents/School:NKU/Spring 2015/CSC 360-002 Object-Oriented Programming II/Assignment6/browser-af-monthly-200807-201503.csv");
	Region asia = new Region("Asia", "/Users/EntheoMac/Documents/School:NKU/Spring 2015/CSC 360-002 Object-Oriented Programming II/Assignment6/browser-as-monthly-200807-201503.csv");
	Region europe = new Region("Europe", "/Users/EntheoMac/Documents/School:NKU/Spring 2015/CSC 360-002 Object-Oriented Programming II/Assignment6/browser-eu-monthly-200807-201503.csv");
	Region india = new Region("India", "/Users/EntheoMac/Documents/School:NKU/Spring 2015/CSC 360-002 Object-Oriented Programming II/Assignment6/browser-IN-monthly-200807-201503.csv");
	Region kazakhstan = new Region("Kazakhstan", "/Users/EntheoMac/Documents/School:NKU/Spring 2015/CSC 360-002 Object-Oriented Programming II/Assignment6/browser-KZ-monthly-200807-201503.csv");
	Region northAmerica = new Region("North America", "/Users/EntheoMac/Documents/School:NKU/Spring 2015/CSC 360-002 Object-Oriented Programming II/Assignment6/browser-na-monthly-200807-201503.csv");
	Region netherlands = new Region("Netherlands", "/Users/EntheoMac/Documents/School:NKU/Spring 2015/CSC 360-002 Object-Oriented Programming II/Assignment6/browser-NL-monthly-200807-201503.csv");
	Region newZealand = new Region("New Zealand", "/Users/EntheoMac/Documents/School:NKU/Spring 2015/CSC 360-002 Object-Oriented Programming II/Assignment6/browser-NZ-monthly-200807-201503.csv");
	Region oceania = new Region("Oceania", "/Users/EntheoMac/Documents/School:NKU/Spring 2015/CSC 360-002 Object-Oriented Programming II/Assignment6/browser-oc-monthly-200807-201503.csv");
	Region southAmerica = new Region("South America", "/Users/EntheoMac/Documents/School:NKU/Spring 2015/CSC 360-002 Object-Oriented Programming II/Assignment6/browser-sa-monthly-200807-201503.csv");
	Region unitedStates = new Region("United States", "/Users/EntheoMac/Documents/School:NKU/Spring 2015/CSC 360-002 Object-Oriented Programming II/Assignment6/browser-US-monthly-200807-201503.csv");
	Region holySee = new Region("Holy See (Vatican City)", "/Users/EntheoMac/Documents/School:NKU/Spring 2015/CSC 360-002 Object-Oriented Programming II/Assignment6/browser-VA-monthly-200807-201503.csv");
	Region worldWide = new Region("Worldwide", "/Users/EntheoMac/Documents/School:NKU/Spring 2015/CSC 360-002 Object-Oriented Programming II/Assignment6/browser-ww-monthly-200807-201503.csv");

	Region[] regions = {africa, asia, europe, india, kazakhstan, northAmerica, netherlands, newZealand, oceania, southAmerica, unitedStates, holySee, worldWide};
	Integer[] topBrowsers = {3,4,5,6,7,8,9,10};

	HBox root = new HBox();
	BorderPane window = new BorderPane();

	LineChart<String, Number> graph = new LineChart<String,Number>(new CategoryAxis(), new NumberAxis());

	@Override
	public void start(Stage primaryStage) {
		try {
			
			// For selecting region
			ComboBox<Region> regionSelect = new ComboBox<>();
			ObservableList<Region> regionItems = FXCollections.observableArrayList(regions);
			regionSelect.getItems().addAll(regionItems);
			regionSelect.setValue(worldWide);
			Label lbl1 = new Label("Select your region:", regionSelect);
			lbl1.setContentDisplay(ContentDisplay.RIGHT);

			// For selecting number of top browsers
			ComboBox<Integer> topBrowserSelect = new ComboBox<>(); 
			ObservableList<Integer> topBrowserItems = FXCollections.observableArrayList(topBrowsers);
			topBrowserSelect.getItems().addAll(3,4,5,6,7,8,9,10);
			topBrowserSelect.setValue(3);
			Label lbl2 = new Label("Number of top browsers to show:", topBrowserSelect);
			lbl2.setContentDisplay(ContentDisplay.RIGHT);

			regionSelect.setOnAction( e -> {
				drawGraph(regionItems.indexOf(regionSelect.getValue()),topBrowserItems.indexOf(topBrowserSelect.getValue()));
			});

			topBrowserSelect.setOnAction( e -> {
				drawGraph(regionItems.indexOf(regionSelect.getValue()),topBrowserItems.indexOf(topBrowserSelect.getValue()));
			});
			
			// Initiate with Worldwide and 3 browsers
			drawGraph(0,0);

			root.getChildren().add(lbl1);
			root.getChildren().add(lbl2);

			graph.setTitle("Browser Popularity");

			Scene scene = new Scene(window,800,600);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();

		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void drawGraph(int regionIndex, int topBrowserIndex) {

		regions[regionIndex].initiateBrowsers();
		graph.getData().clear();
		
		// Graph data for given region and number of top browsers
		for (int i = 0; i < topBrowsers[topBrowserIndex]; i++) {
			XYChart.Series series = new XYChart.Series();
			series.setName(regions[regionIndex].getBrowser(i).getName());
			for (int j = 0; j < regions[regionIndex].getBrowser(i).getBrowserData().size(); j++) {
				series.getData().add(new XYChart.Data(regions[regionIndex].getDate(j),regions[regionIndex].getBrowser(i).getDataPoint(j)));
			}
			graph.getData().add(series);
		}

		XYChart.Series other = new XYChart.Series();
		other.setName("Other");
		int dataCount = 0;
		int numberOther = regions[regionIndex].getLength() - (topBrowsers[topBrowserIndex]);

		// Always graph the average of the other browsers
		for (int i = 0; i < regions[regionIndex].getDateSize(); i++) {
			for (int j = topBrowsers[topBrowserIndex]; j < regions[regionIndex].getLength(); j++) {
				dataCount += regions[regionIndex].getBrowser(j).getDataPoint(i);
			}
			other.getData().add(new XYChart.Data(regions[regionIndex].getDate(i),dataCount/numberOther));;
		}
		
		graph.getData().add(other);

		window.setCenter(graph);
		window.setBottom(root);
	}

	public static void main(String[] args) {
		launch(args);
	}
}
