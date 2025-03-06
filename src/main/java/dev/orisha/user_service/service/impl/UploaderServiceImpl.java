package dev.orisha.user_service.service.impl;

import dev.orisha.user_service.domain.Uploader;
import dev.orisha.user_service.repository.UploaderRepository;
import dev.orisha.user_service.service.UploaderService;
import dev.orisha.user_service.service.dto.UploaderDTO;
import dev.orisha.user_service.service.mapper.UploaderMapper;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link dev.orisha.user_service.domain.Uploader}.
 */
@Service
@Transactional
public class UploaderServiceImpl implements UploaderService {

  private static final Logger log = LoggerFactory.getLogger(
    UploaderServiceImpl.class
  );

  private final UploaderRepository uploaderRepository;

  private final UploaderMapper uploaderMapper;

  public UploaderServiceImpl(
    UploaderRepository uploaderRepository,
    UploaderMapper uploaderMapper
  ) {
    this.uploaderRepository = uploaderRepository;
    this.uploaderMapper = uploaderMapper;
  }

  @Override
  public UploaderDTO save(UploaderDTO uploaderDTO) {
    log.debug("Request to save Uploader : {}", uploaderDTO);
    Uploader uploader = uploaderMapper.toEntity(uploaderDTO);
    uploader = uploaderRepository.save(uploader);
    return uploaderMapper.toDto(uploader);
  }

  @Override
  public UploaderDTO update(UploaderDTO uploaderDTO) {
    log.debug("Request to update Uploader : {}", uploaderDTO);
    Uploader uploader = uploaderMapper.toEntity(uploaderDTO);
    uploader = uploaderRepository.save(uploader);
    return uploaderMapper.toDto(uploader);
  }

  @Override
  public Optional<UploaderDTO> partialUpdate(UploaderDTO uploaderDTO) {
    log.debug("Request to partially update Uploader : {}", uploaderDTO);

    return uploaderRepository
      .findById(uploaderDTO.getId())
      .map(existingUploader -> {
        uploaderMapper.partialUpdate(existingUploader, uploaderDTO);

        return existingUploader;
      })
      .map(uploaderRepository::save)
      .map(uploaderMapper::toDto);
  }

  @Override
  @Transactional(readOnly = true)
  public Optional<UploaderDTO> findOne(Long id) {
    log.debug("Request to get Uploader : {}", id);
    return uploaderRepository.findById(id).map(uploaderMapper::toDto);
  }

  @Override
  public void delete(Long id) {
    log.debug("Request to delete Uploader : {}", id);
    uploaderRepository.deleteById(id);
  }
}
