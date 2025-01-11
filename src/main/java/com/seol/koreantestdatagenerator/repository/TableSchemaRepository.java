package com.seol.koreantestdatagenerator.repository;

import com.seol.koreantestdatagenerator.domain.TableSchema;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TableSchemaRepository extends JpaRepository<TableSchema, Long> {
}
