package junit;


import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.both;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.hamcrest.MatcherAssert;
import org.hamcrest.core.CombinableMatcher;
import org.junit.Ignore;
import org.junit.Test;

// make sur test are independent so if one failed others won't !!!!

public class AssertTests {

    // convert string to byte array and then test the equality of arrays using assetarrayequals
    @Test
    public void testAssertArrayEquals() {
        byte[] expected = "trial".getBytes();
        byte[] actual = "trial".getBytes();
        assertArrayEquals("failure - byte arrays not same", expected, actual);
    }
    // assert equals will use .equals to test objs
    @Test
    public void testAssertEquals() {
        assertEquals("failure - strings are not equal", "text", "text");
    }

    // test if its false
    @Test
    public void testAssertFalse() {
        assertFalse("failure - should be false", false);
    }

    @Test
    public void testAssertNotNull() {
        assertNotNull("should not be null", new Object());
    }
    // different from assert equals bcz same is testing the 2 ref are pointing at the same obj
    // here are separate objects
    @Test
    public void testAssertNotSame() {
        assertNotSame("should not be same Object", new Object(), new Object());
    }

    @Test
    public void testAssertNull() {
        assertNull("should be null", null);
    }
    // here are same objects

    @Test
    public void testAssertSame() {
        Integer aNumber = 768;
        assertSame("should be same", aNumber, aNumber);
    }

    // assert that is deprecated
    // JUnit Matchers assertThat
    @Test
    public void testAssertThatBothContainsString() {
        assertThat("albumen", both(containsString("a")).and(containsString("b")));
    }
//    @Test
//    public void testAssertThatBothContainsString2() {
//        // Using Hamcrest's assertThat directly
//        MatcherAssert.assertThat("albumen", both(containsString("a")).and(containsString("b")));
//    }
//Instead of using org.junit.Assert.assertThat, use org.hamcrest.MatcherAssert.assertThat. This is a direct way to utilize Hamcrest’s powerful assertion capabilities without relying on the JUnit wrapper, which might be deprecated in newer versions.
    @Test
    public void testAssertThatHasItems() {
        assertThat(Arrays.asList("one", "two", "three"), hasItems("one", "three"));
    }

    @Test
    public void testAssertThatEveryItemContainsString() {
        assertThat(Arrays.asList("fun", "ban", "net"), everyItem(containsString("n")));
    }

    // Core Hamcrest Matchers with assertThat
    @Test @Ignore
    public void testAssertThatHamcrestCoreMatchers() {
        // Assert that the string "good" matches all of the specified matchers: equals to "good" and starts with "good".
        MatcherAssert.assertThat("good", allOf(equalTo("good"), startsWith("good")));

        // Assert that the string "good" does not match all of the specified matchers: equals to "bad" and equals to "good".
        MatcherAssert.assertThat("good", not(allOf(equalTo("bad"), equalTo("good"))));

        // Assert that the string "good" matches at least one of the specified matchers: equals to "bad" or equals to "good".
        MatcherAssert.assertThat("good", anyOf(equalTo("bad"), equalTo("good")));

        // Assert that the integer 7 is neither equal to 3 nor to 4 using a combiner matcher.
        MatcherAssert.assertThat(7, not(CombinableMatcher.<Integer>either(equalTo(3)).or(equalTo(4))));

        // Assert that two separate Object instances do not refer to the same object instance.
        MatcherAssert.assertThat(new Object(), not(sameInstance(new Object())));
    }

    @Test
    public void testAssertTrue() {
        assertTrue("failure - should be true", true);
    }
}
