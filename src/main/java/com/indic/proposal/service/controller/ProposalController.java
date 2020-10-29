package com.indic.proposal.service.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/api/greet")
public class ProposalController {

    @GetMapping
    public ResponseEntity<String> greet(){
        return ResponseEntity.ok("Hello There....");
    }
}
