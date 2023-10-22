package com.anjali.ps.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Packages {
    @Id
    private String packageId;
    private String packageCategory;
    private String vehicleCategory;
    private String hotelCategory;

    @ElementCollection
    private List<String> hotelsList;

    @ElementCollection
    private List<String> vehicleList;
}
