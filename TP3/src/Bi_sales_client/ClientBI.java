package Bi_sales_client;

import BI_Sales_server.IRemoteSalesServices;
import BI_Sales_server.Sales;

import java.rmi.Naming;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class ClientBI {
    public static void main(String[] args) {
        try {
            IRemoteSalesServices service = (IRemoteSalesServices) Naming.lookup("rmi://localhost:1099/ServerBi");

            service.addSale(new Sales("S1", "Laptop", "Nord", 1200.0, LocalDate.of(2025, 1, 10)));
            service.addSale(new Sales("S2", "Mouse", "Sud", 50.0, LocalDate.of(2025, 1, 11)));
            service.addSale(new Sales("S3", "Laptop", "Nord", 1300.0, LocalDate.of(2025, 1, 12)));
            service.addSale(new Sales("S4", "Keyboard", "Est", 100.0, LocalDate.of(2025, 1, 13)));
            service.addSale(new Sales("S5", "Mouse", "Sud", 60.0, LocalDate.of(2025, 1, 14)));

            System.out.println("Chiffre d'affaires total : " + service.getTotalRevenue());

            Map<String, Double> revenueByRegion = service.getRevenueByRegion();
            System.out.println("CA par région : " + revenueByRegion);

            System.out.println("Produit le plus vendu : " + service.getMostSoldProduct());

            List<Sales> salesAbove100 = service.getSalesAboveAmount(100.0);
            System.out.println("Ventes supérieures à 100 : " + salesAbove100);

            List<Sales> allSales = service.getAllSales();
            System.out.println("Toutes les ventes : " + allSales);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
