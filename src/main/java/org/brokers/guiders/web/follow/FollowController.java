package org.brokers.guiders.web.follow;


import lombok.RequiredArgsConstructor;
import org.brokers.guiders.config.security.UserCustom;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/follow")
@RequiredArgsConstructor
public class FollowController {

    private final FollowService followService;

    @PostMapping
    @ResponseBody
    public ResponseEntity<Boolean> follow(@RequestBody String guider, Authentication authentication) {
        boolean result = false;
        JSONObject obj = new JSONObject(guider);
        if (authentication != null) {
            UserCustom user = (UserCustom) authentication.getPrincipal();
            followService.follow(obj.getString("guider"), user.getEmail());
            result = true;
        }
        return ResponseEntity.ok(result);
    }

    @DeleteMapping
    @ResponseBody
    public ResponseEntity<Boolean> unfollow(@RequestBody String guider, Authentication authentication) {
        JSONObject obj = new JSONObject(guider);
        if (authentication.getPrincipal() != null) {
            UserCustom user = (UserCustom) authentication.getPrincipal();
            followService.unfollow(obj.getString("guider"), user.getEmail());
        }
        return ResponseEntity.ok(true);
    }

}
