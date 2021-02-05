package org.launchcode.techjobs_oo.Tests;

import org.junit.Test;
import org.junit.Before;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.*;

public class JobTest {
    Job testJob;
    Job testJob2;
    Job testJobFields;
    Job testJobFields2;

    @Before
    public void createJobObject() {
        testJob = new Job();
        testJob2 = new Job ();
        testJobFields = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        testJobFields2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
    }


    @Test
    public void testSettingJobId() {
        assertFalse(testJob.getId() == testJob2.getId());
        assertTrue(testJob2.getId() == testJob.getId() + 1);
    }


    @Test
    public void testJobConstructorSetsAllFields() {
        assertTrue(testJobFields instanceof Job);
        assertTrue(testJobFields.getEmployer() instanceof Employer);
        assertTrue(testJobFields.getLocation() instanceof Location);
        assertTrue(testJobFields.getPositionType() instanceof PositionType);
        assertTrue(testJobFields.getCoreCompetency() instanceof CoreCompetency);
        assertEquals("Product tester", testJobFields.getName());
        assertEquals("ACME", testJobFields.getEmployer().toString());
        assertEquals("Desert", testJobFields.getLocation().toString());
        assertEquals("Quality control", testJobFields.getPositionType().toString());
        assertEquals("Persistence", testJobFields.getCoreCompetency().toString());


    }

    @Test
    public void testJobsForEquality() {
        assertFalse(testJobFields == testJobFields2);

    }



}

