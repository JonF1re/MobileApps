package com.example.lab3;

import java.util.List;

public class PixabayResponse {
    public List<Hit> hits;

    public class Hit {
        public String webformatURL;
    }
}