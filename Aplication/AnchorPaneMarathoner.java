
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class AnchorPaneMarathoner extends AnchorPane {
	public AnchorPaneMarathoner() {

		Text nombre = new Text("Nombre");
		this.getChildren().add(nombre);
		nombre.setLayoutX(63);
		nombre.setLayoutY(93);

		Text cc = new Text("C.C :");
		this.getChildren().add(cc);
		cc.setLayoutX(63);
		cc.setLayoutY(135);

		Text equipo = new Text("Equipo :");
		this.getChildren().add(equipo);
		equipo.setLayoutX(63);
		equipo.setLayoutY(175);


		ImageView foto = new ImageView(new Image("mara.png"));
		this.getChildren().add(foto);
		foto.setFitWidth(250);
		foto.setFitHeight(150);
		foto.setLayoutX(243);
		foto.setLayoutY(47);

		

	}
}
