package com.example.shorten_url.web;

import java.util.ArrayList;
import java.util.List;

import com.example.shorten_url.domain.model.entity.ShortenUrlData;
import com.example.shorten_url.service.ShortenUrlService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shortenURL")
public class ShortenUrlController {
    @Autowired
    ShortenUrlService shortenUrlService;

    @ResponseBody
    @RequestMapping(value="/create", method=RequestMethod.POST, consumes="application/json")
    public ShortenUrlData create(@RequestBody ShortenUrlData req) {
        System.out.println(req.getTargetUrl());

        String shortenUrl = shortenUrlService.CreateShortenUrl(req.getTargetUrl());
        ShortenUrlData data = new ShortenUrlData();
        data.setTargetUrl(req.getTargetUrl());
        data.setShortenUrl(shortenUrl);
        return data;
    }

    @RequestMapping(value="/list", method=RequestMethod.GET, produces="application/json")
    public List<ShortenUrlData> list() {    
        Iterable<ShortenUrlData> iter = shortenUrlService.findAllShortenUrl();
        List<ShortenUrlData> list = new ArrayList<ShortenUrlData>();
        for (ShortenUrlData data : iter) {
            list.add(data);
        }
        return list;
    }

    @RequestMapping(value="/{id}")
    public ResponseEntity<Void> find(@PathVariable String id) {
        System.out.println(id);
        String targetUrl = shortenUrlService.findTargetUrl(id);
        System.out.println(targetUrl);
        return ResponseEntity.status(HttpStatus.MOVED_PERMANENTLY).header(HttpHeaders.LOCATION, targetUrl).build();
    }
}