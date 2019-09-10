package example.controller;

import org.apache.log4j.Logger;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErrorPageController implements ErrorController {

    private Logger log = Logger.getLogger(ErrorPageController.class);

    @RequestMapping("/404")
    public String handlerErrorNotFoundUrl(Model model) {

        log.error("Invalid Url");

        model.addAttribute("message", "NOT FOUNT");
        return "error";
    }

    @RequestMapping("/500")
    public String handlerErrorSystem(Model model) {

        log.error("Internal error");

        model.addAttribute("message", "SYSTEM ERROR");
        return "error";
    }

    @Override
    public String getErrorPath() {
        return null;
    }
}
