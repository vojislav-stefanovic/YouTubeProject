package project.service.impl;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.model.User;
import project.model.Video;
import project.repository.VideoRepository;
import project.service.VideoService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class JpaVideoService implements VideoService {

    private @NonNull VideoRepository videoRepository;


    @Override
    public List<Video> findAll() {
        return videoRepository.findAll();
    }

    @Override
    public Optional<Video> findById(Long id) {
        return videoRepository.findById(id);
    }

    @Override
    public Optional<Video> deleteById(Long id) {
        Optional<Video> video = videoRepository.findById(id);
        videoRepository.deleteById(id);
        return video;
    }

    @Override
    public Video save(Video video) {
        return videoRepository.save(video);
    }

    @Override
    public List<Video> findByUserId(Long userId) {
        return videoRepository.findByUserId(userId);
    }
}
