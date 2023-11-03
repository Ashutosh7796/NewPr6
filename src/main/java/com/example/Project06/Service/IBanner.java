package com.example.Project06.Service;

import com.example.Project06.Dto.BannerDto;
import com.example.Project06.Entity.Banner;

import java.util.List;

public interface IBanner {

    public void saveBannerDetails(BannerDto bannerDto);

    public Banner getBannerDetailsById(Integer bannerId);

    public List<Banner> getAllBannerDetails();

    public String updateBannerDetails(String taital,String status,String name,Integer bannerId);

    public String deleteBannerDetailsByID(Integer bannerId);
}
