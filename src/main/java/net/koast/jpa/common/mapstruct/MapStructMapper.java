package net.koast.jpa.common.mapstruct;

import java.util.List;

public interface MapStructMapper<D, E> {

    D toDto(E entity);

    E toEntity(D dto);

    List<D> toDtoList(List<E> entityList);

    List<E> toEntityList(List<D> dtoList);

}
