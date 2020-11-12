package it.unimi.di.prog2.lab8.controller;

import static org.assertj.core.api.Assertions.*;

import it.unimi.di.prog2.lab8.model.Model;
import it.unimi.di.prog2.lab8.view.TemperatureView;
import org.junit.Ignore;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class TestController {

  @Test
  public void testHandle() {
    TemperatureView view = mock(TemperatureView.class);
    Model model = mock(Model.class);
    when(view.getTempValue()).thenReturn(42.00);

    Controller sut= new Controller(view, model);
    sut.updateModel();

    verify(view).getTempValue();
    verify(model).setTemp(42.00);
  }
}
