package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Home {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String greeting(@RequestParam(value="val1", required=false)  String val1,
                           @RequestParam(value = "val2", required = false) String val2,
                           @RequestParam(value = "mathType", required = false) String mathType,
                           Model model) {
        if (val1 != null && val2 != null && mathType != null) {
            switch (mathType) {
                case "plus" :
                    model.addAttribute("svar", Double.parseDouble(val1) + Double.parseDouble(val2));
                    break;
                case "minus" :
                    model.addAttribute("svar", Double.parseDouble(val1) - Double.parseDouble(val2));
                    break;
                case "multiply" :
                    model.addAttribute("svar", Double.parseDouble(val1) * Double.parseDouble(val2));
                    break;
		case "divide" :
                    model.addAttribute("svar", Double.parseDouble(val1) / Double.parseDouble(val2));
                    break;
                default:
                    break;

            }
        }
        return "index";
    }


}
