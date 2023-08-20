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
                case DEPOSIT_MONEY:
                    getDeposit();
                    break;
                case WITHDRAW_MONEY:
                    getWithdraw();
                    break;
                case TRANSFER_MONEY:
                    getTransfer();
                    break;
                case BALANCE_CHECK:
                    getAccountBal();
                    break;
                case DELETE_ACCOUNT:
                    deleteAccount();
                    break;
                case PRINT_DETAILS:
                    printDetails();;
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

    
    //Name Validation

    public static String getUserName(){

        boolean valid;
        String value;

        do{

            valid = true;
            System.out.print("\tEnter User name : ");
            value = SCANNER.nextLine().strip();

            if(value.isBlank()){
                System.out.printf(ERROR_MSG, "User name can't be empty");
                valid = false;
                continue;
            }
            for (int i = 0; i < value.length(); i++) {
                if(!(Character.isLetter(value.charAt(i))|| Character.isSpaceChar(value.charAt(i)))){
                    System.out.printf(ERROR_MSG, "Invalid name");
                    valid = false;
                    break;
                }
            }
        }while(!valid);
        return value;

    }

     //ID Validation

     public static String getUserId(){

        boolean valid;
        String value;

        do{

            valid = true;
            System.out.print("\tEnter Account Number : ");
            value=SCANNER.nextLine().strip();

            if(value.isBlank()){
                System.out.printf(ERROR_MSG,"ID can't be empty");
                valid=false;
                continue;
            }
            if(!(value.startsWith("SDB-") && value.length() == 9)){
                System.out.printf(ERROR_MSG, "Invalid ID format");
                valid = false;
                continue; 
            }
            
            index = 0;
            boolean isExistedID = false;
            for (int i = 0; i < bankUsers.length; i++) {
                if(bankUsers[i][0].equals(value)){
                    index = i;
                    isExistedID = true;
                    break;
                }
            }
            if(!isExistedID){
                System.out.printf(ERROR_MSG, "User ID does not exist");
                valid = false;
                continue;
            }

        }while(!valid);
        return value;
        
    }

     //From user ID validation

     public static String getFromUserId(){

        boolean valid;
        String value;

        do{

            valid = true;
            System.out.print("\tEnter From Account Number : ");
            value=SCANNER.nextLine().strip();

            if(value.isBlank()){
                System.out.printf(ERROR_MSG,"ID can't be empty");
                valid=false;
                continue;
            }
            if(!(value.startsWith("SDB-") && value.length() == 9)){
                System.out.printf(ERROR_MSG, "Invalid ID format");
                valid = false;
                continue; 
            }
            
            
            boolean isExistedID = false;
            for (int i = 0; i < bankUsers.length; i++) {
                if(bankUsers[i][0].equals(value)){
                    index = i;
                    isExistedID = true;
                    break;
                }
            }
            if(!isExistedID){
                System.out.printf(ERROR_MSG, "User ID does not exist");
                valid = false;
                continue;
            }

        }while(!valid);
        return value;
    }

     //To user ID validation

     public static String getToUserId(){

        boolean valid;
        String value;

        do{

            valid = true;
            System.out.print("\tEnter To Account Number : ");
            value=SCANNER.nextLine().strip();

            if(value.isBlank()){
                System.out.printf(ERROR_MSG,"ID can't be empty");
                valid=false;
                continue;
            }
            if(!(value.startsWith("SDB-") && value.length() == 9)){
                System.out.printf(ERROR_MSG, "Invalid ID format");
                valid = false;
                continue; 
            }
            
            
            boolean isExistedID = false;
            for (int i = 0; i < bankUsers.length; i++) {
                if(bankUsers[i][0].equals(value)){
                    index = i;
                    isExistedID = true;
                    break;
                }
            }
            if(!isExistedID){
                System.out.printf(ERROR_MSG, "User ID does not exist");
                valid = false;
                continue;
            }

        }while(!valid);
        return value;
    }

     //Initial Deposit Validation

     public static double getInitialDeposit(){

        boolean valid;
        String amountStr;
        double amount = 0;

        do{

            valid = true;
            System.out.print("\tEnter Initial Deposit : ");
            amountStr = SCANNER.nextLine();

            if(amountStr.isBlank()){
                System.out.printf(ERROR_MSG, "Deposit can't be empty");
                valid = false;
                continue;
            }
            amount = Double.parseDouble(amountStr);
            if(amount < 5000){
                System.out.printf(ERROR_MSG, "Insufficient Initial Deposit");
                valid = false;
                continue;
            }

        }while(!valid);
        return amount;
    }

    //Extend Array

    public static String[][] arryExtend(String[][] input, String id, String name, double amount){

        String[][] newUserArray = new String[input.length + 1][3];

        for (int i = 0; i < input.length; i++) {
            newUserArray[i] = input[i];
        }
        newUserArray[newUserArray.length -1][0] = id;
        newUserArray[newUserArray.length-1][1]=name ;
        newUserArray[newUserArray.length-1][2]=amount + " ";
        input = newUserArray;
        return input;

    }

    //Create new Account

    public static void createNewAccount(){

        //User Id generation

        id = String.format("SDB-%05d", bankUsers.length + 1);
        System.out.printf("\tSDB-%05d \n", bankUsers.length + 1);

        name = getUserName();
        balance = getInitialDeposit();

        bankUsers = arryExtend(bankUsers, id, name, balance);
        
        System.out.println();
        System.out.printf(SUCCESS_MSG, String.format("%s:%s added successfully \n", id, name));
        System.out.print("\tDo you want to continue ? (Y/n)");
        if (!SCANNER.nextLine().toUpperCase().strip().equals("Y"))
        screen = DASHBOARD;
        
    }

    //Deposit

    public static void getDeposit(){

        id = getUserId();
        System.out.println("\tCurrent Balance : " + bankUsers[index][2]);

        //Check Deposit amount
        boolean valid;
        double depoAmount = 0;
        String depoStr;
        do{
            valid = true;
            System.out.print("\tEnter Deposit amount : ");
            depoStr = SCANNER.nextLine().strip();

            if(depoStr.isBlank()){
                System.out.printf(ERROR_MSG, "Deposit Amount can't be empty");
                valid = false;
                continue;
            }
            depoAmount = Double.parseDouble(depoStr);
            if(depoAmount < 500){
                System.out.printf(ERROR_MSG, "Insufficient Deposit Amount");
                valid = false;
                continue;
            }
        }while(!valid);

        balance = Double.parseDouble(bankUsers[index][2]) + depoAmount;
        bankUsers[index][2] = balance + " ";

        System.out.printf("\tNew Balance : Rs.%.2f \n",Double.parseDouble(bankUsers[index][2]));

        System.out.println();
        System.out.printf(SUCCESS_MSG, String.format("Rs.%.2f amount deposited successfully \n", depoAmount));
        System.out.print("\tDo you want to continue ? (Y/n)");
        if (!SCANNER.nextLine().toUpperCase().strip().equals("Y"))
        screen = DASHBOARD;
    }

    //Withdraw

    public static void getWithdraw(){

        id = getUserId();

        boolean valid;
        double withAmount = 0;
        String withStr;

        do{

            valid = true;
            System.out.print("\tEnter Withdraw amount : ");
            withStr = SCANNER.nextLine().strip();

            if(withStr.isBlank()){
                System.out.printf(ERROR_MSG, "Withdraw Amount can't be empty");
                valid = false;
                continue;
            }
            withAmount = Double.parseDouble(withStr);
            if(withAmount < 100){
                System.out.printf(ERROR_MSG, "Insufficient Withdraw Amount");
                valid = false;
                continue;
            }

            balance =  Double.parseDouble(bankUsers[index][2]) - withAmount;
            if(balance < 500){
                System.out.printf(ERROR_MSG, "Insufficient Account Balance");
                valid = false;
                continue;
            }
        }while(!valid);
        bankUsers[index][2] = balance +"";

        System.out.printf("\tNew Balance : Rs.%.2f \n",Double.parseDouble(bankUsers[index][2]));

        System.out.println();
        System.out.printf(SUCCESS_MSG, String.format("Rs.%.2f amount withdraw successfully \n", withAmount));
        System.out.print("\tDo you want to continue ? (Y/n)");
        if (!SCANNER.nextLine().toUpperCase().strip().equals("Y"))
        screen = DASHBOARD;    
    }

      //Transfer

      public static void getTransfer(){

        String fromId = getFromUserId();
        int fromUserIndex = index;
        System.out.println("\tFrom Account Holder : " + bankUsers[index][1]);

        String toId = getToUserId();
        int toUserIndex = index;
        System.out.println("\tTo Account Holder : " + bankUsers[index][1]);

        System.out.printf("\tFrom account Balance : Rs.%.2f \n", Double.parseDouble(bankUsers[fromUserIndex][2]));
        System.out.printf("\tTo account Balance : Rs.%.2f \n", Double.parseDouble(bankUsers[toUserIndex][2]));;

        boolean valid;
        double transAmount = 0;
        String transStr;
        double fromUserBal = 0;
        double toUserBal = 0;

        do{

            valid = true;
            System.out.print("\tEnter Transfer amount : ");
            transStr = SCANNER.nextLine().strip();

            if(transStr.isBlank()){
                System.out.printf(ERROR_MSG, "Transfer Amount can't be empty");
                valid = false;
                continue;
            }
            transAmount = Double.parseDouble(transStr);
            if(transAmount < 100){
                System.out.printf(ERROR_MSG, "Insufficient Transfer Amount");
                valid = false;
                continue;
            }

            fromUserBal =  Double.parseDouble(bankUsers[fromUserIndex][2]) - transAmount;
            if(fromUserBal< 500){
                System.out.printf(ERROR_MSG, "Insufficient Account Balance");
                valid = false;
                continue;
            }
        }while(!valid);

        toUserBal = Double.parseDouble(bankUsers[toUserIndex][2]) + transAmount;
        bankUsers[toUserIndex][2] = toUserBal + "";

        //bankUsers[toUserIndex][2] += transAmount + "";
        //Update From User's balance after transfer
        bankUsers[fromUserIndex][2]= fromUserBal - transAmount * 0.1 + "";

        System.out.printf("\tFrom account Balance : Rs.%.2f \n", Double.parseDouble(bankUsers[fromUserIndex][2]));
        System.out.printf("\tTo account Balance : Rs.%.2f \n", Double.parseDouble(bankUsers[toUserIndex][2]));

        System.out.println();
        System.out.printf(SUCCESS_MSG, String.format("Rs.%.2f amount transfer successfully \n", transAmount));
        System.out.print("\tDo you want to continue ? (Y/n)");
        if (!SCANNER.nextLine().toUpperCase().strip().equals("Y"))
        screen = DASHBOARD;
    }

    //Check Account Balance

    public static void getAccountBal(){

        id = getToUserId();
        balance = Double.parseDouble(bankUsers[index][2]);
        System.out.printf("\tCurrent Account Balance : Rs.%.2f \n", balance);
        System.out.printf("\tWithdraw Available Balance : Rs.%.2f \n", balance - 500);

        System.out.println();
        System.out.print("\tDo you want to continue ? (Y/n)");
        if (!SCANNER.nextLine().toUpperCase().strip().equals("Y"))
        screen = DASHBOARD;

    }

      //Shrink Array

      public static String[][] arryShrink(String[][] input, int index){

        String[][] newUserArray = new String[input.length -1][3];
        for (int i = 0; i < input.length; i++) {
            
            if(i < index){
                newUserArray[i] = input[i];
            }else if(i == index){
                continue;
            }else{
                newUserArray[i - 1 ] = input[i];
            }
        }
        input = newUserArray;
        return input;
    }


    //Delete Account

    public static void deleteAccount(){

        id = getUserId();

        System.out.println("\tName : " + bankUsers[index][1]);
        System.out.println("\tBalance : " + bankUsers[index][2]);

        System.out.println();
        System.out.print("\tAre you sure to delete ? (Y/n)");
        if (!SCANNER.nextLine().toUpperCase().strip().equals("Y"))
        screen = DASHBOARD;

        bankUsers = arryShrink(bankUsers, index);

        System.out.println();
        System.out.printf(SUCCESS_MSG, String.format("%s: account deletd successfully \n", id));
        System.out.print("\tDo you want to continue ? (Y/n)");
        if (!SCANNER.nextLine().toUpperCase().strip().equals("Y"))
        screen = DASHBOARD;

    }

     //Print Details

     public static void printDetails(){

        if (bankUsers.length == 0){
            System.out.printf(ERROR_MSG, "No customer records found, please add a new customer!");                      
        }else {
            final String LINE = "\t+".concat("-".repeat(12)).concat("+").concat("-".repeat(13)).concat("+")
            .concat("-".repeat(15)).concat("+");
            System.out.println(LINE);
            System.out.printf("\t|%-12s|%-13s|%-15s| \n", "ID", "NAME", "BALANCE");
            System.out.println(LINE);
            // Body
            for (int i = 0; i < bankUsers.length; i++) {
                System.out.printf("\t|%-12s|%-13s|%-15s|\n", bankUsers[i][0],
                bankUsers[i][1] , bankUsers[i][2]);  
            }
            System.out.println(LINE);
        }

        System.out.print("\tDo you want to go back? (Y/n) ");
        if (SCANNER.nextLine().strip().toUpperCase().equals("Y")) screen = DASHBOARD;
         
    }






}