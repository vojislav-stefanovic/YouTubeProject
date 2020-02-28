package project;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import project.model.User;
import project.model.UserType;
import project.model.Video;
import project.model.VideoType;
import project.service.UserService;
import project.service.VideoService;

import javax.annotation.PostConstruct;
import java.util.Date;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TestData {

    private @NonNull UserService userService;
    private @NonNull VideoService videoService;

    @PostConstruct
    public void init(){

        User user1 = User.builder()
                .userName("vojica").userType(UserType.ADMINISTRATOR).blocked(false)
                .email("voja@mail.com").firstName("Vojislav")
                .lastName("Stef").password("123").date(new Date())
                .build();
        User user2 = User.builder()
                .userName("milan").userType(UserType.REGULAR).blocked(false)
                .email("milan@mail.com").firstName("Milan")
                .lastName("Milanov").password("123").date(new Date())
                .build();
        User user3 = User.builder()
                .userName("marko").userType(UserType.REGULAR).blocked(false)
                .email("marko@mail.com").firstName("Marko")
                .lastName("Markovic").password("123").date(new Date())
                .build();
        User user4 = User.builder()
                .userName("petar").userType(UserType.REGULAR).blocked(false)
                .email("petar@mail.com").firstName("Petar")
                .lastName("Peric").password("123").date(new Date())
                .build();

        userService.save(user1);
        userService.save(user2);
        userService.save(user3);
        userService.save(user4);


        Video video1 = Video.builder()
                .videoType(VideoType.PUBLIC)
                .videoUrl("https://www.youtube.com/watch?v=7yHTpGog0IY")
                .videoName("Don McLean - American Pie")
                .blocked(false).commentsAllowed(true)
                .date(new Date()).ratingsAvailable(true)
                .thumbnailUrl("https://images.dexerto.com/uploads/thumbnails" +
                        "/_thumbnailLarge/youtube-logo-thumbnail-change-experiment.jpg")
                .views(50).user(user1)
                .build();
        Video video2 = Video.builder()
                .videoType(VideoType.PRIVATE)
                .videoUrl("https://www.youtube.com/watch?v=O17i437KIBI")
                .videoName("The Doors - L.A. Woman")
                .blocked(false).commentsAllowed(true)
                .date(new Date()).ratingsAvailable(true)
                .thumbnailUrl("https://images.dexerto.com/uploads/thumbnails" +
                        "/_thumbnailLarge/youtube-logo-thumbnail-change-experiment.jpg").views(50).user(user2)
                .build();
        Video video3 = Video.builder()
                .videoType(VideoType.UNLISTED)
                .videoUrl("https://www.youtube.com/watch?v=KuRxXRuAz-I")
                .videoName("The Rolling Stones- Miss You")
                .blocked(false).commentsAllowed(true)
                .date(new Date()).ratingsAvailable(true)
                .thumbnailUrl("https://images.dexerto.com/uploads/thumbnails" +
                        "/_thumbnailLarge/youtube-logo-thumbnail-change-experiment.jpg").views(50).user(user2)
                .build();
        Video video4 = Video.builder()
                .videoType(VideoType.PUBLIC)
                .videoUrl("https://www.youtube.com/watch?v=Q0oIoR9mLwc")
                .videoName("Red Hot Chili Peppers - Dark Necessities")
                .blocked(false).commentsAllowed(true)
                .date(new Date()).ratingsAvailable(true)
                .thumbnailUrl("https://images.dexerto.com/uploads/thumbnails" +
                        "/_thumbnailLarge/youtube-logo-thumbnail-change-experiment.jpg").views(50).user(user3)
                .build();
        Video video5 = Video.builder()
                .videoType(VideoType.PUBLIC)
                .videoUrl("https://www.youtube.com/watch?v=8DyziWtkfBw")
                .videoName("Red Hot Chili Peppers - Can't Stop")
                .blocked(false).commentsAllowed(true)
                .date(new Date()).ratingsAvailable(true)
                .thumbnailUrl("https://images.dexerto.com/uploads/thumbnails" +
                        "/_thumbnailLarge/youtube-logo-thumbnail-change-experiment.jpg").views(50).user(user4)
                .build();
        Video video6 = Video.builder()
                .videoType(VideoType.PUBLIC)
                .videoUrl("https://www.youtube.com/watch?v=xdOykEJSXIg&list=RDxdOykEJSXIg&start_radio=1")
                .videoName("Freedom - Django Unchained")
                .blocked(false).commentsAllowed(true)
                .date(new Date()).ratingsAvailable(true)
                .thumbnailUrl("https://images.dexerto.com/uploads/thumbnails" +
                        "/_thumbnailLarge/youtube-logo-thumbnail-change-experiment.jpg").views(50).user(user4)
                .build();

        videoService.save(video1);
        videoService.save(video2);
        videoService.save(video3);
        videoService.save(video4);
        videoService.save(video5);
        videoService.save(video6);


    }

}
