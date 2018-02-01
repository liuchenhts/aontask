package au.com.chen.aontask.dto;

import java.util.Objects;

/**
 * The data transfer object of output quote
 *
 * @author chenliu
 */
public class Quote {

    private String insurerName;

    private Double price;

    public Quote(String insurerName, Double price) {
        this.insurerName = insurerName;
        this.price = price;
    }

    public String getInsurerName() {
        return insurerName;
    }

    public void setInsurerName(String insurerName) {
        this.insurerName = insurerName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quote quote = (Quote) o;
        return Objects.equals(insurerName, quote.insurerName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(insurerName);
    }

    @Override
    public String toString() {
        return "Quote{" +
                "insurerName='" + insurerName + '\'' +
                ", price=" + price +
                '}';
    }
}
