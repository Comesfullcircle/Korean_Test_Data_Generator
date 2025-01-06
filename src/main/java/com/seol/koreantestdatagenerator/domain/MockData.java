package com.seol.koreantestdatagenerator.domain;

import com.seol.koreantestdatagenerator.domain.constant.MockDataType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MockData {

    private MockDataType mockDataType;
    private String mockDataValue;

}
