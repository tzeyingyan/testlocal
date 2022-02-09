package com.local.test.mapstruct.ignorenull;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.Optional;
import java.util.UUID;

@Mapper
public interface ElementMapper {

    @Mapping(target = "identifiant", source = "id", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
    @Mapping(target = "montant", source = "montant")
    Element1 versElement1(Element2 element2);

    @Mapping(target = "id", source = "identifiant")
    @Mapping(target = "montant", source = "montant")
    Element2 versElement2(Element1 element1);

    default UUID stringVersUuid(String value) {
        return Optional.ofNullable(value)
                .map(UUID::fromString)
                .orElse(null);
    }

    default String uuidVersString(UUID value) {
        return Optional.ofNullable(value)
                .map(UUID::toString)
                .orElse(null);
    }
}
