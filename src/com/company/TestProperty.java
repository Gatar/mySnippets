package com.company;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

@AllArgsConstructor
@Getter
public class TestProperty {

    private String property;
    private String data = StringUtils.EMPTY;

    private TestProperty(){
        //empty
    }

    private TestProperty(String property) {
        this.property = property;
    }

    public static TestProperty fetchProperty(String property, boolean isActive, PropertyGenerator generator){
        if(isActive){
            return new TestProperty(property, generator.generate());
        } else{
            return new TestProperty(property);
        }
    }
}
