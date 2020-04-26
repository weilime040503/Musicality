package au.edu.unsw;
import java.io.Serializable;
import java.util.List;


public class CloudResponse implements Serializable {


    private List<Cloud> data;

    public List<Cloud> getData() {
        return data;
    }

    public void setData(List<Cloud> data) {
        this.data = data;
    }


}
