package au.com.chen.aontask.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * The entity of Insurer, which can be used as entity if use ORM
 *
 * @author chenliu
 */

public class Insurer implements Serializable {

    private static final long serialVersionUID = -3009157732242241606L;

    private String name;

    private List<String> exludedPostcodes = new ArrayList<String>();

    private List<String> exludedOccupations = new ArrayList<String>();

    private Double minTurnover;

    public Insurer(String name) {
        this.name = name;
    }

    public Insurer(String name, List<String> exludedPostcodes, List<String> exludedOccupations, Double minTurnover) {
        this.name = name;
        this.exludedPostcodes = exludedPostcodes;
        this.exludedOccupations = exludedOccupations;
        this.minTurnover = minTurnover;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getExludedPostcodes() {
        return exludedPostcodes;
    }

    public void setExludedPostcodes(List<String> exludedPostcodes) {
        this.exludedPostcodes = exludedPostcodes;
    }

    public List<String> getExludedOccupations() {
        return exludedOccupations;
    }

    public void setExludedOccupations(List<String> exludedOccupations) {
        this.exludedOccupations = exludedOccupations;
    }

    public Double getMinTurnover() {
        return minTurnover;
    }

    public void setMinTurnover(Double minTurnover) {
        this.minTurnover = minTurnover;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Insurer insurer = (Insurer) o;
        return Objects.equals(name, insurer.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Insurer{" +
                "name='" + name + '\'' +
                ", exludedPostcodes=" + exludedPostcodes +
                ", exludedOccupations=" + exludedOccupations +
                ", minTurnover=" + minTurnover +
                '}';
    }
}
