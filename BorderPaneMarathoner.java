
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Conection.DataHandler;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class BorderPaneMarathoner extends BorderPane {

	public BorderPaneMarathoner(Stage stage, DataHandler bd) {

		this.setStyle("-fx-base : GRAY");

		MenuBar mb = new MenuBar();
		this.setTop(mb);

		Menu archivo = new Menu("Archivo");
		mb.getMenus().add(archivo);
		MenuItem cerrar = new MenuItem("Cerrar Sesion");
		archivo.getItems().add(cerrar);
		cerrar.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				try {
					bd.cerrar();
				} catch (SQLException e1) {
				}
				stage.close();
				try {
					new Acces().start(new Stage());
				} catch (Exception e) {
				}
			}
		});
		MenuItem salir = new MenuItem("Salir");
		archivo.getItems().add(salir);
		salir.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				Platform.exit();
			}
		});

		Menu encuestas = new Menu("Encuestas");
		mb.getMenus().add(encuestas);
		MenuItem algoritmica = new MenuItem("Algoritmica");
		encuestas.getItems().add(algoritmica);
		algoritmica.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				try {
					Desktop.getDesktop().browse(new URI("https://goo.gl/forms/Nv0wHPcDMHKZoQn22"));
				} catch (URISyntaxException ex) {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("PROBLEM URL");
					alert.setHeaderText(null);
					alert.setContentText("Hubo un problema con el url, por favor intenta mas tarde");
					alert.showAndWait();
				} catch (IOException e) {
				}
			}
		});
		MenuItem matematicas = new MenuItem("Matematicas");
		encuestas.getItems().add(matematicas);
		matematicas.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				try {
					Desktop.getDesktop().browse(new URI("https://goo.gl/forms/hRsSyeJEHDdbvgKL2"));
				} catch (URISyntaxException ex) {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("PROBLEM URL");
					alert.setHeaderText(null);
					alert.setContentText("Hubo un problema con el url, por favor intenta mas tarde");
					alert.showAndWait();
				} catch (IOException e) {
				}
			}
		});
		MenuItem ingles = new MenuItem("Ingles");
		encuestas.getItems().add(ingles);
		ingles.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				try {
					Desktop.getDesktop().browse(new URI("https://goo.gl/forms/tgrItQOwNTm9mX392"));
				} catch (URISyntaxException ex) {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("PROBLEM URL");
					alert.setHeaderText(null);
					alert.setContentText("Hubo un problema con el url, por favor intenta mas tarde");
					alert.showAndWait();
				} catch (IOException e) {
				}
			}
		});
		
		Menu resultados = new Menu("Resultados");
		mb.getMenus().add(resultados);
		algoritmica = new MenuItem("Algoritmica");
		resultados.getItems().add(algoritmica);
		algoritmica.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("Resultados algoritmicas");
			}
		});
		matematicas = new MenuItem("Matematicas");
		resultados.getItems().add(matematicas);
		matematicas.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("Resultados matematicas");
			}
		});
		ingles = new MenuItem("Ingles");
		resultados.getItems().add(ingles);
		ingles.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("Resultados ingles");
			}
		});
		MenuItem recomendaciones = new MenuItem("Recomendaciones");
		resultados.getItems().add(recomendaciones);
		ingles.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("recomendaciones");
			}
		});
		
	}
}
