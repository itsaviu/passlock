package com.uas.passlock.controller;

import com.uas.passlock.models.dto.PassVaultDto;
import com.uas.passlock.service.PassVaultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class PassVaultController extends BaseController {


    @Autowired
    private PassVaultService passVaultService;

    @PostMapping("/vault/pass")
    public ResponseEntity addPassToVault(@Valid @RequestBody PassVaultDto passVaultDto) {
        return ResponseEntity.ok(passVaultService.addPassToVault(passVaultDto));
    }

    @GetMapping("/vault/pass")
    public ResponseEntity getPassFromVault() {
        return ResponseEntity.ok(passVaultService.getAllPassFromVault());
    }
}
