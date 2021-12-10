package br.com.felipe.request.converter;

import br.com.felipe.exception.UnsuportedMathOperationException;

public class NumberConverter {

	public static Double convertToDouble(String number) {
		if (!isNumeric(number)) {
			throw new UnsuportedMathOperationException("Por favor, defina um valor numérico!");
		}
		String cleanedNumber = number.replaceAll(",", ".");
		return Double.parseDouble(cleanedNumber);
	}

	public static boolean isNumeric(String number) {
		if (number == null) return false;
		String cleanedNumber = number.replaceAll(",", ".");
		return cleanedNumber.matches("[-+]?[0-9]*\\.?[0-9]+");
	}
}
