package com.degree.studyitserver.controller;

import com.degree.studyitserver.domain.dto.ContactRequestDto;
import com.degree.studyitserver.domain.entity.ContactRequest;
import com.degree.studyitserver.mapper.ContactRequestMapper;
import com.degree.studyitserver.service.ContactRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/contact-request")
public class ContactRequestController {

    private final ContactRequestService contactRequestService;
    private final ContactRequestMapper contactRequestMapper;

    @Autowired
    public ContactRequestController(ContactRequestService contactRequestService,
                                    ContactRequestMapper contactRequestMapper) {
        this.contactRequestService = contactRequestService;
        this.contactRequestMapper = contactRequestMapper;
    }

    @PostMapping(value = "/create")
    public ContactRequestDto create(@RequestBody ContactRequestDto contactRequestDto) {
        ContactRequest contactRequest = contactRequestService.create(contactRequestMapper.toEntity(contactRequestDto));
        return contactRequestMapper.toDto(contactRequest);
    }

    @GetMapping(value = "/find-all")
    public List<ContactRequestDto> findAll() {
        return contactRequestMapper.toDtos(contactRequestService.findAll());
    }
}
