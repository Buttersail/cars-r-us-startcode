package kea.sem3.jwtdemo.api;

import kea.sem3.jwtdemo.dto.MemberRequest;
import kea.sem3.jwtdemo.dto.MemberResponse;
import kea.sem3.jwtdemo.service.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/members")
public class MemberController {
    MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping
    public ResponseEntity<List<MemberResponse>> getAllMembers() {
        return ResponseEntity.ok(memberService.getMembers());
    }

    @GetMapping("/{username}")
    public MemberResponse getMembersFromUserName(@PathVariable String username) {
        return (memberService.getMemberByUserName(username));
    }

    @PostMapping()
    public MemberResponse AddMember(@RequestBody MemberRequest body) {
        return memberService.addMember(body);
    }

    @PutMapping("/{username}")
    public MemberResponse UpdateMember(@PathVariable String username, @RequestBody MemberRequest body) {
        return memberService.updateMember(username, body);
    }

    @DeleteMapping("/{username}")
    public void deleteMember(@PathVariable String username) {
        memberService.deleteMember(username);
    }

}
