package domain;

public class Order {
    int orderID;
    String orderStatus;
    String orderInformation;
    String orderName;

    public Order(int orderID, String orderStatus, String orderInformation, String orderName) {
        this.orderID = orderID;
        this.orderStatus = orderStatus;
        this.orderInformation = orderInformation;
        this.orderName = orderName;
    }

    public Order() {
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderInformation() {
        return orderInformation;
    }

    public void setOrderInformation(String orderInformation) {
        this.orderInformation = orderInformation;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }
}
