package model;

import observer.Observer;
import org.junit.Test;
import static org.mockito.Mockito.*;

import view.DisplayView;
import view.InputView;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static junit.framework.TestCase.assertEquals;


public class TestNewsModel {

    @Test
    public void testAddNews(){

        NewsModel sut=new NewsModel();

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime now = LocalDateTime.now();

        InputView inputView = mock(InputView.class);
        Observer<String> displayView = mock(Observer.class);

        sut.addObserver(displayView);
        when(inputView.getNews()).thenReturn("falala");

        sut.addNews(inputView.getNews());

        verify(displayView).update(sut,now.format(dtf) + " falala\n");

    }
    @Test
    public void testGetNew(){
        NewsModel sut=new NewsModel();

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime now = LocalDateTime.now();

        InputView inputView = mock(InputView.class);
        InputView inputView2 = mock(InputView.class);

        when(inputView.getNews()).thenReturn("f");
        when(inputView2.getNews()).thenReturn("u");

        sut.addNews(inputView2.getNews());

        sut.addNews(inputView.getNews());
        sut.addNews(inputView.getNews());
        sut.addNews(inputView.getNews());
        sut.addNews(inputView.getNews());
        sut.addNews(inputView.getNews());
        sut.addNews(inputView.getNews());
        sut.addNews(inputView.getNews());
        sut.addNews(inputView.getNews());
        sut.addNews(inputView.getNews());
        sut.addNews(inputView.getNews());
        sut.addNews(inputView.getNews());

        String s="";
        for (int i = 0; i < 10; i++) {
            s+= now.format(dtf) +" f\n";
        }

        assertEquals(sut.getState(), s);

    }
}
