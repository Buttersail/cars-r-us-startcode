package kea.sem3.jwtdemo.service;

import kea.sem3.jwtdemo.dto.MemberRequest;
import kea.sem3.jwtdemo.dto.MemberResponse;
import kea.sem3.jwtdemo.entity.Member;
import kea.sem3.jwtdemo.entity.Role;
import kea.sem3.jwtdemo.error.Client4xxException;
import kea.sem3.jwtdemo.repositories.MemberRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MemberService {

    MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public List<MemberResponse> getMembers() {
        List<Member> members = memberRepository.findAll();
        return members.stream().map(member -> new MemberResponse(member, false)).collect(Collectors.toList());
    }

    public MemberResponse getMemberByUserName(String username) {
        Member member = memberRepository.findById(username).orElseThrow(() -> new Client4xxException("User not found", HttpStatus.NOT_FOUND));
        return new MemberResponse(member, false);
    }

    public MemberResponse addMember(MemberRequest body) {

        if (memberRepository.existsById((body.getUsername()))) {
            throw new Client4xxException("Provided user name is taken");
        }
        if (memberRepository.emailExist(body.getEmail())) {
            throw new Client4xxException("Provided email is taken");
        }
        Member member = new Member(body);
        member.addRole(Role.USER);
        member = memberRepository.save(member);
        return new MemberResponse(member.getUsername(), member.getCreated(), member.getRoles());
    }

    public MemberResponse updateMember(String username, MemberRequest body) {
        Member member = memberRepository.findById(username).orElseThrow(() -> new Client4xxException("Member not found!", HttpStatus.NOT_FOUND));
        member.setUsername(body.getUsername());
        member.setPassword(body.getPassword());
        member.setEmail(body.getEmail());
        member.setFirstName(body.getFirstName());
        member.setLastName(body.getLastName());
        member.setStreet(body.getStreet());
        member.setCity(body.getCity());
        member.setZip(body.getZip());

        return new MemberResponse(memberRepository.save(member), false);
    }

    public void deleteMember(String username) {
        Member member = memberRepository.findById(username).orElseThrow(() -> new Client4xxException("Member not found", HttpStatus.NOT_FOUND));
        try {
            memberRepository.delete(member);
        } catch (Exception ex) {
            throw new Client4xxException("Could not delete user with username: " + username, HttpStatus.BAD_REQUEST);
        }
    }

}
