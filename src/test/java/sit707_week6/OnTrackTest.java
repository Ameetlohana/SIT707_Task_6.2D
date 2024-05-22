package sit707_week6;

import org.junit.Test;
import java.util.*;
import static org.junit.Assert.*;

public class OnTrackTest {

    @Test
    public void testGetTaskInbox() {
        OnTrack onTrack = new OnTrack();
        onTrack.submitTask("1_Task1", "Task 1 Details");
        onTrack.submitTask("2_Task2", "Task 2 Details");
        onTrack.submitTask("1_Task3", "Task 3 Details");

        List<String> expected = Arrays.asList("Task 1 Details", "Task 3 Details");
        assertEquals(expected, onTrack.getTaskInbox("1"));
    }

  


    @Test
    public void testSubmitTask() {
        OnTrack onTrack = new OnTrack();
        assertTrue(onTrack.submitTask("1_Task1", "Task 1 Details"));
        assertFalse(onTrack.submitTask("1_Task1", "Task 1 Details"));
    }

    @Test
    public void testProvideFeedback() {
        OnTrack onTrack = new OnTrack();
        assertTrue(onTrack.submitTask("1_Task1", "Task 1 Details"));
        assertTrue(onTrack.provideFeedback("1_Task1", "Good work"));
        assertFalse(onTrack.provideFeedback("2_Task2", "Good work"));
    }

    @Test
    public void testSendMessage() {
        OnTrack onTrack = new OnTrack();
        assertTrue(onTrack.submitTask("1_Task1", "Task 1 Details"));
        assertTrue(onTrack.provideFeedback("1_Task1", "Good work"));
        assertTrue(onTrack.sendMessage("1_Task1", "Thank you!"));
        assertFalse(onTrack.sendMessage("2_Task2", "Hello"));
    }

    
   

    @Test
    public void testGetCurrentUnits() {
        OnTrack onTrack = new OnTrack();
        onTrack.currentUnits.put("1", Arrays.asList("Unit A", "Unit B"));
        assertEquals(Arrays.asList("Unit A", "Unit B"), onTrack.getCurrentUnits("1"));
        assertEquals(new ArrayList<>(), onTrack.getCurrentUnits("2"));
    }

    @Test
    public void testGetPreviousUnits() {
        OnTrack onTrack = new OnTrack();
        onTrack.previousUnits.put("1", Arrays.asList("Unit C", "Unit D"));
        assertEquals(Arrays.asList("Unit C", "Unit D"), onTrack.getPreviousUnits("1"));
        assertEquals(new ArrayList<>(), onTrack.getPreviousUnits("2"));
    }
}
