package huangdihd.xinbot;

import xin.bbtt.mcbot.Bot;
import xin.bbtt.mcbot.event.EventHandler;
import xin.bbtt.mcbot.event.Listener;
import xin.bbtt.mcbot.events.PublicChatEvent;
import xin.bbtt.mcbot.plugin.Plugin;

class listener implements Listener {
    @EventHandler
    public void onChatMessage(PublicChatEvent event) {
        if (Bot.INSTANCE.getConfig().getConfigData().getAccount().getName().equals(event.getSender().getName())) return;
        String message = event.getMessage();
        if (!message.contains("入")) return;
        String result = message.replaceFirst("^.*?入", "");
        if (result.isBlank()) return;
        Bot.INSTANCE.sendChatMessage("羡慕" + result);
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
        Bot.INSTANCE.getPluginManager().registerEvents(new listener(), this);
    }

    @Override
    public void onDisable() {
    }
}