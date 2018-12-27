package homework2;

public class Main {
    public static void main(String[] args) {
        System.out.println(Account.builder().withCardNumber("9876678998766789").withOverdraft(200).withOvnerId(1654387).build());
    }
}
