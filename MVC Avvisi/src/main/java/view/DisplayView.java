package view;

import javafx.scene.control.Label;
import observer.Observer;
import observer.Subject;

public class DisplayView extends Label implements Observer<String> {

    private final ShowStrategy showStrategy;

    public DisplayView(ShowStrategy showStrategy) {
        this.showStrategy=showStrategy;
    }

    @Override
    public void update(Subject<String> subject, String state) {
        this.setText(showStrategy.getOutputText(state));
    }
}
