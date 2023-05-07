package com.test.meetingapp.models;

import jakarta.persistence.*;
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
    private Integer id;
    @Column(name = "people_inside", unique = false, nullable = false)
    private Integer peopleInside;
    @Column(name = "name", unique = false, nullable = false)
    private String name;
    @Column(name = "identifier", unique = true, nullable = false)
    private String identifier;
}
