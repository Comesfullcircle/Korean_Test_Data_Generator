package com.seol.koreantestdatagenerator.dto;

import com.seol.koreantestdatagenerator.domain.SchemaField;
import com.seol.koreantestdatagenerator.domain.constant.MockDataType;

import java.time.LocalDateTime;

/**
 * DTO for {@link com.seol.koreantestdatagenerator.domain.SchemaField}
 */
public record SchemaFieldDto(
        Long id,
        String fieldName,
        MockDataType mockDataType,
        Integer fieldOrder,
        Integer blankPercent,
        String typeOptionJson,
        String forceValue,

        LocalDateTime createdAt,
        String createdBy,
        LocalDateTime modifiedAt,
        String modifiedBy
) {

    public static SchemaFieldDto of (Long id, String fieldName, MockDataType mockDataType, Integer fieldOrder, Integer blankPercent, String typeOptionJson, String forceValue, LocalDateTime createdAt, String createdBy, LocalDateTime modifiedAt, String modifiedBy) {
       return new SchemaFieldDto(id, fieldName, mockDataType, fieldOrder, blankPercent, typeOptionJson, forceValue, createdAt, createdBy, modifiedAt, modifiedBy);
    }

    public static SchemaFieldDto of (String fieldName, MockDataType mockDataType, Integer fieldOrder, Integer blankPercent, String typeOptionJson, String forceValue) {
        return new SchemaFieldDto(null, fieldName, mockDataType, fieldOrder, blankPercent, typeOptionJson, forceValue, null, null, null, null);
    }

    public static SchemaFieldDto fromEntity(SchemaField entity) {
        return new SchemaFieldDto(
                entity.getId(),
                entity.getFieldName(),
                entity.getMockDataType(),
                entity.getFieldOrder(),
                entity.getBlankPercent(),
                entity.getTypeOptionJson(),
                entity.getForceValue(),

                entity.getCreatedAt(),
                entity.getCreatedBy(),
                entity.getModifiedAt(),
                entity.getModifiedBy()
        );
    }

    public SchemaField createEntity() {
        return SchemaField.of(
                fieldName,
                mockDataType,
                fieldOrder,
                blankPercent,
                typeOptionJson,
                forceValue
        );

    }

}