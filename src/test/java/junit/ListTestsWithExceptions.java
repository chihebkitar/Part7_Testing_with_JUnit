package junit;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

public class ListTestsWithExceptions {
    // Initializing a list with fixed values
    private List<String> strings = Arrays.asList("this", "is", "a", "list", "of", "strings");

    @Rule // Declares a rule to catch exceptions with more flexibility than the traditional approach
    public ExpectedException thrown = ExpectedException.none();  // Initializes the ExpectedException rule to none(dep), which allows specifying the type of exception expected in tests dynamically

    @Test // Test to ensure the list contains exactly six strings
    public void defaultListHasSixStrings() {
        assertThat(strings.size(), is(6)); // Asserts that the size of the list is 6 using Hamcrest's 'is' matcher
    }

    @Test // A test using the older JUnit style to handle exceptions
    public void nullListThrowsNPEOldStyle() {
        strings = null; // Explicitly set strings to null to induce a NullPointerException
        try {
            strings.add("hello"); // This line should throw NullPointerException because 'strings' is null
            fail("Should have thrown an NPE"); // This line should not be executed; if it does, the test will fail
        } catch (NullPointerException e) {
            assertNull(strings); // Asserts that 'strings' is null when the exception is caught
        }
    }

    // Test using the `expected` attribute to declare an expected exception simplifies the test logic
    @Test(expected = NullPointerException.class) // Declares that this test expects a NullPointerException to be thrown
    public void nullListThrowsNPE() {
        strings = null; // Set strings to null
        strings.add("hello"); // Attempting to add a string to a null list, which will throw NullPointerException
    }

    @Test // Demonstrates using the ExpectedException rule to handle exceptions with additional matchers for the type and message
    public void nullListThrowsNPEUsingRule() {
        String[] stringArray = strings.toArray(new String[0]); // Converts the list to an array
        thrown.expect(ArrayIndexOutOfBoundsException.class); // Sets up the ExpectedException to expect an ArrayIndexOutOfBoundsException
        thrown.expectMessage("7"); // Also expects that the exception message contains the number "7"
        System.out.println(stringArray[7]); // Accessing an invalid index which should throw the specified exception
    }
}
