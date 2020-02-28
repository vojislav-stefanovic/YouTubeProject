package project.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Builder
@Table(name = "tbl_video")
@AllArgsConstructor
@NoArgsConstructor
public class Video {


    @Id
    @GeneratedValue
    @Column
    private Long id;
    @Column(nullable = false)
    private String videoUrl;
    @Column
    private String videoName;
    @Column(nullable = false)
    private String thumbnailUrl;
    @Column
    private String description;
    @Column(nullable = false)
    private VideoType videoType;
    @Column(nullable = false)
    private Boolean commentsAllowed;
    @Column(nullable = false)
    private Boolean ratingsAvailable;
    @Column(nullable = false)
    private Boolean blocked;
    @Column(nullable = false)
    private Integer views;
    @Column(nullable = false)
    private Date date;

    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    @OneToMany(mappedBy = "video")
    private List<LikeDislike> likes = new ArrayList<>();

}
