package au.com.chen.aontask.dto;

/**
 * The data transfer object of input query
 *
 * @author chen liu
 */
public class Query {

    private String postcode;

    private String occupation;

    private Double turnover;

    public Query(String postcode, String occupation, Double turnover) {
        this.postcode = postcode;
        this.occupation = occupation;
        this.turnover = turnover;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public Double getTurnover() {
        return turnover;
    }

    public void setTurnover(Double turnover) {
        this.turnover = turnover;
    }


    @Override
    public String toString() {
        return "Query{" +
                "postcode='" + postcode + '\'' +
                ", occupation='" + occupation + '\'' +
                ", turnover=" + turnover +
                '}';
    }
}
