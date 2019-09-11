package example.controller;

import example.exception.ParameterInvalidException;
import example.exception.ProductApiErrorException;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class WebExceptionHandler {

    private Logger log = Logger.getLogger(WebExceptionHandler.class);

    @ExceptionHandler(ParameterInvalidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleParameterInvalidException(
            ParameterInvalidException ex, Model model) {

        log.error("Invalid Input parameter", ex);

        model.addAttribute("message", "Invalid Input parameter");
        return "error";
    }

    @ExceptionHandler(ProductApiErrorException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleProductApiErrorException(
            ProductApiErrorException ex, Model model) {

        log.error("Product Api return Error", ex);

        model.addAttribute("message", "Product Api return Error");
        return "error";
    }


    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleUnknownException(
            Exception ex, Model model) {

        log.error("INTERNAL SERVER ERROR", ex);

        model.addAttribute("message", "INTERNAL SERVER ERROR");
        return "error";
    }


}