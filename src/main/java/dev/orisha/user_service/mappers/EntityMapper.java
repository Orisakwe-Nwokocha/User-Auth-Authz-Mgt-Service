package dev.orisha.user_service.mappers;

import org.mapstruct.BeanMapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

public interface EntityMapper<D, E> {

    D toDto(E entity);

    E toEntity(D dto);

    List<D> toDto(List<E> entityList);

    List<E> toEntity(List<D> dtoList);

    @Named("partialUpdate")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void partialUpdate(@MappingTarget E entity, D dto);

}
