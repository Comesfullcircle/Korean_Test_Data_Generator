package com.seol.koreantestdatagenerator.service;

import com.seol.koreantestdatagenerator.dto.TableSchemaDto;
import com.seol.koreantestdatagenerator.repository.TableSchemaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Transactional
@Service
public class TableSchemaService {

    private final TableSchemaRepository tableSchemaRepository;


    @Transactional(readOnly = true)
    public List<TableSchemaDto> loadMySchemas(String userId) {
        return loadMySchemas(userId, Pageable.unpaged()).toList();
    }

    @Transactional(readOnly = true)
    public Page<TableSchemaDto> loadMySchemas(String userId, Pageable pageable) {
        return tableSchemaRepository.findByUserId(userId, pageable)
                .map(TableSchemaDto::fromEntity);
    }

    //단권 조회
    @Transactional(readOnly = true)
    public TableSchemaDto loadMySchema(String userId, String schemaName) {
        return tableSchemaRepository.findByUserIdAndSchemaName(userId, schemaName)
                .map(TableSchemaDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("테이블 스키마가 없습니다 - userId: " + userId + ", schemaName: " + schemaName));
    }

    //작성 참고
    //public void: 작업만 수행하고 반환값이 필요 없을 때 사용.
   // public <반환 타입>: 작업 결과를 반환하거나, 호출자에게 결과를 제공해야 할 때 사용.
    //Upsert는 "Update"와 "Insert"의 결합된 단어로, 데이터베이스 작업에서 "존재하면 업데이트, 존재하지 않으면 삽입"의 의미
    public void upsertTableSchema(TableSchemaDto dto){
       tableSchemaRepository.findByUserIdAndSchemaName(dto.userId(), dto.schemaName())
               .ifPresentOrElse(
                       entity -> tableSchemaRepository.save(dto.updateEntity(entity)),
                       () -> tableSchemaRepository.save(dto.createEntity())
               );
    }

    public void deleteTableSchema(String userId, String schemaName) {
        tableSchemaRepository.deleteByUserIdAndSchemaName(userId, schemaName);
    }
}