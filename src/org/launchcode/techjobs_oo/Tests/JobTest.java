package org.launchcode.techjobs_oo.Tests;

import org.junit.Test;
import org.junit.Before;
import org.launchcode.techjobs_oo.*;

import java.util.ArrayList;
import java.util.HashMap;

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
    } //before annotation allows these to be used for all of the tests


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
        assertFalse(testJobFields.equals(testJobFields2));

    }

   @Test
    public void testJobInformationIsBookendedByBlankLines() {

        assertTrue(testJobFields.toString().startsWith("\n"));
       assertTrue(testJobFields.toString().endsWith("\n"));
   }

   @Test
    public void testJobPrintsLabelsAndValues() {
       String[] labelArray = new String[] {"ID: ", "Name: ", "Employer: ", "Location: ",
       "Position Type: ", "Core Competency: "};
       String[] splitJobFields = testJobFields.toString().trim().split("\n");
       for (int i=0; i< labelArray.length; i++) {
           assertTrue(splitJobFields[i].startsWith(labelArray[i]));

       }
       String[] valueArray = new String [] {Integer.toString(testJobFields.getId()), testJobFields.getName(), testJobFields.getEmployer().toString(),
       testJobFields.getLocation().toString(), testJobFields.getPositionType().toString(), testJobFields.getCoreCompetency().toString()};
      for (int i=0; i<valueArray.length; i++) {
          assertTrue(splitJobFields[i].endsWith(valueArray[i]));
      }

       // assertTrue(splitJobFields[0].endsWith(Integer.toString(testJobFields.getId()));
       // assertTrue(splitJobFields[1].endsWith(testJobFields.getName()));
       // assertTrue(splitJobFields[2].endsWith(testJobFields.getEmployer().toString()));
       // assertTrue(splitJobFields[3].endsWith(testJobFields.getLocation().toString()));
       // assertTrue(splitJobFields[4].endsWith(testJobFields.getPositionType().toString()));
       // assertTrue(splitJobFields[5].endsWith(testJobFields.getCoreCompetency().toString()));

    }

    @Test
    public void testJobRecognizesEmptyField() {
        Job emptyJobField = new Job(null, new Employer(""), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertTrue(emptyJobField.toString().contains("Data not available"));

      //  assertEquals("Data not available", emptyJobField.getName().toString());
        //assertEquals("Data not available", emptyJobField.getEmployer().toString());

    }



}

