package br.com.erudio.controllers;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.exceptions.UnsupportedMathOperationException;
import br.com.erudio.manipulations.NumberConverter;
import br.com.erudio.operations.SimpleMath;

@RestController
public class MathController {

	private static final String template = "Hello, %s!";
	
	private final AtomicLong counter = new AtomicLong();
	
	SimpleMath math = new SimpleMath();
	
	NumberConverter numberConverter = new NumberConverter();
	
	@RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double sum(
			@PathVariable(value = "numberOne") String numberOne, 
			@PathVariable(value = "numberTwo") String numberTwo
			) throws Exception {
		
		if(!numberConverter.isNumeric(numberOne) || !numberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		return math.sum(numberConverter.convertToDouble(numberOne), numberConverter.convertToDouble(numberTwo));
	}
	
	@RequestMapping(value = "/sub/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double sub(
			@PathVariable(value = "numberOne") String numberOne, 
			@PathVariable(value = "numberTwo") String numberTwo
			) throws Exception {
		
		if(!numberConverter.isNumeric(numberOne) || !numberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		return math.subtraction(numberConverter.convertToDouble(numberOne), numberConverter.convertToDouble(numberTwo));
	}
	
	@RequestMapping(value = "/mult/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double mult(
			@PathVariable(value = "numberOne") String numberOne, 
			@PathVariable(value = "numberTwo") String numberTwo
			) throws Exception {
		
		if(!numberConverter.isNumeric(numberOne) || !numberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		return math.multiplication(numberConverter.convertToDouble(numberOne),numberConverter.convertToDouble(numberTwo));
	}
	
	@RequestMapping(value = "/div/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double div(
			@PathVariable(value = "numberOne") String numberOne, 
			@PathVariable(value = "numberTwo") String numberTwo
			) throws Exception {
		
		if(!numberConverter.isNumeric(numberOne) || !numberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		return math.division(numberConverter.convertToDouble(numberOne), numberConverter.convertToDouble(numberTwo));
	}
	
	@RequestMapping(value = "/mean/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double mean(
			@PathVariable(value = "numberOne") String numberOne, 
			@PathVariable(value = "numberTwo") String numberTwo
			) throws Exception {
		
		if(!numberConverter.isNumeric(numberOne) || !numberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		return math.mean(numberConverter.convertToDouble(numberOne), numberConverter.convertToDouble(numberTwo));
	}
	
	@RequestMapping(value = "/squareRoot/{number}", method=RequestMethod.GET)
	public Double squareRoot(
			@PathVariable(value = "number") String number 
			) throws Exception {
		
		if(!numberConverter.isNumeric(number)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		return math.squareRoot(numberConverter.convertToDouble(number));
	}
}

