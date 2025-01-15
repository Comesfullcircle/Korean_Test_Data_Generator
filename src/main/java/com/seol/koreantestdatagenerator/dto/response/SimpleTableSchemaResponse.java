package com.seol.koreantestdatagenerator.dto.response;

import com.seol.koreantestdatagenerator.dto.TableSchemaDto;

public record SimpleTableSchemaResponse(
        String schemaName,
        String userId
) {

    public static SimpleTableSchemaResponse fromDto(TableSchemaDto dto){
        return new SimpleTableSchemaResponse(dto.schemaName(), dto.userId());
    }
}
