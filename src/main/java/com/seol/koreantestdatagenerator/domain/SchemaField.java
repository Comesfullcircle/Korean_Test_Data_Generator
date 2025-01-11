package com.seol.koreantestdatagenerator.domain;

import com.seol.koreantestdatagenerator.domain.constant.MockDataType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.Objects;


/**
 * 특정 {@link TableSchema}의 단위 필드 정보.
 * 이 필드들이 모여서 테이블 스키마를 구성한다.
 *
 * @author seol
 */
@Getter
@ToString(callSuper = true)
@Entity
public class SchemaField extends AuditingFields {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @ManyToOne(optional = false)
    private TableSchema tableSchema;

    @Setter @Column(nullable = false) private String fieldName;
    @Setter @Column(nullable = false) @Enumerated(EnumType.STRING)  private MockDataType mockDataType;
    @Setter @Column(nullable = false) private Integer fieldOrder;
    @Setter @Column(nullable = false) private Integer blankPercent;

    @Setter private String typeOptionJson;
    @Setter private String forceValue;

    protected SchemaField() {}

    public SchemaField(String fieldName, MockDataType mockDataType, Integer fieldOrder, Integer blankPercent, String typeOptionJson, String forceValue) {
        this.fieldName = fieldName;
        this.mockDataType = mockDataType;
        this.fieldOrder = fieldOrder;
        this.blankPercent = blankPercent;
        this.typeOptionJson = typeOptionJson;
        this.forceValue = forceValue;
    }

    public static SchemaField of(String fieldName, MockDataType mockDataType, Integer fieldOrder, Integer blankPercent, String typeOptionJson, String forceValue) {
        return new SchemaField(fieldName, mockDataType, fieldOrder, blankPercent, typeOptionJson, forceValue);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        SchemaField that = (SchemaField) object;
        return Objects.equals(id, that.id) &&
                Objects.equals(fieldName, that.fieldName) &&
                mockDataType == that.mockDataType &&
                Objects.equals(fieldOrder, that.fieldOrder) &&
                Objects.equals(blankPercent, that.blankPercent) &&
                Objects.equals(typeOptionJson, that.typeOptionJson) &&
                Objects.equals(forceValue, that.forceValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fieldName, mockDataType, fieldOrder, blankPercent, typeOptionJson, forceValue);
    }
}
