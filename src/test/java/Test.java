import mvc.model.Banner;
import mvc.service.BannerService;

import java.util.List;

public class Test {

    public static void main(String[] args) throws Exception {
        BannerService bannersService2 = new BannerService();
        List<Banner> banners = bannersService2.getBannersByWeight(5);

        for (Banner b : banners)
            System.out.println(b.toString());

    }
}
