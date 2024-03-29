import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringTest {

    @Test
    @DisplayName("split() 메소드 이용시 지정한 delimiter 기준 잘 분리되는지 테스트")
    void stringSplit_separate_success() {
        // given
        String multiNumber = "1,2";
        String singleNumber = "1";

        // when
        String[] splitMultiNumber = multiNumber.split(",");
        String[] splitSingleNumber = singleNumber.split(",");

        // then
        assertAll(() -> {
            assertThat(splitMultiNumber).contains("1");
            assertThat(splitMultiNumber).contains("2");
            assertThat(splitMultiNumber).containsExactly("1", "2");
            assertThat(splitSingleNumber).contains("1");
            assertThat(splitSingleNumber).containsExactly("1");
        });
    }

    @Test
    @DisplayName("(1,2)의 값이 주어졌을때 String의 substring() 메소드를 활용해 ()을 제거한 값을 반환하는 테스트")
    void substring_괄호제거하고_올바른_문자열값_반환_성공() {
        // given
        String bracketNumber = "(1,2)";

        // when
        String numberWithoutBracket = bracketNumber.substring(1, 4);

        // then
        assertThat(numberWithoutBracket).isEqualTo("1,2");
    }

    @Test
    @DisplayName("String.charAt() 메소드를 활용해 특정 위치의 문자열을 가져오고, 위치값을 벗어나면 예외 발생하는 테스트")
    void charAt_지정된_위치_문자열_가져오고_범위를_벗어나면_예외_발생() {
        // given
        String alphabet = "abc";

        // when
        // then
        assertAll(() -> {
            assertThat(alphabet.charAt(0)).isEqualTo('a');
            assertThat(alphabet.charAt(1)).isEqualTo('b');
            assertThat(alphabet.charAt(2)).isEqualTo('c');
            assertThatThrownBy(() -> alphabet.charAt(3))
                    .isInstanceOf(StringIndexOutOfBoundsException.class);
        });
    }
}
