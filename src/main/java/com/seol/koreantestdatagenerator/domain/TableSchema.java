package com.seol.koreantestdatagenerator.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.*;

/**
 * 단위 테이블 스키마 정보.
 * 식별자({@link #userId})로 특정할 수 있는 회원이 소유한다.
 *
 * @author seol
 */
@Getter
@ToString(callSuper = true)
@Entity
public class TableSchema extends AuditingFields{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter private String schemaName;
    @Setter private String userId;
    @Setter private LocalDateTime exportedAt;

    @ToString.Exclude
    @OneToMany(mappedBy = "tableSchema", cascade = CascadeType.ALL, orphanRemoval = true)
    private final Set<SchemaField> schemaFields = new LinkedHashSet<>();

    protected TableSchema() {}

    public TableSchema(String schemaName, String userId) {
        this.schemaName = schemaName;
        this.userId = userId;
        this.exportedAt = null;
    }

    public static TableSchema of(String schemaName, String userId) {
        return new TableSchema(schemaName, userId);
    }

    public void markExported(){
        exportedAt = LocalDateTime.now();
    }

    public boolean isExpected(){
        return exportedAt != null;
    }

    public void addSchemaField(SchemaField schemaField) {
        schemaField.setTableSchema(this);
        schemaFields.add(schemaField);
    }

    public void addSchemaFields(Collection<SchemaField> schemaFields) {
        schemaFields.forEach(this::addSchemaField);
    }

    public void clearSchemaFields() {
        schemaFields.clear();
    }


    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof TableSchema that)) return false;

        if (that.getId() == null) {
            return Objects.equals(this.getSchemaName(), that.getSchemaName() )&&
                    Objects.equals(this.getUserId(), that.getUserId()) &&
                    Objects.equals(this.getExportedAt(), that.getExportedAt()) &&
                    Objects.equals(this.getSchemaFields(), that.getSchemaFields());
        }

        return Objects.equals(this.getId(), that.getId());

       // if (object == null || getClass() != object.getClass()) return false;
       // TableSchema that = (TableSchema) object;
       // return Objects.equals(id, that.id) && Objects.equals(schemaName, that.schemaName) && Objects.equals(userId, that.userId) && Objects.equals(exportedAt, that.exportedAt) && Objects.equals(schemaFields, that.schemaFields);
    }

    @Override
    public int hashCode() {
        if (getId() == null) {
            return Objects.hash(this.getSchemaName(), this.getUserId(), this.getExportedAt(), this.getSchemaFields());
        }
        return Objects.hash(getId());

        //return Objects.hash(id, schemaName, userId, exportedAt, schemaFields);
    }
}
