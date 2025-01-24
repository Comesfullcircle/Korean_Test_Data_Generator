package com.seol.koreantestdatagenerator.service;

import com.seol.koreantestdatagenerator.domain.TableSchema;
import com.seol.koreantestdatagenerator.domain.constant.ExportFileType;
import com.seol.koreantestdatagenerator.dto.TableSchemaDto;
import com.seol.koreantestdatagenerator.repository.TableSchemaRepository;
import com.seol.koreantestdatagenerator.service.exporter.MockDataFileExporterContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SchemaExportService {

    private final MockDataFileExporterContext mockDataFileExporterContext;
    private final TableSchemaRepository tableSchemaRepository;

    public String export(ExportFileType fileType, TableSchemaDto dto, Integer rowCount) {
        if (dto.userId() != null) {
            tableSchemaRepository.findByUserIdAndSchemaName(dto.userId(), dto.schemaName())
                    .ifPresent(TableSchema::markExported);
        }

        return mockDataFileExporterContext.export(fileType, dto, rowCount);
    }

}
