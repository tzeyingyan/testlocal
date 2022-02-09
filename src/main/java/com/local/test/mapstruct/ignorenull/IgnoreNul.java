package com.local.test.mapstruct.ignorenull;

import org.mapstruct.factory.Mappers;

public class IgnoreNul {
    public static void main(String[] args) {
        ElementMapper mapper = Mappers.getMapper(ElementMapper.class);

        Element2 element2 = new Element2(null, 2);
        Element1 element1 = mapper.versElement1(element2);
        System.out.println("*-*-*-* Element 1: " + element1);
    }
}
