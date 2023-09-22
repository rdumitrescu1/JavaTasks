import java.util.regex.Pattern;
import java.util.regex.Matcher;
//Part 6
public class RegexProblem {

    public static void main(String[] args) {

//1
        String finder = "orderUUID";
        String string = "app=edi_adapter_converter wingtipsTrace=8faeae6709355291 INFO  OrderCreateClient - action=EDIOrderSent originalFilename=Integration_test_Contract customerName=0005084863 orderUUID=d34149d8-88ab-4791-bb0a-46c96e034200 poNum=Test_TS5155079515 lineCount=3";

        Pattern pattern = Pattern.compile(finder);
        Matcher matcher = pattern.matcher(string);

        boolean found = false;
        while (matcher.find()) {
            System.out.println("Match found");
            found=true;
        }
         if(!found){
           System.out.println(found);
        }

//2
        String string2 = "app=edi_adapter_converter wingtipsTrace=8faeae6709355291 INFO  OrderCreateClient - action=EDIOrderSent originalFilename=Integration_test_Contract customerName=0005084863 orderUUID=d34149d8-88ab-4791-bb0a-46c96e034200 poNum=Test_TS5155079515 lineCount=3";
        Pattern pattern2 = Pattern.compile("orderUUID=([a-fA-F0-9-]+)");
        Matcher matcher2 = pattern2.matcher(string2);
        if (matcher2.find())
        {
            System.out.println(matcher2.group(1));
        }
//3
        String string3 = "test 2667843 (test_email@griddynamics.com) test 67483 some string ";
        Pattern pattern3 = Pattern.compile("\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}\\b");
        Matcher matcher3 = pattern3.matcher(string3);
        if (matcher3.find())
        {
            System.out.println(matcher3.group());
        }

//4
        String string4 = "app=edi_adapter_splitter wingtipsTrace=225debfbe6e5fac7 poiFileName=Integration_test_Contract INFO  LogUtils - POI file name: [Integration_test_Contract], total number of orders successfully processed: [2]";
        Pattern pattern4 = Pattern.compile("total number of orders successfully processed: \\[(\\d+)\\]");
        Matcher matcher4 = pattern4.matcher(string4);
        if (matcher4.find())
        {
            System.out.println(matcher4.group(1));
        }

    }

        }






