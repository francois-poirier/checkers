package views;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import controllers.ResumeController;
import utils.Console;

@RunWith(MockitoJUnitRunner.class)
public class ResumeViewTest {

    @Mock
    ResumeController resumeController;

    @Mock
    Console console;

    @InjectMocks
    ResumeView resumeView;

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }
    
    @Test
    public void givenResumeViewWhenAnswerYesThenReplay() {
        when(console.readChar(ResumeView.QUESTION)).thenReturn('s');
        resumeView.interact(resumeController);
        verify(resumeController).resume(true);
    }

    @Test
    public void givenResumeViewWhenAsnwerNoThenFinish() {
        when(console.readChar(ResumeView.QUESTION)).thenReturn('n');
        resumeView.interact(resumeController);
        verify(resumeController).resume(false);
    }

}
    
