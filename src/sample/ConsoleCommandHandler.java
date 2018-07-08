package sample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ConsoleCommandHandler {

    private Map<String, Runnable> Commands = new HashMap<>();

    private ArrayList<String> ShortCuts = new ArrayList<>();
    public ConsoleCommandHandler(HashMap commands) {
        Commands = commands;
    }

    public HashMap getCommnds() {
        return (HashMap)Commands;
    }
}

/*
* if (ConsoleCommandHandler.getCommands.get
* Try catch:
*   commands.get(shortCut).run()
* */
