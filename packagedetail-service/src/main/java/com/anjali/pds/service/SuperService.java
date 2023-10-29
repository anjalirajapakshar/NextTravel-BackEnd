package com.anjali.pds.service;


import com.anjali.pds.dto.PackageDetailDTO;
import com.anjali.pds.entity.PackageDetail;
import com.anjali.pds.response.Response;

import java.util.List;
import java.util.Optional;

public interface SuperService<T extends PackageDetailDTO,ID >{
    Response save(T t);

    Response update(T t);

    Response delete(ID id);

    Response search(ID id);

    PackageDetailDTO getPackageDetail(ID id);

    Response getAll();

    Response deletePackageDetails(String userId);

    Response createAndSendResponse(int statusCode, String message, Object data);

    Response getPackageDetailByUserName(String packageDetailName);

}
