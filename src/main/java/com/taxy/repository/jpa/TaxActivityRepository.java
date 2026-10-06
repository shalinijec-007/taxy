package com.taxy.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taxy.entity.TaxActivity;

public interface TaxActivityRepository
        extends JpaRepository<TaxActivity, Long> {

}