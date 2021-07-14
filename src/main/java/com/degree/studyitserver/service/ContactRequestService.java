package com.degree.studyitserver.service;

import com.degree.studyitserver.domain.entity.ContactRequest;
import com.degree.studyitserver.repository.ContactRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ContactRequestService {

    private final ContactRequestRepository contactRequestRepository;

    @Autowired
    public ContactRequestService(ContactRequestRepository contactRequestRepository) {
        this.contactRequestRepository = contactRequestRepository;
    }

    public ContactRequest create(ContactRequest newContactRequest) {
        newContactRequest.setDate(new Date());
        return contactRequestRepository.save(newContactRequest);
    }

    public List<ContactRequest> findAll() {
        return contactRequestRepository.findAll();
    }
}
