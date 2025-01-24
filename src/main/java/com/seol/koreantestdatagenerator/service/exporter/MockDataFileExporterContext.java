package com.seol.koreantestdatagenerator.service.exporter;

import com.seol.koreantestdatagenerator.domain.constant.ExportFileType;
import com.seol.koreantestdatagenerator.dto.TableSchemaDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class MockDataFileExporterContext {

    public final Map<ExportFileType, MockDataFileExporter> mockDataFileExporterMap;

    public MockDataFileExporterContext(List<MockDataFileExporter> mockDataFileExporters) {
        this.mockDataFileExporterMap = mockDataFileExporters.stream()
                .collect(Collectors.toMap(MockDataFileExporter::getType, Function.identity()));
    }

    public String export(ExportFileType fileType, TableSchemaDto dto, Integer rowCount){
        MockDataFileExporter fileExporter = mockDataFileExporterMap.get(fileType);

        return fileExporter.export(dto, rowCount);
    }
}
