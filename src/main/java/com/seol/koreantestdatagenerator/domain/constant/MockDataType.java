package com.seol.koreantestdatagenerator.domain.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

@Getter
@RequiredArgsConstructor
public enum MockDataType {

    STRING(Set.of("minLength", "maxLength"), null),
    NUMBER(Set.of("min", "max", "decimals"), null),
    BOOLEAN(Set.of(),null),
    DATETIME(Set.of("from", "to"),null),
    ENUM(Set.of("elements"),null),

    SENTENCE(Set.of("minSentences", "maxSentences"), STRING),
    PARAGRAPH(Set.of("minParagraphs", "maxParagraphs"), STRING),
    UUID(Set.of(), STRING),
    EMAIL(Set.of(), STRING),
    CAR(Set.of(), STRING),
    ROW_NUMBER(Set.of("start, step"), NUMBER),
    NAME(Set.of(), STRING),
    ;

    private final Set<String> requiredOptions;
    private final MockDataType baseType;

    private static final List<MockDataTypeObject> objects =
            Stream.of(values())
                    .map(MockDataType::toObject)
                    .toList();

    public static List<MockDataTypeObject> toObjects(){
        return objects;
    }

    public boolean isBaseType() {
        return baseType == null;
    }

    public MockDataTypeObject toObject() {
        return new MockDataTypeObject(
                this.name(),
                this.requiredOptions,
                this.baseType == null ? null : this.baseType.name()
        );
    }

    public record MockDataTypeObject(
            String name,
            Set<String> requiredOptions,
            String baseType
    ) {}

}
