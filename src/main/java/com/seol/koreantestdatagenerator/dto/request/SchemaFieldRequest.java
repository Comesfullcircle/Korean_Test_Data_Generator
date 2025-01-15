package com.seol.koreantestdatagenerator.dto.request;

import com.seol.koreantestdatagenerator.domain.constant.MockDataType;
import com.seol.koreantestdatagenerator.dto.SchemaFieldDto;

public record SchemaFieldRequest(
        String fieldName,
        MockDataType mockDataType,
        Integer fieldOrder,
        Integer blankPercent,
        String typeOptionJson,
        String forceValue
) {
    public SchemaFieldDto toDto() {
        return SchemaFieldDto.of(
                fieldName(),
                mockDataType(),
                fieldOrder(),
                blankPercent(),
                typeOptionJson(),
                forceValue()
        );
    }
}
