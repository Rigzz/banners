package mvc.service;

import mvc.model.Banner;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class BannerService {

    private static final String BANNERS = "banners.txt";
    private static final Logger LOG = Logger.getLogger(BannerService.class);

    /**
     * Getting count banners (random result)
     * @param count
     * @return listBanners
     */
    public List<Banner> getBanners(Integer count) {
        List<Banner> listBanners = new ArrayList<>();
        try {
            List<Banner> banners = parseListBanners();
            listBanners = new Random().ints(0, banners.size()).distinct().limit(count).mapToObj(banners::get).collect(Collectors.toList());
            LOG.info("Successful method results - getBanners!");
        } catch (Exception e) {
            LOG.error("When the error of the method - getBanners: " + "\n" + e);
        }
        return listBanners;
    }

    /**
     * Getting count banners (weight result)
     * @param count
     * @return listBanners
     */
    public List<Banner> getBannersByWeight(Integer count) {
        List<Banner> listBanners = new ArrayList<>();
        try {
            List<Banner> banners = parseListBanners();
            int sumWeight = sumWeight(banners);
            banners.stream().filter(b -> (double) b.getWeight() / (double) sumWeight > 0.1 * new Random().nextDouble()).filter(b -> listBanners.size() != count).forEach(listBanners::add);
            LOG.info("Successful method results - getBannersByWeight!");
        } catch (Exception e) {
            LOG.error("When the error of the method - getBannersByWeight: " + "\n" + e);
        }
        return listBanners;
    }

    public Integer sumWeight(List<Banner> banners) {
        int sumWeight = 0;
        for (Banner b : banners)
            sumWeight += b.getWeight();
        return sumWeight;
    }

    public List<Banner> parseListBanners() throws Exception {
        return readFileBanners().stream().map(s -> new Banner((s.substring(0, s.indexOf("#"))), Integer.valueOf(s.substring(s.indexOf("#") + 1)))).collect(Collectors.toList());
    }

    public List<String> readFileBanners() throws IOException {
        BufferedReader br = Files.newBufferedReader(Paths.get(String.valueOf(new File(getClass().getClassLoader().getResource(BANNERS).getFile()))));
        return br.lines().collect(Collectors.toList());
    }

}
