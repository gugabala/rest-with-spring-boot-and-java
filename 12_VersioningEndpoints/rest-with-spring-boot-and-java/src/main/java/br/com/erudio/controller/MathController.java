package br.com.erudio.controller;

import br.com.erudio.converters.NumberConverter;
import br.com.erudio.exceptions.ResourceNotFoundException;
import br.com.erudio.math.SimpleMath;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class MathController {

	private static final String template = "Hello , %s!";
	private final AtomicLong counter = new AtomicLong();

	private SimpleMath math = new SimpleMath();


	@RequestMapping(value="/sum/{numerOne}/{numerTwo}"
			,method= RequestMethod.GET)
	public Double sum(@PathVariable(value = "numerOne") String numberOne,
					  @PathVariable(value = "numerTwo") String numberTwo) throws Exception {

		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)){
			 throw new ResourceNotFoundException("Please set a numeric value !");
		}

		return math.sum( NumberConverter.convertToDouble(numberOne) , NumberConverter.convertToDouble(numberTwo));
	}


	@RequestMapping(value="/subtraction/{numerOne}/{numerTwo}"
			,method= RequestMethod.GET)
	public Double subtraction(@PathVariable(value = "numerOne") String numberOne,
					  @PathVariable(value = "numerTwo") String numberTwo) throws Exception {

		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)){
			throw new ResourceNotFoundException("Please set a numeric value !");
		}

		return math.subtraction( NumberConverter.convertToDouble(numberOne) , NumberConverter.convertToDouble(numberTwo));
	}

	@RequestMapping(value="/multipliction/{numerOne}/{numerTwo}"
			,method= RequestMethod.GET)
	public Double multipliction(@PathVariable(value = "numerOne") String numberOne,
							  @PathVariable(value = "numerTwo") String numberTwo) throws Exception {

		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)){
			throw new ResourceNotFoundException("Please set a numeric value !");
		}

		return math.multipliction( NumberConverter.convertToDouble(numberOne) ,NumberConverter.convertToDouble(numberTwo));
	}

	@RequestMapping(value="/division/{numerOne}/{numerTwo}"
			,method= RequestMethod.GET)
	public Double division(@PathVariable(value = "numerOne") String numberOne,
								@PathVariable(value = "numerTwo") String numberTwo) throws Exception {

		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)){
			throw new ResourceNotFoundException("Please set a numeric value !");
		}

		return math.division( NumberConverter.convertToDouble(numberOne) , NumberConverter.convertToDouble(numberTwo));
	}

	@RequestMapping(value="/mean/{numerOne}/{numerTwo}"
			,method= RequestMethod.GET)
	public Double mean(@PathVariable(value = "numerOne") String numberOne,
						   @PathVariable(value = "numerTwo") String numberTwo) throws Exception {

		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)){
			throw new ResourceNotFoundException("Please set a numeric value !");
		}

		return math.mean (NumberConverter.convertToDouble(numberOne)   , NumberConverter.convertToDouble(numberTwo) );
	}

	@RequestMapping(value="/squareRoot/{numer}"
			,method= RequestMethod.GET)
	public Double squareRoot(@PathVariable(value = "numer") String numberOne ) throws Exception {

		if(!NumberConverter.isNumeric(numberOne) ){
			throw new ResourceNotFoundException("Please set a numeric value !");
		}

		return  math.squareRoot(NumberConverter.convertToDouble(numberOne))  ;
	}


}
