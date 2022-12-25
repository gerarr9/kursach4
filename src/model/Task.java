package model;

import exception.IncorredTaskParametorException;
import model.OneTime;
import model.Repeatability;

import java.time.LocalDateTime;
public class Task {
    private static int idGenerator = 1;
    private  int id;
    private  String title;
    private  String description;
    private Type type;
    private LocalDateTime dateTime;
    private Repeatability repeatability;

    public Task(String title,
                String description,
                Type type,
                LocalDateTime dateTime,
                Repeatability repeatability) throws IncorredTaskParametorException {
        id =idGenerator++;
        setTitle(title);
        setDescription(description);
        setType(type);
        setDateTime(dateTime);
        setRepeatability(repeatability);
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) throws IncorredTaskParametorException {
        if (title == null || title.isBlank() || title.isEmpty()){
            throw new IncorredTaskParametorException("заголовок");
        }
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) throws IncorredTaskParametorException {
        if (description == null || description.isBlank() || description.isEmpty()){
            throw new IncorredTaskParametorException("задачи");
        }
        this.description = description;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) throws IncorredTaskParametorException {
        if (type == null){
            type = Type.PERSONAL;
        }
        this.type = type;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Repeatability getRepeatability() {
        return repeatability;
    }

    public void setRepeatability(Repeatability repeatability) {
        if (repeatability== null){
            repeatability = new OneTime();
        }
        this.repeatability = repeatability;
    }
}
