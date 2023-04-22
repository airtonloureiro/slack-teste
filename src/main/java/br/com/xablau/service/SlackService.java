package br.com.xablau.service;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;

public class SlackService {
    private String token = "xxxxxxxx-xxxxxxxx";
    private String channel = "xxxx";

    public void sendMessage(String message) {

        String json = ""
        + "{"
            + "\"channel\": \"" + channel +"\","
            + "\"text\": \"" + message +"\""
        + "}";


        OkHttpClient client = new OkHttpClient();
        MediaType mediaType = MediaType.parse("application/json; charset=utf-8");

        RequestBody body = RequestBody.create(mediaType, json);
        Request request = new Request.Builder()
        .url("https://slack.com/api/chat.postMessage")
        .addHeader("Authorization" , "Bearer " + token)
        .post(body)
        .build();

        try {
            client.newCall(request).execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
