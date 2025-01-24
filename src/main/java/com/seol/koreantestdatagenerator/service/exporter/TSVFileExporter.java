package com.seol.koreantestdatagenerator.service.exporter;

import com.seol.koreantestdatagenerator.domain.constant.ExportFileType;
import com.seol.koreantestdatagenerator.dto.SchemaFieldDto;
import com.seol.koreantestdatagenerator.dto.TableSchemaDto;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class TSVFileExporter extends DelimiterBasedFileExporter implements MockDataFileExporter {

    @Override
    public String getDelimiter() {
        return "\t";
    }

    @Override
    public ExportFileType getType() {
        return ExportFileType.TSV;
    }

}
