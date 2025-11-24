package com.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SimpleWebTest {

    
    @Test
    @DisplayName("Проверка корректности работы methodEx")
    void simpleTest(){
        String actual = methodEx();
        Assertions.assertEquals(1,actual, "Сообщение об ошибке");
    }

    String methodEx(){
        return "1";
    }
}
