package com.seol.koreantestdatagenerator.repository;

import com.seol.koreantestdatagenerator.domain.MockData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MockDataRepository extends JpaRepository<MockData, Long> {
}
