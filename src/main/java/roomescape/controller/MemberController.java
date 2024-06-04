package roomescape.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import roomescape.service.MemberService;
import roomescape.service.dto.MemberJoinRequest;
import roomescape.service.dto.MemberResponse;

import java.net.URI;

@RestController
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping
    public ResponseEntity<MemberResponse> save(@RequestBody @Valid MemberJoinRequest memberRequest) {
        MemberResponse memberResponse = memberService.join(memberRequest);

        return ResponseEntity.created(URI.create("/members/" + memberResponse.id()))
                .body(memberResponse);
    }
}
