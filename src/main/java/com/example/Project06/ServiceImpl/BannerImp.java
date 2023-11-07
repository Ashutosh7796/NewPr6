package com.example.Project06.ServiceImpl;

import com.example.Project06.Dto.BannerDto;
import com.example.Project06.Entity.Banner;
import com.example.Project06.Repository.BannerRepo;
import com.example.Project06.Service.IBanner;
import com.example.Project06.exception.BannerNotFoundByIdException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BannerImp implements IBanner {
private final BannerRepo bannerRepo;
    @Override
    public void saveBannerDetails(BannerDto bannerDto) {
        Banner banner = new Banner(bannerDto);
        bannerRepo.save(banner);

    }

    @Override
    public Banner getBannerDetailsById(Integer bannerId) {
        return this.bannerRepo.findById(bannerId).orElseThrow(() -> new BannerNotFoundByIdException("banner details Not found By Id"));
    }

    @Override
    public List<Banner> getAllBannerDetails() {
        return this.bannerRepo.findAll();
    }

    @Override
    public String updateBannerDetails(String taital, String status, String name,Integer bannerId) {
        Banner banner = bannerRepo.findById(bannerId).orElseThrow(() -> new BannerNotFoundByIdException("banner details Not found By Id"));

        banner.setName(name.length()>0 ? name : banner.getName());
        banner.setStatus(status.length()>0 ? status : banner.getStatus());
        banner.setTaital(taital.length()>0 ? taital : banner.getTaital());
        bannerRepo.save(banner);
        return "banner details updated";
    }

    @Override
    public String deleteBannerDetailsByID(Integer bannerId) {
        Banner banner = bannerRepo.findById(bannerId).orElseThrow(() -> new BannerNotFoundByIdException("banner details Not found By Id"));
        bannerRepo.deleteById(bannerId);
        return "banner detals deleted by id";
    }


}
