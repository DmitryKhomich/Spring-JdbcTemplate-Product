package demo.view;
import org.springframework.stereotype.Component;
import java.util.Scanner;
@Component
public class UpdateView {
    public String[] getData(){
        Scanner scanner = new Scanner(System.in);
        String title = "Input id: ";
        System.out.println(title);
        String id = scanner.nextLine().trim();
        title = "Input price: ";
        System.out.println(title);
        String price = scanner.nextLine().trim();
        return new String[]{id, price};
    }
    public void getOutput(String output) {
        System.out.println(output);
    }
}
