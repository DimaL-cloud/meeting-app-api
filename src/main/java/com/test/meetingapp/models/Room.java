package com.test.meetingapp.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "rooms")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    @JsonIgnore
    private Integer id;

    @Column(name = "name", unique = false, nullable = false)
    @NotBlank(message = "Name is required")
    @JsonProperty("name")
    private String name;

    @Column(name = "identifier", unique = true, nullable = false)
    @NotBlank(message = "Identifier is required")
    @JsonProperty("identifier")
    private String identifier;

    @Column(name = "people_inside", unique = false, nullable = false)
    @JsonProperty("people_inside")
    private Integer peopleInside = 0;
}
