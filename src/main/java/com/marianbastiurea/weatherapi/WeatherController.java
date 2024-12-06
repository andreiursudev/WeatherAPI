package com.marianbastiurea.weatherapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/weather")
public class WeatherController {
    private final WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping
    public List<Weather> getWeatherForDateRange(
            @RequestParam String startDate,
            @RequestParam String endDate) {
        return weatherService.getWeatherByDateRange(
                LocalDate.parse(startDate), LocalDate.parse(endDate));
    }

    @GetMapping("/{date}")
    public Weather getWeatherForDate(@PathVariable String date) {
        LocalDate localDate = LocalDate.parse(date);
        return weatherService.getWeatherByDate(localDate);
    }
}
