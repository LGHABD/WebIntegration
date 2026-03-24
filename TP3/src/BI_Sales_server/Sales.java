package BI_Sales_server;

import java.io.Serializable;
import java.time.LocalDate;

public class Sales implements Serializable {
    private static final long serialVersionUID = 1L;

    private String saleId;
    private String product;
    private String region;
    private double amount;
    private LocalDate date;

    public Sales(String saleId, String product, String region, double amount, LocalDate date) {
        this.saleId = saleId;
        this.product = product;
        this.region = region;
        this.amount = amount;
        this.date = date;
    }

    public String getSaleId() {
        return saleId;
    }

    public String getProduct() {
        return product;
    }

    public String getRegion() {
        return region;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Sale{saleId='" + saleId + "', product='" + product + "', region='" + region + "', amount=" + amount + ", date=" + date + "}";
    }
}
