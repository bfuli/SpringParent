import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;

public class Test {
    public static void main(String[] args) throws IOException {
        String url = "https://glados.rocks/api/user/checkin";
        String cookie = "koa:sess=eyJ1c2VySWQiOjI3MjQ2NiwiX2V4cGlyZSI6MTcwMjE3NzcwODc0OCwiX21heEFnZSI6MjU5MjAwMDAwMDB9; koa:sess.sig=uZWDIDW1y5uebBueJbyShrYr0YM; __stripe_mid=ddca2882-7832-48cf-96cf-f37f6d623d8209cdcc; _gid=GA1.2.1296387912.1682319055; _ga=GA1.2.714848822.1676257652; _gat_gtag_UA_104464600_2=1; _ga_CZFVKMNT9J=GS1.1.1682645651.49.1.1682645676.0.0.0";

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // 设置请求方法为POST
        con.setRequestMethod("POST");

        // 设置请求头信息
//        con.setRequestProperty(":authority", "glados.rocks");
//        con.setRequestProperty(":method", "POST");
//        con.setRequestProperty(":path", "/api/user/checkin");
//        con.setRequestProperty(":scheme", "https");
        con.setRequestProperty("accept", "application/json, text/plain, */*");
        con.setRequestProperty("accept-encoding", "gzip, deflate, br");
        con.setRequestProperty("authorization", "2634595116366161951166623495519-1080-1920");
        con.setRequestProperty("content-length", "26");
        con.setRequestProperty("content-type", "application/json;charset=UTF-8");
        con.setRequestProperty("origin", "https://glados.rocks");
        con.setRequestProperty("sec-ch-ua", "\"Chromium\";v=\"112\", \"Microsoft Edge\";v=\"112\", \"Not:A-Brand\";v=\"99\"");
        con.setRequestProperty("sec-ch-ua-mobile", "?0");
        con.setRequestProperty("sec-ch-ua-platform", "Windows");
        con.setRequestProperty("sec-fetch-mode", "cors");
        con.setRequestProperty("sec-fetch-dest", "empty");
        con.setRequestProperty("sec-fetch-site", "same-origin");
        con.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/112.0.0.0 Safari/537.36 Edg/112.0.1722.58");
        con.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.9,en-US;q=0.8,en;q=0.7,en-GB;q=0.6");
        con.setRequestProperty("Cookie", cookie);

        // 发送POST请求
        con.setDoOutput(true);
        String postData = "token=glados.network";
        con.getOutputStream().write(postData.getBytes("UTF-8"));

        // 处理响应
        int responseCode = con.getResponseCode();
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        // 输出响应结果
        System.out.println("Response Code : " + responseCode);
        System.out.println("Response Body : " + response.toString());
    }
}
