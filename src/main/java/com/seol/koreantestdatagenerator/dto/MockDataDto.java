package com.seol.koreantestdatagenerator.dto;

import com.seol.koreantestdatagenerator.domain.MockData;
import com.seol.koreantestdatagenerator.domain.constant.MockDataType;

public record MockDataDto(
        Long id,
        MockDataType mockDataType,
        String mockDataValue
) {
    public static MockDataDto FromEntity(MockData entity) {

        return new MockDataDto(
                entity.getId(),
                entity.getMockDataType(),
                entity.getMockDataValue()
        );
    }
}
