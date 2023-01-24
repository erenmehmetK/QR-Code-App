package qr_goats;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import nl.delphinity.qr_goats.domain.Persoon;

public class PersoonTest {
	
	@Test
    public void testCompareTo() {
        Persoon p1 = new Persoon(1, "John", "van", "Doe");
        Persoon p2 = new Persoon(2, "Jane", "van der", "Doe");
        Persoon p3 = new Persoon(3, "John", "van", "Smith");
        Persoon p4 = new Persoon(4, "John", null, "Doe" );
        Persoon p5 = new Persoon(5, "John", "van", "Doe");

        // Test comparison by naam
        assertTrue(p1.compareTo(p2) > 0);
        assertTrue(p2.compareTo(p1) < 0);

        // Test comparison by achternaam
        assertTrue(p1.compareTo(p3) < 0);
        assertTrue(p3.compareTo(p1) > 0);

        // Test comparison by tussenvoegsel
        assertTrue(p2.compareTo(p3) < 0);
        assertTrue(p3.compareTo(p2) > 0);

        // Test comparison with null tussenvoegsel
        assertEquals(p1.compareTo(p4), 0);
        assertEquals(p4.compareTo(p1), 0);

        // Test comparison with equal objects
        assertEquals(p1.compareTo(p5), 0);
        assertEquals(p5.compareTo(p1), 0);
        
        System.out.println(p1.compareTo(p2));
        System.out.println(p2.compareTo(p1));
        System.out.println(p1.compareTo(p3));
        System.out.println(p3.compareTo(p1));
        System.out.println(p1.compareTo(p4));
        System.out.println(p4.compareTo(p1));
        System.out.println(p1.compareTo(p5));
        System.out.println(p5.compareTo(p1));
    }

}
