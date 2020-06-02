/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lab.subject.controllers;

import java.net.URI;
import java.util.List;
import static org.bouncycastle.crypto.tls.ConnectionEnd.client;
 
import org.springframework.cloud.client.ServiceInstance;
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
 
    @GetMapping("/sentence")
    public @ResponseBody String getSentence() {
    return 
      getWord("LAB-4-SUBJECT") + " "
      + getWord("LAB-4-VERB") + " "
      + getWord("LAB-4-ARTICLE") + " "
      + getWord("LAB-4-ADJECTIVE") + " "
      + getWord("LAB-4-NOUN") + "."
      ;
  }

    private String getWord(String service) {
        
        return null;
    }
  
    
}
