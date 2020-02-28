package project.web.controller;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.metadata.ItemMetadata;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.model.Video;
import project.service.VideoService;
import project.support.VideoToVideoDTO;
import project.web.dto.VideoDTO;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/videos")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ApiVideoController {

    private @NonNull VideoService videoService;
    private @NonNull VideoToVideoDTO videoToVideoDTO;

    @GetMapping
    public @ResponseBody
    Iterable<VideoDTO> getVideos() {

        return videoService.findAll()
                .stream().sorted(Comparator.comparing(Video::getViews))
                .map(videoToVideoDTO::convert)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<VideoDTO> getVideo(@PathVariable Long id){

        return videoService.findById(id)
                .map(video -> new ResponseEntity<>(videoToVideoDTO.convert(video), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}
