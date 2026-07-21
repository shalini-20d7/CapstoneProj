package com.sfl.packageservice.controller;

import com.sfl.packageservice.dto.PackageDTO;
import com.sfl.packageservice.entity.Package;
import com.sfl.packageservice.service.PackageService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/package")
public class PackageController {

    @Autowired
    private PackageService service;

    // Register Package
    @PostMapping("/register")
    public String registerPackage(@Valid @RequestBody PackageDTO dto) {

        log.info("Method execution started : registerPackage()");

        Package pack = new Package();
        pack.setPackageId(dto.getPackageId());
        pack.setSenderName(dto.getSenderName());
        pack.setReceiverName(dto.getReceiverName());
        pack.setPackageWeight(dto.getPackageWeight());
        pack.setSourceLocation(dto.getSourceLocation());
        pack.setDestinationLocation(dto.getDestinationLocation());
        pack.setPackageStatus(dto.getPackageStatus());

        String response = service.registerPackage(pack);

        log.info("Method execution exit : registerPackage()");

        return response;
    }

    // Get All Packages
    @GetMapping("/get")
    public Iterable<Package> getAllPackages() {

        log.info("Method execution started : getAllPackages()");

        Iterable<Package> packages = service.getAllPackages();

        log.info("Method execution exit : getAllPackages()");

        return packages;
    }

    // Get Package By Id
    @GetMapping("/get/{id}")
    public Package getPackageById(@PathVariable Long id) {

        log.info("Method execution started : getPackageById()");

        Package pack = service.getPackageById(id);

        log.info("Method execution exit : getPackageById()");

        return pack;
    }

    // Delete Package
    @DeleteMapping("/delete/{id}")
    public String deletePackage(@PathVariable Long id) {

        log.info("Method execution started : deletePackage()");

        String response = service.deletePackage(id);

        log.info("Method execution exit : deletePackage()");

        return response;
    }
}