package huangdihd.xinbot;

import xin.bbtt.mcbot.Bot;
import xin.bbtt.mcbot.Utils;
import xin.bbtt.mcbot.event.EventHandler;
import xin.bbtt.mcbot.event.Listener;
import xin.bbtt.mcbot.events.SystemChatMessageEvent;
import xin.bbtt.mcbot.plugin.Plugin;

import java.util.ArrayList;

class listener implements Listener {
    @EventHandler
    public void onChatMessage(SystemChatMessageEvent event) {
        ArrayList<String> strings = Utils.toStrings(event.getContent());
        if (strings.size() != 3) return;
        if (!strings.get(1).contains("<") || !strings.get(1).contains(">")) return;
        if (!strings.get(2).contains("入")) return;
        String result = strings.get(2).replaceFirst("^.*?入", "");
        if (result.isBlank()) return;
        Bot.Instance.sendChatMessage("羡慕" + result);
    }
}

public class Envy implements Plugin {
    @Override
    public void onLoad() {
    }

    @Override
    public void onUnload() {
    }

    @Override
    public void onEnable() {
        Bot.Instance.getPluginManager().registerEvents(new listener(), this);
    }

    @Override
    public void onDisable() {
    }
}