package cz.bern.planer.security;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import cz.bern.planer.repository.MemberRepository;
import cz.bern.planer.service.MemberNotFoundException;

@Service
public class SecurityService {

    protected final MemberRepository memberRepository;

    public SecurityService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public boolean isOwner(long memberId) {
        final var authentication = SecurityContextHolder.getContext().getAuthentication();
        final var username = authentication.getName();
        final var member = memberRepository.findById(memberId).orElseThrow(() -> new MemberNotFoundException(memberId));
        return member.getUsername().equals(username);
    }
}