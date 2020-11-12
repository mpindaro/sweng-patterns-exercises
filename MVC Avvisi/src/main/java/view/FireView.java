package view;

import controller.AbstractController;
import javafx.scene.control.Button;

public class FireView extends Button implements InputView {



    private static final String message = "ALLARME INCENDIO: scappare a gambe levate";

    public FireView(){
        super();
        this.setText("ALLARME INCENDIO");
    }

    public String getNews() {
        return message;
    }

    @Override
    public void addListener(AbstractController controller) {
        this.setOnAction(controller);
    }


}
