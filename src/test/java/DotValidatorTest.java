import com.lisi4ka.web_lab3.DotValidator;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class DotValidatorTest {

    @Test
    public void resultFirstString() {
        String[] actual = DotValidator.result(-1.0f,2.0f,3.0f,0.3f);
        String[] expected = {String.valueOf(60), String.valueOf(60), String.valueOf(60), "Не пробил!"};
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], actual[i]);
        }
    }

    @Test
    public void resultSecondString(){
        String[] actual = DotValidator.result(1.2f, 0.3f, 2f, 0.6f);
        String[] expected = {String.valueOf(0), String.valueOf(255), String.valueOf(0), "Есть пробитие!"};
        for(int i = 0; i < expected.length; i++){
            assertEquals(expected[i], actual[i]);
        }
    }

    @Test
    public void resultThirdString(){
        String[] actual = DotValidator.result(0f, 0f, 0f, 0.4f);
        String[] expected = {String.valueOf(150), String.valueOf(150), String.valueOf(150), "Рикошет!"};
        for(int i = 0; i < expected.length; i++){
            assertEquals(expected[i], actual[i]);
        }
    }

    @Test
    public void resultForthString(){
        String[] actual = DotValidator.result(-1.1f, -2f, 2.5f, 0.5f);
        String[] expected = {String.valueOf(255), String.valueOf(0), String.valueOf(0), "Не попал!"};
        for(int i = 0; i< expected.length; i++ ){
            assertEquals(expected[i], actual[i]);
        }
    }
}