package serviceBanners;

import mvc.model.Banner;
import mvc.service.BannerService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:mvcConfig.xml", "classpath:applicationContext.xml"})
public class BannersServiceTest {

    @Autowired
    private BannerService banners;
    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void testBeanBannerService() {
        BannerService bannerService = applicationContext.getBean("bannerService", BannerService.class);
        Assert.assertNotNull(bannerService);

        bannerService = (BannerService) applicationContext.getBean("bannerService");
        Assert.assertNotNull(bannerService);
    }

    @Test
    public void testReadFileBanners() throws Exception {
        List<String> listBanners = banners.readFileBanners();
        Assert.assertNotNull(listBanners);
        listBanners.forEach(System.out::println);
    }

    @Test
    public void testParseListBanners() throws Exception {
        List<Banner> listBanners = banners.parseListBanners();
        Assert.assertNotNull(listBanners);
        for (Banner b : listBanners)
            System.out.println(b.toString());
    }

    @Test
    public void testSumWeight() throws Exception {
        List<Banner> listBanners = new ArrayList<>();
        for (int i = 0; i < 5; i++)
            listBanners.add(new Banner("Test_" + i, i));
        int sumWeight = banners.sumWeight(listBanners);
        Assert.assertEquals(10, sumWeight);
    }

    @Test
    public void testGetBanners() throws Exception {
        List<Banner> listBanners = banners.getBanners(5);
        Assert.assertNotNull(listBanners);
        Assert.assertEquals(5, listBanners.size());
        for (Banner b : listBanners)
            System.out.println(b.toString());
    }

    @Test
    public void testGetBannersByWeight() throws Exception {
        List<Banner> listBanners = banners.getBannersByWeight(5);
        Assert.assertNotNull(listBanners);
        Assert.assertEquals(5, listBanners.size());
        for (Banner b : listBanners)
            System.out.println(b.toString());
    }

    @Test
    public void testCheckRandomByWeight() throws Exception {
        int countResultCheck = 10, firstObtainBanner = 1, totalWeight = 0;
        Map<String, Integer> resultCheckBanners = new HashMap<>();
        List<List<Banner>> allIterationWeight = new ArrayList<>();

        for (int i = 0; i < countResultCheck; i++)
            allIterationWeight.add(banners.getBannersByWeight(5));

        for (List<Banner> listBan : allIterationWeight) {
            Assert.assertNotNull(listBan);
            Assert.assertEquals(5, listBan.size());
            for (Banner b : listBan)
                if (!resultCheckBanners.containsKey(b.getNameBanner()))
                    resultCheckBanners.put(b.getNameBanner(), firstObtainBanner);
                else resultCheckBanners.put(b.getNameBanner(), resultCheckBanners.get(b.getNameBanner()) + 1);
        }

        for (Map.Entry<String, Integer> m : resultCheckBanners.entrySet())
            totalWeight += m.getValue();

        Assert.assertEquals(50, totalWeight);
    }

}
