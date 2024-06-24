package cz.bern.planer.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import cz.bern.planer.entities.Member;
import cz.bern.planer.repository.MemberRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class MemberService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MemberService.class);

    protected final MemberRepository memberRepository;
    protected final String uploadDir;

    public MemberService(MemberRepository memberRepository, @Value("${upload.dir}") String uploadDir) {
        this.memberRepository = memberRepository;
        this.uploadDir = uploadDir;
    }

    @Transactional(readOnly = true)
    public Member getMember(long id) {
        return memberRepository.findById(id).orElseThrow(() -> new MemberNotFoundException(id));
    }

    @Transactional(readOnly = true)
    public Member getMemberByUsername(String username) {
        return memberRepository.findByUsername(username).orElseThrow(() -> new MemberNotFoundException(username));
    }



}
