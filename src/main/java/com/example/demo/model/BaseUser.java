package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity(name = "baseUser")
@Data
@AllArgsConstructor
@NoArgsConstructor
@With
@Builder(toBuilder = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class BaseUser {
    @EqualsAndHashCode.Include
    @Id
    String userName;
    @NonNull
    @JsonIgnore
    String password;


}
