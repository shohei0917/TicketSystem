import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class MainIntegrationTest {

    @Test
    void testMainAppFlow() {

        String simulatedInput = "3" + System.lineSeparator()
                + "4" + System.lineSeparator()
                + "c" + System.lineSeparator()
                + "1100" + System.lineSeparator();

        InputStream originalIn = System.in;
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        PrintStream originalOut = System.out;
        ByteArrayOutputStream stdOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(stdOut));

        try {
            Main.main(new String[]{});

            String actualOutput = stdOut.toString();

            assertTrue(actualOutput.contains("しおラーメン"), "画面に『しおラーメン』が表示されていません。");
            assertTrue(actualOutput.contains("ごはん"), "画面に『ごはん』が表示されていません。");
            assertTrue(actualOutput.contains("1030"), "合計金額である『1030』が画面に表示されていません。");
            assertTrue(actualOutput.contains("70"), "おつりである『70』が画面に表示されていません。");

        } finally {
            System.setIn(originalIn);
            System.setOut(originalOut);
        }
    }
}