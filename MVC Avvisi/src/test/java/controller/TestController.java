package controller;
import javafx.event.ActionEvent;
import javafx.event.Event;
import model.Model;
import model.NewsModel;
import observer.Observer;
import org.junit.Test;
import static org.mockito.Mockito.*;

import view.DisplayView;
import view.InputView;
import static junit.framework.TestCase.assertEquals;

public class TestController {

    @Test
    public void testUpdate(){

        InputView inputView = mock(InputView.class);
        NewsModel model = mock(NewsModel.class);
        Observer<String> observer= mock(Observer.class);

        model.addObserver(observer);
        when(inputView.getNews()).thenReturn("falala");

        Controller controller = new Controller(inputView,model);

        controller.updateModel();

        verify(inputView).getNews();
        verify(model).addNews("falala");
    }

    @Test
    public void testHandle(){
        InputView inputView = mock(InputView.class);
        NewsModel model = mock(NewsModel.class);
        Observer<String> observer= mock(Observer.class);
        ActionEvent actionEvent = mock(ActionEvent.class);

        model.addObserver(observer);
        when(inputView.getNews()).thenReturn("falala");

        Controller controller = new Controller(inputView,model);

        controller.handle(actionEvent);

        verify(inputView).getNews();
        verify(model).addNews("falala");
    }
}
