package dev.orisha.user_service.service.mapper;

import dev.orisha.user_service.domain.Authority;
import dev.orisha.user_service.domain.Uploader;
import dev.orisha.user_service.service.dto.AuthorityDTO;
import dev.orisha.user_service.service.dto.UploaderDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Authority} and its DTO {@link AuthorityDTO}.
 */
@Mapper(componentModel = "spring")
public interface AuthorityMapper extends EntityMapper<AuthorityDTO, Authority> {
  @Mapping(
    target = "uploader",
    source = "uploader",
    qualifiedByName = "uploaderId"
  )
  AuthorityDTO toDto(Authority s);

  @Named("uploaderId")
  @BeanMapping(ignoreByDefault = true)
  @Mapping(target = "id", source = "id")
  UploaderDTO toDtoUploaderId(Uploader uploader);
}
