package com.anjali.ps.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class VehiclePackageIdDTO  implements Serializable,SuperDTO{
    private String VehicleId;
    private String PackageId;
}
