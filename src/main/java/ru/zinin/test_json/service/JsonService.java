package ru.zinin.test_json.service;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.fluent.Request;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class JsonService {

    public JSONObject getItem() {
        String url = "https://cloud-api.yandex.net:443/v1/disk/resources/?path=/&limit=100&sort=name";
        String name = "Authorization";
        String value = "OAuth AQAAAAAGLQtTAAVUVZEaClXVb0C8hLp8V2S1Uow";
        HttpResponse response = null;
        try {
            response = Request.Get(url).addHeader(name, value).execute().returnResponse();
        } catch (IOException e) {
            e.printStackTrace();
        }
        JSONObject jsonResponse = null;
        try {
            jsonResponse = new JSONObject(IOUtils.toString(response.getEntity().getContent()));
        } catch (IOException e) {
            e.printStackTrace();
        }



        return jsonResponse;
    }
}
