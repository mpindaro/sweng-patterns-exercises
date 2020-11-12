package view;

import controller.AbstractController;

public interface InputView {
    void addListener(AbstractController controller);
    String getNews();
}
