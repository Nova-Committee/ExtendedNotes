package committee.nova.extendednotes;

import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraftforge.fml.common.Mod;

@Mod(ExtendedNotes.MODID)
public class ExtendedNotes {
    public static final String MODID = "extendednotes";
    public static final IntegerProperty NOTE = IntegerProperty.create("note", 0, 72);
}
