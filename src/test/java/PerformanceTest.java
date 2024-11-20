import org.example.AwesomePasswordChecker;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PerformanceTest {

    @Test
    void testComputeMD5Performance() {
        String longInput = "a".repeat(10_000); // Chaîne de 10 000 caractères
        long startTime = System.nanoTime();

        AwesomePasswordChecker.ComputeMD5(longInput);

        long endTime = System.nanoTime();
        long duration = endTime - startTime;

        System.out.println("Temps d'exécution pour ComputeMD5 : " + duration / 1_000_000.0 + " ms");
        assertTrue(duration < 100_000_000); // Vérifie que le temps est inférieur à 100 ms
    }
}
