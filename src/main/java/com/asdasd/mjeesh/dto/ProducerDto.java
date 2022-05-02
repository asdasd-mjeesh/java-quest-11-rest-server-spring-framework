package com.asdasd.mjeesh.dto;

import com.asdasd.mjeesh.model.Contact;

import java.util.List;

public record ProducerDto(Long id,
                          String name,
                          List<Contact> contacts) {
}
