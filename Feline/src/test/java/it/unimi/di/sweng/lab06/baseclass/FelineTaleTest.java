package it.unimi.di.sweng.lab06.baseclass;

import it.unimi.di.sweng.lab06.Feline;
import it.unimi.di.sweng.lab06.baseclasses.Lion;
import it.unimi.di.sweng.lab06.baseclasses.Tiger;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.rules.Timeout;
import static org.assertj.core.api.Assertions.*;

public class FelineTaleTest {
	
	@Rule
	public Timeout globalTimeout = Timeout.seconds(2);

	@Rule
	public final SystemOutRule output = new SystemOutRule().enableLog();

	@Test
	public void lionsAndTigersRoar() {
		Feline lion = new Lion();
		Feline tiger = new Tiger();
		lion.roar();
		tiger.roar();
		assertThat(output.getLog()).isEqualTo("ROAR\nROAR\n");
	}

}