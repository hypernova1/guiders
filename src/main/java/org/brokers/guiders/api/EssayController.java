package org.brokers.guiders.api;

import lombok.RequiredArgsConstructor;
import org.brokers.guiders.web.essay.EssayDto;
import org.brokers.guiders.web.essay.EssayService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("essayApi")
@RequestMapping("/api/essay")
@RequiredArgsConstructor
public class EssayController {

    private final EssayService essayService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getEssay(@PathVariable Long id) {
        EssayDto.DetailResponse essay = essayService.getEssay(id);
        return ResponseEntity.ok(essay);
    }

}
