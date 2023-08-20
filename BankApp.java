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

}