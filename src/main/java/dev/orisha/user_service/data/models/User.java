package dev.orisha.user_service.data.models;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import dev.orisha.user_service.config.CustomEmptyStringSerializer;
import dev.orisha.user_service.data.enums.Authority;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.Set;

import static jakarta.persistence.EnumType.STRING;

@Getter
@Setter
@Entity
@Table(name = "users")
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    @JsonSerialize(using = CustomEmptyStringSerializer.class)
    private String password;

    @ElementCollection
    @Enumerated(STRING)
    private Set<Authority> authorities;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private Instant dateRegistered;

    @UpdateTimestamp
    @Column(insertable = false)
    private Instant dateUpdated;

    @Transient
//    @OneToOne
    private Age age;

    @Column(name = "age_id")
    private Long ageId;


    public void setAge(Age age) {
        this.age = age;
        this.ageId = age == null ? null : age.getId();
    }
}
