package model;


import java.util.Objects;

public class Events {
    private String id;
    private String title;
    private String price;
    private String remark;


    public Events() {
    }

    public Events(String id, String title, String price, String remark) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.remark = remark;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Events events = (Events) o;
        return Objects.equals(id, events.id) &&
                Objects.equals(title, events.title) &&
                Objects.equals(price, events.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, price, remark);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", price=" + price + '\'' +
                ", title='" + remark +
                '}';
    }
}
