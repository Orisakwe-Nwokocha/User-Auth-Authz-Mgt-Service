package dev.orisha.user_service.service.mapper;

import dev.orisha.user_service.domain.Uploader;
import dev.orisha.user_service.service.dto.UploaderDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Uploader} and its DTO {@link UploaderDTO}.
 */
@Mapper(componentModel = "spring")
public interface UploaderMapper extends EntityMapper<UploaderDTO, Uploader> {}
