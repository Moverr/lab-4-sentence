/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lab.subject.controllers;

import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;

import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author muyin
 */
@RestController
public class Controller {

    @Autowired
    DiscoveryClient client;

    @GetMapping("/sentence")
    public @ResponseBody   String getSentence() {
        
        String response =  getWord("LAB-4-SUBJECT") + " "
                + getWord("LAB-4-VERB") + " "
                + getWord("LAB-4-ARTICLE") + " "
                + getWord("LAB-4-ADJECTIVE") + " "
                + getWord("LAB-4-NOUN") + ".";
        
        return response;
    }

    private String getWord(String service) {
        List<ServiceInstance> list = client.getInstances(service);
        if (list != null && list.size() > 0) {
            URI uri = list.get(0).getUri();
            if (uri != null) {
                String st =  (new RestTemplate()).getForObject(uri, String.class);
                
                return st;
            }
        }
        return null;
    }

}
