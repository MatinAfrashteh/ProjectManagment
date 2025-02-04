package com.example.ProjectManagment.Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorController implements org.springframework.boot.web.servlet.error.ErrorController {
    @GetMapping("/error")
    public String hadnleError(HttpServletRequest request){
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        if (status != null) {
            Integer statusCode = Integer.valueOf(status.toString());

            if (statusCode == HttpStatus.NOT_FOUND.value()){
                return "errorpages/404";
            }
            if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()){
                return "errorpages/500";
            }
            if (statusCode == HttpStatus.FORBIDDEN.value()){
            return "errorpages/403";
            }

        }
        return "errorpages/error";
    }
//    @Override
//    public String getErrorPath() {
//        return "/error";
//    }
}
