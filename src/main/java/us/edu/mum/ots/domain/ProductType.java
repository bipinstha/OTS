package us.edu.mum.ots.domain;

/**
 *
 * @author bipin
 */
public enum ProductType {

    COMPUTER_RELATED("Computer Related", 2.0), HEALTH_RELATED("Health Related", 1.0),
    AUDIOVIDEO_RELATED("AudioVideo Related", 0.5), OTHERS("Others", 0.25);

    private String name;
    private Double point;

    private ProductType(String name, Double point) {
        this.name = name;
        this.point = point;
    }

    public String getName() {
        return name;
    }

    public Double getPoint() {
        return point;
    }

}
