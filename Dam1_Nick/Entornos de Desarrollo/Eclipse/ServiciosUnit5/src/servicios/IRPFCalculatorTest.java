package servicios;

	import org.junit.jupiter.api.BeforeEach;
	import org.junit.jupiter.api.DisplayName;
	import org.junit.jupiter.api.Test;
	import org.junit.jupiter.params.ParameterizedTest;
	import org.junit.jupiter.params.provider.ValueSource;

	import static org.junit.jupiter.api.Assertions.*;

	class IRPFCalculatorTest {

	    private IRPFCalculator irpfCalculator;

	    @BeforeEach
	    void setUp() {
	        this.irpfCalculator = new IRPFCalculator();
	    }

	    @Test
	    @DisplayName("Prueba de cálculo estándar (15%)")
	    void testCalculateIRPFStandard() {
	        double result = irpfCalculator.calculateIRPF(1000.0);
	        assertEquals(150.0, result, "El IRPF de 1000 debería ser 150");
	    }

	    @Test
	    @DisplayName("Prueba con valor cero")
	    void testCalculateIRPFZero() {
	        double result = irpfCalculator.calculateIRPF(0.0);
	        assertEquals(0.0, result, "El IRPF de 0 debe ser 0");
	    }

	    @Test
	    @DisplayName("Prueba con valores decimales")
	    void testCalculateIRPFDecimal() {
	        double result = irpfCalculator.calculateIRPF(100.50);
	        assertEquals(15.075, result, 0.001);
	    }

	    @ParameterizedTest
	    @ValueSource(doubles = {100.0, 200.0, 500.0})
	    @DisplayName("Prueba parametrizada para múltiples montos")
	    void testCalculateIRPFParameterized(double amount) {
	        double expected = amount * 0.15;
	        assertEquals(expected, irpfCalculator.calculateIRPF(amount));
	    }

	    @Test
	    @DisplayName("Prueba con montos grandes")
	    void testCalculateIRPFHighAmount() {
	        double result = irpfCalculator.calculateIRPF(1000000.0);
	        assertTrue(result > 0);
	        assertEquals(150000.0, result);
	    }
	}
