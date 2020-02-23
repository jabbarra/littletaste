package com.obarra.proventesting.java8;

import static  org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {

    @Test
    public void sortedAndReduceWhenStreamWasClosed(){
        Stream<String> strings = Stream.of("a", "c", "b", "e");
        strings.sorted();
        assertThrows(IllegalStateException.class, () -> strings.reduce("", String::concat));
    }

    @Test
    public void sortedAndReduce(){
        String strings = Stream.of("a", "c", "b", "e")
                .sorted()
                .reduce("", String::concat);

        assertEquals("abce", strings);
    }

    @Test
    public void sortedAndForEach(){
        StringBuilder stringBuilder = new StringBuilder();
        Stream.of("a", "c", "b", "e")
                .sorted()
                .forEach(stringBuilder::append);

        assertEquals("abce", stringBuilder.toString());
    }

    /**
     * Se ejecuto de forma secuencial porque el origen del Stream es List el cual es por definicion ordenada
     * El collecto deberia tener como minimo la caracteristica UNORDENRED
     * Al no tener esta caractica indica que el resultado del joinig depende del orden de los elementos
     * por lo tanto no se puede ejecutar de forma paralela
     */
    @Test
    public void parallelStream(){
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        String joined = list.parallelStream()
                .map(String::valueOf)
                .collect(Collectors.joining(","));

        assertEquals("1,2,3,4,5,6,7,8,9", joined);
    }
}