package addressbook;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Created by Don Robles on 2/2/2017 with IntelliJ IDEA.
 */
public class AddressBook implements AddressInterface {

    private static Utils util = new Utils();

    public static void main(String[] args) {
        AddressBook app = new AddressBook();
        processInput(app, System.in, System.out);
    }
    /*
     * Main body of the app.  IO is abstracted out to accommodate testing with mock input.
	 * (See TestConsoleInteraction)
	 */

    public static void processInput(AddressBook app, InputStream inputStream, PrintStream outputStream) {
        outputStream.print(app.createMenu());
        boolean appRunning = true;
        Scanner in = new Scanner(inputStream);
        while (appRunning) {
            int action = EXIT;
            String userInput = "";
            if (in.hasNext()) {
                userInput = in.nextLine().trim();
                System.out.println(userInput);
//                action = util.validateName(userInput) ? action : 1;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(userInput);

            if ("q".equals(userInput)) {
                appRunning = false;
            }
//            switch (action) {
//                case EXIT:
//                    appRunning = false;
//                    // This was not in the spec, but it's nicer :-)
//                    sb.append(EXIT_MESG);
//                    break;
//                case RESTOCK:
////                    app.inventory.restock();
//                    sb.append(app.createMenu());
//                    break;
//                case INVALID:
////                    sb.append(app.invalidMessage(userInput)).append(EOL);
//                    sb.append(app.createMenu());
//                    break;
//                default:
////                    Drink r = app.recipes.getRecipeByOrdinal(action - 1);
////                    if (app.inventory.sellUnit(r)) {
////                        sb.append(app.dispensingMessage(r.getName())).append(EOL);
////                    } else {
////                        sb.append(app.outOfStockMessage(r.getName())).append(EOL);
////                    }
////                    sb.append(app.createMenu());
//            }
            outputStream.print(sb.toString());
        }
        in.close();
    }

    private String createMenu() {
        StringBuilder sb = new StringBuilder();
        sb.append("Test Message");
        return sb.toString();
    }
}
