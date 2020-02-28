package project.web.dto;

import lombok.Builder;
import lombok.Data;
import project.model.User;
import project.model.VideoType;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.util.Date;

@Data
@Builder
public class VideoDTO {

    private Long id;
    private String videoUrl;
    private String videoName;
    private String thumbnailUrl;
    private String description;
    private VideoType videoType;
    private Boolean commentsAllowed;
    private Boolean ratingsAvailable;
    private Boolean blocked;
    private Integer views;
    private Date date;
    private UserDTO user;
}
