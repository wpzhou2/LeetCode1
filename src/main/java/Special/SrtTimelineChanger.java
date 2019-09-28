package Special;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

/**
 * @Author: weipeng
 * @Date: 2019/9/28 15:03
 * @Description:  调整字母文件的时间
 **/
public class SrtTimelineChanger {

    public static void main(String[] args) {
//        String filePath = args[0];
//        int timeShift = Integer.parseInt(args[1]);
        String filePath = "D:\\Users\\weipeng\\jinfeng\\godfather.srt";
        int timeShift = -500;

        SrtTimelineChanger changer = new SrtTimelineChanger();
        try {
            changer.change(filePath, timeShift);
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.print("Exit");
    }

    private void change(String filePath, int timeShift) throws IOException {
        File file = new File(filePath);

        StringBuilder sb = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                new FileInputStream(file), "UTF-8"));
        String line = reader.readLine();
        while (line != null) {
            sb.append(changeLine(line, timeShift));
            sb.append("\r\n");
            line = reader.readLine();
        }

        reader.close();
        File outFile = new File("D:\\Users\\weipeng\\jinfeng\\godfather1.srt");
        if (outFile.exists()) {
            outFile.delete();
        }
        outFile.createNewFile();
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(outFile), "GBK"));
        writer.write(sb.toString());
        writer.flush();
        writer.close();
    }

    private Object changeLine(String line, int timeShift) {
        if (line.matches("^\\d\\d:\\d\\d:\\d\\d,\\d\\d\\d.*\\d\\d:\\d\\d:\\d\\d,\\d\\d\\d$")) {
            int start = calculate(line.substring(0, 12));
            int end = calculate(line.substring(17, 29));

            StringBuilder sb = new StringBuilder();
            sb.append(expand(start + timeShift));
            sb.append(" --> ");
            sb.append(expand(end + timeShift));

            System.out.println(line);
            System.out.println(sb.toString());

            return sb.toString();
        }

        return line;
    }

    private String expand(long l) {
        int hour = (int) (l / 3600000);
        int min = (int) ((l - hour * 3600000) / 60000);
        int sec = (int) ((l - hour * 3600000 - min * 60000) / 1000);
        int mili = (int) (l - hour * 3600000 - min * 60000 - sec * 1000);

        return String.format("%02d:%02d:%02d,%03d", hour, min, sec, mili);
    }

    private int calculate(String time) {
        int hour = Integer.parseInt(time.substring(0, 2));
        int min = Integer.parseInt(time.substring(3, 5));
        int sec = Integer.parseInt(time.substring(6, 8));
        int mili = Integer.parseInt(time.substring(9, 12));

        return mili + sec * 1000 + min * 60000 + hour * 3600000;
    }
}

