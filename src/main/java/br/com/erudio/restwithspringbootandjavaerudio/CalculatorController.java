package br.com.erudio.restwithspringbootandjavaerudio;

// import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.exceptions.UnsupportedMathOperationException;

@RestController
public class CalculatorController {
  // private final AtomicLong counter = new AtomicLong();

  @RequestMapping("/sum/{paramOne}/{paramTwo}")
  public Double sum(
    @PathVariable(value = "paramOne") String paramOne,
    @PathVariable(value = "paramTwo") String paramTwo
  ) throws UnsupportedMathOperationException{

    if(!isNumeric(paramOne)||!isNumeric(paramTwo)){
      throw new UnsupportedMathOperationException("teste");
    }
    return convertToDouble(paramOne) +convertToDouble(paramTwo) ;
  } 
  public static boolean isNumeric(String strNumber) {
        if (strNumber == null) return false; 
        String number = strNumber.replaceAll(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");

    }

  private Double convertToDouble(String strNumber){
    if(strNumber==null) return 0D;
    return Double.parseDouble(strNumber);
  }

}

