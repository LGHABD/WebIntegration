package BI_Sales_server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RemoteSalesServices extends UnicastRemoteObject implements IRemoteSalesServices {
    private List<Sales> sales;

    public RemoteSalesServices() throws RemoteException {
        super();
        sales = new ArrayList<>();
    }

    @Override
    public synchronized void addSale(Sales sale) throws RemoteException {
        sales.add(sale);
        System.out.println("Vente ajoutée : " + sale);
    }

    @Override
    public synchronized double getTotalRevenue() throws RemoteException {
        double total = 0;
        for (Sales sale : sales) {
            total += sale.getAmount();
        }
        return total;
    }

    @Override
    public synchronized Map<String, Double> getRevenueByRegion() throws RemoteException {
        Map<String, Double> revenueByRegion = new HashMap<>();
        for (Sales sale : sales) {
            String region = sale.getRegion();
            double amount = sale.getAmount();
            if (revenueByRegion.containsKey(region)) {
                revenueByRegion.put(region, revenueByRegion.get(region) + amount);
            } else {
                revenueByRegion.put(region, amount);
            }
        }
        return revenueByRegion;
    }

    @Override
    public synchronized String getMostSoldProduct() throws RemoteException {
        Map<String, Integer> productCount = new HashMap<>();
        for (Sales sale : sales) {
            String product = sale.getProduct();
            if (productCount.containsKey(product)) {
                productCount.put(product, productCount.get(product) + 1);
            } else {
                productCount.put(product, 1);
            }
        }

        String mostSold = "Aucun produit";
        int maxCount = 0;
        for (Map.Entry<String, Integer> entry : productCount.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mostSold = entry.getKey();
            }
        }
        return mostSold;
    }

    @Override
    public synchronized List<Sales> getSalesAboveAmount(double amount) throws RemoteException {
        List<Sales> result = new ArrayList<>();
        for (Sales sale : sales) {
            if (sale.getAmount() > amount) {
                result.add(sale);
            }
        }
        return result;
    }

    @Override
    public synchronized List<Sales> getAllSales() throws RemoteException {
        return new ArrayList<>(sales);
    }
}
