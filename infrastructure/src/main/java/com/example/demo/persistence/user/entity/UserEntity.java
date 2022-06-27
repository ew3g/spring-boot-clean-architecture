package com.example.demo.persistence.user.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserEntity implements Serializable {
    private static final long serialVersionUID = 3728194057385948L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userSequence")
    @SequenceGenerator(name = "userSequence", sequenceName = "user_id_sequence", allocationSize = 1)
    private Long id;

    @Column(name = "user", unique = true)
    private String user;

    @Column(name = "password")
    private String password;
}
