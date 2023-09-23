package committee.nova.extendednotes.mixin;

import committee.nova.extendednotes.ExtendedNotes;
import net.minecraft.world.level.block.NoteBlock;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(NoteBlock.class)
public abstract class MixinNoteBlock {
    @Mutable
    @Shadow
    @Final
    public static IntegerProperty NOTE;

    @Inject(method = "<clinit>", at = @At("TAIL"))
    private static void inject$clinit(CallbackInfo ci) {
        NOTE = ExtendedNotes.NOTE;
    }

    @Inject(method = "getPitchFromNote", at = @At("HEAD"), cancellable = true)
    private static void inject$getPitchFromNote(int note, CallbackInfoReturnable<Float> cir) {
        cir.setReturnValue((float) Math.pow(2.0D, (double) (note - 36) / 12.0D));
    }
}
