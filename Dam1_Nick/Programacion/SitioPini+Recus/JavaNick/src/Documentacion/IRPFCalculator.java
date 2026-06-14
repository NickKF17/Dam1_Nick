package Documentacion;

/**
 * Calculadora del Impuesto sobre la Renta de las Personas Físicas (IRPF).
 * <p>
 * Esta clase proporciona métodos para calcular la retención de IRPF
 * aplicable a diferentes tipos de rendimientos económicos.
 * El tipo impositivo base aplicado es del 15%.
 * </p>
 *
 * @author Nick Constante
 * @version 1.0
 * @since 2026-05-05
 */
public class IRPFCalculator {

    /** Tipo impositivo por defecto aplicado al cálculo del IRPF. */
    private static final double DEFAULT_TAX_RATE = 0.15;

    /** Tipo impositivo personalizado para este calculador. */
    private double taxRate;

    /**
     * Constructor por defecto.
     * <p>
     * Inicializa la calculadora con el tipo impositivo estándar del 15%,
     * tal como establece la normativa general del IRPF para rendimientos del trabajo.
     * </p>
     */
    public IRPFCalculator() {
        this.taxRate = DEFAULT_TAX_RATE;
    }

    /**
     * Constructor con tipo impositivo personalizado.
     *
     * @param taxRate tipo impositivo a aplicar (valor entre 0.0 y 1.0)
     */
    public IRPFCalculator(double taxRate) {
        this.taxRate = taxRate;
    }

    /**
     * Calcula la retención de IRPF aplicando el tipo impositivo fijo del 15%.
     * <p>
     * Este método utiliza siempre un tipo fijo del 15%, independientemente
     * del tipo configurado en la instancia. Para usar el tipo configurado,
     * utiliza {@link #calculateIRPFWithRate(double)} en su lugar.
     * </p>
     *
     * @param amount importe bruto sobre el que calcular la retención, en euros
     * @return importe de la retención de IRPF correspondiente
     * @deprecated Usar {@link #calculateIRPFWithRate(double)} que respeta el tipo
     *             impositivo configurado en la instancia.
     */
    @Deprecated
    public double calculateIRPF(double amount) {
        return amount * 0.15;
    }

    /**
     * Calcula la retención de IRPF aplicando el tipo impositivo configurado en la instancia.
     * <p>
     * A diferencia de {@link #calculateIRPF(double)}, este método utiliza el tipo
     * impositivo establecido al crear la calculadora, lo que permite mayor flexibilidad.
     * </p>
     *
     * @param amount importe bruto sobre el que calcular la retención, en euros
     * @return importe de la retención de IRPF según el tipo configurado
     */
    public double calculateIRPFWithRate(double amount) {
        return amount * this.taxRate;
    }
}