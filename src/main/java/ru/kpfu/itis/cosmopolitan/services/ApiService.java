package ru.kpfu.itis.cosmopolitan.services;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.cosmopolitan.dto.response.Response;
import ru.kpfu.itis.cosmopolitan.repositories.api.ApiRepository;

import java.io.IOException;

@Service
public class ApiService{

    @Autowired
    ApiRepository apiRepository;
    public int convertToRub(int price) {
        try {
            Gson gson = new Gson();
            Response response = gson.fromJson(apiRepository.convertToRub(), Response.class);
            return (int)Math.ceil(response.getRates().getRub() * price);
        }
        catch (IOException e) {
            return price * 70;
        }
    }
}
