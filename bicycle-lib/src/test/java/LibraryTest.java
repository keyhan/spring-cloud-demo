import com.keyhan.model.Bicycle;
import org.junit.Test;
import static org.junit.Assert.*;

/*
 * This Java source file was auto generated by running 'gradle init --type java-library'
 * by 'keyhan' at '2016-11-02 11:05' with Gradle 2.14.1
 *
 * @author keyhan, @date 2016-11-02 11:05
 */
public class LibraryTest {
    @Test public void testSomeLibraryMethod() {
        Bicycle.BicycleBuilder builder;
        Library classUnderTest = new Library();
        assertTrue("someLibraryMethod should return 'true'", classUnderTest.someLibraryMethod());
    }
}
