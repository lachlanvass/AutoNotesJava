package autonotes;

import java.util.HashMap;

public class AutoNotesTextWriter extends ConsoleTextWriter{

    public String finishingChar = "--";
    public AutoNotesTextWriter() {

        // This constructor is run automatically when loaded from FXML file
        // Therefore use this to populate specific commands.
        // Applicaion Specific version of the ConsoleTextWriter

        commandHashMap = new HashMap<>();

        // End note

        commandHashMap.put(finishingChar, () -> this.newNote());

        // COPY COMMANDS

        commandHashMap.put("pp", generateReplaceTextRunnable("Booked passport appointment.", true));
        commandHashMap.put("empt", generateReplaceTextRunnable("Dear Team \n\n\n\n Thanks\n CCC", true));
        commandHashMap.put("miss", generateReplaceTextRunnable("Dear Team\n\n Possible missing item. EDD + ", true));
        commandHashMap.put("update", generateReplaceTextRunnable("------------- UPDATE---------- \n \n \n ------------------", true)); // autogenerate date
        commandHashMap.put("not del compl", generateReplaceTextRunnable("-------------- NOT A DELIVERY COMPLAIN --------------", true));
        commandHashMap.put("del compl", generateReplaceTextRunnable("Dear Team \n \n Customer complains...", true));

        // DISPUTED DELIVERIES
        commandHashMap.put("disp", generateReplaceTextRunnable("Dear Team \n\n Customer disputes delivery. \n\n Thansks\n CCC", true));
        commandHashMap.put("disp safe", generateReplaceTextRunnable("Dear Team \n\n Customer disputes delivery. Safe drop image does not match customers address. \n\n Thanks\n CCC", true));
        commandHashMap.put("disp sig", generateReplaceTextRunnable("Dear Team \n\n Customer disputes delivery. Signatory name unknown to customer. \n\n Thanks\n CCC", true));


        // MISC.
        commandHashMap.put("trck", generateReplaceTextRunnable("Tracking enquiry.", false));
        commandHashMap.put("mrs", generateReplaceTextRunnable("MRS enquiry. \n" + prompt + " CRN: ", false));
        commandHashMap.put("nfa", generateReplaceTextRunnable("No further action possible.", false));
        commandHashMap.put("lit", generateReplaceTextRunnable("Searched RMRC \n" + prompt + "Advised lost in transit", false));
        commandHashMap.put("await", generateReplaceTextRunnable("Advised awaiting collection", false));
        commandHashMap.put("driver", generateReplaceTextRunnable("Advised on board with driver to be delivered today", false));
        commandHashMap.put("ex comp", generateReplaceTextRunnable("Express failure. Comped sender postage", false));
        commandHashMap.put("card", generateReplaceTextRunnable("Carded item", false));
        commandHashMap.put("no trck", generateReplaceTextRunnable("No valid tracking number \n" + prompt + "Advised contact sender for assistance", false));
        commandHashMap.put("con send", generateReplaceTextRunnable("Advised contact sender", false));
        commandHashMap.put("nr", generateReplaceTextRunnable("No response from customer. Terminated call", false));


        // TRANSFERS
        commandHashMap.put("trans int", generateReplaceTextRunnable("Transferred to international", false));
        commandHashMap.put("trans bus", generateReplaceTextRunnable("Transferred to business.", false));
        commandHashMap.put("trans spec", generateReplaceTextRunnable("Transferred to specialist", false));


        // SUPPORT INFORMATION - NOT FOR CUSTOMERS

        commandHashMap.put("aps", generateReplaceTextRunnable("APS: 11059155", false)); // Give user option to set their own APS number
        commandHashMap.put("wcid", generateReplaceTextRunnable("WCID: 111907", false)); // give support info a place to just be read


        // CONTACT SOMEONE ELSE

        commandHashMap.put("con pp", generateReplaceTextRunnable("Advised contact Passport Office", false));
        commandHashMap.put("con ato", generateReplaceTextRunnable("Advised contact ATO", false));
        commandHashMap.put("con customs", generateReplaceTextRunnable("Advised contact customs", false));

        // PHONE NUMBERS

        commandHashMap.put("star ph", generateReplaceTextRunnable("Star track: 13 23 45", false));
        commandHashMap.put("pp ph", generateReplaceTextRunnable("Passport office: 13 12 32", false)); // get correct number
        commandHashMap.put("bus ph", generateReplaceTextRunnable("Business line: 13 11 18", false));
        commandHashMap.put("ato ph", generateReplaceTextRunnable("ATO: 13 28 61", false));
        commandHashMap.put("retail ph", generateReplaceTextRunnable("Retail support: xxxxxx", false));





    }

    protected Runnable generateReplaceTextRunnable(String input, boolean toCopy) {
        return () -> this.replaceText(input, toCopy);
    }

}
