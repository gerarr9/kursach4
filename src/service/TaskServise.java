package service;
import model.Task;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class TaskServise {
    private static  Map<Integer,Task> TASK = new HashMap<>();

    private TaskServise(){

    }
    public void add(Task task){
        TASK.put(task.getId(), task);
    }
    public static Collection<Task> getTasksByDay(LocalDate day){
        Collection<Task> tasksByDay = new ArrayList<>();
        Collection<Task> allTasks = TASK.values();
        for (Task task : allTasks){
            LocalDateTime currentDateTime = task.getDateTime();
            LocalDateTime nextDateTime = task.getRepeatability().nextTime(currentDateTime);
            if (nextDateTime == null && currentDateTime.toLocalDate().equals(day)){
                tasksByDay.add(task);
                continue;
            }
            do {
                if (nextDateTime.toLocalDate().equals(day)){
                    tasksByDay.add(task);
                    break;
                }
                nextDateTime = task.getRepeatability().nextTime(nextDateTime);
            } while (nextDateTime.toLocalDate().isBefore(day));
        }
        return tasksByDay;
    }
    public void removeById(int id){
        TASK.put(task.getId(), task);
    }
}
