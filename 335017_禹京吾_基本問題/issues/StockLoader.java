package issues;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/**
 * Stock型のデータをファイルから読み込み、書き込みを行うプログラム
 * @author 禹京吾
 * @version 1.0.0
 */
public class StockLoader {
    /**
     * StockMap型の変数です。
     */
    private StockMap stockMap = new StockMap();
	
    /**
     * stockLoadメソッド
     * ファイルを読み込み、マップにstockデータを保持させて返す。
     * @param file ファイル名
     * @return CSVファイルから読み込んだデータをすべて保持しているマップ
     * @throws java.io.IOException ファイルの入出力に関するエラー
     */
	public StockMap stockLoad(File file) throws IOException {    
        try (
            FileInputStream input = new FileInputStream(file);
            InputStreamReader stream = new InputStreamReader(input, "UTF-8");
            BufferedReader br = new BufferedReader(stream);
            ) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] data = line.split(",");
                    Stock stock = new Stock(data[0], data[1]);
                    stock.setAmount(Double.valueOf(data[2]));
                    stock.setBookValue(Double.parseDouble(data[3]));
                    stock.setActualValue(Double.parseDouble(data[4]));
                    stockMap.loadAddPosition(stock);
            }        
		} catch (IOException error) {
            throw error;    
		}
		return stockMap;
	}

    /**
     * writingメソッド
     * ファイルにstockデータを書き込み、完了したら値を返す。
     * @param file ファイル名
     * @param stock stock型
     * @param errorInt 整数値
     * @return エラーが発生したかどうかを判断する整数値
     */
	public int writing(File file, Stock stock, int errorInt) {
		try (
            FileOutputStream outputStream = new FileOutputStream(file, true);
            OutputStreamWriter outputWriter = new OutputStreamWriter(outputStream,"UTF-8");
            BufferedWriter bufferedWriter = new BufferedWriter(outputWriter);
            PrintWriter printWriter = new PrintWriter(bufferedWriter);
            ) {
            printWriter.print(stock.getCode());
            printWriter.print(",");
            printWriter.print(stock.getName());
            printWriter.print(",");
            printWriter.print(Double.toString(stock.getAmount()));
            printWriter.print(",");
            printWriter.print(Double.toString(stock.getBookValue()));
            printWriter.print(",");
            printWriter.print(Double.toString(stock.getActualValue()));
            printWriter.println();
            return errorInt;
        } catch (IOException error) {
            return errorInt + 1;
        }
	}

    /**
     * fileDeleteメソッド
     * ファイルの中身をすべて削除するメソッド。
     * @param file ファイル名
     */
    public void fileDelete(File file) {
        try (
            FileOutputStream outputStream = new FileOutputStream(file);
            OutputStreamWriter outputWriter = new OutputStreamWriter(outputStream,"UTF-8");
            BufferedWriter bufferedWriter = new BufferedWriter(outputWriter);
            PrintWriter printWriter = new PrintWriter(bufferedWriter);
            ) {
            printWriter.print("");
        } catch (IOException ex) {
            System.out.println("ファイルの中身の消去にエラーが発生しました。");;
        }
    }
}
