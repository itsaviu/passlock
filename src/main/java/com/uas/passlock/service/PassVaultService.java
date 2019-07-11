package com.uas.passlock.service;

import com.uas.passlock.models.dto.PassVaultDto;
import com.uas.passlock.models.entity.PassVault;
import com.uas.passlock.models.entity.User;
import com.uas.passlock.repo.PassVaultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassVaultService {

    @Autowired
    private UserService userService;

    @Autowired
    private PassVaultRepository passVaultRepository;

    public PassVault addPassToVault(PassVaultDto passVaultDto) {
        User user = userService.getUserById(passVaultDto.getUserId());
        return passVaultRepository.save( new PassVault(passVaultDto.getUrl(), passVaultDto.getName(), passVaultDto.getIdentity(), passVaultDto.getPassword(), user));
    }

    public List<PassVault> getAllPassFromVault() {
        return passVaultRepository.findAll();
    }

}
