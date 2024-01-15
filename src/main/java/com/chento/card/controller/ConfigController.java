package com.chento.card.controller;

import com.chento.card.config.CardServiceConfig;
import com.chento.card.property.Properties;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/config")
public class ConfigController {

    private final CardServiceConfig serviceConfig;

    @GetMapping("/properties")
    public ResponseEntity<?> getProperties()  {

        Properties properties = new Properties(
                serviceConfig.getMsg(),
                serviceConfig.getBuildVersion(),
                serviceConfig.getMailDetails(),
                serviceConfig.getActiveBranches()
        );

        return ResponseEntity.ok(properties);
    }

}
