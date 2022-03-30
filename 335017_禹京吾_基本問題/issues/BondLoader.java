package issues;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Bond型のデータをファイルからロードするプログラム
 * @author 禹京吾
 * @version 1.0.0
 */
public class BondLoader {
	/**
	 * BondMap型の変数です。
	 */
    private BondMap bondMap = new BondMap();
	
	/**
     * bondLoadメソッド
     * ファイルを読み込み、マップにbondデータを保持させて返す
     * @param file ファイル名
     * @return CSVファイルから読み込んだデータをすべて保持しているマップ
	 * @throws java.io.IOException ファイルの入出力に関するエラー
     */
	public BondMap bondLoad(File file) throws IOException {
		try (
			FileInputStream input = new FileInputStream(file);
			InputStreamReader stream = new InputStreamReader(input, "UTF-8");
			BufferedReader br = new BufferedReader(stream);
			) {
			String line;

			while ((line = br.readLine()) != null) {
				String[] data = line.split(",");
				Bond bond = new Bond(String.valueOf(data[0]), String.valueOf(data[1]), Integer.parseInt(data[2]), Double.parseDouble(data[3]), Integer.parseInt(data[4]));
				bondMap.loadAddBond(bond);
			}
		} catch (IOException error) {
			throw error;
		}
		return bondMap;
	}
}
