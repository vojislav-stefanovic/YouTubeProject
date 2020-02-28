package project.support;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import project.model.Video;
import project.web.dto.UserDTO;
import project.web.dto.VideoDTO;

@Component
public class VideoToVideoDTO implements Converter<Video, VideoDTO> {

    @Override
    public VideoDTO convert(Video video) {

        return VideoDTO.builder()
                .blocked(video.getBlocked())
                .commentsAllowed(video.getCommentsAllowed())
                .date(video.getDate())
                .description(video.getDescription())
                .id(video.getId())
                .ratingsAvailable(video.getRatingsAvailable())
                .thumbnailUrl(video.getThumbnailUrl())
                .videoType(video.getVideoType())
                .videoUrl(video.getVideoUrl())
                .views(video.getViews())
                .videoName(video.getVideoName())
                .user(new UserDTO(video.getUser()))
                .build();
    }
}
