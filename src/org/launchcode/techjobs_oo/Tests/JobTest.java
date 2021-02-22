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
    // compares the id values returned, false if they are the same, true if they differ by 1


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
    // instanceof makes sure they are in the right class; assertEquals compares the expected field value to the actual,
    // calls toString() because it's being compared to a String

    @Test
    public void testJobsForEquality() {
        assertFalse(testJobFields.equals(testJobFields2));

    }

    //makes sure each gets a unique id, and that it's the only field that doesn't match

   @Test
    public void testJobInformationIsBookendedByBlankLines() {

        assertTrue(testJobFields.toString().startsWith("\n"));
       assertTrue(testJobFields.toString().endsWith("\n"));
   }
//\n starts a new line, so it will print out a blank line. This checks that it is the first and last 'character'

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
    // splitJobFields makes testJobFields a string, then takes out the beginning and ending blank lines so they don't effect the indices,
       // and splits each field onto a new line
       // the for loop loops over each line in the split up jobFields and makes sure that it starts with a matching
       // String to the Strings in the label Array

       // the value Array takes all the field values and coverts them to strings for comparison. Then the for loop
       // loops over each line in the split up jobFields, looks at the ending Strings, and matches them with the valueArray


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

        // tested how this printed with both null and empty string values
        //this test makes sure that an empty field generates "data not available" somewhere in the returned String
        // QUESTION: I could not figure out a way to test the specific fields that were empty, just that the entire thing
        // would contain the String- is there a way to get more specific?

    }



}

