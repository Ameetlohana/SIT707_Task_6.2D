package sit707_week6;

import java.util.*;

public class OnTrack {
    private Map<String, List<String>> taskInbox; // <Student ID, List of tasks>
    private Map<String, Map<String, List<String>>> taskDetails; // <Task ID, <Feedback, List of Chat Messages>>
    private Map<String, List<String>> submittedTasks; // <Task ID, Task Details>
    public Map<String, List<String>> currentUnits; // <Student ID, List of Current Units>
    public Map<String, List<String>> previousUnits; // <Student ID, List of Previous Units>

    public OnTrack() {
        this.taskInbox = new HashMap<>();
        this.taskDetails = new HashMap<>();
        this.submittedTasks = new HashMap<>();
        this.currentUnits = new HashMap<>();
        this.previousUnits = new HashMap<>();
    }

    
    public List<String> getTaskInbox(String studentID) {
        return taskInbox.getOrDefault(studentID, new ArrayList<>());
    }

  
    
    public boolean submitTask(String taskID, String taskDetails) {
        if (!submittedTasks.containsKey(taskID)) {
            submittedTasks.put(taskID, new ArrayList<>());
            submittedTasks.get(taskID).add(taskDetails);
            // Add the task to the student's inbox
            String studentID = taskID.split("_")[0]; // Extracting student ID from task ID
            taskInbox.computeIfAbsent(studentID, k -> new ArrayList<>()).add(taskDetails);
            return true;
        }
        return false;
    }

    
    public boolean provideFeedback(String taskID, String feedback) {
        if (submittedTasks.containsKey(taskID)) {
            taskDetails.putIfAbsent(taskID, new HashMap<>());
            taskDetails.get(taskID).put(feedback, new ArrayList<>());
            return true;
        }
        return false;
    }

    
    public boolean sendMessage(String taskID, String message) {
        if (taskDetails.containsKey(taskID)) {
            taskDetails.get(taskID).values().iterator().next().add(message);
            return true;
        }
        return false;
    }

   
   
    
    public List<String> getCurrentUnits(String studentID) {
        return currentUnits.getOrDefault(studentID, new ArrayList<>());
    }

    
    public List<String> getPreviousUnits(String studentID) {
        return previousUnits.getOrDefault(studentID, new ArrayList<>());
    }
}
