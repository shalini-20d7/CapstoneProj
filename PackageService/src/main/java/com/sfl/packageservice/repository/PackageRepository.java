package com.sfl.packageservice.repository;
import com.sfl.packageservice.entity.Package;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface PackageRepository extends CrudRepository<Package, Long> {

}