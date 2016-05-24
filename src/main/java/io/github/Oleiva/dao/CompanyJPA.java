package io.github.Oleiva.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.Oleiva.entity.CompanysEntity;

/**
 * Created by Oleh Ivashko on 24.05.2016.
 */

public interface CompanyJPA extends JpaRepository<CompanysEntity, Long> {
}
