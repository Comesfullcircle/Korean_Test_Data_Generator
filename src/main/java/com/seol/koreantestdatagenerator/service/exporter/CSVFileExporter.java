package com.seol.koreantestdatagenerator.service.exporter;

import com.seol.koreantestdatagenerator.domain.constant.ExportFileType;
import org.springframework.stereotype.Component;

@Component
public class CSVFileExporter extends DelimiterBasedFileExporter implements MockDataFileExporter {

    @Override
    public String getDelimiter() {
        return ",";
    }

    @Override
    public ExportFileType getType() {
        return ExportFileType.CSV;
    }
}
