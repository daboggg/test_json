package ru.zinin.test_json;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.fluent.Request;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        String url = "https://cloud-api.yandex.net:443/v1/disk/resources/?path=/&limit=100&sort=name";
        String name = "Authorization";
        String value = "OAuth AQAAAAAGLQtTAAVUVZEaClXVb0C8hLp8V2S1Uow";
        HttpResponse response = Request.Get(url).addHeader(name, value).execute().returnResponse();
//        System.out.println(response);
        JSONObject jsonResponse = new JSONObject(IOUtils.toString(response.getEntity().getContent()));
//        System.out.println(jsonResponse.getString("name"));
//        System.out.println(jsonResponse.getString("modified"));
//        System.out.println(jsonResponse.getString("created"));
//        JSONObject embedded = jsonResponse.getJSONObject("_embedded");
//        JSONArray items = embedded.getJSONArray("items");

//        System.out.println(items.getJSONObject(50).getString("mime_type"));

        System.out.println(jsonResponse);
    }
}
