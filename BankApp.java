import java.util.Scanner;

public class BankApp{

    private static final Scanner SCANNER = new Scanner(System.in);
    final static String CLEAR = "\033[H\033[2J";
    final static String COLOR_BLUE_BOLD = "\033[34;1m";
    final static String COLOR_RED_BOLD = "\033[31;1m";
    final static String COLOR_GREEN_BOLD = "\033[33;1m";
    final static String RESET = "\033[0m";

    final static String DASHBOARD = "Welcome to Start Banking";
    final static String CREATE_NEW_ACCOUNT = "Create New Account";
    final static String DEPOSIT_MONEY = "Deposit";
    final static String WITHDRAW_MONEY = "Withdrawal";
    final static String TRANSFER_MONEY = "Transfer";
    final static String BALANCE_CHECK = "Check the Balance";
    final static String DELETE_ACCOUNT = "Delete Statement";
    final static String PRINT_DETAILS = "Print Details";
    
    final static String ERROR_MSG = String.format("\t%s%s%s\n", COLOR_RED_BOLD, "%s", RESET);
    final static String SUCCESS_MSG = String.format("\t%s%s%s\n", COLOR_GREEN_BOLD, "%s", RESET);
    static String screen = "";

    static String[][] bankUsers = new String[0][];
    static String id;
    static String name;
    static double balance;
    static int index;

    public static void main(String[] args) {
        
        screen = DASHBOARD;

        do{

            final String APP_TITLE = String.format("%s%s%s",
            COLOR_BLUE_BOLD, screen, RESET);

            System.out.println(CLEAR);
            System.out.println("\t" + APP_TITLE + "\n");

            switch(screen){

                case DASHBOARD:
                    getDashboard();
                    break;





            }







        }while(true);

    }

    //Get DASHBOARD

    public static void getDashboard(){
        System.out.println("\t[1]. Create New Account");
        System.out.println("\t[2]. Deposit");
        System.out.println("\t[3]. Withdrawal");
        System.out.println("\t[4]. Transfer");
        System.out.println("\t[5]. Check the Balance");
        System.out.println("\t[6]. Delete Statement");
        System.out.println("\t[7]. Print Details");
        System.out.println("\t[8]. Exit");
        System.out.print("\n\t Enter an option to continue: ");

        int option = SCANNER.nextInt();
        SCANNER.nextLine();

        switch(option){
            case 1:
                screen = CREATE_NEW_ACCOUNT;
                break;
            case 2:
                screen = DEPOSIT_MONEY;
                break;
            case 3:
                screen = WITHDRAW_MONEY;
                break;
            case 4:
                screen = TRANSFER_MONEY;
                break;
            case 5:
                screen = BALANCE_CHECK;
                break;
            case 6:
                screen = DELETE_ACCOUNT;
                break;
            case 7:
                screen = PRINT_DETAILS;
                break;
            case 8:
                System.out.println(CLEAR);
                System.exit(0);
        }
    }

}