
import Conection.DataHandler;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class CoachPrincipal extends Application {
	
	public String user,pass;
	@Override
	public void start(Stage Stage) throws Exception {
		BorderPane root = new BorderPaneCoach(Stage,new DataHandler(user, pass));
		Scene s = new Scene(root,500,400,Color.GRAY);
		Stage.setTitle("Beta Coach");

		root.setCenter(new AnchorPaneCoach());

		Stage.setResizable(false);
		Stage.setScene(s);
		Stage.show();
	}
	public void set(String user,String pass){
		this.user=user;
		this.pass=pass;
	}
}
