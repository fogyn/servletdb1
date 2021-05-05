package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ManufactoryCol implements Serializable {

   private String name;
   private int count;

    public ManufactoryCol() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
