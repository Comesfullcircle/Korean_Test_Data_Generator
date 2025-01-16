package com.seol.koreantestdatagenerator.dto.request;

import com.seol.koreantestdatagenerator.dto.TableSchemaDto;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
@Data
public class TableSchemaRequest {

    private String schemaName;
    private String userId;
    private List<SchemaFieldRequest> schemaFields;

    public TableSchemaDto toDto() {
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
