package BI_Sales_server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;

public interface IRemoteSalesServices extends Remote {
    void addSale(Sales sale) throws RemoteException;
    double getTotalRevenue() throws RemoteException;
    Map<String, Double> getRevenueByRegion() throws RemoteException;
    String getMostSoldProduct() throws RemoteException;
    List<Sales> getSalesAboveAmount(double amount) throws RemoteException;
    List<Sales> getAllSales() throws RemoteException;
}
