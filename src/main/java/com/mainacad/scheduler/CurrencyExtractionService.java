package com.mainacad.scheduler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.*;

@Slf4j
@Component
public class CurrencyExtractionService {

    private List<String> list = Collections.synchronizedList(new ArrayList<>());

    @Scheduled(initialDelay = 1000, fixedDelay = 5000)
    public void getUkrNetResponse() {
         list.add("https://www.ukr.net/ - " + Instant.now());
    }

    @Scheduled(initialDelay = 1000, fixedDelay = 2000)
    public void writeData() {
        if (list.isEmpty()) {
            return;
        }
        list.forEach(text -> log.info(text));

        list.clear();
    }

}
