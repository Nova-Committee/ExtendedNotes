package committee.nova.extendednotes.mixin;

import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.client.sounds.SoundEngine;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(SoundEngine.class)
public abstract class MixinSoundEngine {
    @Inject(method = "calculatePitch", at = @At("HEAD"), cancellable = true)
    private void inject$calculatePitch(SoundInstance instance, CallbackInfoReturnable<Float> cir) {
        cir.setReturnValue(Math.max(instance.getPitch(), 10e-20f));
    }
}
