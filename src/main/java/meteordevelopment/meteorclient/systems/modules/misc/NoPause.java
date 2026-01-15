/*
 * This file is part of the Meteor Client distribution (https://github.com/MeteorDevelopment/meteor-client).
 * Copyright (c) Meteor Development.
 */

package meteordevelopment.meteorclient.systems.modules.misc; // Or your custom package


import meteordevelopment.meteorclient.systems.modules.Categories;
import meteordevelopment.meteorclient.systems.modules.Module;

public class NoPause extends Module {
    private boolean originalSetting;

    public NoPause() {
        // Using Misc category as it fits better than Movement
        super(Categories.Misc, "no-pause", "Prevents the game from pausing or opening the menu when you tab out.");
    }

    @Override
    public void onActivate() {
        originalSetting = mc.options.pauseOnLostFocus;
        mc.options.pauseOnLostFocus = false;
        mc.options.write();
    }

    @Override
    public void onDeactivate() {
        mc.options.pauseOnLostFocus = originalSetting;
        mc.options.write();
    }
}
