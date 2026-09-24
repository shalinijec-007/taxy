package com.taxy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taxy.entity.TaxActivity;

public interface TaxActivityRepository
        extends JpaRepository<TaxActivity, Long> {

}