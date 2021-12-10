package br.com.felipe.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.felipe.exception.UnsuportedMathOperationException;
import br.com.felipe.request.converter.NumberConverter;

@RestController
public class MathController {

	private static final String template = "Hello, %s!";
	
	private final AtomicLong counter = new AtomicLong();
	
	@RequestMapping(value="/sum/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		Double sum = NumberConverter.convertToDouble(numberOne) + NumberConverter.convertToDouble(numberTwo);
		return sum;
	}
	
	@RequestMapping(value="/sub/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double sub(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) {
		Double n1 = NumberConverter.convertToDouble(numberOne);
		Double n2 = NumberConverter.convertToDouble(numberTwo);

		return n1-n2;
	}
	
	@RequestMapping(value="/mul/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double mul(@PathVariable("numberOne") String numberOne,@PathVariable("numberTwo") String numberTwo) {
		Double n1 = NumberConverter.convertToDouble(numberOne);
		Double n2 = NumberConverter.convertToDouble(numberTwo);
		
		return n1 * n2;
	}
	
	@RequestMapping(value="/div/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double div(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) {
		Double n1 = NumberConverter.convertToDouble(numberOne);
		Double n2 = NumberConverter.convertToDouble(numberTwo);
		
		if (n2 == 0) throw new UnsuportedMathOperationException("Não é possível dividir qualquer número por zero!");
		
		return n1 / n2;
	}
	
	@RequestMapping(value="/med/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double med(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) {
		Double n1 = NumberConverter.convertToDouble(numberOne);
		Double n2 = NumberConverter.convertToDouble(numberTwo);
		
		return (n1 + n2) / 2;
	}
	
	@RequestMapping(value="/sqrt/{number}", method = RequestMethod.GET)
	public Double sqrt(@PathVariable("number") String number) {
		return Math.sqrt(NumberConverter.convertToDouble(number));
	}



}
