package testpag.com.br.util;

public final class CalculoUtil {

	public static String calcularPorcentagem(final Double cheque_especial, final Double taxa) {

		double valor = cheque_especial; // valor original
		double percentual = taxa / 100.0; // %
		double valor_final = valor + (percentual * valor);
		String duasCasas = ConverterToString.converterDoubleString(valor_final);

		return duasCasas;
	}

}
