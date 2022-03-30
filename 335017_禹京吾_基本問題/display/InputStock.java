package display;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.Map;

import issues.StockMap;
import issues.Stock;
import issues.StockLoader;

/**
 * 簿価の入力と時価の入力用プログラム
 * @author 禹京吾
 * @version 1.0.0
 */
public class InputStock {

    /**
     * inputStockWritingメソッド
     * 入力された銘柄、保有数量、簿価をファイルに書き込む。
     * @param stockFile ファイル
     * @param br BufferdReader型
     * @param stockLoader StockLoader型
     * @param stockMap StockMap型
     */
    public void inputStockWriting(File stockFile, BufferedReader br, StockLoader stockLoader, StockMap stockMap) {
        menu: while (true) {
            try {
                System.out.println("銘柄コードを入力してください。");
                String code = br.readLine();
                Stock stock = stockMap.findStockPosition(code);
                if(stock == null) {
                    System.out.println();
                    System.out.println("指定した銘柄は存在しません。");
                    System.out.println("もう一度、初めから入力してください。");
                    System.out.println();
                    System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
                    break menu;
                } else {
                    Format format = new Format();
                    System.out.println("銘柄名: " + stock.getName());
                    System.out.println("現在の保有数量は" + format.convertInt(stock.getAmount()) + "です。");
                    System.out.println("移動平均簿価は" + format.convertDouble(stock.getBookValue()) + "円です。");
                }
                System.out.println();
                System.out.println("数量を入力してください。");
                System.out.println("数量が減る場合は「-」を付けてください。");
                System.out.println("例: -200.45");
                String amountString = br.readLine();
                Double amount = Double.valueOf(amountString);
                if(0 > stockMap.findStockPosition(code).getAmount() + Double.valueOf(amount)) {
                    System.out.println();
                    System.out.println("保有数量がマイナスになります。");
                    System.out.println("もう一度、初めから入力してください。");
                    System.out.println();
                    System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
                    break menu;
                }
                System.out.println();
                System.out.println("簿価を入力してください。");
                String bookValueString = br.readLine();
                int bookValue = Integer.parseInt(bookValueString);
                Double calculation = (stock.getBookValue() * stock.getAmount() + bookValue * amount) / (stock.getAmount() + amount);
                amount += stock.getAmount();
                stockMap.addPosition(code, amount, calculation);
                int errorInt = 0;
                stockLoader.fileDelete(stockFile);
                for(Map.Entry<String, Stock> entry : stockMap.getPortfolioMap().entrySet()) {
                    Stock stockWrite = entry.getValue();
                    stockLoader.writing(stockFile, stockWrite, errorInt);
                }
                System.out.println();
                if(errorInt == 0) {
                    System.out.println("入力が完了しました。");
                } else {
                    System.out.println("書き込みにエラーがありました。");
                }
                break menu;
            } catch (IOException ex) {
                System.out.println("");
                System.out.println("ファイルが見つかりません。");
            } catch (NumberFormatException error) {
                System.out.println("");
                System.out.println("適切な形で値が入力されていません。");
                System.out.println("もう一度、初めから入力してください。");
                break menu;
            }
        }
    }

    /**
     * inputActualValueメソッド
     * 入力された時価をファイルに書き込む。
     * @param stockFile ファイル
     * @param br BufferdReader型
     * @param stockLoader StockLoader型
     * @param stockMap StockMap型
     */
    public void inputActualValue(File stockFile, BufferedReader br, StockMap stockMap, StockLoader stockLoader) {
        stockLoader.fileDelete(stockFile);
        System.out.println("それぞれの保有銘柄の時価を入力してください。");
        for(Map.Entry<String, Stock> entry : stockMap.getPortfolioMap().entrySet()) {
            loop: while(true) {
                try {
                    System.out.println("銘柄コード: " + entry.getValue().getCode() + " 銘柄名: " + entry.getValue().getName());
                    String actualValue = br.readLine();
                    Stock stockActualValue = entry.getValue();
                    stockActualValue.setActualValue(Integer.parseInt(actualValue));
                    stockLoader.writing(stockFile, stockActualValue, 0);
                    System.out.println();
                    break loop;
                } catch (IOException ex) {
                    System.out.println("エラーが発生しました。担当者に連絡してください。");
                } catch (NumberFormatException error) {
                    System.out.println("");
                    System.out.println("適切な形で値が入力されていません。");
                    System.out.println("もう一度、入力してください。");
                    System.out.println("");
                }
            }
        }
        System.out.println();
        System.out.println("入力が完了しました。");
    }
}
