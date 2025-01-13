package com.ecommerce.shopping.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "Cotegoerytable")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cotegoery {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long cotegoeryId;

    @NotBlank
    @Size(min = 5,message = "CotegoeryName should not be less than 5 character")
    private String cotegoeryName;

}
