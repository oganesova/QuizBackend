package  com.quizz.quizPortal.helper;
import com.quizz.quizPortal.entity.DataStatistics;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public  class CSVHelper{
    public static String TYPE = "text/csv";
    static String[] HEADERs = { "id", "programm_language", "rating", "year" };

    public static boolean hasCSVFormat(MultipartFile file) {
        if (TYPE.equals(file.getContentType())
                || file.getContentType().equals("application/vnd.ms-excel")) {
            return true;
        }

        return false;
    }

    public static List<DataStatistics> csvToTutorials(InputStream is) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
             CSVParser csvParser = new CSVParser(fileReader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

            List<DataStatistics> dataList = new ArrayList<>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            for (CSVRecord csvRecord : csvRecords) {
                DataStatistics data = new DataStatistics(
                        Long.parseLong(csvRecord.get("id")),
                        csvRecord.get("programm_language"),
                        csvRecord.get("rating"),
                        csvRecord.get("year"));

                dataList.add(data);
            }

            return dataList;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }
}