package com.example.resizeimage2.controller;

import com.example.resizeimage2.dto.Form;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@org.springframework.stereotype.Controller
public class Controller {

    @GetMapping("/new")
    public String newForm() {
        return "new";
    }

    @PostMapping("/modify")
    public String Form(Form form) {
        System.out.println(form.toString());
        return "";
    }


    public String getUrl(String url) throws Exception {

        String re = "(ftp|http|https):\\/\\/(\\w+:{0,1}\\w*@)?(\\S+)(:[0-9]+)?(\\/|\\/([\\w#!:.?+=&%@!\\-\\/]))?[^)]";
        Pattern p = Pattern.compile(re);
        Matcher m = p.matcher(url);
        if (!m.find()) {
            throw new Exception();
        }
        return m.group();
    }

    public String applySize(String url, int size) {
        String strSize = Integer.toString(size);
        return "<img src=" + url +
                " width=\"" + strSize +
                "%\" height=\"" + strSize +
                "%\"/><br>";
    }
}
