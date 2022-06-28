package com.example.demo.user.domain;

import com.example.demo.shared.SelfValidation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User extends SelfValidation<User> implements Serializable {
    private static final long serialVersionUID = 9543475833960573L;

    @Min(0)
    private Long id;

    @NotEmpty
    private String username;

    @NotEmpty
    private String password;
}
