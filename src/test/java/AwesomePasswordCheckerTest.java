import org.example.AwesomePasswordChecker;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;



class AwesomePasswordCheckerTest {

    @Test
    void testMaskAff() {
        AwesomePasswordChecker checker = null;
        try {
            checker = AwesomePasswordChecker.getInstance();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Test 1: Mot de passe vide
        assertArrayEquals(new int[28], checker.maskAff(""));

        // Test 2: Lettres minuscules (but expect '2' for lowercase, except specific ones)
        int[] expectedLower = new int[28];
        Arrays.fill(expectedLower, 0, 4, 2);  // Les 4 premières lettres sont des minuscules
        assertArrayEquals(expectedLower, checker.maskAff("abcd"));

        // Test 3: Lettres minuscules except 'e', 's', etc.
        int[] expectedLowerExceptSpecial = new int[28];
        Arrays.fill(expectedLowerExceptSpecial, 0, 4, 1);  // Test lowercase special cases like 'e'
        assertArrayEquals(expectedLowerExceptSpecial, checker.maskAff("esab"));

        // Test 4: Lettres majuscules
        int[] expectedUpper = new int[28];
        Arrays.fill(expectedUpper, 0, 4, 4);  // Les 4 premières lettres sont des majuscules
        assertArrayEquals(expectedUpper, checker.maskAff("ABCD"));

        // Test 5: Chiffres
        int[] expectedDigits = new int[28];
        Arrays.fill(expectedDigits, 0, 4, 5);  // Les 4 premiers caractères sont des chiffres
        assertArrayEquals(expectedDigits, checker.maskAff("1234"));

        // Test 6: Caractères spéciaux
        int[] expectedSpecial = new int[28];
        Arrays.fill(expectedSpecial, 0, 4, 6);  // Les 4 premiers caractères sont spéciaux
        assertArrayEquals(expectedSpecial, checker.maskAff("!@#$"));
    }


    @Test
    void testGetDistance() {
        AwesomePasswordChecker checker = null;
        try {
            checker = AwesomePasswordChecker.getInstance();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Set cluster centers directly for testing purposes
        checker.clusterCenters.add(new double[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0});

        // Test: Mot de passe vide
        assertEquals(0, checker.getDIstance(""));

        // Test: Mot de passe correspondant au centre
        assertEquals(0, checker.getDIstance("")); // Distance minimale
    }


    @Test
    void testComputeMD5() {
        // Test : Chaîne vide
        assertEquals("d41d8cd98f00b204e9800998ecf8427e", AwesomePasswordChecker.ComputeMD5(""));

        // Test : Chaîne courte
        assertEquals("900150983cd24fb0d6963f7d28e17f72", AwesomePasswordChecker.ComputeMD5("abc"));

        // Test : Chaîne longue
        String longString = "a".repeat(1000);
        assertEquals("cabe45dcc9ae5b66ba86600cca6b8ba8", AwesomePasswordChecker.ComputeMD5(longString));
    }
}
