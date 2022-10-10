import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        main2();
    }

    public static void main1() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите путь к файлу: ");
        String s = scanner.nextLine();
        File f1 = new File(s);
        String s1 = "";
        try {
            readSmallFiles();
        } catch (IOException e) {
        }
    }

    public static void readSmallFiles() throws IOException {
        Path path = Paths.get("HW");
        List<String> strings = Files.readAllLines(path);
        BufferedWriter writer = new BufferedWriter(new FileWriter("Valid"));
        BufferedWriter writer1 = new BufferedWriter(new FileWriter("notValid"));
        for (String s: strings) {
            if(s.length()==15 && (s.startsWith("docnum") || s.startsWith("contract"))) {
                writer.append(s + "\n");
            }
        }
        for (String s: strings) {
            if(s.length()<15) {
                writer1.append(s + " Длина номера документа слишком мала!" + "\n");
            }
            if(s.length()>15) {
                writer1.append(s + " Длина номера документа слишком большая!" + "\n");
            }
            if (!(s.startsWith("docnum") || s.startsWith("contract"))){
                writer1.append(s + " Неправильное начало номера документа!" + "\n");
            }
        }
        writer.close();
        writer1.close();
    }

    public static void readFiles(File baseDirectory){
        if (baseDirectory.isDirectory()){
            for (File file : baseDirectory.listFiles()) {
                if(file.isFile()){
                    System.out.println(file.getName() + " файл");
                }else {
                    System.out.println(file.getName() + " каталог");
                    readFiles(file);
                }
            }
        }
    }

    //это я нашла в интернете
    public static void main2() {
        new Info();
    }
}