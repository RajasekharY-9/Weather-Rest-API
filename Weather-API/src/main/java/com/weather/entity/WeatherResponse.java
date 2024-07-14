package com.weather.entity;

import lombok.Data;

import java.util.List;

@Data
public class WeatherResponse {
   private List<Weather> weather;
   private Main main;


   public static class Weather {
       private String description;
         public String getDescription() {
              return description;
         }
         public void setDescription(String description) {
              this.description = description;
         }
    }

    public static class Main {
       private double temp;
            public double getTemp() {
                return temp;
            }
            public void setTemp(double temp) {
                this.temp = temp;
            }
        }
}
