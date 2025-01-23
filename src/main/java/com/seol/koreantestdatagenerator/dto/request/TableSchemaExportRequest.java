package com.seol.koreantestdatagenerator.dto.request;

import com.seol.koreantestdatagenerator.domain.constant.ExportFileType;
import com.seol.koreantestdatagenerator.dto.TableSchemaDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

//TODO: 후에 record 방식으로 쓸 수 있는지 검토하기
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
@Data
public class TableSchemaExportRequest {

    private String schemaName;
    private Integer rowCount;
    private ExportFileType fileType;
    private List<SchemaFieldRequest> schemaFields;

    public TableSchemaDto toDto(String userId) {
        return TableSchemaDto.of(
                schemaName,
                userId,
                null,
                schemaFields.stream()
                        .map(SchemaFieldRequest::toDto)
                        .collect(Collectors.toUnmodifiableSet())
        );
    }

}
