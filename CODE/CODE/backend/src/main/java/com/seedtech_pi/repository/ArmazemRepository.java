package com.seedtech_pi.repository;

import com.seedtech_pi.model.Armazem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArmazemRepository extends JpaRepository<Armazem, Integer> {}
