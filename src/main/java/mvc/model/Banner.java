package mvc.model;

public class Banner {
    private String nameBanner;
    private Integer weight;

    public Banner() {
    }

    public Banner(String nameBanner, Integer weight) {
        this.nameBanner = nameBanner;
        this.weight = weight;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getNameBanner() {
        return nameBanner;
    }

    public void setNameBanner(String nameBanner) {
        this.nameBanner = nameBanner;
    }

    @Override
    public String toString() {
        return "Banner{" +
                "nameBanner='" + nameBanner + '\'' +
                ", weight=" + weight +
                '}';
    }
}
