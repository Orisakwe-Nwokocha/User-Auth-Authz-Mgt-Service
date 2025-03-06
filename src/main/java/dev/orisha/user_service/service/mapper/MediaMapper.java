package dev.orisha.user_service.service.mapper;

import dev.orisha.user_service.domain.Media;
import dev.orisha.user_service.domain.Uploader;
import dev.orisha.user_service.service.dto.MediaDTO;
import dev.orisha.user_service.service.dto.UploaderDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Media} and its DTO {@link MediaDTO}.
 */
@Mapper(componentModel = "spring")
public interface MediaMapper extends EntityMapper<MediaDTO, Media> {
  @Mapping(
    target = "uploader",
    source = "uploader",
    qualifiedByName = "uploaderEmail"
  )
  MediaDTO toDto(Media s);

  @Named("uploaderEmail")
  @BeanMapping(ignoreByDefault = true)
  @Mapping(target = "id", source = "id")
  @Mapping(target = "email", source = "email")
  UploaderDTO toDtoUploaderEmail(Uploader uploader);
}
