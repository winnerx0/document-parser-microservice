package com.winnerx0.document_parser.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.web.multipart.MultipartFile;

public record DocumentRequest(@NotNull(message = "File required") MultipartFile file, @NotEmpty(message = "Name required") String name){

}