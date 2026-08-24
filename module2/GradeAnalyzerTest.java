import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Arrays;

public class GradeAnalyzerTest {
    
    
    @Test
    void calculateAverage_returnsZero_whenListIsEmpty() {

        ArrayList<Integer> scores = new ArrayList<>();

        assertEquals(0.00, GradeAnalyzer.calculateAverage(scores));
    }

    @Test
    void calculateAverage_returnsCorrectAverage_forTypicalScores() {

        ArrayList<Integer> scores = new ArrayList(Arrays.asList(80, 90, 100));
        assertEquals(90.0, GradeAnalyzer.calculateAverage(scores));


    }

    @Test
    void calculateAverage_returnsSingleValue_whenListHasOneItem() {


        assertEquals(75.0, GradeAnalyzer.calculateAverage(new ArrayList<Integer>(Arrays.asList(75))));

    }

    @Test
    void calculateAverage_returnsDouble_notInteger() {

        assertEquals(1.5, GradeAnalyzer.calculateAverage(new ArrayList<Integer>(Arrays.asList(1,2))));

    }

    @Test
    void calculateAverage_handlesAllSameValues() {

        ArrayList<Integer> scores = new ArrayList<>(Arrays.asList(88, 88, 88));

        assertEquals(88.0, GradeAnalyzer.calculateAverage(scores));


    }
    
    
    @Test
    void getLetterGrade_returnsA_forScoreOf90() {

        assertEquals("A", GradeAnalyzer.getLetterGrade(90));

    }

    @Test
    void getLetterGrade_returnsA_forScoreOf100() {

        assertEquals("A", GradeAnalyzer.getLetterGrade(100));

    }

    @Test
    void getLetterGrade_returnsB_forScoreOf89() {

        assertEquals("B", GradeAnalyzer.getLetterGrade(89));

    }


    @Test
    void getLetterGrade_returnsF_forScoreOf59() {

        assertEquals("F", GradeAnalyzer.getLetterGrade(59));

    }
}
