package project.service;

import project.model.Video;

import java.util.List;
import java.util.Optional;

public interface VideoService {

    List<Video> findAll();

    Optional<Video> findById(Long id);

    Optional<Video> deleteById(Long id);

    Video save(Video video);

    List<Video> findByUserId(Long userId);

}
