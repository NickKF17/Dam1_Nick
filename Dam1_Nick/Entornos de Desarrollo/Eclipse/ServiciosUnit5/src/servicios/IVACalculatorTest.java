package servicios;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IVACalculatorTest {

    private IVACalculator ivaCalculator;

    @BeforeEach
    void setUp() {
        this.ivaCalculator = new IVACalculator();
    }

    @Test
    @DisplayName("Cálculo básico de IVA sobre 100")
    void testCalculateIVABasic() {
        double result = ivaCalculator.calculateIVA(100.0);
        assertEquals(21.0, result, "El IVA de 100 debe ser 21");
    }

    @Test
    @DisplayName("Verificar que el resultado no sea nulo o negativo con entrada positiva")
    void testCalculateIVAPositive() {
        double result = ivaCalculator.calculateIVA(50.0);
        assertAll(
            () -> assertTrue(result > 0),
            () -> assertEquals(10.5, result)
        );
    }

    @Test
    @DisplayName("Prueba de precisión con números pequeños")
    void testCalculateIVASmallAmount() {
        double result = ivaCalculator.calculateIVA(1.0);
        assertEquals(0.21, result);
    }

    @Test
    @DisplayName("Prueba de consistencia: el IVA siempre debe ser el 21%")
    void testCalculateIVAConsistency() {
        double amount = 500.0;
        double result = ivaCalculator.calculateIVA(amount);
        assertEquals(amount * 0.21, result);
    }

    @Test
    @DisplayName("Prueba con valores negativos (comportamiento actual)")
    void testCalculateIVANegative() {
        // Dado que el servicio no tiene validación de negativos, esperamos el cálculo matemático
        double result = ivaCalculator.calculateIVA(-100.0);
        assertEquals(-21.0, result, "Debe permitir números negativos según la lógica actual");
    }
}