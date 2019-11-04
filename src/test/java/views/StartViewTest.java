package views;

import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import controllers.StartController;
import utils.Console;

@RunWith(MockitoJUnitRunner.class)
public class StartViewTest {

	@Mock
	StartController startController;

	@Mock
	Console console;

	@Mock
	BoardView boardView;
	
	@InjectMocks
	StartView startView;

	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testInteract() {
		startView.interact(startController);
		verify(console).writeln(StartView.INITIAL_MESSAGE);
		verify(startController).start();
	}
}