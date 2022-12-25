package model;

import model.Repeatability;

import java.time.LocalDateTime;

public class Yearly implements Repeatability {
    @Override
    public LocalDateTime nextTime(LocalDateTime currentDateTime) {
        return currentDateTime.plusYears(1);
    }
}
