package com.sfl.packageservice.service;

import com.sfl.packageservice.entity.Package;
import com.sfl.packageservice.exception.PackageNotFoundException;
import com.sfl.packageservice.repository.PackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PackageService {

    @Autowired
    private PackageRepository repository;

    // Register Package
    public String registerPackage(Package pack) {

        // Validation 1 - Unique Package ID
        if (repository.existsById(pack.getPackageId())) {
            throw new PackageNotFoundException("Package ID Already Exists");
        }

        // Validation 2 - Package Weight
        if (pack.getPackageWeight() <= 0) {
            throw new PackageNotFoundException("Package Weight must be greater than 0");
        }

        repository.save(pack);

        return "Package Registered Successfully";
    }

    // Get All Packages
    public Iterable<Package> getAllPackages() {
        return repository.findAll();
    }

    // Get Package By Id
    public Package getPackageById(Long id) {

        if (repository.existsById(id)) {
            return repository.findById(id).get();
        }

        throw new PackageNotFoundException("Package Not Found");
    }

    // Delete Package
    public String deletePackage(Long id) {

        if (repository.existsById(id)) {

            repository.deleteById(id);

            return "Package Deleted Successfully";
        }

        throw new PackageNotFoundException("Package Not Found");
    }
}