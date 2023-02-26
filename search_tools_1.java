import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.Scanner;

public class NutsAndBolts {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("체결류 종류를 입력하세요: ");
        String type = scanner.nextLine();
        String url = "https://www.boltdepot.com/fastener-information/types-and-uses.aspx";
        try {
            Document document = Jsoup.connect(url).get();
            Element table = document.select("table[class=fasteners]").first();
            Elements rows = table.select("tr");
            boolean found = false;
            for (int i = 1; i < rows.size(); i++) {
                Element row = rows.get(i);
                Elements columns = row.select("td");
                if (columns.size() > 1 && columns.get(0).text().equalsIgnoreCase(type)) {
                    found = true;
                    String tool = columns.get(1).text();
                    System.out.println("체결류 " + type + "에 대한 사용되는 공구: " + tool);
                    break;
                }
            }
            if (!found) {
                System.out.println("입력한 체결류 종류가 존재하지 않습니다.");
            }
        } catch (IOException e) {
            System.out.println("웹 페이지 연결에 실패했습니다.");
            e.printStackTrace();
        }
    }
}
