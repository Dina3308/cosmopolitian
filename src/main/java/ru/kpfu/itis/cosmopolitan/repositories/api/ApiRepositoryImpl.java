package ru.kpfu.itis.cosmopolitan.repositories.api;

import com.google.gson.JsonObject;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.Objects;

@Repository
public class ApiRepositoryImpl implements ApiRepository{

    private static final String BASE_URL = "https://openexchangerates.org/api/";
    private static final String API_KEY = "47bdb7b93c404bcb83a3274e0573176f";

    @Autowired
    OkHttpClient okHttpClient;

    @Override
    public String convertToRub() throws IOException{
        Request request = new Request
                .Builder()
                .url(BASE_URL + "latest.json?app_id=" + API_KEY + "&symbols=RUB")
                .build();
        return okHttpClient.newCall(request).execute().body().string();
    }
}
