package lotto.domain.numbers

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Test

class CustomNumbersGeneratorTest {
    @Test
    fun `사용자가 입력한 6개의 숫자를 반환한다`() {
        val customLottoNumbers = listOf(1, 2, 3, 4, 5, 6)
        val generator = CustomNumbersGenerator(customLottoNumbers)

        assertThat(generator.generate())
            .hasSize(6)
            .isEqualTo(customLottoNumbers)
    }

    @Test
    fun `총 6개의 숫자가 주어지지 않을 경우 IllegalArgumentException 을 반환한다`() {
        val moreThanSix = listOf(1, 2, 3, 4, 5, 6, 7)
        val generator = CustomNumbersGenerator(moreThanSix)

        assertThatIllegalArgumentException().isThrownBy { generator.generate() }
    }

    @Test
    fun `1 과 45 사이의 숫자가 아닐 경우 IllegalArgumentException 을 반환한다`() {
        val listWithInvalidLottoNumber = listOf(-1, 2, 3, 4, 5, 6)
        val generator = CustomNumbersGenerator(listWithInvalidLottoNumber)

        assertThatIllegalArgumentException().isThrownBy { generator.generate() }
    }
}