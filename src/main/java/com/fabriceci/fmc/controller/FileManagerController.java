package com.fabriceci.fmc.controller;

import com.fabriceci.fmc.error.FileManagerException;
import com.fabriceci.fmc.impl.LocalFileManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
public class FileManagerController {

    @GetMapping(value = "/")
    public String home() {
        return "index";
    }

    @RequestMapping(value = "/api")
    public void fm(ModelMap model, HttpServletRequest request, HttpServletResponse response) throws FileManagerException {
        Map<String, String> options = new HashMap<>();

        new LocalFileManager(options).handleRequest(request, response);
    }
}