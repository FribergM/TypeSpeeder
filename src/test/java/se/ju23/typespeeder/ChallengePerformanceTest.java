package se.ju23.typespeeder;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.ju23.typespeeder.data.entities.Text;
import se.ju23.typespeeder.logic.Challenge;
import se.ju23.typespeeder.ui.SystemIO;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class ChallengePerformanceTest {
    private static final int MAX_EXECUTION_TIME = 200;
    private static final int MILLISECONDS_CONVERSION = 1_000_000;

    private List<Text> texts;

    @BeforeEach
    void setup(){
        texts = new ArrayList<>();
        texts.add(new Text("Sample text. Sample text. Sample text. Sample text. Sample text. Sample text.",1,true));
        String input = "Sample text.";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

    @Test
    public void testStartChallengePerformance() {
        Challenge challenge = new Challenge(true,1,1, texts);
        long startTime = System.nanoTime();
        challenge.startChallenge(new SystemIO(),"Sample text.");
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / MILLISECONDS_CONVERSION;
        assertTrue(duration <= MAX_EXECUTION_TIME, "Starting a challenge took too long. Execution time: " + duration + " ms.");
    }
    @Test
    public void testLettersToTypePerformance() {
        Challenge challenge = new Challenge(true,1,1, texts);
        long startTime = System.nanoTime();
        challenge.lettersToType(new SystemIO());
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / MILLISECONDS_CONVERSION;
        assertTrue(duration <= MAX_EXECUTION_TIME, "Selecting letters to type took too long. Execution time: " + duration + " ms.");
    }
}

