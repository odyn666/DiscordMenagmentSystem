package com.github.odyn666.DiscordCRM.service.helper;

import lombok.Locked;
import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class DashboardHelper extends ListenerAdapter {
    private static DashboardHelper instance=null;

    public static DashboardHelper dashboardHelper(){
        if (instance == null) {
            instance = new DashboardHelper();
        }
        return instance;
    }



}
