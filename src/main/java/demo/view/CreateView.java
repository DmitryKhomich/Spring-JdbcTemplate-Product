package demo.view;
import org.springframework.stereotype.Component;
import java.util.Scanner;
@Component
public class CreateView {
    public String[] getData() {
        Scanner scanner = new Scanner(System.in);
        String title = "Input name: ";
        System.out.print(title);
        String name = scanner.nextLine().trim();
        title = "Input quote: ";
        System.out.print(title);
        String quote = scanner.nextLine().trim();
        title = "Input price: ";
        System.out.print(title);
        String price = scanner.nextLine().trim();
        return new String[]{name, quote, price};
    }

    public void getOutput(String output) {
        System.out.println(output);
    }
}
