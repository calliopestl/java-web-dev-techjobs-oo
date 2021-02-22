package org.launchcode.techjobs_oo;

import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    // TODO: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.
    public Job() {
        id = nextId;
        nextId++;
    }

    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency) {
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }

    // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.

    @Override
    public boolean equals(Object o) {
        if (this == o) return true; //if they are already identical (the exact same), the rest of this doesn't need to be done
        if (o == null || getClass() != o.getClass()) return false; //to prevent an error, makes sure compared objects are created from the
        // same class and makes sure there is a value being compared
        Job job = (Job) o; // cast input to be the same type
        return id == job.id; // cites the field that will determine if it's equal
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {

        if (name == null || name.equals("")) {
           setName("Data not available");
        }
        if (this.getEmployer().getValue() == null || this.getEmployer().getValue().equals("")) {
           employer.setValue("Data not available");
        }
        if (this.getLocation().getValue() == null || this.getLocation().getValue().equals("")) {
            location.setValue("Data not available");
        }
        if (this.getPositionType().getValue() == null || this.getPositionType().getValue().equals("")) {
            positionType.setValue("Data not available");
        }
        if (this.coreCompetency.getValue() == null || this.getCoreCompetency().getValue().equals("")) {
            coreCompetency.setValue("Data not available");
        }
            return "\n" +
                    "ID: " + this.id + "\n" +
                    "Name: " + this.name + "\n" +
                    "Employer: " + this.employer + "\n" +
                    "Location: " + this.location + "\n" +
                    "Position Type: " + this.positionType + "\n" +
                    "Core Competency: " + this.coreCompetency +
                    "\n";
        }



    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }

    public int getId() {
        return id;
    }
}

