/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lab.subject.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author muyins
 */
 
@FeignClient(value = "LAB-4-ADJECTIVE")
public interface Lab4Adjective {
    
    @RequestMapping(method=RequestMethod.GET,value = "/")
    String getAdjective();
}
