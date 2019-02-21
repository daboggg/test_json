package ru.zinin.test_json.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import jdk.nashorn.internal.parser.JSONParser;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ru.zinin.test_json.service.JsonService;

import java.util.HashMap;
import java.util.Map;

@RestController
public class MainController {

    @Autowired
    JsonService jsonService;

    @GetMapping(path = "/item")
//    @ResponseBody
    public Map<String, Object> start() {

        JSONObject object = jsonService.getItem();

        return object.toMap();
    }
}
