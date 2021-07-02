package testpag.com.br.util;

import java.text.DecimalFormat;

public class ConverterToString {

	public static String chequeEspecialLiberado(Integer cheque_especial_liberado) {

		String cheque_especial_liberado_string = null;

		if (cheque_especial_liberado.equals(1)) {

			cheque_especial_liberado_string = "Liberado";

		} else {
			cheque_especial_liberado_string = "Não liberado";
		}

		return cheque_especial_liberado_string;
	}

	public static String converterDoubleString(double precoDouble) {
		DecimalFormat fmt = new DecimalFormat("0.00");
		String string = fmt.format(precoDouble);
		String[] part = string.split("[,]");
		String valor = part[0] + "." + part[1];
		return valor;
	}

}
