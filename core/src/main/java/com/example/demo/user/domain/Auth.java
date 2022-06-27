package com.example.demo.user.domain;

import com.example.demo.shared.SelfValidation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Auth extends SelfValidation<Auth> implements Serializable {
    private static final long serialVersionUID = 958403995847382980L;

    private String token;
}
