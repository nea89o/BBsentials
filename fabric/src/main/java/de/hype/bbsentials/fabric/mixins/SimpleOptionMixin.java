package de.hype.bbsentials.fabric.mixins;

import de.hype.bbsentials.forge.common.api.ISimpleOption;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.SimpleOption;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import java.util.Objects;
import java.util.function.Consumer;

@Mixin(SimpleOption.class)
public class SimpleOptionMixin implements ISimpleOption {
    @Shadow
    Object value;
    @Shadow
    @Final
    private Consumer<Object> changeCallback;

    @Override
    public void set(Object value) {
        if (!MinecraftClient.getInstance().isRunning()) {
            this.value = value;
        }
        else {
            if (!Objects.equals(this.value, value)) {
                this.value = value;
                this.changeCallback.accept(this.value);
            }
        }
    }
}
