package de.hype.bbsentials.fabric;

import de.hype.bbsentials.forge.common.api.ISimpleOption;
import net.minecraft.client.MinecraftClient;

public class Options implements de.hype.bbsentials.forge.common.mclibraries.Options {
    public void setFov(int value) {
        ((ISimpleOption) (Object) MinecraftClient.getInstance().options.getFov()).set(value);
    }
    public void setGamma(double value) {
        ((ISimpleOption) (Object) MinecraftClient.getInstance().options.getGamma()).set(value);
    }
}

