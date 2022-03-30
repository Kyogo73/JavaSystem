import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import issues.BondLoader;
import issues.BondMap;
import issues.StockMap;
import issues.StockLoader;
import display.InputStock;
import display.ListDisplay;

/**
 * メインプログラム
 * @author 禹京吾
 * @version 1.0.0
 */
public class Main {

    /**
     * mainメソッド
     * 保有銘柄についての処理を行う。
     */
    public static void main(String[] args) {
        try {
            File masterFile = new File("dataFile/MasterData.csv");
            File stockFile = new File("dataFile/StockData.csv");
            
            loop: while (true) {
                System.out.println("★  銘柄の損益を計算できる在庫管理システムです。");
                System.out.println("--メニューリスト--");
                System.out.println("1. 在庫入力");
                System.out.println("2. 値洗い");
                System.out.println("3. 保有銘柄残高一覧表示");
                System.out.println("4. 終了");
                System.out.println("------------------");
                
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                System.out.println("メニューの番号を入力してください。");
                String selectMenu = br.readLine();
                System.out.println();
                
                StockLoader stockLoader = new StockLoader();
                InputStock inputStock = new InputStock();
                StockMap stockMap;
                BondMap bondMap;
                switch(selectMenu) {
                    case "1":
                        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                        System.out.println();
                        try {
                            stockMap = stockLoader.stockLoad(stockFile);
                            inputStock.inputStockWriting(stockFile, br, stockLoader, stockMap);
                        } catch (IOException error) {
                            System.out.println("ファイルにエラーが発生しています。");
                            System.out.println("「StockData.csv」を確認してください。");
                        }
                        System.out.println();
                        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
                        break;
                        
                    case "2":
                        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                        System.out.println();
                        try {
                            stockMap = stockLoader.stockLoad(stockFile);
                            inputStock.inputActualValue(stockFile, br, stockMap, stockLoader);
                        } catch (IOException error) {
                            System.out.println("ファイルにエラーが発生しています。");
                            System.out.println("「StockData.csv」を確認してください。");
                        }
                        System.out.println();
                        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
                        break;
                
                    case "3":
                        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                        System.out.println();
                        try {
                            BondLoader bondLoader = new BondLoader();
                            bondMap = bondLoader.bondLoad(masterFile);
                            stockMap = stockLoader.stockLoad(stockFile);
                            ListDisplay list = new ListDisplay();
                            list.listDisplay(stockMap, bondMap);
                        } catch (IOException error) {
                            System.out.println("ファイルにエラーが発生しています。");
                            System.out.println("「StockData.csv」, 「MasterData.csv」を確認してください。");
                        }
                        System.out.println();
                        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
                        break;
                
                    case "4":
                        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                        System.out.println();
                        System.out.println("終了します。");
                        System.out.println();
                        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
                        break loop;
                
                    default:
                        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                        System.out.println();
                        System.out.println("メニューの番号が間違っています。");
                        System.out.println("もう一度、入力してください。");
                        System.out.println();
                        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
                        break;
                }
            }
        } catch (IOException ex) {
            System.out.println("エラーが発生しました。担当者に連絡してください。");
        } 
    } 
}
