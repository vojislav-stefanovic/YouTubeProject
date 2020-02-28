package project.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Builder
@Table(name="tbl_likes")
@AllArgsConstructor
@NoArgsConstructor
public class LikeDislike {

    @Id
    @GeneratedValue
    @Column
    private Long id;
    @Column(nullable = false)
    private Boolean like;
    @Column(nullable = false)
    private Date date;

    @ManyToOne(fetch = FetchType.EAGER)
    private Comment comment;

    @ManyToOne(fetch = FetchType.EAGER)
    private Video video;
}
