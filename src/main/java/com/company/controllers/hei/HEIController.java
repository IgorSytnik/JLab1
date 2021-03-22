package com.company.controllers.hei;

import com.company.services.hei.HEIService;

public class HEIController {

    private final HEIService heiService;

    public HEIController(HEIService heiService) {
//        Assert.notNull(heiService);
        this.heiService = heiService;
    }
}
