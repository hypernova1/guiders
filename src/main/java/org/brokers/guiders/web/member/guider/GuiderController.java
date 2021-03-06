package org.brokers.guiders.web.member.guider;

import lombok.RequiredArgsConstructor;
import org.brokers.guiders.config.security.AuthUser;
import org.brokers.guiders.web.member.Member;
import org.brokers.guiders.web.member.guider.payload.GuiderDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class GuiderController {

    private final GuiderService guiderService;

    @GetMapping("/guiders")
    public String guiders() {
        return "guiders/guiders";
    }

    @GetMapping("/guider")
    public ResponseEntity<List<GuiderDetail>> getGuiderList(
            @RequestParam(defaultValue = "1") Integer page, @AuthUser Member member) {
        List<GuiderDetail> guiderList = guiderService.getGuiderList(page, member);
        return ResponseEntity.ok(guiderList);
    }

    @GetMapping("/guider/{id}")
    public ResponseEntity<GuiderDetail> getGuiderInfo(@PathVariable Long id) {
        GuiderDetail guider = guiderService.getGuider(id);
        return ResponseEntity.ok(guider);
    }

}
