package dev.example.dataanalysermicroservice.entity.user;

import dev.example.dataanalysermicroservice.entity.AbstractEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "users")
public class UserEntity extends AbstractEntity {
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int  age;
}
