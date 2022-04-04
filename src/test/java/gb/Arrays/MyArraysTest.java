package gb.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MyArraysTest {

    MyArrays ma;

    @BeforeEach
    void before(){
        ma = new MyArrays();
    }


    static Stream<Arguments> dataForMassTestArrays1(){
        return Stream.of(
          Arguments.arguments(new int[]{1, 7},new int[]{ 1, 2, 4, 4, 2, 3, 4, 1, 7}),
          Arguments.arguments(new int[]{},new int[]{ 1, 2, 4, 4, 2, 4 }),
          Arguments.arguments(new int[]{},new int[]{ 1, 2, 4, 4, 2, 4, 5}), //доп тест на провал
          Arguments.arguments(new int[]{1, 7, 5, 6, 1},new int[]{1, 2, 4, 4, 1, 7, 5, 6, 1})
        );
    }

    @ParameterizedTest
    @MethodSource("dataForMassTestArrays1")
    void task1_arrayResult(int[]result, int[]input) {
        Assertions.assertArrayEquals(result,ma.task1(input));
    }

    @Test
    void task1_exceptionResult() throws RuntimeException{
        Throwable thrown = assertThrows(RuntimeException.class, ()-> {
            ma.task1(new int[]{1, 2, 1, 7, 444, 44, 14}); });

    //    assertNotNull(thrown.getMessage());
    }

    static Stream<Arguments> dataForMassTestArrays2(){
        return Stream.of(
                Arguments.arguments(true,   new int[]{ 1, 1, 1, 4, 4, 1, 4, 4}),
                Arguments.arguments(false,  new int[]{ 1, 1, 1, 1, 1, 1}),
                Arguments.arguments(false,  new int[]{ 4, 4, 4, 4}),
                Arguments.arguments(false,  new int[]{1, 4, 4, 1, 1, 4, 3})
        );
    }


    @ParameterizedTest
    @MethodSource("dataForMassTestArrays2")
    void task2(boolean expected, int[] input) {
        Assertions.assertEquals(expected,ma.task2(input));
    }
}