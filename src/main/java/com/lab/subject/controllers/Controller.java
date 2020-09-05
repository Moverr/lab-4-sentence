/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lab.subject.controllers;

import com.lab.subject.feign.Lab4Adjective;
import com.lab.subject.feign.Lab4Article;
import com.lab.subject.feign.Lab4Noun;
import com.lab.subject.feign.Lab4Verb;
import com.lab.subject.feign.Lab4subject;
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

    @Autowired
    Lab4subject lab_subject;

    @Autowired
    Lab4Adjective lab_adjective;

    @Autowired
    Lab4Article lab_article;

    @Autowired
    Lab4Noun lab_noun;

    @Autowired
    Lab4Verb lab_verb;

    @GetMapping("/sentence")
    public @ResponseBody
    String getSentence() {

        String response = getWord("LAB-4-SUBJECT") + " "
                + getWord("LAB-4-VERB") + " "
                + getWord("LAB-4-ARTICLE") + " "
                + getWord("LAB-4-ADJECTIVE") + " "
                + getWord("LAB-4-NOUN") + ".";

        return response;
    }

    private String getWord(String service) {

        switch (service) {
            case "LAB-4-SUBJECT":
                return lab_subject.getVerb();
            case "LAB-4-VERB":
                return lab_verb.getVerb();
            case "LAB-4-ARTICLE":
                return lab_article.getVerb();
            case "LAB-4-ADJECTIVE":
                return lab_adjective.getVerb();
            case "LAB-4-NOUN":
                return lab_noun.getVerb();
            default:
                /* List<ServiceInstance> list = client.getInstances(service);
                 if (list != null && list.size() > 0) {
                 URI uri = list.get(0).getUri();
                 if (uri != null) {
                 String st = (new RestTemplate()).getForObject(uri, String.class);
                 return st;
                 }
                 }*/
                return null;
        }

    }

}
