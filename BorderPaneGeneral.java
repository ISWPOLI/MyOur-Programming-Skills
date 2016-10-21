

import java.sql.SQLException;

import Conection.DataHandler;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class BorderPaneGeneral extends BorderPane {

	public BorderPaneGeneral(Stage stage, DataHandler bd) {

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
	}
}
