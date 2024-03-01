package br.com.regexconvert.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;

@RestController
public class ConversorController {

	
	@Operation(summary = "Converter um número de série para um padrão regex", tags = "Conversor")
	@GetMapping("/conversor/{numSerie}")
	public ResponseEntity<String> convert(@PathVariable String numSerie) {
		StringBuilder pattern = new StringBuilder();
		
		String numeroSerie = numSerie.replaceAll("\\s", "");
		
		 for(int x = 0; x < numeroSerie.length(); x++){
	            char caractereAtualNumSerie = numeroSerie.charAt(x);
	            //System.out.print(caractereAtualNumSerie);
	            if(Character.isDigit(caractereAtualNumSerie)){
	                pattern.append("[0-9]");
	                //System.out.println(" digit");
	            }else if(Character.isLetter(caractereAtualNumSerie)){
	                pattern.append("[A-Z]");
	               // System.out.println(" letter");
	            }else {
	            	pattern.append("?");
	            }
	        }
		
		return ResponseEntity.ok(pattern.toString());
	}
	
}
