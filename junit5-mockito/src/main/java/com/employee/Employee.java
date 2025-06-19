package com.employee;

import java.time.LocalDateTime;

public class Employee {
    private LocalDateTime joiningDate;

    public LocalDateTime getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(LocalDateTime joiningDate) {
        this.joiningDate = joiningDate;
    }
}