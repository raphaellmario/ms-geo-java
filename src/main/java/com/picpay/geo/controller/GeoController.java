package com.picpay.geo.controller;

import com.picpay.geo.service.GeoService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/geo")
public class GeoController {

    @RequestMapping(value="/all", method= RequestMethod.GET)
    @ResponseBody
    public String getAllTerminal(@RequestParam(value = "latitude") String lat, @RequestParam(value = "longitude") String lon) {
        GeoService geoService = new GeoService();
        return geoService.getAll(lat, lon);
    }

    @RequestMapping(value="/find/{id}", method= RequestMethod.GET)
    @ResponseBody
    public String findTerminalById(@PathVariable(value = "id") int id) {
        GeoService geoService = new GeoService();
        return geoService.find(id);
    }

}
