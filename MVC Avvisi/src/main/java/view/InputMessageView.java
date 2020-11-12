package view;

import controller.AbstractController;
import javafx.scene.control.TextField;


public class InputMessageView extends TextField implements InputView {


    @Override
    public void addListener(AbstractController controller) {
        this.setOnAction(controller);
    }

    @Override
    public String getNews() {
        return this.getText();
    }

}
