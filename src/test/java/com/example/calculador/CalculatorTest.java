package com.example.calculador;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;

public class CalculatorTest {
    private Calculator calculador = new Calculator();
    @Test
    public void testSum() {
        assertEquals(5, calculador.sum(2, 3));
    }
}