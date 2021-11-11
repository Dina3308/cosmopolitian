package ru.kpfu.itis.cosmopolitan.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Response {
    private String disclaimer;
    private String license;
    private Long timestamp;
    private String base;
    private Rates rates;
}


