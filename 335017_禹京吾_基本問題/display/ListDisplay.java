package display;

import java.util.Map;

import issues.Bond;
import issues.BondMap;
import issues.Paymentday;
import issues.StockMap;
import issues.Stock;

/**
 * 銘柄残高一覧表示用プログラム
 * @author 禹京吾
 * @version 1.0.0
 */
public class ListDisplay {    
    
    /**
     * listDisplayメソッド
     * 保有銘柄残高一覧表示をする。
     * @param stockMap　stock型のマップ
     * @param bondMap　bond型のマップ
     */
    public void listDisplay(StockMap stockMap, BondMap bondMap) {
        final int LENGTH = 15;
        Format format = new Format();
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------");
        String[] menuList = {"銘柄コード", "銘柄名", "償還年月日", "利率", "クーポン回数", "保有数量", "簿価", "時価", "評価損益"} ;
        System.out.println("|" + format.formatString(menuList[0], LENGTH) + "|" + format.formatString(menuList[1], LENGTH) + "|" + format.formatString(menuList[2], LENGTH) + "|" + format.formatString(menuList[3], LENGTH) + "|" + format.formatString(menuList[4], LENGTH) 
        + "|" + format.formatString(menuList[5], LENGTH) + "|" + format.formatString(menuList[6], LENGTH) + "|" + format.formatString(menuList[7], LENGTH) + "|" + format.formatString(menuList[8], LENGTH) + "|");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------");
        
        Paymentday pay = new Paymentday();
        for(Map.Entry<String, Bond> entry : bondMap.getBondMap().entrySet()) {
            Stock stock = stockMap.findStockPosition(entry.getKey());
            if(stock != null) {
                String amountString = format.convertInt(stock.getAmount());
                String couponString = format.convertDouble(entry.getValue().getCouponRate() * 100);
                String paymentDay = pay.paymentString(entry.getValue().getMaturity());
                String bookValueString = format.convertDouble(stock.getBookValue());
                String actualValueString = format.convertDouble(stock.getActualValue());
                Double balance = (stock.getActualValue() - stock.getBookValue()) * stock.getAmount();
                String balanceString = format.convertInt(balance);

                if(amountString.equals("0") == true) {
                    bookValueString = "0.000";
                    balanceString = "0";
                }

                if(actualValueString.equals("0.000") == true) {
                    actualValueString = "Not Avallable";
                    balanceString = "Not Avallable";
                }

                System.out.println("|" + format.formatInt(entry.getValue().getCode(), LENGTH) + "|" + format.formatString(entry.getValue().getName(), LENGTH) + "|" + format.formatInt(paymentDay, LENGTH) + "|" + format.formatInt(couponString + "%", LENGTH) + "|" + format.formatInt(String.valueOf(entry.getValue().getCoupon()), LENGTH) + "|" 
                + format.formatInt(amountString, LENGTH) + "|" + format.formatInt(bookValueString, LENGTH) + "|" + format.formatInt(actualValueString, LENGTH) + "|" + format.formatInt(balanceString, LENGTH) + "|");
                System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------");
            }
        } 
    }
}
