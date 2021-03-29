package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class Project {
    private String name;
    private String description;
    private String startDate;
    private String dueDate;
    List<Employee> teamMembers = new ArrayList<>();

    public String getName() { return this.name; }
    public String getDescription() { return this.description; }
    public String getStartDate() { return this.startDate; }
    public String getDueDate() { return this.dueDate; }
    public List<Employee> getTeamMembers() { return this.teamMembers; }

    public void setName(String name) { this.name = name; }
    public void setDescription(String description) { this.description = description; }
    public void setStartDate(String startDate) { this.startDate = startDate; }
    public void setDueDate(String dueDate) { this.dueDate = dueDate; }
    public void setTeamMembers(Employee teamMember) { this.teamMembers.add(teamMember); }


    public Project (String name, String description, String startDate, String dueDate) {
        setName(name);
        setDescription(description);
        setStartDate(startDate);
        setDueDate(dueDate);
    }
}
