package com.redcompany.red.jaxbcategory.ref.controller.command;

import com.redcompany.red.jaxbcategory.ref.controller.command.impl.*;
import com.redcompany.red.jaxbcategory.ref.controller.command.util.CommandName;

import java.util.HashMap;
import java.util.Map;

public class CommandManager  {

    private static final CommandManager instance = new CommandManager();
    private Map<CommandName, BasicCommand> commands = new HashMap<>();


    public CommandManager() {
        commands.put(CommandName.NO_SUCH_COMMAND, new NoSuchCommand());
        commands.put(CommandName.XJCE_GENERATION_COMMAND, new XJCEGenCommand());
        commands.put(CommandName.ALL_NEWS_COMMAND, new AllNewsCommand());
        commands.put(CommandName.ADD_NEWS_COMMAND, new AddNewsCommand());

    }



    public static CommandManager getInstance() {
        return instance;
    }

    public BasicCommand getCommand(String commandName) {
        CommandName name = CommandName.valueOf(commandName.toUpperCase());
        BasicCommand command;
        if (name != null) {
            command = commands.get(name);
        } else {
            command = commands.get(CommandName.NO_SUCH_COMMAND);
        }
        return command;
    }

}
