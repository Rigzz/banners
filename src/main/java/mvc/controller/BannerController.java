package mvc.controller;

import mvc.model.Banner;
import mvc.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BannerController {

    @Autowired
    private BannerService banners;

    @RequestMapping(value = "/banners", method = RequestMethod.GET)
    public List<Banner> banners(@RequestParam(value = "count") Integer count) {
        return banners.getBanners(count);
    }

    @RequestMapping(value = "/bannersByWeight", method = RequestMethod.GET)
    public List<Banner> bannersByWeight(@RequestParam(value = "count") Integer count) {
        return banners.getBannersByWeight(count);
    }

}
